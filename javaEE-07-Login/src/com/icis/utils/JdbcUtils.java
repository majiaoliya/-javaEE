package com.icis.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

//操作数据库的工具类
public class JdbcUtils {
    private static Properties pp;
    //静态代码块 加载属性文件
    static  {
      try{
          pp=new Properties();
          //1.获得类加载器
          ClassLoader classLoader = JdbcUtils.class.getClassLoader();
          //加载属性文件
          InputStream inputStream = classLoader.getResourceAsStream("druid.properties");
          //常见一个Properties对象
          pp.load(inputStream);
      }catch (Exception e){
          e.printStackTrace();
      }

    }

    //获得数据库连接池对象
    public static DataSource getDs(){
        try {
            return DruidDataSourceFactory.createDataSource(pp);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
