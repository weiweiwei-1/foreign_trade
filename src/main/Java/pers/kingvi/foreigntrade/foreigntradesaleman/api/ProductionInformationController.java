package pers.kingvi.foreigntrade.foreigntradesaleman.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.kingvi.foreigntrade.foreigntradesaleman.service.ProductInformationService;
import pers.kingvi.foreigntrade.po.ProductInformation;

import java.util.List;

@Controller
//@CrossOrigin
@RequestMapping(value = "/productinformation")
public class ProductionInformationController {

    @Autowired
    private ProductInformationService productInformationService;

    @RequestMapping(value = "/list", method={RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public List<ProductInformation> getProductionInformationList() {
        return productInformationService.selectByFtsId(9L);
    }
}
