package group.bootcamp.technicaltest.unit;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


@Slf4j
public class SerializationTest {
    @BeforeAll
    void init(){
        log.info("StartUp Test");
    }

    @Test
    void testSerialization(){
        ObjectMapper mapper = new ObjectMapper();
        //*

        //* mock email send acc

    }
}
