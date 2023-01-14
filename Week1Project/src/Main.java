import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);

        char[][] board = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        Integer[] choices = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int gameIteration = 8;
        int userInput;
        boolean winnerFlag= true;
        String winner=null;

        while (true) {
            if (gameIteration % 2 == 0) {
                //User iteration
                System.out.println("Would you like to play? (1-9)");
                userInput = scaner.nextInt();
                if (choiceAvailability(userInput, choices)) {
                    choiceInBoard(0, userInput, board);
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
                choiceInBoard(1, randomNumber, board);
                printBoard(board);

            }
            //End the game if any player win
            winner= checkWinner(board);
            if(winner.equals("X") || winner.equals("O")){
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
        if(winner.equals("X"))
            System.out.println("Congratulations! well deserved ");
        else if (winner.equals("O")) {
            System.out.println("Hard luck! Computer wins :(");
        } else
            System.out.println("Draw! No player has won");

    }//End of main


    public static boolean choiceAvailability(int userInput, Integer[] choices) {
        if (Arrays.asList(choices).contains(userInput)) {
            int index = Arrays.asList(choices).indexOf(userInput);
            choices[index] = -1;
            return true;
        } else {
            return false;
        }

    }

    public static void choiceInBoard(int userType, int userInput, char[][] board) {
        char symbol;
        if (userType == 0) {
            symbol = 'X';
        } else {
            symbol = 'O';
        }

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
        int range = 9 - 1 + 1;

        int randomNumber;
        while (true) {
            randomNumber = rn.nextInt(range) + 1;

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



}//End of class