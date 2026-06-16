package cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.in;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "管理后台 - ERP 稻谷收购入库新增/修改 Request VO")
@Data
public class ErpGrainPurchaseSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "17386")
    private Long id;

    @Schema(description = "收购时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "收购时间不能为空")
    private LocalDateTime purchaseTime;

    @Schema(description = "'售粮人姓名'", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "售粮人姓名不能为空")
    private String sellerName;


    @Schema(description = "粮食品种", requiredMode = Schema.RequiredMode.REQUIRED)
    private int grainType;

    @Schema(description = "'季节'", requiredMode = Schema.RequiredMode.REQUIRED)
    private int season;

    @Schema(description = "''稻谷状态''", requiredMode = Schema.RequiredMode.REQUIRED)
    private int grainStatus;

    @Schema(description = "车牌号", example = "你猜")
    private String plateNo;

    @Schema(description = "毛重(kg)", requiredMode = Schema.RequiredMode.REQUIRED)
    private int grossWeight;

    @Schema(description = "皮重(kg)", requiredMode = Schema.RequiredMode.REQUIRED)
    private int tareWeight;

    @Schema(description = "净重(kg)", requiredMode = Schema.RequiredMode.REQUIRED)
    private int netWeight;

    @Schema(description = "水分", requiredMode = Schema.RequiredMode.REQUIRED)
    private int moisture;


    @Schema(description = "重金属值", example = "7127")
    private BigDecimal heavyMetal;

    @Schema(description = "扣杂", example = "7127")
    private BigDecimal deduction;

    @Schema(description = "结算单价(元/kg)", example = "7127")
    private BigDecimal unitPrice;

    @Schema(description = "金额(元)", example = "7127")
    private BigDecimal amount;

    @Schema(description = "卸车人", example = "你猜")
    private String unloader;

    @Schema(description = "备注", example = "你猜")
    private String remark;

}