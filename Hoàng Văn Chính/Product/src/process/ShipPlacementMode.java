package process;

import display.TableScreen;
import model.*;

public class ShipPlacementMode {
    //Hàm tạo một thuyền (truyền vào tên thuyền tiếng Việt viết hoa chữ cái đầu)
    public static Ship initShipCustom(String name) {
        int leng = 0;
        switch (name) {
            case "Thuyền Tuần Tra":
                leng = 2;
                break;
            case "Tàu Khu Trục":
                leng = 4;
                break;
            case "Tàu Ngầm":
                leng = 3;
                break;
            case "Thiết Giáp Hạm":
                leng = 5;
                break;
        }
        System.out.print("Nhập vị trí đầu tàu!\n");
        System.out.print("Nhập hàng A -> J: ");
        int rowBegin = ScannerInput.scanner.nextLine().trim().charAt(0) - 'A' + 1;
        System.out.print("Nhập cột 1 -> 10: ");
        int columnBegin = Integer.parseInt(ScannerInput.scanner.nextLine().trim());
        int rowEnd = rowBegin;
        int columnEnd = columnBegin;
        String orientation = "left";
        System.out.println(">>   LỰA CHỌN HƯỚNG TÀU   <<");
        System.out.println("++ ---------------------- ++");
        System.out.println("| 1. Quay lên              |");
        System.out.println("| 2. Quay xuống            |");
        System.out.println("| 3. Quay trái             |");
        System.out.println("| 4. Quay phải             |");
        System.out.println("++ ---------------------- ++");
        System.out.println("Lựa chọn của bạn là: ");
        int feature = Integer.parseInt(ScannerInput.scanner.nextLine().trim());
        switch (feature) {
            case 1:
                orientation = "up";
                rowEnd = rowBegin - (leng - 1);
                break;
            case 2:
                orientation = "down";
                rowEnd = rowBegin + (leng - 1);
                break;
            case 3:
                orientation = "left";
                columnEnd = columnBegin - (leng - 1);
                break;
            case 4:
                orientation = "right";
                columnEnd = columnBegin + (leng - 1);
                break;
        }
        return new Ship(name, rowBegin, columnBegin, rowEnd, columnEnd, orientation, leng);
    }

    //Là thuyền thoả mãn điều kiện nằm hết trong bảng,
    public static boolean isShipInRegion(Ship ship) {
        if(!(ship.getRowBegin() >= 1 &&  ship.getRowBegin() <= 10)) return false;
        if(!(ship.getRowEnd() >= 1 &&  ship.getRowEnd() <= 10)) return false;
        if(!(ship.getColumnBegin() >= 1 &&  ship.getColumnBegin() <= 10)) return false;
        if(!(ship.getColumnEnd() >= 1 &&  ship.getColumnEnd() <= 10)) return false;
        return true;
    }
    //Là thuyền hợp lệ với tất cả điều kiện.
    public static boolean isShipValid(Ship ship, Player player) {
        if(!isShipInRegion(ship)) {
            System.out.println("\u001B[31mNgoài vùng đặt thuyền!\u001B[0m");
            System.out.println("\u001B[33mVui lòng đặt lại!\u001B[0m");
            return false;
        }
        for(int i = Math.min(ship.getRowBegin(), ship.getRowEnd()); i <= Math.max(ship.getRowBegin(), ship.getRowEnd()); ++i) {
            for(int j = Math.min(ship.getColumnBegin(), ship.getColumnEnd()); j <= Math.max(ship.getColumnBegin(), ship.getColumnEnd()); ++j) {
                if(player.getMyTable()[i][j] >= '1' && player.getMyTable()[i][j] <= '5') {
                    System.out.println("\u001B[31mVị trí bị trùng với thuyền đã được đặt!\u001B[0m");
                    System.out.println("\u001B[33mVui lòng đặt lại!\u001B[0m");
                    return false;
                }
            }
        }
        return true;
    }

    public static void updateTable(Ship ship, Player player) {
        for(int i = Math.min(ship.getRowBegin(), ship.getRowEnd()); i <= Math.max(ship.getRowBegin(), ship.getRowEnd()); ++i) {
            for(int j = Math.min(ship.getColumnBegin(), ship.getColumnEnd()); j <= Math.max(ship.getColumnBegin(), ship.getColumnEnd()); ++j) {
                player.getMyTable()[i][j] = (char)(player.getShips().size() + '0');
            }
        }
    }

    public static void placeShipsCustom(Player player) {
        Ship ship;
        TableScreen.screenNormalTable(player.getMyTable());
        //Thuyền Tuần Tra x2
        for(int i = 1; i <= 2; ++i) {
            do {
                System.out.println("Đặt Thuyền Tuần Tra: ");
                ship = initShipCustom("Thuyền Tuần Tra");
            }
            while (!isShipValid(ship, player));
            player.getShips().add(ship);
            updateTable(ship, player);
            System.out.println("Bảng hiện tại: ");
            TableScreen.screenNormalTable(player.getMyTable());
        }

        //Tàu Khu Trục x1
        System.out.println("Đặt Tàu Khu Trục: ");
        do {
            ship = initShipCustom("Tàu Khu Trục");
        }
        while (!isShipValid(ship, player));
        player.getShips().add(ship);
        updateTable(ship, player);
        System.out.println("Bảng hiện tại: ");
        TableScreen.screenNormalTable(player.getMyTable());

        //Tàu Ngầm x1
        System.out.println("Đặt Tàu Ngầm: ");
        do {
            ship = initShipCustom("Tàu Ngầm");
        }
        while (!isShipValid(ship, player));
        player.getShips().add(ship);
        updateTable(ship, player);
        System.out.println("Bảng hiện tại: ");
        TableScreen.screenNormalTable(player.getMyTable());

        //Thiết giáp hạm x1
        System.out.println("Đặt Thiết Giáp Hạm: ");
        do {
            ship = initShipCustom("Thiết Giáp Hạm");
        }
        while (!isShipValid(ship, player));
        player.getShips().add(ship);
        updateTable(ship, player);
        System.out.println("Bảng hiện tại: ");
        TableScreen.screenNormalTable(player.getMyTable());
    }
}
