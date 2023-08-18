package test.redis.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import test.redis.dto.NotiRequestDto;
import test.redis.entity.Notification;
import test.redis.repository.NotiRedisRepository;

@Slf4j
@Service
public class NotiService {

    private NotiRedisRepository notiRedisRepository;

    public NotiService(NotiRedisRepository notiRedisRepository) {
        this.notiRedisRepository = notiRedisRepository;
    }

    public void createNotification(String postId, String userId){
        String notiId = postId + userId;
        if (notiRedisRepository.existsById(notiId)) {
            log.info("Notification already exists. postId={}, userId={}", postId, userId);
            return;
        }
        Notification notification = new Notification(notiId);
        notiRedisRepository.save(notification);
    }
}
