package cn.iocoder.yudao.module.erp.controller.admin.feed.vo.enter;

import cn.iocoder.yudao.framework.common.validation.Mobile;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - ERP 饲料谷入库新增/修改 Request VO")
@Data
public class ErpFeedSaveReqVO {

    @Schema(description = "饲料谷id", requiredMode = Schema.RequiredMode.REQUIRED, example = "17791")
    private Long id;

    /**
     * 合同编号
     */
    @NotBlank(message = "合同编号不能为空")
    @Size(max = 50, message = "合同编号长度不能超过50个字符")
    private String contractNo;

    /**
     * 客户名称
     */
    @NotBlank(message = "客户名称不能为空")
    @Size(max = 100, message = "客户名称长度不能超过100个字符")
    private String customerName;

    /**
     * 客户电话
     */
    @Size(max = 20, message = "客户电话长度不能超过20个字符")
    @Pattern(regexp = "^[0-9\\-\\+\\s]*$", message = "客户电话格式不正确")
    private String customerPhone;

    /**
     * 溯源地
     */
    @Size(max = 200, message = "溯源地长度不能超过200个字符")
    private String originSource;

    /**
     * 结算单价(元/吨)
     */
    @NotNull(message = "结算单价不能为空")
    @DecimalMin(value = "0.00", inclusive = false, message = "结算单价必须大于0")
    @Digits(integer = 8, fraction = 2, message = "结算单价整数部分不能超过8位，小数部分不能超过2位")
    private BigDecimal unitPrice;

    /**
     * 净重(吨)
     */
    @NotNull(message = "净重不能为空")
    @DecimalMin(value = "0.00", inclusive = false, message = "净重必须大于0")
    @Digits(integer = 8, fraction = 2, message = "净重整数部分不能超过8位，小数部分不能超过2位")
    private BigDecimal netWeight;

    /**
     * 金额(元)
     */
    @NotNull(message = "金额不能为空")
    @DecimalMin(value = "0.00", message = "金额不能小于0")
    @Digits(integer = 10, fraction = 2, message = "金额整数部分不能超过10位，小数部分不能超过2位")
    private BigDecimal totalAmount;

    /**
     * 入库时间
     */
    @NotNull(message = "入库时间不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime storageTime;

    /**
     * 车牌号
     */
    @Size(max = 20, message = "车牌号长度不能超过20个字符")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5A-Z0-9\\-\\s]*$", message = "车牌号格式不正确")
    private String plateNumber;

    /**
     * 运费(元)
     */
    @Digits(integer = 8, fraction = 2, message = "运费整数部分不能超过8位，小数部分不能超过2位")
    private BigDecimal freight;

    /**
     * 备注
     */
    @Size(max = 500, message = "备注长度不能超过500个字符")
    private String remark;



}