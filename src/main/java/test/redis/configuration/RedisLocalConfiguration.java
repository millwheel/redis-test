package test.redis.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import test.redis.service.SubService;


@Configuration
public class RedisLocalConfiguration {


    // Local Basic connection
    // Don't need to set up host and port in connection factory if the host is localhost and port is 6379
    @Bean
    public RedisConnectionFactory connectToLocalRedis() {
        return new LettuceConnectionFactory();
    }

    // To use redis template to serialize data to json
    @Bean
    public RedisTemplate<Object, Object> redisTemplate() {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectToLocalRedis());
        redisTemplate.setKeySerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }

    // To use pub sub
    @Bean
    MessageListenerAdapter messageListenerAdapter() {
        return new MessageListenerAdapter(new SubService());
    }

    // To use pub sub
    @Bean
    RedisMessageListenerContainer redisContainer() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectToLocalRedis());
        container.addMessageListener(messageListenerAdapter(), new ChannelTopic("topic1"));
        return container;
    }

}
