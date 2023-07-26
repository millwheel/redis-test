package test.redis.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

@Setter
@Getter
@NoArgsConstructor
@RedisHash(timeToLive = 30)
public class Member {
    private String id;
    private String name;

}
