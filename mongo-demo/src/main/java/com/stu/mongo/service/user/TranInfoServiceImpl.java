package com.stu.mongo.service.user;

import com.stu.mongo.entity.TranInfo;
import com.stu.mongo.service.TranInfoService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @author 86177
 */
@Service
public class TranInfoServiceImpl implements TranInfoService {

    @Resource(name = "orderMongo")
    private MongoTemplate mongoTemplate;

    @Override
    public Collection insertAll(List<TranInfo> tranInfoList) {
        return mongoTemplate.insertAll(tranInfoList);
    }
}
