package edu.sustech.xiangqi.model;

import javax.swing.*;

public class Location {
    private int x;
    private int y;
    private String chessName;//为获取棋子/图片名称
    private JLabel lblChess;//为获取lbl对象

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getChessName() {
        return chessName;
    }

    public void setChessName(String chessName) {
        this.chessName = chessName;
    }

    public JLabel getLblChess() {
        return lblChess;
    }

    public void setLblChess(JLabel lblChess) {
        this.lblChess = lblChess;
    }

    public Location(int x, int y, String chessName, JLabel lblChess) {
        this.x = x;
        this.y = y;
        this.chessName = chessName;
        this.lblChess = lblChess;
    }

    public Location() {
    }
}
