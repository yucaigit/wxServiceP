package com.etc.demo.dao;


import com.etc.demo.entity.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsDao {
    int deleteByPrimaryKey(Integer gId);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer gId);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    void updateGAByID(Integer g_id);

    List<Goods> searchByName(String query1);

    Goods findOne(Integer g_id);

    boolean saveGoods(String name, int gAttributes, String img1, String price, String senTime, Integer id, String adress, String textarea);

    int selectgIdByName(String name, String img);

    @Select("select *from goods")
    List<Goods> getAll();

    @Select("select *from goods where g_ifree = 1")
    List<Goods> getAllFree();

    @Select("select *from goods where g_adress like #{adress}")
    List<Goods> seleAllLikeAdress(String adress);

    @Update("update goods set g_b=#{param1} where g_id=#{param2}")
    boolean changeGb(int a, Integer gid);

    @Update("update goods set g_name=#{param2},g_adress=#{param3},g_describe=#{param4} where g_id = #{param1}")
    boolean updateGoods(Integer gId, String gName, String gAdress, String gDescribe);

    @Delete("delete from goods where g_id = #{gid}")
    boolean deleteGoodsById(Integer gid);

    @Select("select *from goods where g_b=1")
    List<Goods> getAllG();

    @Select("select g_uid from goods where g_id = #{param1}")
    int findUserid(Integer goodsid);

    //update goods set g_a=g_a+1 where g_id=#{g_id}

}