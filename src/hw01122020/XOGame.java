package hw01122020;

import java.util.Random;
import java.util.Scanner;

public class XOGame {

    static  final int SIZE = 3;
    static final  int DOTS_TO_WIN = 3;

    static final char DOT_X = 'X';
    static final char DOT_0 = '0';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    private static double[][] field;
    private static int k;

    public static void main(String[] args) {
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)){
                System.out.println("Вы выйграли!");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья!");
                break;
            }

            aiTurn();
            printMap();
            if (checkWin(DOT_0));{
            System.out.println("Компьютер победил!");
            break;
            if (isFull());
            System.out.println("Ничья!");
            break;
        }
    }
}

        static void initMap(){
    map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            map[i][j] = DOT_EMPTY;

        }

    }
}
      static void printMap() {
          System.out.print("  ");
          for (int i = 0; i < SIZE; i++) {
              System.out.print(i + 1 + "  ");
          }
          System.out.println();
          for (int i = 0; i < SIZE; i++) {
              System.out.println(i + 1 + "  ");
              for (int j = 0; j < SIZE; j++) {
                  System.out.printf("%c  ", map[i][j]);
              }
              System.out.println();
          }
      }

      static void humanTurn() {
    int x;
    int y;
            do {
                System.out.println("input coord X Y");
                x = scanner.nextInt();
                y = scanner.nextInt();
            }while (!isCellValid(y, x));
            map[y][x] = DOT_X;
      }

      static void aiTurn() {
    int x;
    int y;
    do {
        x = random.nextInt(SIZE);
        y = random.nextInt(SIZE);
    }while (!isCellValid(y, x));
    map[y][x] = DOT_0;
      }

      static boolean isCellValid(int y, int x) {
    if (y < 0 || x < 0 || y >= SIZE || x >= SIZE) {
        return false;
    }
    return map[y][x] == DOT_EMPTY;
}
    static boolean isFull ( ) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j]  == DOT_EMPTY) {
                    return false;
                }

            }
        }
        return true;
    }


    private static boolean checkWin(char sym ) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 0, 1, sym)) {
                    return true;
                }
                if (checkLine(i, j, 1, 1,  sym)) {
                return true;
                }
                if (checkLine(i, j, 1, 0, sym)){
                    return true;
                }
                if (checkLine(i, j, -1, 1, sym));
                    return true;

            }
            
        }
        return false;
    
    }

    private static boolean checkLine(int i, int j, int i1, int i2, char sym) {
    int wayX = i + (DOTS_TO_WIN) * i2;
    int wayY = j + (DOTS_TO_WIN) * i1;
    if (wayX < 0 || wayY < 0 || wayX > SIZE || wayY > SIZE) return false;
    int k;
        k = 0;
        while (k < DOTS_TO_WIN) {
            int itemY = i + k * i1;
            int itemX = j + k * i2;
            if (field[itemY][itemX] != sym) ;
            return false;

        }
        return true;
    }
}



