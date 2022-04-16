package com.etc.demo.controller;

import com.etc.demo.entity.Goods;
import com.etc.demo.entity.GoodsEntity;
import com.etc.demo.entity.SwiperListEntity;
import com.etc.demo.jpaservice.JPAGoodsService;
import com.etc.demo.jpaservice.SwiperListService;
import com.etc.demo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class GoodsController {
    // sum 用来存储 热搜榜
    private static int sum;

    @Autowired
    SwiperListService swiperListService;

    @Autowired
    JPAGoodsService jpaGoodsService;

    @Autowired
    GoodsService goodsService;

    //    得到轮播图树据
    @RequestMapping("/findSwiperList")
    public List<SwiperListEntity> swiperList() {
        List<SwiperListEntity> list = swiperListService.findAll();
        return list;
    }

    /*得到全部上架商品*/
    @RequestMapping("/getAll")
    public List<GoodsEntity> getAll() {
        List<GoodsEntity> all = jpaGoodsService.findAll();

        return all;
    }

    /*根据关键字搜索*/
    @RequestMapping("/search")
    public List<Goods> search(@RequestParam String query) {
        System.out.println("--------------------------");
        List<Goods> list = goodsService.selectLikeQuery(query);
        if (list.size() > 0) {
            return list;
        }
        return null;
    }

    /*热搜表单数据*/
    @RequestMapping("/getResou")
    public List<GoodsEntity> reSou() {
        List<GoodsEntity> all = getAll();
//        根据 g_a 为热搜等级
        all.sort(GoodsEntity::compareTo);
        List<GoodsEntity> goodsEntities = all.subList(0, 4);
        return goodsEntities;
    }

    /* 根据Id 搜索数据 */
    @RequestMapping("/findDetailById")
    public GoodsEntity getGoodsById(@RequestParam Integer g_Id) {
//        给当前g_a+1
        goodsService.updateGA(g_Id);
        GoodsEntity goodsEntity = jpaGoodsService.findById(g_Id).get();
        return goodsEntity;
    }

    //    跟据关键词 和分类Id 得到商品列表
    @RequestMapping("/getGoodsListByKwAndcid")
    public List<Goods> getGoodsListByKwAndcid(@RequestBody PageInfo query) {
//        query只是分类名字
        System.out.println(query);
        return null;
    }

    //    根据商品ID 获取商品信息
    @RequestMapping("/findGoodsById")
    public Goods findById(@RequestParam Integer g_id) {
        return goodsService.selectByPrimaryKey(g_id);
    }

    //    根据Id 获取 商品信息
    @RequestMapping("/getGoodsDetail")
    public Goods getDetail(@RequestParam Integer g_id) {
        Goods one = goodsService.findOne(g_id);
        return one;
    }


}