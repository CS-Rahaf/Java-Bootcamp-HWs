public class Account {

    private String id;
    private String name;
    private int balance=0;


    Account(String id, String name){
        this.id=id;
        this.name=name;
    }
    Account(String id, String name, int balance){
        this.id=id;
        this.name=name;
        this.balance=balance;
    }


    public int credit(int amount){
     //withdraw
     if (balance>=amount){
         balance=balance-amount;
         return balance;
     }
     else
         return -1;
    }

    public int debit(int amount){
        //Deposit
        balance=balance+amount;
        return balance;
    }

    public int transferTo(Account another,int amount){
        if (this.balance >= amount){
          another.setBalance(amount);
          this.balance=balance-amount;
          return this.balance;
        }
       else
           return -1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }


}
