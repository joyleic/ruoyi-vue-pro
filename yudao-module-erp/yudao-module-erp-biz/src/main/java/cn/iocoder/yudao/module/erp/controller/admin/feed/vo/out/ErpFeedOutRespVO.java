package cn.iocoder.yudao.module.erp.controller.admin.feed.vo.out;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - ERP 饲料谷管理 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ErpFeedOutRespVO {

    @Schema(description = "饲料谷出库编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "17791")
    @ExcelProperty("饲料谷出库编号")
    private Long id;

    /**
     * 合同编号
     */
    @Schema(description = "合同编号", example = "000000")
    @ExcelProperty("合同编号")
    private String contractNo;

    /**
     * 客户名称
     */
    @Schema(description = "客户名称", example = "张三")
    @ExcelProperty("客户名称")
    private String customerName;

    /**
     * 客户电话
     */
    @Schema(description = "客户电话", example = "19310370558")
    @ExcelProperty("客户电话")
    private String customerPhone;

    /**
     * 溯源地
     */
    @Schema(description = "客户地址", example = "湖南")
    @ExcelProperty("客户地址")
    private String customerAddress;

    /**
     * 结算单价(元/吨)
     */
    @Schema(description = "结算单价(元/斤)", example = "2200")
    @ExcelProperty("结算单价(元/斤)")
    private BigDecimal unitPrice;

    /**
     * 重量(斤)
     */
    @Schema(description = "重量(斤)", example = "35")
    @ExcelProperty("重量(斤)")
    private BigDecimal weight;

    /**
     * 金额(元)
     */
    @Schema(description = "金额(元)", example = "15")
    @ExcelProperty("金额(元)")
    private BigDecimal totalAmount;

    /**
     * 出库时间
     */
    @Schema(description = "出库时间", example = "2025-12-15")
    @ExcelProperty("出库时间")
    private LocalDateTime outboundDate;

    /**
     * 支付方式(cash:现金, company_scan:公司扫码, private_transfer:私人转账)
     */
    @Schema(description = "支付方式", example = "0")
    @ExcelProperty("支付方式")
    private String paymentMethod;

    /**
     * 支包装类型(packed:包装, bulk:散装)
     */
    @Schema(description = "支包装类型", example = "0")
    @ExcelProperty("支包装类型")
    private String packingType;

    /**
     * 是否付款(0:未付, 1:已付)
     */
    @Schema(description = "是否付款", example = "0")
    @ExcelProperty("是否付款")
    private String isPaid;

    /**
     * 收款人
     */
    @Schema(description = "收款人", example = "张三")
    @ExcelProperty("收款人")
    private String payeeName;

    /**
     * 备注
     */
    @Schema(description = "备注", example = "你猜")
    @ExcelProperty("备注")
    private String remark;

}