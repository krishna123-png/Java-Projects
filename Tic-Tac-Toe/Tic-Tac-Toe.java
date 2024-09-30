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

    public static boolean isEmpty(char[][] characters) {
        for (int i = 0; i < characters.length; i++) {
            for (int j = 0; j < characters[i].length; j++) {
                if ((characters[i][j] != 'X') && (characters[i][j] != 'O')) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isDraw(char[][] characters) {
        return (!checkSymbol(characters, 'X') && !checkSymbol(characters, 'O') && !isEmpty(characters)) ? true : false;
    }
    
    public static boolean canBeInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean lessThan1(int num) {
        if (num < 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean greaterThan3(int num) {
        if (num > 3) {
            return true;
        }
        else {
            return false;
        }
    }

    public static boolean canInsert(int num1, int num2, char[][] characters) {
        if ((characters[num1 - 1][num2 - 1] == 'X') || (characters[num1 - 1][num2 - 1] == 'O')) {
            return false;
        }
        else {
            return true;
        }
    }
    
    public static void fillSymbol(char[][] characters, char symbol) {
        Scanner scanner = new Scanner(System.in);
        boolean filledSymbol = false;
        do {
            String input1 = scanner.next();
            String input2 = scanner.next();
            if ((!canBeInteger(input1)) || (!canBeInteger(input2))) {
                System.out.println("You should enter numbers!");
                continue;
            }
            else {
                int num1 = Integer.parseInt(input1);
                int num2 = Integer.parseInt(input2);
                if ((lessThan1(num1)) || (greaterThan3(num1)) || (lessThan1(num2)) || (greaterThan3(num2))) {
                    System.out.println("Coordinates should be from 1 and 3!");
                    continue;
                }
                else if (!canInsert(num1, num2, characters)) {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
                else {
                    characters[num1 - 1][num2 - 1] = symbol;
                    System.out.println("---------");
                    for (int i = 0; i < characters.length; i++){
                        System.out.print("| ");
                        for (int j = 0; j < characters.length; j++){
                            System.out.print(characters[i][j] + " ");
                        }
                        System.out.println("|");
                    }
                    System.out.println("---------");
                    System.out.println(num1 + " " + num2);
                    filledSymbol = true;
                }
            }
        } while (filledSymbol != true);
    }
    public static void main(String[] args) {
        // write your code here
        //System.out.print("X O X\nO X O\nX X O");
        Scanner scanner = new Scanner(System.in);
        String gameState = "         ";
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
        boolean chanceOfX = true;
        boolean chanceOfO = false;
        while ((!checkSymbol(characters, 'X')) && (!checkSymbol(characters, 'O')) && (!isDraw(characters))) {
            char symbol = ((chanceOfX) && (!chanceOfO)) ? 'X' : 'O';
            fillSymbol(characters, symbol);
            chanceOfX = !chanceOfX;
            chanceOfO = !chanceOfO;
        }
        if (isDraw(characters)) {
            System.out.println("Draw");
        }
        else if (checkSymbol(characters, 'O')) {
            System.out.println("O wins");
        }
        else {
            System.out.println("X wins");
        }
        
    }
}
