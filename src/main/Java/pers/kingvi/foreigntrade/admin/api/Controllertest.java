package pers.kingvi.foreigntrade.admin.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.kingvi.foreigntrade.freightagency.service.FreightAgencyService;
import pers.kingvi.foreigntrade.po.FreightAgency;

@Controller
@RequestMapping(value = "/a")
public class Controllertest {

    @Autowired
    private FreightAgencyService freightAgencyService;
    @RequestMapping(value = "/b", method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public FreightAgency returnString() {
        return freightAgencyService.selectByPrimaryKey(6L);
    }
}
