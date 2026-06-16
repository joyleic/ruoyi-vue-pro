package cn.iocoder.yudao.module.erp.service.purchase;

import cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.in.ErpPurchaseInPageReqVO;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.time.format.DateTimeFormatter;

public class RicePurchasePrinter implements Printable {

    private final ErpPurchaseInPageReqVO bill;
    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public RicePurchasePrinter(ErpPurchaseInPageReqVO bill) {
        this.bill = bill;
    }

    // 对外调用打印
    public static void print(ErpPurchaseInPageReqVO bill, String printerName) throws Exception {
        PrinterJob job = PrinterJob.getPrinterJob();
        PrintService service = findPrinter(printerName);
        if (service == null) throw new RuntimeException("未找到打印机：" + printerName);

        job.setPrintService(service);
        job.setPrintable(new RicePurchasePrinter(bill));

        PrintRequestAttributeSet attrs = new HashPrintRequestAttributeSet();
        attrs.add(new Copies(1));
        job.print(attrs);
    }

    // 查找打印机
    private static PrintService findPrinter(String name) {
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
        for (PrintService s : services) {
            if (s.getName().contains(name)) return s;
        }
        return PrintServiceLookup.lookupDefaultPrintService();
    }

    // ==================== 绘制表格 ====================
/*    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

        // ========== 字体设置：按单据层级设置大小 ==========
        Font titleFont = new Font("宋体", Font.BOLD, 15);    // 大标题
        Font headerFont = new Font("宋体", Font.BOLD, 8);   // 表头
        Font contentFont = new Font("宋体", Font.PLAIN, 8); // 内容
        g2d.setFont(titleFont);

        int x = 10;
        int y = 40;
        int colWidth = 50; // 每列宽度，适配针式打印机241纸

        // ========== 1. 标题 ==========
        String fullTitle = "湖南东安穗星农业发展有限公司粮食收购结算单";
        int titleWidth = g2d.getFontMetrics().stringWidth(fullTitle);
        g2d.drawString(fullTitle, (int) (pageFormat.getImageableWidth() - titleWidth) /3, y+g2d.getFontMetrics().getAscent());
        y += 15;

        // 日期靠右
        g2d.setFont(contentFont);
        g2d.drawString("结算日期：" + bill.getPurchaseTime(), (int) pageFormat.getImageableWidth() - 100, y);
        y += 10;

        // ========== 2. 表格1：客户信息 ==========
        drawLine(g2d, 5 ,y, x + colWidth * 12, y);
        drawLine(g2d, 5, y, x, y + 20);

        drawLine(g2d, x + colWidth, y, x + colWidth, y + 20);
        drawLine(g2d, x + colWidth * 2, y, x + colWidth * 2, y + 20);
        drawLine(g2d, x + colWidth * 3, y, x + colWidth * 3, y + 20);
        drawLine(g2d, x + colWidth * 4+50, y, x + colWidth * 4, y + 20);
        drawLine(g2d, x + colWidth * 5, y, x + colWidth * 5, y + 20);
        drawLine(g2d, x + colWidth * 6, y, x + colWidth * 6, y + 20);
        drawLine(g2d, x + colWidth * 7, y, x + colWidth * 7, y + 20);
        drawLine(g2d, x + colWidth * 8, y, x + colWidth * 8, y + 20);

        // 表头文字
        g2d.setFont(headerFont);
        g2d.drawString("客户姓名", x + 5, y + 15);
        g2d.drawString("身份证号", x + colWidth *2+ 5, y + 15);
        g2d.drawString("售粮人电话", x + colWidth *4+ 5, y + 15);
        g2d.drawString("车牌号", x + colWidth *6+ 5, y + 15);

       // g2d.drawString("地址", x + 5, y + 35);

        // 内容文字
        g2d.setFont(contentFont);
        g2d.drawString(bill.getSellerName(), x + colWidth + 5, y + 15);
        g2d.drawString("431103199112055455", x + colWidth * 3 + 5, y + 15);
        g2d.drawString("13266858566", x + colWidth  * 5+ 5, y + 15);
        g2d.drawString(bill.getPlateNo(), x + colWidth  * 7+ 5, y + 15);

        //g2d.drawString("永州市东安县", x + colWidth + 5, y + 35);

        drawLine(g2d, x, y + 40, x + colWidth * 8, y + 40);
        y += 40;

        // ========== 3. 表格2：粮食信息 ==========
      *//*  drawLine(g2d, x, y, x + colWidth * 8, y);
        drawLine(g2d, x, y, x, y + 40);
        drawLine(g2d, x + colWidth, y, x + colWidth, y + 40);
        drawLine(g2d, x + colWidth * 2, y, x + colWidth * 2, y + 40);
        drawLine(g2d, x + colWidth * 3, y, x + colWidth * 3, y + 40);
        drawLine(g2d, x + colWidth * 4, y, x + colWidth * 4, y + 40);
        drawLine(g2d, x + colWidth * 5, y, x + colWidth * 5, y + 40);
        drawLine(g2d, x + colWidth * 6, y, x + colWidth * 6, y + 40);
        drawLine(g2d, x + colWidth * 7, y, x + colWidth * 7, y + 40);
        drawLine(g2d, x + colWidth * 8, y, x + colWidth * 8, y + 40);

        g2d.setFont(headerFont);
        g2d.drawString("粮食品种", x + colWidth + 5, y + 15);
        g2d.drawString("季节", x + colWidth * 7 + 5, y + 15);
        g2d.drawString("水份", x + colWidth * 5 + 5, y + 15);
        g2d.drawString("杂质", x + colWidth * 7 + 5, y + 15);

        g2d.setFont(contentFont);
        g2d.drawString(bill.getGrainType()+"", x + colWidth + 5, y + 15);
        g2d.drawString(bill.getSeason()+"", x + colWidth * 2 + 5, y + 15);
        g2d.drawString(bill.getMoisture()+"", x + colWidth * 2 + 5, y + 15);
        g2d.drawString(bill.getDeduction()+"", x + colWidth * 6 + 5, y + 15);

        drawLine(g2d, x, y + 40, x + colWidth * 8, y + 40);
        y += 40;

        // ========== 4. 表格3：重量扣量 ==========
        drawLine(g2d, x, y, x + colWidth * 8, y);
        drawLine(g2d, x, y, x, y + 40);
        drawLine(g2d, x + colWidth, y, x + colWidth, y + 40);
        drawLine(g2d, x + colWidth * 2, y, x + colWidth * 2, y + 40);
        drawLine(g2d, x + colWidth * 3, y, x + colWidth * 3, y + 40);
        drawLine(g2d, x + colWidth * 4, y, x + colWidth * 4, y + 40);
        drawLine(g2d, x + colWidth * 5, y, x + colWidth * 5, y + 40);
        drawLine(g2d, x + colWidth * 6, y, x + colWidth * 6, y + 40);
        drawLine(g2d, x + colWidth * 7, y, x + colWidth * 7, y + 40);
        drawLine(g2d, x + colWidth * 8, y, x + colWidth * 8, y + 40);

        g2d.setFont(headerFont);
        g2d.drawString("毛重", x + 5, y + 15);
        g2d.drawString("皮重", x + colWidth + 5, y + 15);
        g2d.drawString("水份扣量", x + colWidth * 2 + 5, y + 15);
        g2d.drawString("杂质扣量", x + colWidth * 4 + 5, y + 15);

        g2d.drawString("净重", x + colWidth * 4 + 5, y + 35);

        g2d.setFont(contentFont);
        g2d.drawString(bill.getGrossWeight()+"", x + colWidth + 5, y + 15);
        g2d.drawString(bill.getTareWeight()+"", x + colWidth * 2 + 5, y + 15);
        g2d.drawString(bill.getMoisture()+"", x + colWidth * 3 + 5, y + 15);
        g2d.drawString(bill.getDeduction().toString(), x + colWidth * 5 + 5, y + 15);

        g2d.drawString(bill.getNetWeight()+"", x + colWidth * 4 + 5, y + 35);

        drawLine(g2d, x, y + 40, x + colWidth * 8, y + 40);
        y += 40;

        // ========== 5. 表格4：结算信息 ==========
        drawLine(g2d, x, y, x + colWidth * 8, y);
        drawLine(g2d, x, y, x, y + 20);
        drawLine(g2d, x + colWidth * 2, y, x + colWidth * 2, y + 20);
        drawLine(g2d, x + colWidth * 4, y, x + colWidth * 4, y + 20);
        drawLine(g2d, x + colWidth * 8, y, x + colWidth * 8, y + 20);

        g2d.setFont(headerFont);
        g2d.drawString("结算单价", x + 5, y + 15);
        g2d.drawString("金额", x + colWidth * 2 + 5, y + 15);
        g2d.drawString("金额大写", x + colWidth * 4 + 5, y + 15);

        g2d.setFont(contentFont);
        g2d.drawString(bill.getUnitPrice().toString(), x + colWidth + 5, y + 15);
        g2d.drawString(bill.getAmount().toString(), x + colWidth * 3 + 5, y + 15);
        g2d.drawString(bill.getAmount().toString(), x + colWidth * 5 + 5, y + 15);

        drawLine(g2d, x, y + 20, x + colWidth * 8, y + 20);
        y += 20;

        // ========== 6. 表格5：收款信息 ==========
        drawLine(g2d, x, y, x + colWidth * 8, y);
        drawLine(g2d, x, y, x, y + 20);
        drawLine(g2d, x + colWidth * 2, y, x + colWidth * 2, y + 20);
        drawLine(g2d, x + colWidth * 4, y, x + colWidth * 4, y + 20);
        drawLine(g2d, x + colWidth * 6, y, x + colWidth * 6, y + 20);
        drawLine(g2d, x + colWidth * 8, y, x + colWidth * 8, y + 20);

        g2d.setFont(headerFont);
        g2d.drawString("收款方姓名", x + 5, y + 15);
        g2d.drawString("账号", x + colWidth * 2 + 5, y + 15);
        g2d.drawString("开户行", x + colWidth * 6 + 5, y + 15);

        g2d.setFont(contentFont);
        g2d.drawString("張三", x + colWidth + 5, y + 15);
        g2d.drawString("9999999", x + colWidth * 3 + 5, y + 15);
        g2d.drawString("中國農業銀行", x + colWidth * 7 + 5, y + 15);

        drawLine(g2d, x, y + 20, x + colWidth * 8, y + 20);
        y += 20;

        // ========== 7. 底部签字栏 ==========
        drawLine(g2d, x, y, x + colWidth * 8, y);
        drawLine(g2d, x, y, x, y + 20);
        drawLine(g2d, x + colWidth * 2, y, x + colWidth * 2, y + 20);
        drawLine(g2d, x + colWidth * 4, y, x + colWidth * 4, y + 20);
        drawLine(g2d, x + colWidth * 6, y, x + colWidth * 6, y + 20);
        drawLine(g2d, x + colWidth * 8, y, x + colWidth * 8, y + 20);

        g2d.setFont(headerFont);
        g2d.drawString("检验员", x + 5, y + 15);
        g2d.drawString("检斤员", x + colWidth * 2 + 5, y + 15);
        g2d.drawString("结算员", x + colWidth * 4 + 5, y + 15);
        g2d.drawString("客户签名", x + colWidth * 6 + 5, y + 15);

        g2d.setFont(contentFont);
        g2d.drawString("張三", x + colWidth + 5, y + 15);
        g2d.drawString("張三", x + colWidth * 3 + 5, y + 15);
        g2d.drawString("張三", x + colWidth * 5 + 5, y + 15);
        g2d.drawString(" ", x + colWidth * 7 + 5, y + 15);

        drawLine(g2d, x, y + 20, x + colWidth * 8, y + 20);
*//*
        return PAGE_EXISTS;
    }*/

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // ========== 全局边距 ==========
        final int TOP_MARGIN = 10;   // 标题距顶部10px
        final int LEFT_MARGIN = 10;  // 表格距左边10px
        int pageWidth = (int) pageFormat.getImageableWidth();
        int y=40;

