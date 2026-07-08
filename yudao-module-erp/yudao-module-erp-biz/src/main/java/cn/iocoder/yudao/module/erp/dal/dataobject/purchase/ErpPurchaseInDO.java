package cn.iocoder.yudao.module.erp.dal.dataobject.purchase;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import cn.iocoder.yudao.module.erp.dal.dataobject.finance.ErpAccountDO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * ERP 采购入库 DO
 *
 * @author 芋道源码
 */
@TableName(value = "grain_purchase")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErpPurchaseInDO extends BaseDO {

    /**
     * 编号
     */
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 收购时间
     */
    private LocalDateTime purchaseTime;

    /**
     * 售粮人姓名
     */
    private String sellerName;

    /**
     * 粮食品种
     */
    private String grainType;

    /**
     * 季节
     */
    private String season;

    /**
     * 稻谷状态
     */
    private String grainStatus;

    /**
     * 车牌号
     */
    private String plateNo;

    /**
     * 毛重(kg)
     */
    private BigDecimal grossWeight;

    /**
     * 皮重(kg)
     */
    private BigDecimal tareWeight;

    /**
     * 净重(kg)
     */
    private BigDecimal netWeight;

    /**
     * 纯净重(kg)
     */
    private BigDecimal pureWeight;

    /**
     * 水分
     */
    private BigDecimal moisture;

    /**
     * 水分扣重
     */
    private BigDecimal moistDeduction;

    /**
     * 重金属值
     */
    private BigDecimal heavyMetal;

    /**
     * 扣杂/元
     */
    private BigDecimal deduction;

    /**
     * 扣杂扣重
     */
    private BigDecimal deductionKg;

    /**
     * 结算单价(元/kg)
     */
    private BigDecimal unitPrice;

    /**
     * 金额(元)
     */
    private BigDecimal amount;

    /**
     * 卸车人
     */
    private String unloader;

    /**
     * 备注
     */
    private String remark;

    @Schema(description = "应付金额(元)")
    private BigDecimal realPay;

    @Schema(description = "是否支付完结")
    private String isFinish;

}