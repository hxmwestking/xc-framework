package com.xuecheng.manage.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author Administrator
 * @version 1.0
 * @create 2018-09-12 18:11
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class RestTemplateTest {

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testRestTemplate() {
        ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://localhost:31001/cms/com.xuecheng.test.rabbitmq.config/getmodel/5a791725dd573c3574ee333f", Map.class);
        Map body = forEntity.getBody();
        System.out.println(body);
    }

    @Test
    public void test() throws Exception {
        String url = "http://localhost:31001/cms/page/test";
        File file = new File("C:\\Users\\P7XXTM1-G\\Desktop\\1.txt");
        File tempFile = tempFile("1.txt", FileUtils.openInputStream(file));
        FileSystemResource resource = new FileSystemResource(tempFile);
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.add("file", resource);
        form.add("accessKey","123456");
        HttpHeaders headers = new HttpHeaders();
        headers.add("remoteIp","192.168.110.110");
        headers.add("uid","3400");
        headers.add("accountType","9");
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(form, headers);
        ResponseEntity<JSONObject> exchange = restTemplate.exchange(url, HttpMethod.POST, httpEntity, JSONObject.class);
        System.out.println(exchange.getBody().toJSONString());
        tempFile.delete();
    }

    private File tempFile(String fileName, InputStream in) throws IOException {
        System.out.println(FileUtils.getTempDirectoryPath());
        File file = new File(FileUtils.getTempDirectoryPath() + fileName);
        FileUtils.copyToFile(in,file);
        return file;
    }

}
