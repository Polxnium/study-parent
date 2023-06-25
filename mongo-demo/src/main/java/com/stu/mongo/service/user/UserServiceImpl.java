package com.stu.mongo.service.user;

import com.stu.mongo.entity.User;
import com.stu.mongo.service.UserService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 86177
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource(name = "userMongo")
    private MongoTemplate mongoTemplate;

    @Override
    public void insert(User user) {
        mongoTemplate.insert(user);
    }
}
