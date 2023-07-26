package test.redis.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import test.redis.entity.Member;

@SpringBootTest
public class MemberRepositoryTest {

    private SpringDataRedisMemberRepository repository;

    @Autowired
    public MemberRepositoryTest(SpringDataRedisMemberRepository repository) {
        this.repository = repository;
    }

    @Test
    void createMemberTest(){
        // given
        Member member = new Member();
        String memberId = "132d";
        String memberName = "John";
        member.setId(memberId);
        member.setName(memberName);
        // when
        repository.save(member);
        Member savedMember = repository.findById(memberId).orElseGet(null);
        // then
        Assertions.assertThat(savedMember.getName()).isEqualTo(memberName);
    }
}
