package vgalaxy.echoserver.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;
import vgalaxy.echoserver.exception.TooManyRequestsException;
import vgalaxy.echoserver.model.Echo;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class EchoServiceImpl implements EchoService {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Override
    @SentinelResource(value = "echo", fallback = "echoFallback")
    public Echo echo(String msg) {
        return new Echo(counter.incrementAndGet(), String.format(template, msg));
    }

    public Echo echoFallback(String msg, Throwable ex) {
        // Do some log here.
        ex.printStackTrace();
        throw new TooManyRequestsException();
    }
}
