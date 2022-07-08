package vgalaxy.echoserver.controller;

import io.micrometer.core.annotation.Timed;
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

    @Timed(value = "echo_request_duration", description = "Time taken to echo", histogram = true)
    @GetMapping("/echo/{msg}")
    public Echo echo(@PathVariable(value = "msg") String msg) {
        return service.echo(msg);
    }
}
