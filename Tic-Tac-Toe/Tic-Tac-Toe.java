package tictactoe;
import java.util.Scanner;
public class Main {
    public static boolean checkSymbol(char[][] characters, char symbol) {
        boolean symbolWins = false;
        for (int i  = 0; i < characters.length; i++) {
            for (int j = characters[i].length - 1; j > 0; j--) {
                if ((characters[i][j] == symbol) && (characters[i][j - 1] == symbol)) {
                    symbolWins = true;
                    continue;
                }
                else {
                    symbolWins = false;
                    break;
                }
            }
            if (symbolWins == true) {
                return symbolWins;
            }
        }
        for (int i = 0; i < characters.length; i++) {
            for (int j = 0; j < characters[i].length - 1; j++) {
                if ((characters[j][i] == symbol) && (characters[j + 1][i] == symbol)) {
                    symbolWins = true;
                    continue;
                }
                else {
                    symbolWins = false;
                    break;
                }
            }
            if (symbolWins == true) {
                return symbolWins;
            }
        }
       for (int i = 0; i < characters.length; i++) {
           for (int j = 0; j < characters[i].length; j++) {
               if ( i == j ) {
                  if ( characters[i][j] == symbol ) {
                      symbolWins = true;
                  }
                   else {
                       symbolWins = false;
                   }
               }
           }
           if (symbolWins == false) {
               break;
           } 
       }
       if (symbolWins == true) {
           return symbolWins;
       }
       for (int i = 0; i < characters.length; i++) {
           for (int j = 0; j < characters[i].length; j++) {
               if (i + j == characters[i].length - 1) {
                   if (characters[i][j] == symbol) {
                       symbolWins = true;
                   }
                   else {
                       symbolWins = false;
                   }
               }
           }
           if (symbolWins == false) {
               break;
           }
       }
       if (symbolWins == true) {
           return symbolWins;
       }
       return symbolWins; 
    }
    public static void result(char[][] characters) {
        boolean Xwins = false;
        boolean Owins = false;
        boolean isEmpty = false;
        for (int i = 0; i < characters.length; i++) {
            for (int j = 0; j < characters[i].length; j++) {
                if ((characters[i][j] != 'X') && (characters[i][j] != 'O')) {
                    isEmpty = true;
                }
                break;
            }
            if (isEmpty == true) {
                break;
            }
        }
        int noOfX = 0;
        int noOfO = 0;
        for (int i = 0; i < characters.length; i++) {
            for (int j = 0; j < characters[i].length; j++) {
                if (characters[i][j] == 'X') {
                    noOfX++;
                }
                else if (characters[i][j] == 'O') {
                    noOfO++;
                }
            }
        }
        Xwins = checkSymbol(characters, 'X');
        Owins = checkSymbol(characters, 'O');
        if ((Xwins) && (Owins)) {
            System.out.print("Impossible");
        }
        else if ((noOfX - noOfO) > 1) {
            System.out.print("Impossible");
        }
        else if ((noOfO - noOfX) > 1) {
            System.out.print("Impossible");
        }
        else if ((!Xwins) && (!Owins) && (isEmpty)) {
            System.out.println("Game not finished");
        }
        else if ((!Xwins) && (!Owins) && (!isEmpty)) {
            System.out.print("Draw");
        }
        else if ((Xwins) && (!Owins)) {
            System.out.print("X wins");
        }
        else if ((Owins) && (!Xwins)) {
            System.out.print("O wins");
        }
    }
    public static void main(String[] args) {
        // write your code here
        //System.out.print("X O X\nO X O\nX X O");
        Scanner scanner = new Scanner(System.in);
        String gameState = scanner.nextLine();
        char[][] characters = new char[3][3];
        int index = 0;
        System.out.println("---------");
        for (int i = 0; i < characters.length; i++) {
            for (int j = 0; j < characters[i].length; j++){
                characters[i][j] = gameState.charAt(index);
                index++;
            }
        }
        for (int i = 0; i < characters.length; i++){
            System.out.print("| ");
            for (int j = 0; j < characters.length; j++){
                System.out.print(characters[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------"); 
        result(characters);
    }
}
