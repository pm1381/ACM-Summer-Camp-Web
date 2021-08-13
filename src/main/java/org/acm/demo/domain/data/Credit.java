package org.acm.demo.domain.data;

/**
 * @author : Bahar Zolfaghari
 **/
public class Credit {
    private Integer id;
    private Long balance;

    public Integer getId() {
        return id;
    }

    public Credit setId(Integer id) {
        this.id = id;
        return this;
    }

    public Long getBalance() {
        return balance;
    }

    public Credit setBalance(Long balance) {
        this.balance = balance;
        return this;
    }
}
