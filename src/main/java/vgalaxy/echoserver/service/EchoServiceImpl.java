package vgalaxy.echoserver.service;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;
import vgalaxy.echoserver.exception.TooManyRequestsException;
import vgalaxy.echoserver.model.Echo;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class EchoServiceImpl implements EchoService {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Override
    public Echo echo(String msg) {
        try (Entry ignored = SphU.entry("echo")) {
            // 被保护的逻辑
            return new Echo(counter.incrementAndGet(), String.format(template, msg));
        } catch (BlockException ex) {
            // 处理被流控的逻辑
            throw new TooManyRequestsException();
        }
    }

//    @Override
//    @SentinelResource(value = "echo", fallback = "echoFallback")
//    public Echo echo(String msg) {
//        return new Echo(counter.incrementAndGet(), String.format(template, msg));
//    }

//    public Echo echoFallback(String msg, Throwable ex) {
//        // Do some log here.
//        ex.printStackTrace();
//        throw new TooManyRequestsException();
//    }
}
