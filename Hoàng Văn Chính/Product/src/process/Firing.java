package process;

import model.*;
import display.TableScreen;

public class Firing {
    //Truyền vào player đối thủ
    public static String fire(Player player) {
        char[][] myTable = player.getMyTable();
        CannonballInitialization cannonballInitialization = new CannonballInitialization();
        Cannonball cannonball = cannonballInitialization.initCannonball(player);
        if(myTable[cannonball.row][cannonball.column] == 0) {
            System.out.println("\u001B[33mBạn đã bắn trượt!\u001B[0m");
            myTable[cannonball.row][cannonball.column] = 'O';
            System.out.println("\n");
            TableScreen.screenFogTable(myTable);
            return "Trượt";
        }
        else {
            System.out.println("\u001B[32mBạn đã bắn trúng tàu của đối thủ!\u001B[0m");
            Ship ship = player.getShips().get(myTable[cannonball.row][cannonball.column] - '1');
            int newLeng = ship.getLeng() - 1;
            ship.setLeng(newLeng);
            myTable[cannonball.row][cannonball.column] = 'X';
            if(newLeng == 0) {
                System.out.printf("\u001B[1m\u001B[32m%s của đối thủ đã chìm\u001B[0m\n", ship.getName());
            }
            return "Trúng";
        }
    }
}
