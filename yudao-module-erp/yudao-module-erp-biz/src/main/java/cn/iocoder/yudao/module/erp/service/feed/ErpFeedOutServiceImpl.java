package cn.iocoder.yudao.module.erp.service.feed;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import cn.iocoder.yudao.module.erp.controller.admin.feed.vo.out.ErpFeedOutPageReqVO;
import cn.iocoder.yudao.module.erp.controller.admin.feed.vo.out.ErpFeedOutSaveReqVO;
import cn.iocoder.yudao.module.erp.dal.dataobject.feed.ErpFeedOutbound;
import cn.iocoder.yudao.module.erp.dal.mysql.feed.ErpFeedOutMapper;
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
public class ErpFeedOutServiceImpl implements ErpFeedOutEnterService {

    @Resource
    private ErpFeedOutMapper feedOutMapper;

    @Override
    public Long createOutFeed(ErpFeedOutSaveReqVO createReqVO) {
        ErpFeedOutbound vehliceDO  = BeanUtils.toBean(createReqVO, ErpFeedOutbound.class);
        feedOutMapper.insert(vehliceDO);
        return vehliceDO.getId();
    }

    @Override
    public void updateOutFeed(ErpFeedOutSaveReqVO updateReqVO) {
        // 校验存在
        validateFeedExists(updateReqVO.getId());
        // 更新
        ErpFeedOutbound updateObj = BeanUtils.toBean(updateReqVO, ErpFeedOutbound.class);
        feedOutMapper.updateById(updateObj);
    }

    @Override
    public void deleteOutFeed(Long id) {
        // 校验存在
        validateFeedExists(id);
        // 删除
        feedOutMapper.deleteById(id);
    }

    private void validateFeedExists(Long id) {
        if (feedOutMapper.selectById(id) == null) {
            throw exception(FEED_ENTER_NOT_EXISTS);
        }
    }

    @Override
    public ErpFeedOutbound getFeedOut(Long id) {
        return feedOutMapper.selectById(id);
    }

    @Override
    public ErpFeedOutbound validateFeedOut(Long id) {
        ErpFeedOutbound vehlice = feedOutMapper.selectById(id);
        if (vehlice == null) {
            throw exception(FEED_ENTER_NOT_EXISTS);
        }
        return null;
    }

    @Override
    public List<ErpFeedOutbound> getFeedOutList(Collection<Long> ids) {
        return feedOutMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<ErpFeedOutbound> getFeedOutPage(ErpFeedOutPageReqVO pageReqVO) {
        return feedOutMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ErpFeedOutbound> getSupplierList() {
        return feedOutMapper.selectList();
    }


}