package com.mhl.mall.common.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RestHighLevelClientUtilTest {

    @Test
    public void index() {

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("user", "hul");
        jsonMap.put("postDate", new Date());
        jsonMap.put("message", "trying out Elasticsearch");

        String join = String.join(",", jsonMap.keySet());
        System.out.println(join);
    }
}