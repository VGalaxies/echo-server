package vgalaxy.echoserver.service;

import vgalaxy.echoserver.model.Echo;

public interface EchoService {
    Echo echo(String msg);
}
