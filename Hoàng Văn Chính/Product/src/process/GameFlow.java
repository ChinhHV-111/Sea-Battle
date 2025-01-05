package process;

import display.ClearConsole;
import display.TableScreen;
import display.WinnerScreen;
import model.Player;
import model.Ship;

import java.util.ArrayList;

public class GameFlow {
    private Player firstPlayer;
    private Player secondPlayer;
    private String winner;

    public String determineWinner(ArrayList<Ship> ships) {
        for(Ship ship : ships) {
            if(ship.getLeng() > 0) return "Chưa Có Người Thắng";
        }
        return "Chiến Thắng";
    }

    public void makePlayerTurnChoice(Player currentTurnPlayer, Player opponent) {
        //Người chơi 1 bắn:
        System.out.printf("Lượt của \u001B[34m[%s]\u001B[0m!\n", currentTurnPlayer.getName());
        //loop dùng để lặp vòng lặp while
        boolean loop = true;
        //Vòng lặp có thể lựa chọn xem bảng nhiều lần và 1 lần bắn
        while (loop) {
            System.out.println(">>       LỰA CHỌN TÍNH NĂNG       <<");
            System.out.println("++ ------------------------------ ++");
            System.out.println("| 1. Bắn                           |");
            System.out.println("| 2. Xem bảng của bạn và đối thủ   |");
            System.out.println("++ ------------------------------ ++");
            System.out.println("Lựa chọn của bạn là: ");
            int feature = Integer.parseInt(ScannerInput.scanner.nextLine().trim());
            switch (feature) {
                case 1:
                    while (Firing.fire(opponent).equals("Trúng")) {
                        if(determineWinner(opponent.getShips()).equals("Chiến Thắng")) {
                            winner = currentTurnPlayer.getName();
                            return;
                        }
                        System.out.println("Bắn tiếp!");
                        TableScreen.screenFogTable(opponent.getMyTable());
                    }
                    System.out.println("Lượt bắn của bạn đã kết thúc!\n");
                    loop = false;
                    break;
                case 2:
                    //Bảng của bạn
                    System.out.println("Bảng của bạn: ");
                    TableScreen.screenNormalTable(currentTurnPlayer.getMyTable());
                    //Bảng của đối thủ
                    System.out.println("Bảng của đối thủ: ");
                    TableScreen.screenFogTable(opponent.getMyTable());
                    break;
            }
        }
        loop = true;
        //Vòng lặp lựa chọn có thể xem bảng nhiều lần và kết thúc lượt của mình
        while (loop) {
            System.out.println(">>       LỰA CHỌN TÍNH NĂNG       <<");
            System.out.println("++ ------------------------------ ++");
            System.out.println("| 1. Kết thúc lượt                 |");
            System.out.println("| 2. Xem bảng của bạn và đối thủ   |");
            System.out.println("++ ------------------------------ ++");
            System.out.println("Lựa chọn của bạn là: ");
            int feature = Integer.parseInt(ScannerInput.scanner.nextLine().trim());
            switch (feature) {
                case 1:
                    loop = false;
                    break;
                case 2:
                    //Bảng của bạn
                    TableScreen.screenNormalTable(currentTurnPlayer.getMyTable());
                    //Bảng của đối thủ
                    TableScreen.screenFogTable(opponent.getMyTable());
                    break;
            }
        }
    }

    public void playGame() {
        //Nhập tên, khởi tạo player
        String name;
        System.out.println("Nhập tên người chơi thứ nhất: ");
        name = ScannerInput.scanner.nextLine().toUpperCase();
        firstPlayer = new Player(name);
        System.out.println("Nhập tên người chơi thứ hai: ");
        name = ScannerInput.scanner.nextLine().toUpperCase();
        secondPlayer = new Player(name);
        //Tạo ship
        PlayerInitialization.initPlayerShip(firstPlayer);
        PlayerInitialization.initPlayerShip(secondPlayer);

        winner = "####";
        while (true) {
            //Lượt của người chơi thứ nhất
            makePlayerTurnChoice(firstPlayer, secondPlayer);
            ClearConsole.clearConsole();
            if(winner.equals(firstPlayer.getName())) {
                WinnerScreen.printWinner(firstPlayer.getName());
                return;
            }
            //Lượt của người chơi thứ hai
            makePlayerTurnChoice(secondPlayer, firstPlayer);
            ClearConsole.clearConsole();
            if(winner.equals(secondPlayer.getName())) {
                WinnerScreen.printWinner(secondPlayer.getName());
                return;
            }
        }
    }
}
