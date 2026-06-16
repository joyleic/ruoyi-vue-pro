package cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.pay;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - ERP 稻谷收购支付新增/修改 Request VO")
@Data
public class PurchasePayVo {
    private Long id; //修改时传

    private String orderNo;

    @NotNull(message = "支付时间不能为空")
    private LocalDateTime payTime;

    @NotNull(message = "支付方式不能为空")
    private String payType;

    @NotNull(message = "实付金额不能为空")
    private BigDecimal realPay;

    @NotNull(message = "已付金额不能为空")
    private BigDecimal tempPay;

    @NotNull(message = "是否完结不能为空")
    private Integer isFinish;

    private String remark;
}
