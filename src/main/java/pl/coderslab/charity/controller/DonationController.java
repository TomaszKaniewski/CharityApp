package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.model.DonationStep4;
import pl.coderslab.charity.services.CategoryService;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"dataSavedInSession"})
@RequestMapping("/donation")
public class DonationController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final DonationStep4 donationStep4;

    public DonationController(InstitutionService institutionService, DonationService donationService, CategoryService categoryService, DonationStep4 donationStep4) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.donationStep4 = donationStep4;
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
    public String donationAction1(@RequestParam(value = "category", required = false) Long[] category, HttpSession session, Model model) {
        if (category == null) {
            model.addAttribute("error", "noCategorySelectedError");
            return "/donationFormStep1";
        }
        Donation donation = new Donation();
        List<Category> categoriesList = new ArrayList<>();
        for (Long el : category) {
            categoriesList.add(categoryService.getCategoryById(el));
        }
        donation.setCategoryList(categoriesList);
        session.setAttribute("dataSavedInSession", donation);
        return "redirect: donationFormStep2";
    }

    @GetMapping("/donationFormStep2")
    public String donationAction2() {
        return "donationFormStep2";
    }

    @PostMapping("/donationFormStep2")
    public String donationAction1(@RequestParam(value = "bags", required = false) String bags, HttpSession session, Model model) {
        int bagsAmount;
        try {
            bagsAmount = Integer.parseInt(bags);
        } catch (Exception e) {
            model.addAttribute("error", "emptyFieldError");
            return "/donationFormStep2";
        }
        if (bagsAmount == 0 || bagsAmount > 100) {
            model.addAttribute("error", "amountError");
            return "/donationFormStep2";
        }

        Donation donation = (Donation) session.getAttribute("dataSavedInSession");
        donation.setQuantity(bagsAmount);
        session.setAttribute("dataSavedInSession", donation);
        return "redirect: donationFormStep3";
    }

    @GetMapping("/donationFormStep3")
    public String donationAction3() {
        return "donationFormStep3";
    }

    @PostMapping("/donationFormStep3")
    public String donationAction3(@RequestParam(value = "institution", required = false) Long institution, HttpSession session, Model model) {
        if (institution == null) {
            model.addAttribute("error", "noInstitutionSelectedError");
            return "/donationFormStep3";
        }
        Donation donation = (Donation) session.getAttribute("dataSavedInSession");
        donation.setInstitution(institutionService.getIntitutionById(institution));
        session.setAttribute("dataInSession", donation);
        return "redirect: donationFormStep4";
    }

    @GetMapping("/donationFormStep4")
    public String donationAction4(Model model) {
        model.addAttribute("donationStep4", new DonationStep4());
        return "donationFormStep4";
    }

    @PostMapping("/donationFormStep4")
    public String donationAction4(@ModelAttribute ("donationStep4") @Valid DonationStep4 donationStep4, BindingResult bindingResult, HttpSession session){
        if(bindingResult.hasErrors()){
            return "donationFormStep4";
        }
        Donation donation = (Donation) session.getAttribute("dataSavedInSession");

        donation.setCity(donationStep4.getCity());
        donation.setStreet(donationStep4.getStreet());
        donation.setZipCode(donationStep4.getZipCode());
        donation.setPickUpDate(donationStep4.getPickUpDate());
        donation.setPickUpTime(donationStep4.getPickUpTime());
        donation.setPhoneNumber(donationStep4.getPhoneNumber());
        donation.setPickUpComment(donationStep4.getPickUpComment());

        session.setAttribute("dataInSession", donation);
        System.out.println("aaa");
        return "redirect:/donation/summary";
    }

    @GetMapping("/summary")
    public String donationAction5(HttpSession session, Model model) {
        Donation donation = (Donation) session.getAttribute("dataInSession");
        model.addAttribute("donationDetails", donation);
        return "summary";
    }

    @PostMapping("/summary")
    public String donationAction5(HttpSession session) {

        //zapis do bazy

        return "redirect:/donation/confirmation";
    }

    @GetMapping("/confirmation")
    public String donationAction6() {
        return "confirmation";
    }

    @ModelAttribute("categories")
    List<Category> categoryList() {
        return categoryService.getCategories();
    }

    @ModelAttribute("institutions")
    List<Institution> institutionList() {
        return institutionService.showAllInstitution();
    }

}
