package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@SuppressWarnings("ALL")
@Controller
public class HomeController {

    @RequestMapping("/")
    public String homeAction(){
        return "index";
    }
}
