package ir.ac.kntu.models.userRelated;

public class Credit {
    private int id;
    private int balance = 0; // mande hesab;;

    public Credit(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int addedMoney) {
        this.balance = balance + addedMoney;
    }

    public void withDrawAccount(int money){
        this.balance = balance - money;
    }
}
