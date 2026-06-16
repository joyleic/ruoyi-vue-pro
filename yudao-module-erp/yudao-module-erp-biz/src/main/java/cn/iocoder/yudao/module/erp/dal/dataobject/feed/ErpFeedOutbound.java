package cn.iocoder.yudao.module.erp.dal.dataobject.feed;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 饲料稻谷出库实体类
 */
@Data
@TableName("erp_feed_outbound")
public class ErpFeedOutbound extends BaseDO {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("contract_no")
    private String contractNo;

    @TableField("outbound_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate outboundDate;

    @TableField("unit_price")
    private BigDecimal unitPrice;

    @TableField("weight")
    private BigDecimal weight;

    @TableField("total_amount")
    private BigDecimal totalAmount;

    @TableField("payment_method")
    private String paymentMethod;

    @TableField("packing_type")
    private String packingType;

    @TableField("is_paid")
    private Boolean isPaid;

    @TableField("customer_name")
    private String customerName;

    @TableField("customer_phone")
    private String customerPhone;

    @TableField("customer_address")
    private String customerAddress;

    @TableField("vehicle_no")
    private String vehicleNo;

    @TableField("remark")
    private String remark;

    @TableField("payee_name")
    private String payeeName;

}
