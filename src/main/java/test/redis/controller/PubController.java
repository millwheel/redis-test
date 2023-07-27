package test.redis.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import test.redis.entity.ChatMessage;
import test.redis.service.PubService;

@RestController
public class PubController {

    private final PubService redisPubService;

    public PubController(PubService redisPubService) {
        this.redisPubService = redisPubService;
    }

    @PostMapping("/chat")
    public void sendMessage(@RequestBody ChatMessage chatMessage) throws JsonProcessingException {
        redisPubService.sendMessage(chatMessage);
    }
}
