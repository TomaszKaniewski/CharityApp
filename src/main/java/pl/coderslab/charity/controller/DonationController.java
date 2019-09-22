package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.services.CategoryService;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"dataInSession"})
@RequestMapping("/donation")
public class DonationController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final CategoryService categoryService;

    public DonationController(InstitutionService institutionService, DonationService donationService, CategoryService categoryService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.categoryService = categoryService;
    }

    @RequestMapping("")
    public String donationAction(Model model) {
        return "donationFormIntroduction";
    }

    @GetMapping("/donationFormStep1")
    public String donationAction1(Model model) {
        return "donationFormStep1";
    }

    @PostMapping("/donationFormStep1")
    public String donationAction1(@RequestParam(value = "category") Long [] categoriesFromForm, HttpSession session) {
        Donation donation = new Donation();
        List <Category> categoriesList = new ArrayList<>();
                for (Long el : categoriesFromForm) {
            categoriesList.add(categoryService.getCategoryById(el));
        }
        donation.setCategoryList(categoriesList);
        for (Category el : donation.getCategoryList()) {
            System.out.println(el.toString());
        }
        session.setAttribute("dataInSession", donation);
        return "redirect: donationFormStep2";
    }

    @GetMapping("/donationFormStep2")
    public String donationAction2(Model model) {
         return "donationFormStep2";
    }


    @ModelAttribute("categories")
    List<Category> categoryList() {
        return categoryService.getCategories();
    }

    @ModelAttribute("intitutions")
    List<Institution> institutionList() {
        return institutionService.showAllInstitution();
    }

}
