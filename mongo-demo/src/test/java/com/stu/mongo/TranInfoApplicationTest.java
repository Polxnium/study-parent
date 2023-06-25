package com.stu.mongo;

import com.stu.mongo.entity.TranInfo;
import com.stu.mongo.service.TranInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;

@SpringBootTest
class TranInfoApplicationTest {

    @Autowired
    private TranInfoService tranInfoService;

    @Test
    void contextLoads() {
        List<TranInfo> tranInfoList = new ArrayList<>(100100);
        for (int i = 0; i < 20000000; i++) {
            TranInfo tranInfo = new TranInfo();
            tranInfo.setTranCode(UUID.randomUUID()+"");
            tranInfo.setOrderCode(UUID.randomUUID()+"");
            tranInfo.setTranStatus(i % 7);
            tranInfo.setPlateNumber("闽D:"+i);
            tranInfo.setVehicleId("123"+i);
            tranInfo.setVehicleType("H"+i);
            tranInfo.setVehicleLength(i+"");
            tranInfo.setGoodsType("goodsType"+i);
            tranInfo.setGoodsType("goodsDescription"+i);
            tranInfo.setWeight(new BigDecimal(String.valueOf(i)));
            tranInfo.setVolume(tranInfo.getWeight());
            tranInfo.setMeasure(i % 4);
            tranInfo.setFeeType(i % 2);
            tranInfo.setFreight(new BigDecimal(String.valueOf(i*100)));
            tranInfo.setTaxFreight(tranInfo.getFreight().add(BigDecimal.TEN));
            tranInfo.setOwnerUserId(i);
            tranInfo.setOwnerName("货主企业名称有限:"+i);
            tranInfo.setDriverAmount(tranInfo.getFreight());
            tranInfo.setDriverUserId(i);
            tranInfo.setDriverName("司机名:"+i);

            tranInfo.setStarProvinceStr("福建"+i);
            tranInfo.setStarAreaStr("海沧"+i);
            tranInfo.setStarCityStr("厦门"+i);
            tranInfo.setEndProvinceStr("浙江"+i);
            tranInfo.setEndCityStr("杭州"+i);
            tranInfo.setEndAreaStr("萧山"+i);

            tranInfo.setNumber(i);
            tranInfo.setPriceSettle(tranInfo.getFreight());
            tranInfo.setTaxPriceSettle(tranInfo.getTaxFreight());
            tranInfo.setPayStatus(i % 3);
            tranInfo.setPaidPrice(tranInfo.getFreight());
            tranInfo.setUnPaidPrice(tranInfo.getTaxFreight());
            tranInfo.setBusinessType(i % 2);
            tranInfo.setUploadStatus(i % 4);

            tranInfoList.add(tranInfo);
            if (tranInfoList.size() == 100000) {
                Collection collection = tranInfoService.insertAll(tranInfoList);
                if (!CollectionUtils.isEmpty(collection)) {
                    System.out.println("insert success"+i);
                }
                tranInfoList.clear();
            }
        }
    }

}
