package com.stu.mongo;

import com.stu.mongo.entity.BankCard;
import com.stu.mongo.entity.User;
import com.stu.mongo.service.BankCardService;
import com.stu.mongo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@SpringBootTest
class UserApplicationTest {

    @Autowired
    private UserService userService;
    @Autowired
    private BankCardService bankCardService;

    @Test
    @Transactional(transactionManager = "userMongoTransaction")
    public void testTransaction() throws Exception {
        User user = new User();
        user.setId(new Random().nextInt());
        user.setUsername("wang");
        user.setPassword("@123..AB");
        userService.insert(user);

        BankCard bankCard = new BankCard();
        bankCard.setUserId(user.getId());
        bankCard.setCardNo("1323456798913");
        bankCardService.insert(bankCard);
    }

}
