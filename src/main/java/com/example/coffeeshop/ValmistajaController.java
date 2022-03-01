package com.example.coffeeshop;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import com.example.coffeeshop.Services.ValmistajaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ValmistajaController {

    @Autowired
    private ValmistajaService valmistajaService;

    @GetMapping("/valmistajan-muokkaus")
    public String listValmistajat(Model model) {
        model.addAttribute("valmistajat", valmistajaService.getAllValmistajat());
        return "valmistajan-muokkaus";
    }

    @PostMapping("/valmistajan-muokkaus")
    public String addValmistaja(@RequestParam String nimi, @RequestParam String url) {
        valmistajaService.addValmistaja(nimi, url);
        return "redirect:/valmistajan-muokkaus";
    }

    // @PostMapping("/valmistajan-muokkaus/{valmistajaId}")
    // public String updateValmistaja(@RequestParam String nimi, @RequestParam String url, @PathVariable Long valmistajaId) {
    //     valmistajaService.addValmistaja(nimi, url);
    //     return "redirect:/valmistajan-muokkaus";
    // }

    /* @DeleteMapping("/valmistajan-muokkaus/{id}")
    public String deleteValmistaja(@PathVariable("id") long id, Model model) {
        valmistajaService.deleteValmistaja(id);
        return "redirect:/valmistajan-muokkaus";
    } */

    /* @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
    valmistajaService.deleteValmistaja(id);
    return "redirect:/valmistajan-muokkaus"; */
}




// @RequestParam(value = "nimi", required = false, defaultValue = "defaultName") String name
