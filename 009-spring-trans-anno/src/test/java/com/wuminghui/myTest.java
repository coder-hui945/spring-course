package com.wuminghui;

import com.wuminghui.service.BuyGoodsService;
import com.wuminghui.service.impl.BuyGoodsServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class myTest {
    @Test
    public void test01(){
        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext co = new ClassPathXmlApplicationContext(config);
        BuyGoodsService service = (BuyGoodsService) co.getBean("buyService");
        service.buy(1001,10);
    }
}
