package vgalaxy.echoserver.model;

public class Echo {

    private final long id;
    private final String content;

    public Echo(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