        // ========== 1. 公司标题 居中 ==========
        Font companyFont = new Font("宋体", Font.BOLD, 16);
        g2d.setFont(companyFont);
        String companyName = "湖南东安穗星农业发展有限公司粮食收购结算单";
        int titleW = g2d.getFontMetrics(companyFont).stringWidth(companyName);
        int titleX = (pageWidth - titleW) / 2;
        int titleY = TOP_MARGIN + g2d.getFontMetrics().getAscent();
        g2d.drawString(companyName, titleX, titleY);

        y += 25;

        // 日期靠右
        g2d.setFont(new Font("宋体", Font.BOLD, 12));
        g2d.drawString("结算日期：" + fmt.format(bill.getPurchaseTime()), (int) pageFormat.getImageableWidth() - 120, y);
        y += 20;

        // ========== 3. 客户信息表格（两排：表头+数据） ==========

        // 列宽（身份证加宽，确保18位完整显示）
        int colName   = 60;    // 客户姓名
        int colIdCard = 120;   // 身份证号（加宽）
        int colPhone  = 90;   // 售粮人电话
        int colCarNo  = 60;    // 车牌号

        // 表格总宽度（确保右边竖线完整）
        int totalTableWidth = colName + colIdCard + colPhone + colCarNo;
        int tableLeft = LEFT_MARGIN; // 表格整体靠左10px

