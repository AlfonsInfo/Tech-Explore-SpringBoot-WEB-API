package group.learn.springredis;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.core.*;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest
@Slf4j
class RedisTest {

    @Autowired
     StringRedisTemplate redisTemplate;


    @Test
    void redisTemplateCheckNotNull(){
        assertNotNull(redisTemplate);
    }


    @Test
    @SneakyThrows
    void string() {
        ValueOperations<String, String> operations= redisTemplate.opsForValue();

        operations.set("name", "alfons", Duration.ofSeconds(2)); // operations memiliki method yang biasa kita lakukan diredisget
        assertEquals("alfons", operations.get("name"));
        log.info(operations.get("name"));
    }

    @Test
    @SneakyThrows
    void redisList(){
        ListOperations<String ,String> operations = redisTemplate.opsForList();

        operations.rightPush("names" , "ucup");
        operations.rightPush("names" , "surucup");
        operations.rightPush("names" , "budiyono");

        assertEquals("ucup", operations.leftPop("names"));
        assertEquals("surucup", operations.leftPop("names"));
        assertEquals("budiyono", operations.leftPop("names"));

//        assertEquals(""
    }


    @Test
    @SneakyThrows
    void redisSetTest(){
        SetOperations<String, String> operations = redisTemplate.opsForSet();

        operations.add("students", "alfons");
        operations.add("students", "alfons");
        operations.add("students", "alfons");
        operations.add("students", "jamet");
        operations.add("students", "jamet");
        operations.add("students", "bambang");

        Set<String> students = operations.members("students");
        if(students != null && operations.members("students") != null){
        assertEquals(3, students.size());
        assertEquals(3, operations.members("students").size());
        assertThat(students, hasItems("alfons", "jamet", "bambang"));
        }

    }


    @Test
    @SneakyThrows
    void hash(){
        HashOperations<String, Object, Object> operations = redisTemplate.opsForHash();
        operations.put("user:1" , "id", "1");
        operations.put("user:1" , "name", "Jamet");
        operations.put("user:1" , "email", "Jamet@example.com");

        assertEquals("1", operations.get("user:1","id"));
    }


    //sorted redis
    //ZsetOperations
    //Geo -> GeoOperations


    //Redis Transactions & menggunakan @Transactional bisa jg
    @Test
    void transactions(){

        //multi & exec
        redisTemplate.execute(
                new SessionCallback<>() {
                    @Override
                    public <K, V> Object execute(RedisOperations<K, V> operations) throws DataAccessException {
                        operations.multi();
                        operations.opsForValue().set((K) "test1", (V) "Eko", Duration.ofSeconds(2));
                        operations.opsForValue().set((K) "test2", (V) "Budi", Duration.ofSeconds(2));
                        operations.exec();
                        return null;
                    }
                }
        );
        assertEquals("Eko", redisTemplate.opsForValue().get("test1"));
        assertEquals("Budi", redisTemplate.opsForValue().get("test2"));
    }


    //Redis pipeline
    @Test
    void pipeline() {
        List<Object> statuses = redisTemplate.executePipelined(new SessionCallback<>() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                operations.opsForValue().set("test1", "Eko", Duration.ofSeconds(2));
                operations.opsForValue().set("test2", "Eko", Duration.ofSeconds(2));
                operations.opsForValue().set("test3", "Eko", Duration.ofSeconds(2));
                operations.opsForValue().set("test4", "Eko", Duration.ofSeconds(2));
                return null;
            }
        });

        assertThat(statuses, hasSize(4));
        assertThat(statuses, hasItem(true));
        assertThat(statuses, not(hasItem(false)));
    }

    @Test
    void publishStream(){
        StreamOperations<String, Object, Object> operations = redisTemplate.opsForStream();
        MapRecord<String, String, String> record = MapRecord.create("stream-1", Map.of(
                "name", "alfons", "age", "21"
        ));
        for (int i = 0; i < 0 ; i++) {
            operations.add(record);

        }
    }
}
