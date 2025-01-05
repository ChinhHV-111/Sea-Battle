package display;

import model.Player;

public class WinnerScreen {
    public static void printWinner(String name) {
        System.out.println(" █████   ███   █████ █████ ██████   █████ ██████   █████ ██████████ ███████████");
        System.out.println("░░███   ░███  ░░███ ░░███ ░░██████ ░░███ ░░██████ ░░███ ░░███░░░░░█ ░░███░░░░░███");
        System.out.println(" ░███   ░███   ░███  ░███  ░███░███ ░███  ░███░███ ░███  ░███  █ ░   ░███    ░███");
        System.out.println(" ░███   ░███   ░███  ░███  ░███░░███░███  ░███░░███░███  ░██████     ░██████████");
        System.out.println(" ░░███  █████  ███   ░███  ░███ ░░██████  ░███ ░░██████  ░███░░█     ░███░░░░░███");
        System.out.println("  ░░░█████░█████░    ░███  ░███  ░░█████  ░███  ░░█████  ░███ ░   █  ░███    ░███");
        System.out.println("    ░░███ ░░███      █████ █████  ░░█████ █████  ░░█████ ██████████  █████   █████");
        System.out.println("\n");
        System.out.println("\u001B[1m\u001B[32mChúc mừng người chơi:\u001B[0m");
        System.out.printf("\u001B[1m\u001B[34m        [%s]         \u001B[0m\n", name);
        System.out.println("\u001B[1m\u001B[32mBạn đã chiến thắng trong ván đấu này!!!\u001B[0m");
        System.out.println("\n\n\n");
    }
}
