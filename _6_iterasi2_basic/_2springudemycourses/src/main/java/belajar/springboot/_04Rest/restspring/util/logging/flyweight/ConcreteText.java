package belajar.springboot._04Rest.restspring.util.logging.flyweight;

public class ConcreteText implements LogActionText {
    private String content;

    public ConcreteText(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
