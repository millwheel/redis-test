package test.redis.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import test.redis.dto.NotiRequestDto;
import test.redis.service.NotiService;

@RestController
public class NotiController {

    private final NotiService notiService;

    public NotiController(NotiService notiService) {
        this.notiService = notiService;
    }

    @PostMapping("/noti")
    public void receiveNotification(@RequestBody NotiRequestDto notiRequestDto){
        notiService.createNotification(notiRequestDto.getPostId(), notiRequestDto.getUserId());
    }
}
