package ir.ac.kntu.controllers;

import ir.ac.kntu.models.userRelated.Costumer;
import ir.ac.kntu.repositories.CostumerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/entry")
public class EntryController {
    @GetMapping
    public ArrayList<Costumer> showCostumers(){
        return CostumerRepository.getInstance().getCostumers();
    }

    @PostMapping("login")
    public void logIn(@RequestBody Costumer costumer){
        for(Costumer eachCostumer : CostumerRepository.getInstance().getCostumers()){
            if(eachCostumer.equals(costumer)){
                System.out.println("costumer found");
            }
        }
    }

    @PostMapping("signup")
    public void signUp(@RequestBody Costumer costumer){
        if(! CostumerRepository.getInstance().getCostumers().contains(costumer)){
            CostumerRepository.getInstance().addCostumer(costumer);
        }
    }
}
