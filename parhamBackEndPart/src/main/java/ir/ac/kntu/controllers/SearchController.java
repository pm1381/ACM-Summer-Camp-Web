package ir.ac.kntu.controllers;

import ir.ac.kntu.models.goodsRelated.Category;
import ir.ac.kntu.models.goodsRelated.Product;
import ir.ac.kntu.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/search")
public class SearchController {
    @PostMapping("nameSearch")
    public ArrayList<Product> searchByName(@RequestBody String name){
        return ProductRepository.getInstance().doSearchByName(name);
    }

    @PostMapping("companySearch")
    public ArrayList<Product> searchByCompany(@RequestBody String name){
        return ProductRepository.getInstance().doCompanySearch(name);
    }

    @PostMapping("companySearch/remove")
    public void removeFromChosenCompanies(@RequestBody String name){
        ProductRepository.getInstance().removeFromCompaniesSearch(name);
    }

    @PostMapping("priceSearch/{bottom}/{upper}")
    public ArrayList<Product> searchByPrice(@PathVariable("bottom") int bottom, @PathVariable("upper") int upper){
        return ProductRepository.getInstance().enablePriceRange(bottom,upper);
    }

    @PostMapping("ratingSearch/{bottom}/{upper}")
    public ArrayList<Product> searchByRating(@PathVariable("bottom") int bottom, @PathVariable("upper") int upper){
        return ProductRepository.getInstance().enableRatingRange(bottom,upper);
    }

    @PostMapping("categorySearch")
    public ArrayList<Product> searchByCategory(@RequestBody Category category){
        return ProductRepository.getInstance().doCategorySearch(category);
    }

    @PostMapping("categorySearch/remove")
    public void removeFromChosenCategory(@RequestBody Category category){
        ProductRepository.getInstance().removeFromCategoriesSearch(category);
    }
}
