package vgalaxy.echoserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vgalaxy.echoserver.model.Echo;
import vgalaxy.echoserver.service.EchoService;

@RestController
public class EchoController {
    @Autowired
    private EchoService service;

    @GetMapping("/echo/{msg}")
    public Echo echo(@PathVariable(value = "msg") String msg) {
        return service.echo(msg);
    }
}
