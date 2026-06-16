package cn.iocoder.yudao.module.erp.dal.mysql.purchase;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.erp.controller.admin.purchase.vo.vehicle.ErpVehiclePageReqVO;
import cn.iocoder.yudao.module.erp.dal.dataobject.purchase.ErpVehliceDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ERP 供应商 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ErpVehicleMapper extends BaseMapperX<ErpVehliceDO> {

    default PageResult<ErpVehliceDO> selectPage(ErpVehiclePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ErpVehliceDO>()
                .likeIfPresent(ErpVehliceDO::getName, reqVO.getName())
                .likeIfPresent(ErpVehliceDO::getPhone, reqVO.getPhone())
                .likeIfPresent(ErpVehliceDO::getLicPlateNumber, reqVO.getLicPlateNumber())
                .orderByDesc(ErpVehliceDO::getId));
    }

    default List<ErpVehliceDO> selectListByStatus() {
        return selectList();
    }

}