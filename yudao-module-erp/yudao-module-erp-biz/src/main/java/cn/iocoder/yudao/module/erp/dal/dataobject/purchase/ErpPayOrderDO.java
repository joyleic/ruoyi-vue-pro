package cn.iocoder.yudao.module.erp.dal.dataobject.purchase;

import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@TableName("erp_pay_order") // 表名
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErpPayOrderDO extends BaseDO {
    @TableId(type = IdType.AUTO)
    private Long id; // 主键
    private LocalDateTime payTime; // 支付时间
    private String orderNo; // 业务单号
    private String payType; // 支付方式
    private BigDecimal realPay; // 实付金额
    private String remark; // 备注
}
