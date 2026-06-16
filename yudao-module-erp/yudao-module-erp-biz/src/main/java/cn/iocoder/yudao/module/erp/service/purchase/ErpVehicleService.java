package cn.iocoder.yudao.module.erp.service.purchase;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.vehicle.ErpVehiclePageReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.vehicle.ErpVehicleSaveReqVO;
import cn.iocoder.yudao.module.erp.dal.dataobject.purchase.ErpSupplierDO;
import cn.iocoder.yudao.module.erp.dal.dataobject.purchase.ErpVehliceDO;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertMap;

/**
 * ERP 车辆信息管理 Service 接口
 *
 * @author
 */
public interface ErpVehicleService {

    /**
     * 创建车辆信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createVehlice(@Valid ErpVehicleSaveReqVO createReqVO);

    /**
     * 更新车辆信息
     *
     * @param updateReqVO 更新信息
     */
    void updateVehlice(@Valid ErpVehicleSaveReqVO updateReqVO);

    /**
     * 删除车辆信息
     *
     * @param id 编号
     */
    void deleteVehlice(Long id);

    /**
     * 获得车辆信息
     *
     * @param id 编号
     * @return 供应商
     */
    ErpVehliceDO getVehicle(Long id);

    /**
     * 校验车辆信息
     *
     * @param id 编号
     * @return 车辆信息
     */
    ErpVehliceDO validateVehlice(Long id);

    /**
     * 获得车辆信息列表
     *
     * @param ids 编号列表
     * @return 供应商列表
     */
    List<ErpVehliceDO> getVehliceList(Collection<Long> ids);

    /**
     * 获得车辆信息 Map
     *
     * @param ids 编号列表
     * @return 供应商 Map
     */
    default Map<Long, ErpVehliceDO> getVehliceMap(Collection<Long> ids) {
        return convertMap(getVehliceList(ids), ErpVehliceDO::getId);
    }

    /**
     * 获得车辆信息分页
     *
     * @param pageReqVO 分页查询
     * @return 供应商分页
     */
    PageResult<ErpVehliceDO> getVehlicePage(ErpVehiclePageReqVO pageReqVO);

    /**
     * 获得指定状态的供应商列表
     *
     * @return 供应商列表
     */
    List<ErpVehliceDO> getSupplierList();


}