package test.redis.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import test.redis.dto.StoreData;
import test.redis.service.StoreWithoutEntity;

@RestController
public class StoreController {

    private StoreWithoutEntity storeWithoutEntity;

    public StoreController(StoreWithoutEntity storeWithoutEntity) {
        this.storeWithoutEntity = storeWithoutEntity;
    }

    @PostMapping("/store")
    public void storeData(@RequestBody StoreData storeData){
        storeWithoutEntity.createData(storeData.getKey(), storeData.getValue());
    }
}
