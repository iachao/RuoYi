package com.ruoyi.bid.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.bid.mapper.FloorBidMapper;
import com.ruoyi.bid.domain.FloorBid;
import com.ruoyi.bid.service.IFloorBidService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.text.Convert;

/**
 * 地板报价Service业务层处理
 * 
 * @author Chaos
 * @date 2022-03-26
 */
@Service
public class FloorBidServiceImpl extends ServiceImpl<FloorBidMapper,FloorBid> implements IFloorBidService
{
    @Autowired
    private FloorBidMapper floorBidMapper;

    /**
     * 查询地板报价
     * 
     * @param id 地板报价主键
     * @return 地板报价
     */
    @Override
    public FloorBid selectFloorBidById(Long id)
    {
        return floorBidMapper.selectFloorBidById(id);
    }

    /**
     * 查询地板报价列表
     * 
     * @param floorBid 地板报价
     * @return 地板报价
     */
    @Override
    public List<FloorBid> selectFloorBidList(FloorBid floorBid)
    {
        return floorBidMapper.selectFloorBidList(floorBid);
    }

    /**
     * 新增地板报价
     * 
     * @param floorBid 地板报价
     * @return 结果
     */
    @Override
    public int insertFloorBid(FloorBid floorBid)
    {
        floorBid.setCreateTime(DateUtils.getNowDate());
        return floorBidMapper.insertFloorBid(floorBid);
    }

    /**
     * 修改地板报价
     * 
     * @param floorBid 地板报价
     * @return 结果
     */
    @Override
    public int updateFloorBid(FloorBid floorBid)
    {
        floorBid.setUpdateTime(DateUtils.getNowDate());
        return floorBidMapper.updateFloorBid(floorBid);
    }

    /**
     * 批量删除地板报价
     * 
     * @param ids 需要删除的地板报价主键
     * @return 结果
     */
    @Override
    public int deleteFloorBidByIds(String ids)
    {
        return floorBidMapper.deleteFloorBidByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除地板报价信息
     * 
     * @param id 地板报价主键
     * @return 结果
     */
    @Override
    public int deleteFloorBidById(Long id)
    {
        return floorBidMapper.deleteFloorBidById(id);
    }

    @Override
    public List<FloorBid> selectStaffFloorBidList(FloorBid floorBid) {
        return floorBidMapper.selectStaffFloorBidList(floorBid);
    }
}
