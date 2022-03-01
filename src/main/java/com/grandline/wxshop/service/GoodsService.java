package com.grandline.wxshop.service;

import com.grandline.wxshop.dao.GoodsDao;
import com.grandline.wxshop.dao.ShopDao;
import com.grandline.wxshop.generate.Goods;
import com.grandline.wxshop.generate.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class GoodsService {
    private final GoodsDao goodsDao;
    private final ShopDao shopDao;

    @Autowired
    public GoodsService(GoodsDao goodsDao, ShopDao shopDao) {
        this.goodsDao = goodsDao;
        this.shopDao = shopDao;
    }

    public Goods createGoods(Goods goods) {
        Shop shop = shopDao.findShopById(goods.getShopId());

        if (Objects.equals(shop.getOwnerUserId(), UserContext.getCurrentUser().getId())) {
            return goodsDao.insertGoods(goods);
        }else {
            throw new NotAuthorizedForShopException("无权访问！");
        }
    }

    public Goods deleteGoodsById(Long goodsId) {
        Shop shop = shopDao.findShopById(goodsId);

        if (Objects.equals(shop.getOwnerUserId(), UserContext.getCurrentUser().getId())) {
            return goodsDao.deleteGoodsById(goodsId);
        }else {
            throw new NotAuthorizedForShopException("无权访问！");
        }
    }

    public static class NotAuthorizedForShopException extends RuntimeException{
        public NotAuthorizedForShopException(String message) {
            super(message);
        }
    }
}
