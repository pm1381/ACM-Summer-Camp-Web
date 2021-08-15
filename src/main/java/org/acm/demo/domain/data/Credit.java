package org.acm.demo.domain.data;

/**
 * @author : Bahar Zolfaghari
 **/
public class Credit {
    private Integer id;
    private Long balance;

    public Credit(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long addedMoney) {
        this.balance = balance + addedMoney;//balance += addedMoney
    }

    public void withDrawAccount(Long money){
        this.balance = balance - money;
    }
}
