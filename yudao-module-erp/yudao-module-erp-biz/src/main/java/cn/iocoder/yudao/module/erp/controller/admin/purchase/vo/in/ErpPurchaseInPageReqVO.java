package cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.in;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - ERP 采购入库分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ErpPurchaseInPageReqVO extends PageParam {

    public static final Integer PAYMENT_STATUS_NONE = 0;
    public static final Integer PAYMENT_STATUS_PART = 1;
    public static final Integer PAYMENT_STATUS_ALL = 2;


    @Schema(description = "编号")
    private Long id;

    @Schema(description = "收购时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime purchaseTime;

    @Schema(description = "入库时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] inTime;

    @Schema(description = "'售粮人姓名'")
    private String sellerName;

    @Schema(description = "'身份证'")
    private String idCard;


    @Schema(description = "电话")
    private String phone;

    @Schema(description = "地址")
    private String address;

    @Schema(description = "粮食品种")
    private String grainType;

    @Schema(description = "粮食品种名称")
    private String grainTypeName;

    @Schema(description = "'季节'")
    private Integer season;

    @Schema(description = "'季节'")
    private String seasonName;

    @Schema(description = "''稻谷状态''")
    private Integer grainStatus;

    @Schema(description = "''稻谷状态''")
    private String grainStatusName;

    @Schema(description = "车牌号", example = "你猜")
    private String plateNo;

    @Schema(description = "毛重(kg)")
    private Integer grossWeight;

    @Schema(description = "皮重(kg)")
    private Integer tareWeight;

    @Schema(description = "净重(kg)")
    private Integer netWeight;

    @Schema(description = "纯净重(kg)")
    private Integer pureWeight;

    @Schema(description = "水分")
    private Integer moisture;

    @Schema(description = "水分扣重")
    private Integer moistDeduction;


    @Schema(description = "重金属值")
    private BigDecimal heavyMetal;

    @Schema(description = "扣杂")
    private BigDecimal deduction;

    @Schema(description = "扣杂扣重")
    private BigDecimal deductionKg;

    @Schema(description = "结算单价(元/kg)")
    private BigDecimal unitPrice;

    @Schema(description = "金额(元)")
    private BigDecimal amount;

    @Schema(description = "应付金额(元)")
    private BigDecimal realPay;

    @Schema(description = "是否支付完结")
    private String isFinish;

    @Schema(description = "卸车人")
    private String unloader;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "收款方姓名")
    private String bankName;

    @Schema(description = "账号")
    private String bankAccount;

    @Schema(description = "开户行")
    private String bankAddress;


}