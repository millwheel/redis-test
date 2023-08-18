package test.redis.repository;

import org.springframework.data.repository.CrudRepository;
import test.redis.entity.Notification;

public interface NotiRedisRepository extends CrudRepository<Notification, String> {

}
