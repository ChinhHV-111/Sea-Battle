package process;

import model.Cannonball;
import model.Player;

public class CannonballInitialization {
    //Là đạn nằm trong bảng
    public boolean isCannonballInRegion(Cannonball cannonball) {
        if(!(cannonball.row >= 1 &&  cannonball.row <= 10)) return false;
        if(!(cannonball.column >= 1 &&  cannonball.column <= 10)) return false;
        return true;
    }
    //Là đạn thoả mãn tất cả điều kiện
    public boolean isCannonballValid(Cannonball cannonball, Player player) {
        if(!isCannonballInRegion(cannonball)) {
            System.out.println("\u001B[31mToạ độ nằm ngoài vùng bắn!\u001B[0m");
            System.out.println("\u001B[33mVui lòng đặt lại!\u001B[0m");
            return false;
        }
        if(player.getMyTable()[cannonball.row][cannonball.column] == 'X' || player.getMyTable()[cannonball.row][cannonball.column] == 'O') {
            System.out.println("\u001B[31mVị trí đã được bắn!\u001B[0m");
            System.out.println("\u001B[33mVui lòng đặt lại!\u001B[0m");
            return false;
        }
        return true;
    }

    public Cannonball initCannonball(Player player) {
        Cannonball cannonball = new Cannonball();
        do {
            System.out.println("Nhập toạ độ muốn bắn!");
            System.out.print("Nhập hàng A -> J: ");
            cannonball.row = ScannerInput.scanner.nextLine().trim().charAt(0) - 'A' + 1;
            System.out.print("Nhập cột 1 -> 10: ");
            cannonball.column = Integer.parseInt(ScannerInput.scanner.nextLine().trim());
        }
        while (!isCannonballValid(cannonball, player));
        return cannonball;
    }
}
