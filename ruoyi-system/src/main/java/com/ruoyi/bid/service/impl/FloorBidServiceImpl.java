package com.ruoyi.bid.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.bid.domain.FloorBid;
import com.ruoyi.bid.mapper.FloorBidMapper;
import com.ruoyi.bid.service.IFloorBidService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 地板报价Service业务层处理
 * 
 * @author Chaos
 * @date 2022-03-26
 */
@Service
public class FloorBidServiceImpl extends ServiceImpl<FloorBidMapper,FloorBid> implements IFloorBidService
{
    /**
     * 查询地板报价
     * 
     * @param id 地板报价主键
     * @return 地板报价
     */
    @Override
    public FloorBid selectFloorBidById(Long id)
    {
        return baseMapper.selectById(id);
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
        QueryWrapper<FloorBid> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.setEntity(floorBid);
        return baseMapper.selectList(queryWrapper);
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
        return baseMapper.insert(floorBid);
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
        return baseMapper.updateById(floorBid);
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
        return baseMapper.deleteBatchIds(Arrays.asList(Convert.toIntArray(ids)));
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
        return baseMapper.deleteById(id);
    }

    @Override
    public List<FloorBid> selectStaffFloorBidList(FloorBid floorBid) {
        return baseMapper.selectStaffFloorBidList(floorBid);
    }
}
