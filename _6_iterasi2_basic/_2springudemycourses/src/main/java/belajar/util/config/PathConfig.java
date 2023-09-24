package belajar.util.config;


import jakarta.validation.Path;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PathConfig {
    public String getCurrentMethodName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length >= 3) {
            // Index 2 adalah method yang memanggil getCurrentMethodName
            return stackTrace[2].getMethodName();
        } else {
            return "Unknown Method";
        }
    }
}
