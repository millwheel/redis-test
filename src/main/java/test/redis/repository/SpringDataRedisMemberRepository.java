package test.redis.repository;

import org.springframework.data.repository.CrudRepository;
import test.redis.entity.Member;

public interface SpringDataRedisMemberRepository extends CrudRepository<Member, String> {
}
