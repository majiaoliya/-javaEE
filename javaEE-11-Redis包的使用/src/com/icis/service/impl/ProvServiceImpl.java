package com.icis.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icis.dao.ProvDao;
import com.icis.dao.impl.ProvDaoImpl;
import com.icis.pojo.Prov;
import com.icis.service.ProvService;
import com.icis.utils.JedisUtil;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvServiceImpl implements ProvService {

    ProvDao dao = new ProvDaoImpl();
    ObjectMapper mp =  new ObjectMapper();

    static final Jedis JEDIS = JedisUtil.getJedis();

    @Override
    public List<Prov> getAllProv() {
        return dao.getAllProv();
    }

    /**
     * 只有第一次使用的时候去数据库查数据
     * 其他都从redis缓存里查询
     * @return 返回地理位置信息的json字符串
     */
    @Override
    public String getAllProvJson() {
        String prov_list = JEDIS.get("prov_list");
        if(prov_list == null) {
            List<Prov> list = getAllProv();
            try {
                prov_list = mp.writeValueAsString(list);
                JEDIS.set("prov_list", prov_list);
                System.out.println("第一次");
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("第很多次");
        }
        return prov_list;
    }
}
