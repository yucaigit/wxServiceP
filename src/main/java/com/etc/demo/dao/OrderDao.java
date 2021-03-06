package com.etc.demo.dao;


import com.etc.demo.entity.Order;
import com.etc.demo.entity.ReturnOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
@Mapper

public interface OrderDao {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

//    @Select("select *from orders left join goods on user_id = #{uid}")
    List<Order> findAll(int uid);

    int deleteById(Integer orderId);

    Boolean updateOrderState(Integer oId);

    boolean addOrder(Integer uid, Integer goodsid);

    @Select("select a.g_name from goods a,orders b where b.goods_id=a.g_id")
    Set<String> getGoodsName();

    @Select("select a.g_name from goods a,orders b where b.goods_id=a.g_id")
    List<String> getGoodsNameAndValue();

    List<ReturnOrder> getOrders();

    @Update("UPDATE orders SET order_state = 5 where order_id = #{param1}")
    boolean changeOrderState(Integer oId);
}