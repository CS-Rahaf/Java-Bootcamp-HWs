public class Main {
    public static void main(String[] args) {

      System.out.println("First class testing: ");
      Account account1= new Account("1", "Rahaf", 100);
      Account account2= new Account("2", "Omar");

      System.out.println("The first account details: " + account1.toString());
      System.out.println("The second account details: " + account2.toString());

      int transferredAmount=50;
      System.out.println("The account id '" + account1.getId() + "' will send " + transferredAmount + " SAR to the account id '" + account2.getId() + "'" );
      if(account1.transferTo(account2,transferredAmount)!=-1) {
          System.out.println("Status: Money transformation done successfully");
      }
      else {
          System.out.println("Status: Something went wrong with the money transformation");
      }

      System.out.println("The first account's balance after money transformation = " + account1.getBalance());
      System.out.println("The second account's balance after money transformation = " + account2.getBalance());

        System.out.println("The account id '" + account1.getId() + "' will withdraw amount of 20 SAR from his card and the balance will be: " + account1.credit(20));
        System.out.println("The account id '" + account1.getId() + "' will deposit amount of 20 SAR to his card and the balance will be: " + account1.debit(20));


      System.out.println("\n");

      System.out.println("Second class testing: ");
      Employee employee1= new Employee("1","Rahaf",15000);

      System.out.println(employee1.getName() + "'s salary is: "+ employee1.getSalary());
      System.out.println(employee1.getName() + " annual salary is: "+ employee1.getAnnualSalary());
      System.out.println(employee1.getName() + "'s salary after getting bounce of 23%: "+ employee1.raisedSalary(23));
      System.out.println("Double check of the changing of the " + employee1.getName() + "'s salary after raisedSalary() method : "+ employee1.getSalary());
    }

}