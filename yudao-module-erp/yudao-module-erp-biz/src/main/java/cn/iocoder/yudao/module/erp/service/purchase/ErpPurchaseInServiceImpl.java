package cn.iocoder.yudao.module.erp.service.purchase;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.in.ErpPurchaseInPageReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.in.ErpGrainPurchaseSaveReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.pay.PurchasePayVo;
import cn.iocoder.yudao.module.erp.dal.dataobject.purchase.ErpPurchaseInDO;
import cn.iocoder.yudao.module.erp.dal.dataobject.purchase.ErpPurchaseInItemDO;
import cn.iocoder.yudao.module.erp.dal.dataobject.purchase.ErpPayOrderDO;
import cn.iocoder.yudao.module.erp.dal.mysql.purchase.ErpPurchaseInItemMapper;
import cn.iocoder.yudao.module.erp.dal.mysql.purchase.ErpPurchaseInMapper;
import cn.iocoder.yudao.module.erp.dal.mysql.purchase.ErpPurchasePayMapper;
import cn.iocoder.yudao.module.erp.dal.redis.no.ErpNoRedisDAO;
import cn.iocoder.yudao.module.erp.service.finance.ErpAccountService;
import cn.iocoder.yudao.module.erp.service.product.ErpProductService;
import cn.iocoder.yudao.module.erp.service.stock.ErpStockRecordService;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.erp.enums.ErrorCodeConstants.*;

// TODO 芋艿：记录操作日志

/**
 * ERP 采购入库 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ErpPurchaseInServiceImpl implements ErpPurchaseInService {

    @Resource
    private ErpPurchaseInMapper purchaseInMapper;
    @Resource
    private ErpPurchaseInItemMapper purchaseInItemMapper;

    @Resource
    private ErpPurchasePayMapper purchasePayMapper;

    @Resource
    private ErpNoRedisDAO noRedisDAO;

    @Resource
    private ErpProductService productService;
    @Resource
    @Lazy // 延迟加载，避免循环依赖
    private ErpPurchaseOrderService purchaseOrderService;
    @Resource
    private ErpAccountService accountService;
    @Resource
    private ErpStockRecordService stockRecordService;

    @Resource
    private AdminUserApi adminUserApi;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createPurchaseIn(ErpGrainPurchaseSaveReqVO createReqVO) {

        ErpPurchaseInDO purchaseIn = BeanUtils.toBean(createReqVO, ErpPurchaseInDO.class);
        purchaseInMapper.insert(purchaseIn);
        return purchaseIn.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePurchaseIn(ErpGrainPurchaseSaveReqVO updateReqVO) {
        ErpPurchaseInDO purchaseIn = BeanUtils.toBean(updateReqVO, ErpPurchaseInDO.class);
        purchaseInMapper.updateById(purchaseIn);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePurchaseInStatus(Long id, Integer status) {

    }

    @Override
    public void updatePurchaseInPaymentPrice(Long id, BigDecimal paymentPrice) {
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletePurchaseIn(List<Long> ids) {

    }

    private ErpPurchaseInDO validatePurchaseInExists(Long id) {
        ErpPurchaseInDO purchaseIn = purchaseInMapper.selectById(id);
        if (purchaseIn == null) {
            throw exception(PURCHASE_IN_NOT_EXISTS);
        }
        return purchaseIn;
    }

    @Override
    public ErpPurchaseInDO getPurchaseIn(Long id) {
        return purchaseInMapper.selectById(id);
    }

    @Override
    public ErpPurchaseInDO validatePurchaseIn(Long id) {
        return  null;
    }

    @Override
    public PageResult<ErpPurchaseInDO> getPurchaseInPage(ErpPurchaseInPageReqVO pageReqVO) {
        return purchaseInMapper.selectPage(pageReqVO);
    }

    // ==================== 采购入库项 ====================

    @Override
    public List<ErpPurchaseInItemDO> getPurchaseInItemListByInId(Long inId) {
        return purchaseInItemMapper.selectListByInId(inId);
    }

    @Override
    public List<ErpPurchaseInItemDO> getPurchaseInItemListByInIds(Collection<Long> inIds) {
        if (CollUtil.isEmpty(inIds)) {
            return Collections.emptyList();
        }
        return purchaseInItemMapper.selectListByInIds(inIds);
    }

    @Override
    public Long createPurchasePay(@Valid PurchasePayVo createReqVO) {
        ErpPayOrderDO dto = BeanUtils.toBean(createReqVO, ErpPayOrderDO.class);
        purchasePayMapper.insert(dto);
        ErpPurchaseInDO inDo = new ErpPurchaseInDO();
        Long ids = Long.valueOf(createReqVO.getOrderNo());
        inDo.setId(ids);
            inDo.setIsFinish(String.valueOf(createReqVO.getIsFinish()));
            inDo.setRealPay(createReqVO.getTempPay());
            purchaseInMapper.updateById(inDo);
        return dto.getId();
    }

}
