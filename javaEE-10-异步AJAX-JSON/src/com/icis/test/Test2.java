package com.icis.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test2 {
    ObjectMapper mp = new ObjectMapper();
    @Test
    public void test () throws IOException {
//        String str = "";
        String str = "[\n" +
                "\t  {\"pName\":\"华为mate10\",\"pPrice\":20.0,\"sale\":true},\n" +
                "\t  {\"pName\":\"华为mate11\",\"pPrice\":20.0,\"sale\":true},\n" +
                "\t  {\"pName\":\"华为mate12\",\"pPrice\":20.0,\"sale\":true},\n" +
                "\t  {\"pName\":\"华为mate13\",\"pPrice\":20.0,\"sale\":true}\n" +
                "\t ]";
        List<MyTest.Pro> list = mp.readValue(str, new TypeReference<List<MyTest.Pro>>(){});
        System.out.println(list);
    }

    @Test
    public void readJsonToMap() throws IOException {
         String str = "{\"pName\":\"红米Max\",\"pPrice\":2888.88,\"sale\":false}";
         Map<String, Object> map = mp.readValue(str, new TypeReference<Map<String, Object>>(){});
         System.out.println(map);
    }

}
