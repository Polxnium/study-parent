package com.stu.mongo.service;

import com.stu.mongo.entity.TranInfo;

import java.util.Collection;
import java.util.List;

public interface TranInfoService {

    Collection insertAll(List<TranInfo> tranInfoList);
}
