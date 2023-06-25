package com.stu.mongo.service.user;

import com.stu.mongo.entity.BankCard;
import com.stu.mongo.service.BankCardService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 86177
 */
@Service
public class BankCardServiceImpl implements BankCardService {

    @Resource(name = "userMongo")
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(BankCard card) {
        mongoTemplate.insert(card);
    }
}
