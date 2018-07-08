package test.provider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@RestController
public class TestServiceImpl {

    @Autowired
    Registration registration;

    @GetMapping("test")
    public Object get(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("host",registration.getHost());
        map.put("port",registration.getPort());
        map.put("id",registration.getServiceId());
        map.put("元信息",registration.getMetadata());
        return map;
    }

}
