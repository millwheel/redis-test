package test.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class StoreWithoutEntity {

    private final RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    public StoreWithoutEntity(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void createData(String key, String value){
        ValueOperations<Object, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
    }
}
