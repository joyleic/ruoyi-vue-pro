package cn.iocoder.yudao.module.erp.service.purchase;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.vehicle.ErpVehiclePageReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.vehicle.ErpVehicleSaveReqVO;
import cn.iocoder.yudao.module.erp.dal.dataobject.purchase.ErpVehliceDO;
import cn.iocoder.yudao.module.erp.dal.mysql.purchase.ErpVehicleMapper;
import cn.iocoder.yudao.module.erp.dal.redis.GlobalCacheUtil;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.erp.enums.ErrorCodeConstants.VEHILCE_NOT_EXISTS;

/**
 * ERP 供应商 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class ErpVehicleServiceImpl implements ErpVehicleService {

    @Resource
    private ErpVehicleMapper vehicleMapper;

    @Override
    public Long createVehlice(ErpVehicleSaveReqVO createReqVO) {
        ErpVehliceDO vehliceDO  = BeanUtils.toBean(createReqVO, ErpVehliceDO.class);
        vehicleMapper.insert(vehliceDO);
        GlobalCacheUtil.set("ve"+vehliceDO.getLicPlateNumber(),vehliceDO);
        return vehliceDO.getId();
    }

    @Override
    public void updateVehlice(ErpVehicleSaveReqVO updateReqVO) {
        // 校验存在
        validateVehicleExists(updateReqVO.getId());
        // 更新
        ErpVehliceDO updateObj = BeanUtils.toBean(updateReqVO, ErpVehliceDO.class);
        GlobalCacheUtil.set("ve"+updateObj.getLicPlateNumber(),updateObj);
        vehicleMapper.updateById(updateObj);
    }

    @Override
    public void deleteVehlice(Long id) {
        // 校验存在
      String name =  validateVehicleExists(id);
        // 删除
        vehicleMapper.deleteById(id);
        GlobalCacheUtil.remove("ve"+name);
    }

    private String validateVehicleExists(Long id) {
        ErpVehliceDO updateObj =  vehicleMapper.selectById(id);
        if (vehicleMapper.selectById(id) == null) {
            throw exception(VEHILCE_NOT_EXISTS);
        }
        return updateObj.getLicPlateNumber();
    }

    @Override
    public ErpVehliceDO getVehicle(Long id) {
        return vehicleMapper.selectById(id);
    }

    @Override
    public ErpVehliceDO validateVehlice(Long id) {
        ErpVehliceDO Vehlice = vehicleMapper.selectById(id);
        if (Vehlice == null) {
            throw exception(VEHILCE_NOT_EXISTS);
        }
        return Vehlice;
    }

    @Override
    public List<ErpVehliceDO> getVehliceList(Collection<Long> ids) {
        return vehicleMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ErpVehliceDO> getVehlicePage(ErpVehiclePageReqVO pageReqVO) {
        return vehicleMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ErpVehliceDO> getSupplierList() {
        return vehicleMapper.selectList();
    }


}