package com.rendu.agence.controllers;

import com.rendu.agence.models.House;
import com.rendu.agence.services.HouseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HouseController {

    @Autowired
    HouseServices houseServices = new HouseServices();


    // Shows the home page with all the houses
    @GetMapping("/")
    public String index(ModelMap map){
        List<House> houses = this.houseServices.findAll();
        map.put("houses", houses);

        return "index";
    }

    // Shows the details of a house
    @GetMapping("/{houseId}")
    public String detail(@PathVariable("houseId") Integer houseId,ModelMap map){
        House house = this.houseServices.findById(houseId);
        map.put("house",house);

        return "detail";
    }


    // Shows the form to add a house
    @GetMapping("/add")
    public String add(){

        return "add";
    }

    // Save the house and create it if it does not exist
    @PostMapping("/save")
    public String formHandler(@ModelAttribute House house){
        this.houseServices.save(house);

        return "redirect:/list";
    }

    // Shows the table with all the houses
    @GetMapping("/list")
    public String list(ModelMap map){
        List<House> houses = this.houseServices.findAll();
        System.out.println(houses);
        map.put("houses",houses);

        return "list";
    }

    // Delete a house
    @GetMapping("/delete/{id}" )
    public String deleteHouse(@PathVariable("id") Integer houseId){
        this.houseServices.delete(houseId);

        return "redirect:/list";
    }

    // Shows the form to update a house and set the default values of the input with the values of the house
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") Integer houseId, ModelMap map){
        House house = this.houseServices.findById(houseId);
        map.put("house", house);


        return "update";
    }

}
