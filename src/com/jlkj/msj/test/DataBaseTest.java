package com.jlkj.msj.test;

import com.jlkj.msj.dao.ProductionDao;
import com.jlkj.msj.entity.Production;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class DataBaseTest {

    @Resource
    private ProductionDao productionDao;

    @Test
    public void testProduction(){
        List<Production> productions = productionDao.getMyProductions("111");
        System.out.println(productions.size());
    }

}
