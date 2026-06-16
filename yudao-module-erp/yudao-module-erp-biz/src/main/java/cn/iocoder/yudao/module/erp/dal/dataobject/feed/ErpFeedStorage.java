package cn.iocoder.yudao.module.erp.dal.dataobject.feed;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 饲料稻谷入库实体类
 */
@Data
@TableName("erp_feed_storage")
public class ErpFeedStorage extends BaseDO {
    /**
     * 编号(主键)
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 合同编号
     */
    @TableField("contract_no")
    private String contractNo;

    /**
     * 客户名称
     */
    @TableField("customer_name")
    private String customerName;

    /**
     * 客户电话
     */
    @TableField("customer_phone")
    private String customerPhone;

    /**
     * 溯源地
     */
    @TableField("origin_source")
    private String originSource;

    /**
     * 结算单价(元/吨)
     */
    @TableField("unit_price")
    private BigDecimal unitPrice;

    /**
     * 净重(吨)
     */
    @TableField("net_weight")
    private BigDecimal netWeight;

    /**
     * 金额(元)
     */
    @TableField("total_amount")
    private BigDecimal totalAmount;

    /**
     * 入库时间
     */
    @TableField("storage_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime storageTime;

    /**
     * 车牌号
     */
    @TableField("plate_number")
    private String plateNumber;

    /**
     * 运费(元)
     */
    @TableField("freight")
    private BigDecimal freight;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;


}
