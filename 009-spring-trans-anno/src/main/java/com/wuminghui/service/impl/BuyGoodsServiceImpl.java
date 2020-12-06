package com.wuminghui.service.impl;

import com.wuminghui.dao.GoodsDao;
import com.wuminghui.dao.SaleDao;
import com.wuminghui.domain.Goods;
import com.wuminghui.domain.Sale;
import com.wuminghui.excep.NotEnoughException;
import com.wuminghui.service.BuyGoodsService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BuyGoodsServiceImpl implements BuyGoodsService {
    private SaleDao saleDao;
    private GoodsDao goodsDao;
    //加上事务注解
    /*rollbackFor：表示发生指定的异常一定会回滚
    *       处理逻辑：1.spring会首先检查方法抛出的异常是不是在rollbackFor属性值中，如果
    * 在其中，不管是什么类型的异常，都会回滚。
    *                2.如果抛出的异常不在rollbackFor列表中，spring会判断异常是不是RuntimeException，
    * 如果是，一定回滚。
    * */
   /* @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false,
                                 rollbackFor = {NullPointerException.class,NotEnoughException.class}  )*/
    @Transactional/*由于上面都是默认值，所以可以直接省略*/
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
