package test.provider;

import org.apache.servicecomb.saga.omega.spring.EnableOmega;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableOmega
public class TestServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(TestServiceApp.class,args);
    }
}
