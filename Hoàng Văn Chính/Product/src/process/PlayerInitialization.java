package process;

import display.ClearConsole;
import model.*;

public class PlayerInitialization {
    public static void initPlayerShip(Player player) {
        System.out.printf("Người chơi \u001B[34m[%s]\u001B[0m tạo tàu!\n", player.getName());
        ShipPlacementMode.placeShipsCustom(player);
        System.out.printf("\u001B[32mNgười chơi [%s] tạo tàu thành công!!!\u001B[0m\n\n\n", player.getName());;
        ClearConsole.clearConsole();
    }
}
