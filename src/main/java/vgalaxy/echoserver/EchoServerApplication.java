package vgalaxy.echoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vgalaxy.echoserver.limiter.FlowRules;

@SpringBootApplication
public class EchoServerApplication {

    public static void main(String[] args) {
        FlowRules.initFlowRules();
        SpringApplication.run(EchoServerApplication.class, args);
    }

}
