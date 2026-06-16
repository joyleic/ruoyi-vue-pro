package cn.iocoder.yudao.module.erp.service.feed;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.erp.controller.admin.feed.vo.enter.ErpFeedPageReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.feed.vo.enter.ErpFeedSaveReqVO;
import cn.iocoder.yudao.module.erp.dal.dataobject.feed.ErpFeedStorage;
import cn.iocoder.yudao.module.erp.dal.dataobject.purchase.ErpVehliceDO;
import cn.iocoder.yudao.module.erp.dal.mysql.feed.ErpFeedEnterMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.erp.enums.ErrorCodeConstants.FEED_ENTER_NOT_EXISTS;

/**
 * ERP 饲料谷入库 Service 实现类
 *
 */
@Service
@Validated
public class ErpFeedEnterServiceImpl implements ErpFeedEnterService {

    @Resource
    private ErpFeedEnterMapper feedEnterMapper;

    @Override
    public Long createFeed(ErpFeedSaveReqVO createReqVO) {
        ErpFeedStorage vehliceDO  = BeanUtils.toBean(createReqVO, ErpFeedStorage.class);
        feedEnterMapper.insert(vehliceDO);
        return vehliceDO.getId();
    }

    @Override
    public void updateFeed(ErpFeedSaveReqVO updateReqVO) {
        // 校验存在
        validateFeedExists(updateReqVO.getId());
        // 更新
        ErpFeedStorage updateObj = BeanUtils.toBean(updateReqVO, ErpFeedStorage.class);
        feedEnterMapper.updateById(updateObj);
    }

    @Override
    public void deleteFeed(Long id) {
        // 校验存在
        validateFeedExists(id);
        // 删除
        feedEnterMapper.deleteById(id);
    }

    private void validateFeedExists(Long id) {
        if (feedEnterMapper.selectById(id) == null) {
            throw exception(FEED_ENTER_NOT_EXISTS);
        }
    }

    @Override
    public ErpFeedStorage getFeedEnter(Long id) {
        return feedEnterMapper.selectById(id);
    }

    @Override
    public ErpFeedStorage validateFeedEnter(Long id) {
        ErpFeedStorage Vehlice = feedEnterMapper.selectById(id);
        if (Vehlice == null) {
            throw exception(FEED_ENTER_NOT_EXISTS);
        }
        return null;
    }

    @Override
    public List<ErpFeedStorage> getFeedEnterList(Collection<Long> ids) {
        return feedEnterMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ErpFeedStorage> getFeedPage(ErpFeedPageReqVO pageReqVO) {
        return feedEnterMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ErpFeedStorage> getSupplierList() {
        return feedEnterMapper.selectList();
    }


}