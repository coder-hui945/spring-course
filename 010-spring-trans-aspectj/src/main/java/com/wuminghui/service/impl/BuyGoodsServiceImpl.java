package com.wuminghui.service.impl;

import com.wuminghui.dao.GoodsDao;
import com.wuminghui.dao.SaleDao;
import com.wuminghui.domain.Goods;
import com.wuminghui.domain.Sale;
import com.wuminghui.excep.NotEnoughException;
import com.wuminghui.service.BuyGoodsService;

public class BuyGoodsServiceImpl implements BuyGoodsService {
    private SaleDao saleDao;
    private GoodsDao goodsDao;
    @Override
    public void buy(int goodsId, int nums) {
        System.out.println("=======buy方法开始========");
        //记录销售信息，向sale表添加记录
        Sale sale = new Sale(goodsId,nums);
        saleDao.insertSale(sale);

        //更新库存
        Goods goods = goodsDao.selectGoods(goodsId);
        if ( goods == null){
            //商品不存在
            throw new NullPointerException("编号是" + goodsId + "的商品不存在");
        } else if(goods.getAmount() < nums){
            //商品库存不足
            throw new NotEnoughException("编号是" + goodsId + "的商品库存不足");
        }
        Goods buyGoods = new Goods(goodsId, nums);
        goodsDao.updateDoods(buyGoods);
        System.out.println("=======buy方法完成========");

    }

    public SaleDao getSaleDao() {
        return saleDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public GoodsDao getGoodsDao() {
        return goodsDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }


}
