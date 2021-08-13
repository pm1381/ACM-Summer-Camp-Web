package ir.ac.kntu.repositories;

import ir.ac.kntu.models.goodsRelated.Category;
import ir.ac.kntu.models.goodsRelated.Product;
import ir.ac.kntu.models.goodsRelated.ProductFilter;

import java.util.ArrayList;

public class ProductRepository {
    private static ProductRepository instance = null;
    private ArrayList<Product> products = new ArrayList<>();
    private ProductFilter productFilter = new ProductFilter();
    private static int productLastID = 1;

    private ProductRepository(){
    }

    public static ProductRepository getInstance() {
        if(instance == null){
            instance = new ProductRepository();
        }
        return instance;
    }

    public ProductFilter getProductFilter() {
        return productFilter;
    }

    public void addToProducts(Product product){
        product.setId(productLastID++);
        products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Product getProductById(int id){
        for(Product product : products){
            if(id == product.getId()){
                return product;
            }
        }
        return null;
    }

    public Product getProductByCategory(String categoryName){
        for(Product product : products){
            if (product.getCategory().getName().equals(categoryName)){
                return product;
            }
        }
        return null;
    }

    public Product getProductByCompany(String company){
        for(Product product : products){
            if(company.equals(product.getCompany())){
                return product;
            }
        }
        return null;
    }

    public void deleteFromProducts(Product product){
        products.remove(product);
    }

    public void updateProduct(int id,Product newProduct){
        Product oldProduct = getProductById(id);
        if(oldProduct == null){
            return;
        }
        oldProduct.setCategory(newProduct.getCategory());
        oldProduct.setCompany(newProduct.getCompany());
        oldProduct.setPrice(newProduct.getPrice());
        oldProduct.setName(newProduct.getName());
        oldProduct.setQuantity(newProduct.getQuantity());
        oldProduct.setYear(newProduct.getYear());
    }

    public ArrayList<Product> doSearchByName(String name){
        return getProductFilter().searchOnName(name);
    }

    public ArrayList<Product> doCategorySearch(Category category){
        return getProductFilter().searchOnCategory(category);
    }

    public void removeFromCategoriesSearch(Category category){
        getProductFilter().deleteFromSearchedCategories(category);
    }

    public ArrayList<Product> doCompanySearch(String company){
        return getProductFilter().searchedOnCompany(company);
    }

    public void removeFromCompaniesSearch(String company){
        getProductFilter().deleteFromSearchedCompanies(company);
    }

    public ArrayList<Product> enablePriceRange(int bottom,int bound){
        return getProductFilter().setPriceRange(bottom,bound);
    }

    public ArrayList<Product> enableRatingRange(double bottom,double bound){
        return getProductFilter().setRatingRange(bottom,bound);
    }
}

