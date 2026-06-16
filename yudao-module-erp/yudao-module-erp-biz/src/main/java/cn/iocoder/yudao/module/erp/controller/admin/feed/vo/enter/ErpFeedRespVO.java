package cn.iocoder.yudao.module.erp.controller.admin.feed.vo.enter;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - ERP 饲料谷管理 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ErpFeedRespVO {

    @Schema(description = "饲料谷编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "17791")
    @ExcelProperty("饲料谷编号")
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
    @Schema(description = "货源地", example = "湖南")
    @ExcelProperty("货源地")
    private String originSource;

    /**
     * 结算单价(元/吨)
     */
    @Schema(description = "结算单价(元/吨)", example = "2200")
    @ExcelProperty("结算单价(元/吨)")
    private BigDecimal unitPrice;

    /**
     * 净重(吨)
     */
    @Schema(description = "净重(吨)", example = "35")
    @ExcelProperty("净重(吨)")
    private BigDecimal netWeight;

    /**
     * 金额(元)
     */
    @Schema(description = "金额(元)", example = "15")
    @ExcelProperty("金额(元)")
    private BigDecimal totalAmount;

    /**
     * 入库时间
     */
    @Schema(description = "入库时间", example = "2025-12-15")
    @ExcelProperty("入库时间")
    private LocalDateTime storageTime;

    /**
     * 车牌号
     */
    @Schema(description = "车牌号", example = "999999")
    @ExcelProperty("车牌号")
    private String plateNumber;

    /**
     * 运费(元)
     */
    @Schema(description = "运费", example = "15")
    @ExcelProperty("运费(元)")
    private BigDecimal freight;

    /**
     * 备注
     */
    @Schema(description = "备注", example = "你猜")
    @ExcelProperty("备注")
    private String remark;

}