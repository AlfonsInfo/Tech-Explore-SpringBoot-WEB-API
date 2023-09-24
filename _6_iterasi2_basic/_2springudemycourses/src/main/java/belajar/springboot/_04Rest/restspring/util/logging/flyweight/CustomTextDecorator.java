package belajar.springboot._04Rest.restspring.util.logging.flyweight;

import org.springframework.stereotype.Component;

public class CustomTextDecorator implements LogActionText {
    private LogActionText text;
    private String customText;

    public CustomTextDecorator(LogActionText text, String customText) {
        this.text = text;
        this.customText = customText;
    }

    @Override
    public String getContent() {
        return "[" + customText + "]" + text.getContent();
    }


}
