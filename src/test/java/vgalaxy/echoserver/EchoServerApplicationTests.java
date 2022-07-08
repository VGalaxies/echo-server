package vgalaxy.echoserver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vgalaxy.echoserver.model.Echo;
import vgalaxy.echoserver.service.EchoService;

@SpringBootTest
class EchoServerApplicationTests {

    @Autowired
    EchoService echoService;

    @Test
    public void echoTest() {
        Echo res = echoService.echo("world");
        Assertions.assertEquals(res.getContent(), "Hello, world!");
    }
}
