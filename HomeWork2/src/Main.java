import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Question 1: Write a Java program to print the sum, multiply, subtract, divide and remainder of two numbers ");
        System.out.println("Please enter the first number: ");
        int number1 = scanner.nextInt();
        System.out.println("Please enter the second number: ");
        int number2 = scanner.nextInt();
        System.out.println(number1 + " + " + number2 + " = " + (number1 + number2));
        System.out.println(number1 + " - " + number2 + " = " + (number1 - number2));
        System.out.println(number1 + " * " + number2 + " = " + (number1 * number2));
        System.out.println(number1 + " / " + number2 + " = " + (number1 / number2));
        System.out.println(number1 + " mod " + number2 + " = " + (number1 % number2));
        System.out.println("---------------------");


        System.out.println("Question 2: Write a Java program to convert a given string into lowercase");
        System.out.println("Please enter the text: ");
        scanner.nextLine();
        String text = scanner.nextLine();
        System.out.println("The lowercase version of " + text + " is: " + text.toLowerCase());
        System.out.println("---------------------");

        System.out.println("Question 3: Write a Java program to reverse a string.");
        System.out.println("The question is moved to the next day");
        System.out.println("---------------------");

        System.out.println("Question 4: Write a Java program to accept a number and check the number is even or not. Prints 1 if the number is even or 0 if the number is odd. (use if-statement).");
        System.out.println("Please enter the number: ");
        int number3 = scanner.nextInt();
        if (number3 % 2 == 0)
            System.out.println("Even number 1");
        else System.out.println("Odd number 0 ");
        System.out.println("---------------------");

        System.out.println("Question 5: Write a program that checks the role of the user.");
        String userRole = scanner.next();

        if (userRole.equals("admin"))
            System.out.println("Welcome admin");
        else if (userRole.equals("superuser"))
            System.out.println("Welcome superuser");
        else if (userRole.equals("user"))
            System.out.println("Welcome user");
        else System.out.println("wrong input");
        System.out.println("---------------------");

        System.out.println("Question 6: Write a Java program to calculate the sum of two integers and return true if the sum is equal to a third integer.");
        System.out.println("Please enter the first number: ");
        int number01 = scanner.nextInt();
        System.out.println("Please enter the second number: ");
        int number02 = scanner.nextInt();
        System.out.println("Please enter the third number: ");
        int number03 = scanner.nextInt();
        int sum = number01 + number02;
        System.out.println("Is the summation of the two first numbers equal the last number? " + (sum == number03));
        System.out.println("---------------------");

        System.out.println("Question 7: Take three numbers from the user and print the greatest number.");
        int[] arr = new int[3];
        System.out.println("Please enter the first number: ");
        arr[0] = scanner.nextInt();
        System.out.println("Please enter the second number: ");
        arr[1] = scanner.nextInt();
        System.out.println("Please enter the third number: ");
        arr[2] = scanner.nextInt();
        int max = arr[0];
        for (int i = 1; i <= 2; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        System.out.println("The greatest number is: " + max);
        System.out.println("---------------------");

        System.out.println("Question 8: Write a Java program that keeps a number from the user and generates an integer between 1 and 7 and displays the name of the weekday.");
        System.out.println("Please enter the number: ");
        int weekday = scanner.nextInt();
        switch (weekday) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
        }
    }
}