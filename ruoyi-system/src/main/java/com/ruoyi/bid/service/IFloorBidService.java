package com.ruoyi.bid.service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.bid.domain.FloorBid;

/**
 * 地板报价Service接口
 * 
 * @author Chaos
 * @date 2022-03-26
 */
public interface IFloorBidService extends IService<FloorBid>
{
    /**
     * 查询地板报价
     * 
     * @param id 地板报价主键
     * @return 地板报价
     */
        FloorBid selectFloorBidById(Long id);

    /**
     * 查询地板报价列表
     * 
     * @param floorBid 地板报价
     * @return 地板报价集合
     */
    List<FloorBid> selectFloorBidList(FloorBid floorBid);

    /**
     * 新增地板报价
     * 
     * @param floorBid 地板报价
     * @return 结果
     */
    int insertFloorBid(FloorBid floorBid);

    /**
     * 修改地板报价
     * 
     * @param floorBid 地板报价
     * @return 结果
     */
    int updateFloorBid(FloorBid floorBid);

    /**
     * 批量删除地板报价
     * 
     * @param ids 需要删除的地板报价主键集合
     * @return 结果
     */
    int deleteFloorBidByIds(String ids);

    /**
     * 删除地板报价信息
     * 
     * @param id 地板报价主键
     * @return 结果
     */
    int deleteFloorBidById(Long id);
}
