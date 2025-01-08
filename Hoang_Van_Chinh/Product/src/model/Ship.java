package model;

public class Ship {
    private String name;
    private int rowBegin;
    private int columnBegin;
    private int rowEnd;
    private int columnEnd;
    private String orientation;
    private int leng;

    public Ship() {

    }
    public Ship(String name, int rowBegin, int columnBegin, int rowEnd, int columnEnd, String orientation, int leng) {
        this.name = name;
        this.rowBegin = rowBegin;
        this.columnBegin = columnBegin;
        this.rowEnd = rowEnd;
        this.columnEnd = columnEnd;
        this.orientation = orientation;
        this.leng = leng;
    }

    public String getName() {
        return name;
    }
    public int getRowBegin() {
        return rowBegin;
    }
    public int getColumnBegin() {
        return columnBegin;
    }
    public int getRowEnd() {
        return rowEnd;
    }
    public int getColumnEnd() {
        return columnEnd;
    }
    public int getLeng() {
        return leng;
    }

    public void setLeng(int leng) {
        this.leng = leng;
    }
}


