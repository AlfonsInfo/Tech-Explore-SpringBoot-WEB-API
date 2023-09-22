package belajar.util;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
@Slf4j
public class CustomIdGenerator implements IdentifierGenerator
{
    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        //Custom Logic
        String idPrefix = "SUC";
        String randomUUID = UUID.randomUUID().toString();
        String randomId = idPrefix + randomUUID;
        log.info("Success Generate Random UUID : " + randomId );
        return randomId;

    }
}
