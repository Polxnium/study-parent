package com.stu.mongo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 86177
 */
@Data
@Document("tran_info")
public class TranInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    /**
     * 货单主键
     */
    @Field("order_code")
    private String orderCode;

    /**
     * 运单号
     */
    @Field("tran_code")
    private String tranCode;

    /**
     * 运单状态（0已取消;1待接单;2待装货;3运输中;4回单驳回;5回单待确认;6待结算;7已完成;8结算中）
     */
    @Field("tran_status")
    private Integer tranStatus;

    /**
     * 开票状态（0未开票;1开票中;2已开票）
     */
    @Field("ticket_status")
    private Integer ticketStatus = 2;

    /**
     * 预计装货开始时间
     */
    @Field("start_shipping_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date startShippingTime = new Date();

    /**
     * 预计装货结束时间
     */
    @Field("end_shipping_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date endShippingTime = new Date();

    /**
     * 车型要求(逗号隔开）
     */
    @Field("vehicle_type")
    private String vehicleType;

    /**
     * 车长要求(逗号隔开）
     */
    @Field("vehicle_length")
    private String vehicleLength;

    /**
     * 货物类型
     */
    @Field("goods_type")
    private String goodsType;

    /**
     * 货物详情
     */
    @Field("goods_description")
    private String goodsDescription;

    /**
     * 装卸要求
     */
    @Field("order_remarks")
    private String orderRemarks;

    /**
     * 承运重量
     */
    @Field("weight")
    private BigDecimal weight;

    /**
     * 承运体积
     */
    @Field("volume")
    private BigDecimal volume;

    /**
     * 单位(1吨.2方 3:千克 4:公里)
     */
    @Field("measure")
    private Integer measure;

    /**
     * 接单/抢单时间
     */
    @Field("confirm_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date confirmTime = new Date();

    /**
     * 计费方式(1整车计费;2单价计费)
     */
    @Field("fee_type")
    private Integer feeType;

    /**
     * 整车费用（不含税）
     */
    @Field("freight")
    private BigDecimal freight;

    /**
     * 整车计费（含税）
     */
    @Field("tax_freight")
    private BigDecimal taxFreight;

    /**
     * 货主
     */
    @Field("owner_user_id")
    private Integer ownerUserId;

    /**
     * 货主企业名
     */
    @Field("owner_name")
    private String ownerName;

    /**
     * 司机收入
     */
    @Field("driver_amount")
    private BigDecimal driverAmount;

    /**
     * 司机
     */
    @Field("driver_user_id")
    private Integer driverUserId;

    /**
     * 司机名字
     */
    @Field("driver_name")
    private String driverName;

    /**
     * 车辆
     */
    @Field("vehicle_id")
    private String vehicleId;

    /**
     * 创建时间
     */
    @Field("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createTime = new Date();

    /**
     * 修改时间
     */
    @Field("update_time")
    private Date updateTime = new Date();

    @Field("end_province_str")
    private String endProvinceStr;

    @Field("end_city_str")
    private String endCityStr;

    @Field("end_area_str")
    private String endAreaStr;

    @Field("star_city_str")
    private String starCityStr;

    @Field("star_province_str")
    private String starProvinceStr;

    @Field("star_area_str")
    private String starAreaStr;

    @Field("goods_type_str")
    private String goodsTypeStr;

    /**
     * 运单来源 1指派 2抢单
     */
    @Field("tran_type")
    private Integer tranType;

    /**
     * 车牌号
     */
    @Field("plate_number")
    private String plateNumber;

    /**
     * 原含税运费
     */
    @Field("tax_price_settle")
    private BigDecimal taxPriceSettle;

    /**
     * 最终不含税运费
     */
    @Field("price_settle")
    private BigDecimal priceSettle;

    @Field("rate")
    private BigDecimal rate = BigDecimal.TEN;

    @Field("number")
    private Integer number;

    /**
     * 车队长
     */
    @Field("captain_user_id")
    private Integer captainUserId;

    /**
     * 代收金额
     */
    @Field("captain_amount")
    private BigDecimal captainAmount;

    /**
     * 原总价格运费
     */
    @Field("total_original_price")
    private BigDecimal totalOriginalPrice;


    /**
     * 运费支付状态：0-未支付、1-部分支付、2-已支付 3-退款中 4-已退款
     */
    @Field("pay_status")
    private Integer payStatus;

    /**
     * 已支付金额
     */
    @Field("paid_price")
    private BigDecimal paidPrice;

    /**
     * 待支付金额
     */
    @Field("un_paid_price")
    private BigDecimal unPaidPrice;

    /**
     * 运单异常码：
     * 1-异常
     * 2-正常
     */
    @Field("abnormal")
    private Integer abnormal = 1;

    @Field("all_distance")
    private BigDecimal allDistance;

    /**
     * 1:网货 2:城配
     */
    @Field("business_type")
    private Integer businessType = 1;

    /**
     * 支付方式
     */
    @Field("payment_mode")
    private Integer paymentMode = 1;

    /**
     * 运单完成时间
     */
    @Field("complete_time")
    private Date completeTime = new Date();

    /**
     * 上传状态 0未上传 1上传失败 2上传中 3已上传
     */
    @Field(value = "upload_status")
    private Integer uploadStatus;
}

