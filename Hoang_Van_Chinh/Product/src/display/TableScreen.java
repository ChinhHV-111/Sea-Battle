package display;

public class TableScreen {
    public static void screenNormalTable(char[][] table) {
        System.out.println("\u001B[32m");
        System.out.println("   || 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10|");
        System.out.println("   ==========================================");
        for(int i = 1; i <= 10; ++i) {
            System.out.printf(" %c ||", i - 1 + 'A');
            for(int j = 1; j <= 10; ++j) {
                char symbol = ' ';
                if(table[i][j] >= '1' && table[i][j] <= '5') symbol = 'S';
                else if(table[i][j] == 'X') symbol = 'X';
                else if(table[i][j] == 'O') symbol = 'O';
                System.out.printf(" %c |", symbol);
            }
            System.out.println();
            if(i == 10) {
                System.out.println("   ==========================================\n");
            }
        }
        System.out.println("\u001B[0m");
    }

    public static void screenFogTable(char[][] table) {
        System.out.println("\u001B[31m");
        System.out.println("   || 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10|");
        System.out.println("   ==========================================");
        for(int i = 1; i <= 10; ++i) {
            System.out.printf(" %c ||", i - 1 + 'A');
            for(int j = 1; j <= 10; ++j) {
                char symbol = '~';
                if(table[i][j] == 'X') symbol = 'X';
                else if(table[i][j] == 'O') symbol = 'O';
                System.out.printf(" %c |", symbol);
            }
            System.out.println();
            if(i == 10) {
                System.out.println("   ==========================================\n");
            }
        }
        System.out.println("\u001B[0m");
    }
}
