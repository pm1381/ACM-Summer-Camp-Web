package ir.ac.kntu.repositories;

import ir.ac.kntu.models.userRelated.Costumer;

import java.util.ArrayList;

public class CostumerRepository {
    private static CostumerRepository instance = null;
    private ArrayList<Costumer> costumers = new ArrayList<>();
    private static int costumerId =1;

    private CostumerRepository() {
    }

    public static CostumerRepository getInstance(){
        if(instance == null){
            instance = new CostumerRepository();
        }
        return instance;
    }

    public ArrayList<Costumer> getCostumers() {
        return costumers;
    }

    public void addCostumer(Costumer costumer){
        costumer.setId(costumerId++);
        costumer.instantiateFields();
        costumers.add(costumer);
    }

    public void deleteCostumer(int costumerId){
        for(Costumer costumer : getCostumers()){
            if(costumer.getId() == costumerId){
                costumers.remove(costumer);
            }
        }
    }

    public Costumer getCostumerById(int id){
        for(Costumer costumer : costumers){
            if(id == costumer.getId()){
                return costumer;
            }
        }
        return null;
    }

    public Costumer getCostumerByEmail(String email){
        for(Costumer costumer : costumers){
            if(email.equals(costumer.getEmail())){
                return costumer;
            }
        }
        return null;
    }

    public void updateCostumer(int id ,Costumer costumer){
        Costumer oldCostumer = getCostumerById(id);
        if(oldCostumer == null){
            return;
        }
        oldCostumer.setEmail(costumer.getEmail());
        oldCostumer.setFamilyName(costumer.getFamilyName());
        oldCostumer.setName(costumer.getName());
        oldCostumer.setPassword(costumer.getPassword());
        oldCostumer.setPhoneNumber(costumer.getPhoneNumber());
    }

}


/*
    public Costumer getCostumerByEmailAndPassword(String email,String password){
        for(Costumer costumer : costumers){
            if(email.equals(costumer.getEmail()) && password.equals(costumer.getPassword())){
                return costumer;
            }
        }
        return null;
    }
 */
