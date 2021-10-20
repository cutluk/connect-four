import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Asks users what they want the height and length of the board to be
        System.out.print("What would you like the height of the board to be? ");
        int height = input.nextInt();
        System.out.print("What would you like the length of the board to be? ");
        int length = input.nextInt();

        // Calls upon initializeBoard and printBoard to initialize and setup the board
        char[][] board = new char[height][length];
        initializeBoard(board);
        printBoard(board);

        // Prints the players and initializes them
        System.out.println("Player 1: x");
        System.out.println("Player 2: o");

        char player1 = 'x';
        char player2 = 'o';

        // Declared Variables
        boolean Winner = false;
        int count = 0;
        int col;
        int row;
        int increase = 0;
        int boardFull = length * height;

        // This while loop runs the whole game and continues until a player wins or a draw occurs
        while(Winner == false){

            // Checks the board to see if a draw has occured
            if (increase == boardFull){
                System.out.println("Draw. Nobody wins.");
                return;
            }

            // Player 1 turn
            if (count % 2 == 0){
                System.out.print("Player 1: Which column would you like to choose? ");
                col = input.nextInt();
                row = insertChip(board,col,player1);
                count++;
                increase++;
                Winner = checkIfWinner(board,col,row,player1);

                // Player 2 turn
            } else {
                System.out.print("Player 2: Which column would you like to choose? ");
                col = input.nextInt();
                row = insertChip(board,col,player2);
                count++;
                increase++;
                Winner = checkIfWinner(board,col,row,player2);
            }
        }
        // Prints out if player 2 or 1 has won the game
        if (count % 2 == 0){
            System.out.println("Player 2 won the game!");
        }else {
            System.out.println("Player 1 won the game!");
        }

    }

    // Uses initializeBoard and prints out the board based on user input
    public static void printBoard(char[][] array) {
        for (int i = array.length-1; i >= 0; i--) {
            for(int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Sets the board specifications into arrays
    public static void initializeBoard(char[][] array){
        for (int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[0].length; j++) {
                    array[i][j] = '-';
            }
        }
    }

    //checks for player input then enters a chip into the desired location
    public static int insertChip(char[][] array, int col, char chipType) {
        int row = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i][col] == '-') {
                array[i][col] = chipType;
                row = i;
                break;

            }
        }
        printBoard(array);

        return row;
    }

    // checks if a player has won the game
    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType){
        int count = 0;
        boolean winner = false;

        // checks to up and down for 4 in a row
        for(int i = 0; i < array.length; i++){
           if (chipType == array[i][col] && array[i][col] != '-'){
               count++;
           } else {
               count = 0;
           } if(count == 4){
               winner = true;
               break;
           }
        }
        count = 0;

        // checks side to side for 4 in a row
        if(winner == false) {
            for (int i = 0; i < array[row].length; i++) {
                if (chipType==array[row][i] && array[row][i] != '-'){
                    count++;
                } else {
                    count = 0;
                }
                if (count == 4){
                    winner = true;
                    break;
                }
            }
        }





        return winner;
    }
}
