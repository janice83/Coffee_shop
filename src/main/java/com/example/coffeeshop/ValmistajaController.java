package com.example.coffeeshop;

import java.lang.ProcessBuilder.Redirect;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import com.example.coffeeshop.Services.ValmistajaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ValmistajaController {

    @Autowired
    private ValmistajaService valmistajaService;

    // Listaa kaikki valmistajat
    @GetMapping("/valmistajan-muokkaus")
    public String listValmistajat(Model model) {
        model.addAttribute("valmistajat", valmistajaService.getAllValmistajat());
        return "valmistajan-muokkaus";
    }

    // Lisää valmistajan tietokantaan
    @PostMapping("/valmistajan-muokkaus")
    public String addValmistaja(@RequestParam String nimi, @RequestParam String url) {
        valmistajaService.addValmistaja(nimi, url);
        return "redirect:/valmistajan-muokkaus";
    }

    // Näyttää yhden valmistajan tiedot pääsivulla, uudelleenohjaa vamistaja sivulle
    @GetMapping("/valmistajan-muokkaus/{id}")
    public String showValmistaja(@RequestParam Long id, Model model) {
        valmistajaService.findValmistaja(id);
        return "redirect:/valmistaja/" + id;
    }

    // Näyttää id:n perusteella yhden valmistajan tiedot valmistaja-sivulla 
    @GetMapping("/valmistaja/{id}")
    public String showOneValmistaja(@PathVariable Long id, Model model) {
        model.addAttribute("valmistaja", valmistajaService.findValmistaja(id));
        return "valmistaja";
    }

    // Poistaa valmistajan tietokannasta
    @GetMapping("/delete/{id}")
    public String deleteValmistaja(@PathVariable("id") long id, Model model) {
    valmistajaService.deleteOneValmistaja(id);
    return "redirect:/valmistajan-muokkaus";
    }

    // Päivittää valmistajan tiedot
    @PostMapping("/update/{id}")
    public String updateValmistaja(@PathVariable("id") Long id, @RequestParam String nimi, @RequestParam String url) {
        valmistajaService.updateValmistaja(id, nimi, url);
        return "redirect:/valmistajan-muokkaus";
    }

}    
