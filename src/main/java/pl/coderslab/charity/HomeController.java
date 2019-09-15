package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;


@SuppressWarnings("ALL")
@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;

    public HomeController (InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institutions", institutionService.showAllInstitution());
        model.addAttribute("donationAmount", donationService.donationAmount());
        return "index";
    }
}