        // ========== 表格外框 & 竖线 ==========
        g2d.setFont(new Font("宋体", Font.PLAIN, 10));
        // 外框线
        g2d.drawLine(tableLeft, y, tableLeft + totalTableWidth, y); // 顶线
        g2d.drawLine(tableLeft, y, tableLeft, y + 50);              // 左线
        g2d.drawLine(tableLeft + totalTableWidth, y, tableLeft + totalTableWidth, y + 50); // 右线
        g2d.drawLine(tableLeft, y + 50, tableLeft + totalTableWidth, y + 50); // 底线

        // 列分隔竖线（每列之间的线）
        g2d.drawLine(tableLeft + colName, y, tableLeft + colName, y + 50);
        g2d.drawLine(tableLeft + colName + colIdCard, y, tableLeft + colName + colIdCard, y + 50);
        g2d.drawLine(tableLeft + colName + colIdCard + colPhone, y, tableLeft + colName + colIdCard + colPhone, y + 50);

        // 中间横线（分隔表头和数据）
        int middleLineY = y + 25;
        g2d.drawLine(tableLeft, middleLineY, tableLeft + totalTableWidth, middleLineY);

        // ========== 上排：表头文字 ==========
        g2d.drawString("售粮人姓名",   tableLeft + 5, y + 18);
        g2d.drawString("身份证号",   tableLeft + colName + 5, y + 18);
        g2d.drawString("电话", tableLeft + colName + colIdCard + 5, y + 18);
        g2d.drawString("售粮人地址",     tableLeft + colName + colIdCard + colPhone + 5, y + 18);

        // ========== 下排：对应数据（单独一行，不再和表头挤在一起） ==========
        g2d.drawString("张三",           tableLeft + 5, middleLineY + 18);
        g2d.drawString("43110556256355", tableLeft + colName + 5, middleLineY + 18);
        g2d.drawString("13266858566",    tableLeft + colName + colIdCard + 5, middleLineY + 18);
        g2d.drawString("芦洪市镇西江桥村",       tableLeft + colName + colIdCard + colPhone + 5, middleLineY + 18);

        return PAGE_EXISTS;

    }

    // 画横线/竖线工具方法
    private void drawLine(Graphics2D g2d, int x1, int y1, int x2, int y2) {
        g2d.drawLine(x1, y1, x2, y2);
    }
}
