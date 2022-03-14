package pers.kingvi.foreigntrade.test.servicetest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import pers.kingvi.foreigntrade.admin.service.MessageService;
import pers.kingvi.foreigntrade.common.IdWorker;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ForeignTradeSalemanService;
import pers.kingvi.foreigntrade.freightagency.service.FreightAgencyService;
import pers.kingvi.foreigntrade.po.ForeignTradeSaleman;
import pers.kingvi.foreigntrade.po.FreightAgency;
import pers.kingvi.foreigntrade.po.Message;
import pers.kingvi.foreigntrade.util.ErrorInfo;
import pers.kingvi.foreigntrade.vo.PageBeanVo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTestBean {
    private ForeignTradeSalemanService foreignTradeSalemanService;
    private FreightAgencyService freightAgencyService;
    private MessageService messageService;

    @Before
    public void setUp() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        foreignTradeSalemanService = (ForeignTradeSalemanService) ac.getBean("foreignTradeSalemanServiceImpl");
        freightAgencyService = (FreightAgencyService) ac.getBean("freightAgencyServiceImpl");
        messageService = (MessageService)ac.getBean("messageServiceImpl");
    }

    @Test
    public void testSelectByPrimaryKey() {
        List<Long> list = new ArrayList<>();
        list.add(12L);
        PageBeanVo<ForeignTradeSaleman> foreignTradeSalemanPage = foreignTradeSalemanService.selectByList(list,2,4);
        System.out.println(foreignTradeSalemanPage);
    }

    @Test
    public void testSelectByPrimaryKey1() {
        FreightAgency freightAgency = freightAgencyService.selectByPrimaryKey(5L);
        System.out.println(freightAgency);
    }

    @Test
    public void testMessageService() {
        List<Message> messageList = messageService.selectLastFiftyMessage(3L,4L);
//        System.out.print("32");
        System.out.println(messageList);
    }

    @Test
    public void testRegister() {
        IdWorker idWorker = new IdWorker(1, 1, 1);
        Long id = idWorker.nextId();
        FreightAgency freightAgency = new FreightAgency();
        freightAgency.setId(id);
        freightAgency.setAccount("ddd");
        freightAgency.setPassword("aaa");
        freightAgency.setCompany(" ");
        freightAgency.setCity(" ");
        freightAgency.setName(" ");
        freightAgency.setPhoto("default.jpg");
        try {
            freightAgencyService.insertSelective(freightAgency);

        } catch (DataAccessException e) {
            SQLException exception = (SQLException)e.getCause();
            int statusCode = exception.getErrorCode();
            System.out.println("数据库异常，异常码为：" + statusCode);
        }
    }
}
