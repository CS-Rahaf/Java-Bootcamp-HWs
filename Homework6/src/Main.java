import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int codeRunner;
        try {
            // Either run HW4 Q7 version2 or the first project version2. "With exception handling".
            System.out.println("Which code would you like to run ?  \n 1/ HW4 Question7 version2 \n 2/ The first project version2 ");
            codeRunner = scanner.nextInt();

            if (codeRunner == 1) {
                System.out.println("HW4 Question7 'version2': Write a menu driven Java program");
                System.out.println("Please enter the array size");
                int number7 = scanner.nextInt();
                int input7;
                int choice7;
                int element7;
                int index;
                boolean flag7 = true;
                ArrayList<Integer> array7 = new ArrayList<>();

                for (int i = 0; i < number7; i++) {
                    System.out.println("Enter the value");
                    input7 = scanner.nextInt();
                    array7.add(input7);
                }

                System.out.println("Welcome to *Array Program menu* ");
                while (flag7) {
                    System.out.println("Enter \n 1/ To display array elements \n 2/ To search for an element \n 3/ To get the index of a specific element \n 4/ To sort the array \n 0/ to exist ");
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
                        System.out.println("Enter the index");
                        try{
                            index=scanner.nextInt();
                            int result= array7.get(index);
                            System.out.println("The element stored in index "+index + " = "+ result);
                        }//Emd if try block for IndexOutOfBoundsException checking
                        catch (IndexOutOfBoundsException e){
                            System.out.println("the index is greater than list size");
                        }
                    }
                    else if (choice7==4) {
                        Collections.sort(array7);
                        System.out.println("The Array after sort is: " + array7.toString());
                    }
                    else {
                        flag7 = false;
                    }
                }//End of while loop

            }// End of the HW4 Q7
            //------------------------------------------------------------------------------------------------------------------
            else if (codeRunner == 2) {
                System.out.println("The first project 'version2' ");
                char[][] board =
                        {{' ', '|', ' ', '|', ' '},
                                {'-', '+', '-', '+', '-'},
                                {' ', '|', ' ', '|', ' '},
                                {'-', '+', '-', '+', '-'},
                                {' ', '|', ' ', '|', ' '}};

                Integer[] choices = {1, 2, 3, 4, 5, 6, 7, 8, 9};
                int gameIteration = 8;
                int userInput;
                String winner = null;
                while (true) {
                    if (gameIteration % 2 == 0) {
                        //User iteration
                        System.out.println("Would you like to play? (1-9)");
                        userInput = scanner.nextInt();
                        if (choiceAvailability(userInput, choices)) {
                            choiceInBoard('X', userInput, board);
                            printBoard(board);
                        } else {
                            System.out.println(userInput + " is not valid move ");
                            continue;
                        }//place taken "not valid move"
                    }//End of if statement

                    else {
                        //Computer iteration
                        int randomNumber = randomNumberGeneration(choices);
                        System.out.println("Computer choose " + randomNumber);
                        choiceInBoard('O', randomNumber, board);
                        printBoard(board);
                    }

                    //End the game if any player win
                    winner = checkWinner(board);
                    if (winner.equals("X") || winner.equals("O")) {
                        break;
                    }

                    System.out.println();
                    gameIteration--;
                    if (gameIteration < 0) {
                        break;
                    }
                }//End of while loop

                System.out.println(" ** Game Over ** ");

                //Display the winner
                if (winner.equals("X"))
                    System.out.println("Congratulations! You win ");
                else if (winner.equals("O")) {
                    System.out.println("Hard luck! Computer wins :(");
                } else
                    System.out.println("Draw! No player has won");

            }// End of the first project
            //------------------------------------------------------------------------------------------------------------------
            else {
                System.out.println("Invalid input");
            }

        }// End of try block
        catch (InputMismatchException e){
            System.out.println("Invalid input");
        }

    }// End of main method


    public static boolean choiceAvailability(int userInput, Integer[] choices) {
        if (Arrays.asList(choices).contains(userInput)) {
            int index = Arrays.asList(choices).indexOf(userInput);
            choices[index] = -1;
            return true;
        } else {
            return false;
        }

    }

    public static void choiceInBoard(char symbol, int userInput, char[][] board) {

        switch (userInput) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][2] = symbol;
                break;
            case 3:
                board[0][4] = symbol;
                break;
            case 4:
                board[2][0] = symbol;
                break;
            case 5:
                board[2][2] = symbol;
                break;
            case 6:
                board[2][4] = symbol;
                break;
            case 7:
                board[4][0] = symbol;
                break;
            case 8:
                board[4][2] = symbol;
                break;
            case 9:
                board[4][4] = symbol;
                break;
        }

    }// End of choiceInBoard function

    public static int randomNumberGeneration(Integer[] choices) {
        Random rn = new Random();
        int randomNumber;
        while (true) {
            randomNumber = rn.nextInt(9) + 1;
            if (choiceAvailability(randomNumber, choices)) {
                break;
            }
        }
        return randomNumber;
    }// End of randomNumberGeneration

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }//End of printBoard function

    static String checkWinner(char[][] board) {
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = board[0][0] + "" + board[0][2] + board[0][4];
                    break;
                case 1:
                    line = "" + board[2][0] + board[2][2] + board[2][4];
                    break;
                case 2:
                    line = "" + board[4][0] + board[4][2] + board[4][4];
                    break;
                case 3:
                    line = "" + board[0][0] + board[2][0] + board[4][0];
                    break;
                case 4:
                    line = "" + board[0][2] + board[2][2] + board[4][2];
                    break;
                case 5:
                    line = "" + board[0][4] + board[2][4] + board[4][4];
                    break;
                case 6:
                    line = "" + board[0][0] + board[2][2] + board[4][4];
                    break;
                case 7:
                    line = "" + board[0][4] + board[2][2] + board[4][0];
                    break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return "X";
            }

            // For O winner
            else if (line.equals("OOO")) {
                return "O";
            }
        }

        return "null";
    }



}