package com.icis.dao.impl;

import com.icis.dao.ProvDao;
import com.icis.pojo.Prov;
import com.icis.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvDaoImpl implements ProvDao {
    JdbcTemplate jdbc = new JdbcTemplate(JdbcUtils.getDs());
    @Override
    public List<Prov> getAllProv() {
        String sql = "SELECT * FROM province";
        List<Prov> ret = jdbc.query(sql, new BeanPropertyRowMapper<>(Prov.class));
        return ret;
    }
}
