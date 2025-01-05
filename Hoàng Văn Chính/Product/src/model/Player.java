package model;

import java.util.ArrayList;

public class Player {
    private String name;
    public int numberOfShots;
    private char[][] myTable;
    private ArrayList<Ship> ships = new ArrayList<Ship>();
    public int sizeOfTable;

    public Player() {

    }
    public Player(String name) {
        sizeOfTable = 10;
        this.name = name;
        this.numberOfShots = 0;
        this.myTable = new char[sizeOfTable + 1][sizeOfTable + 1];
        for(int j = 1; j <= sizeOfTable; ++j) {
            myTable[0][j] = (char)(j+'0');
        }
        for(int i = 1; i <= sizeOfTable; ++i) {
            myTable[i][0] = (char)(i+'0');
        }
    }

    public String getName() {
        return name;
    }
    public char[][] getMyTable() {
        return myTable;
    }
    public ArrayList<Ship> getShips() {
        return ships;
    }
}
