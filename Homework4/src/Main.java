import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Question1: Write a Java program to test if the first and the last element of an array of integers are same. The length of the array must be greater than or equal to 2");

        int array1 []= {50, -20, 0, 30, 40, 60, 10};
        boolean flag1=true;
        if(array1.length<2){
            System.out.println("The array size is smaller than 2");
        }
        else{
            if (array1[0]!=array1[array1.length-1]){
                flag1=false;
            }
            System.out.println("Test Data: " + Arrays.toString(array1));
            System.out.println(flag1);
        }
        System.out.println("-----------------");


        System.out.println("Question2: Write a Java program to find the k largest elements in a given array. Elements in the array can be in any order.");
        Integer [] array2= {1, 4, 17, 7, 25, 3, 100};
        System.out.println(Arrays.toString(array2));

        Arrays.sort(array2);
        Collections.reverse(Arrays.asList(array2));
        System.out.println("3 largest elements of the said array are: ");
        for (int i= 0; i<3; i++){
            System.out.print(array2[i] + " ");
        }
        System.out.println();
        System.out.println("-----------------");


       System.out.println("Question3: Write a Java program to find the numbers greater than the average of the numbers of a given array.");
       int array3 []= {1, 4, 17, 7, 25, 3, 100};
       ArrayList<Integer> resultArray = new ArrayList<>();
        int sum=0;

       for(int i = 0 ; i< array3.length ; i++){
           sum=sum+ array3[i];
       }
       double average= sum/array3.length;

       for(int val: array3){
           if(val>average)
               resultArray.add(val);
       }
        System.out.println(Arrays.toString(array3));
        System.out.println("The average of the array elements is: " + average);
        System.out.println("The numbers in the above array that are greater than the average are:" + resultArray.toString());
        System.out.println("-----------------");

        System.out.println("Question4: Write a Java program to get the larger value between first and last element of an array of integers.");

        int array4 [] = {20, 30, 40};
        int largestValue=array4[0];
        if(array4[array4.length-1]> array4[0])
            largestValue=array4[array4.length-1];

        System.out.println(Arrays.toString(array4));
        System.out.println("Larger value between first and last element: " + largestValue);
        System.out.println("-----------------");


        System.out.println("Question5: Write a Java program to swap the first and last elements of an array and create a new array.");
        int array5 []= {20, 30, 40};
        System.out.println(Arrays.toString(array5));

        int swapValue= array5[0];
        array5[0]=array5[array5.length-1];
        array5[array5.length-1]= swapValue;

        System.out.println("New array after swapping the first and last elements: " + Arrays.toString(array5));
        System.out.println("-----------------");


        System.out.println("Question6: Write a Java program to find all of the longest word in a given dictionary.");
        String words[]={ "cat", "dog", "red", "is", "am"};
        ArrayList<String > resultArray6 = new ArrayList<>();
        int max= 0;
        for (String val: words){
            if (val.length()>max)
                max=val.length();
        }
        for(int i= 0 ; i<words.length ; i++){
            if (words[i].length() == max){
                resultArray6.add(words[i]);
            }
        }
        System.out.println(Arrays.toString(words));
        System.out.println("Result: " + resultArray6.toString());
        System.out.println("-----------------");


        System.out.println("Question7: Write a menu driven Java program with following option");
        System.out.println("Please enter the array size");
        int number7 = scanner.nextInt();
        int input7;
        int choice7;
        int element7;
        boolean flag7 = true;
        ArrayList<Integer> array7 = new ArrayList<>();

        for (int i = 0; i < number7; i++) {
            System.out.println("Enter the value");
            input7 = scanner.nextInt();
            array7.add(input7);
        }

        System.out.println("Welcome to *Array Program menue* ");
        while (flag7) {
            System.out.println("Enter \n 1/ To display array elements \n 2/ To search for an element \n 3/ To sort the array \n 0/ to exist ");
            choice7 = scanner.nextInt();
            if (choice7 == 1) {
                System.out.println(array7.toString());
            } else if (choice7 == 2) {
                System.out.println("Enter the element: ");
                element7 = scanner.nextInt();
                if (array7.contains(element7)) {
                    System.out.println("Element " + element7 + " exists in the array");
                } else {
                    System.out.println("Element " + element7 + " doesn't exist in the array");
                }
            }
            else if (choice7 == 3) {
                Collections.sort(array7);
                System.out.println("The Array after sort is: " + array7.toString());
            }
            else {
                flag7 = false;
            }
        }
        System.out.println("-----------------");


       System.out.println("Question8: 8. Write a program thats displays the number of occurrences of an element in the array.");
       int array8 []= {1,1,1,3,3,5};
        System.out.println(Arrays.toString(array8));
        System.out.println("Please enter element value that you want to know its number of occurrences? ");
        int number8= scanner.nextInt();
        int counter=0;
        for(int val : array8){
            if(val == number8){
                counter++;
            }
        }

        System.out.println(number8 + " occurs " + counter + " times");
        System.out.println("-----------------");


        System.out.println("Question9:Write a program that places the odd elements of an array before the even elements ");
        int array9 []= {2,3,40,1,5,9,4,10,7};
        ArrayList<Integer > resultArray9 = new ArrayList<>();

        for(int i= 0 ; i<2 ; i++){
            for(int val : array9){
                if(i==0 && (val %2 != 0) ){
                      resultArray9.add(val);
                 }
                 else if (i!= 0 && val %2 == 0){
                    resultArray9.add(val);
                  }
                 else
                     continue;
             }
        }
        System.out.println(Arrays.toString(array9));
        System.out.println(resultArray9.toString());
        System.out.println("-----------------");


        System.out.println("Question10:  Write a program that test the equality of two arrays.");

        int array100 []= {2, 3, 6, 6, 4};
        int array101 []= {2, 3, 6, 6, 4};
        boolean flag10=true;

        if (array100.length!=array101.length) {
            flag10 = false;
        }
        else {
            for(int i = 0 ; i< array100.length; i++){
                if(array100[i]!=array101[i]){
                    flag10=false;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(array100));
        System.out.println(Arrays.toString(array101));
        System.out.println(flag10);
        System.out.println("-----------------");


    }
}
