import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Question1");
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                System.out.print("FizzBuzz ");
            else if (i % 3 == 0) {
                System.out.print("Fizz ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz ");
            } else
                continue;
        }
        System.out.println();
        System.out.println("-------------------");

        System.out.println("Question2: Write a Java program to reverse a string ");
        System.out.println("Please enter the text: ");
        String text= scanner.nextLine();
        String reverse="";
        for (int i =text.length()-1 ; i>=0; i--){
            reverse= reverse+text.charAt(i);
        }
        System.out.println(reverse);
        System.out.println("-------------------");

        System.out.println("Question3: Write a program that prompts the user to input a positive integer. It should then print the multiplication table of that number ");
        System.out.println("Please enter positive number");
        int num= scanner.nextInt();
        if (num<=0){
            System.out.println("Wrong number, please enter positive number");
            num= scanner.nextInt();
        }
        System.out.println("The multiplication table is: ");
        for(int i=1; i<=10; i++){
            System.out.println(num+ " * " +i+" = "+ (num*i));
        }
        System.out.println("-------------------");

        System.out.println("Question4: Write a program to find the factorial value of any number entered through the keyboard.");
        System.out.println("Please enter the number");
        int num2= scanner.nextInt();
        int sum=1;
        for(int i= num2; i>0; i--){
            sum=sum*i;
        }
        System.out.println("The factorial value of "+ num2+ " is: "+ sum);
        System.out.println("-------------------");

        System.out.println("Question5: Two numbers are entered through the keyboard. Write a program to find the value of one number raised to the power of another. (Do not use Java built-in method)");
        System.out.println("Please enter the base number: ");
        int bNum=scanner.nextInt();
        System.out.println("Please enter the power value: ");
        int pValue=scanner.nextInt();
        int result5=1;
        for(int i= pValue; i>0; i--){
            result5=result5*bNum;
        }
        System.out.println(bNum+" power of " + pValue+ " = " + result5);
        System.out.println("-------------------");

        System.out.println("Question6: Write a program that reads a set of integers, and then prints the sum of the even and odd integers.");
        System.out.println("Please enter the numbers. Enter -1 when you finish to print the results");
        int num6= 0;
        int oddSummation=0;
        int evenSummation=0;
        while (true){
         num6= scanner.nextInt();
         if (num6==-1)
             break;
         if(num6%2==0)
             evenSummation=evenSummation+num6;
         else if (num6%2!=0)
             oddSummation=oddSummation+num6;
         else
             continue;
        }
        System.out.println("The sum of even numbers is: "+ evenSummation);
        System.out.println("The sum of odd numbers is: "+ oddSummation);
        System.out.println("-------------------");

        System.out.println("Question7: Write a program that prompts the user to input a positive integer. It should then output a message indicating whether the number is a prime number.");
        System.out.println("Please enter the number: ");
        int num7= scanner.nextInt();
        boolean check=true;
        if(num7<=1)
            check= false;

        for(int i=2;i<=num7/2;i++)
        {
            if((num7%i)==0)
                check= false;
        }
        if (check)
            System.out.println(num7 + " is prime number");
        else
            System.out.println(num7 + " is not prime number");

        System.out.println("-------------------");


        System.out.println("Question8: Write a program to enter the numbers till the user wants and at the end it should display the count of positive, negative and zeros entered. ");
        int pCounter = 0;
        int nCounter = 0;
        int zCounter = 0;
        while(true){
            System.out.println("Please enter the number: ");
            int num8= scanner.nextInt();
            if(num8>0)
                pCounter++;
            else if(num8<0)
                nCounter++;
            else
                zCounter++;
            System.out.println("Do you want to continue? please write y for Yes and n for No");
            scanner.nextLine();
            String check8=scanner.nextLine();
            if(check8.equalsIgnoreCase("n"))
                break;
        }
        System.out.println("Positive numbers: " + pCounter);
        System.out.println("Negative numbers: " + nCounter);
        System.out.println("Zero numbers: " + zCounter);
        System.out.println("-------------------");


        System.out.println("Question9: Use a for loop to print headings for four weeks (Weeks 1 - 4). Then use another for loop to print the days (Days 1 -7) for each week. ");
        for(int i=1 ; i<=4; i++){
            System.out.println("Week "+ i);
            for (int j=1; j<=7; j++){
                System.out.println("Day"+ j);
            }
        }
        System.out.println("-------------------");

        System.out.println("Question10:Write a program thats check if the word is a palindrome or not. hint: A string is said to be a palindrome if it is the same if we start reading it from left to right or right to left. ");
        System.out.println("Please enter the word: ");
        String word10= scanner.nextLine();
        String reverse10="";
        for (int i =word10.length()-1 ; i>=0; i--){
            reverse10= reverse10+word10.charAt(i);
        }
        if(word10.equalsIgnoreCase(reverse10))
            System.out.println("Is " + word10+" palindrome? " + true);
        else
            System.out.println("Is " + word10+" palindrome? " + false);
        System.out.println("-------------------");



    }
    }
