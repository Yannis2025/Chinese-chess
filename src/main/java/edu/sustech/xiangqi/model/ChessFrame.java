package edu.sustech.xiangqi.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChessFrame extends JFrame implements MouseListener {

    private JLabel chessboard;//用于放棋盘图的JLabel
    private JLabel controlPanel;//用于放ControlPanel的JLabel
    private JLabel back;//悔棋图标
    private JLabel musicTurnon;
    private JLabel musicTurnoff;
    private JLabel newGame;
    private JLabel[][] chessPiece=new JLabel[10][9]; //棋子图标数组
    private String chessUI[][]={
            {"黑车","黑马","黑象","黑士","黑帅","黑士","黑象","黑马","黑车"},
            {"","","","","","","","",""},
            {"","黑炮","","","","","","黑炮",""},
            {"黑卒","","黑卒","","黑卒","","黑卒","","黑卒"},
            {"","","","","","","","",""},
            {"","","","","","","","",""},
            {"红卒","","红卒","","红卒","","红卒","","红卒"},
            {"","红炮","","","","","","红炮",""},
            {"","","","","","","","",""},
            {"红车","红马","红象","红士","红帅","红士","红象","红马","红车"}
    };
    //棋盘边界与窗口边界的差距
    private static final int MARGIN = 51;
    //格子大小
    private static final int CELL_SIZE = 58;
    //棋子半径
    private static final int PIECE_RADIUS = 27;
    //是否选中(位于抽象棋子类/棋子共同属性类中,还未接入)
    private AbstractPiece selectedPiece = null;
    //棋子坐标
    private Location[][] location = new Location[10][9];

    //处理鼠标点击(未接入)
    private void handleMouseClick(int x, int y) {
        int col = Math.round((float)(x - MARGIN) / CELL_SIZE);
        int row = Math.round((float)(y - MARGIN) / CELL_SIZE);

        /*if (!model.isValidPosition(row, col)) {
            return;
        }

        if (selectedPiece == null) {
            selectedPiece = model.getPieceAt(row, col);
        } else {
            model.movePiece(selectedPiece, row, col);
            selectedPiece = null;
        }*/

        // 处理完点击事件后，需要重新绘制ui界面才能让界面上的棋子“移动”起来
        // Swing 会将多个请求合并后再重新绘制，因此调用 repaint 后gui不会立刻变更
        // repaint 中会调用 paintComponent，从而重新绘制gui上棋子的位置等
        repaint();
    }

    //设置ChessFrame中的图标
    public ChessFrame(){
        //设置窗口大小
        setBounds(600,75,700,650);
        //不许改变窗口大小
        setResizable(false);
        setTitle("中国象棋");
        //清空默认布局方式
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeChess();
        //棋盘背景图
        chessboard =new JLabel(new ImageIcon("image/Chessboard.gif"));
        chessboard.setBounds(0,0,558,620);
        getContentPane().add(chessboard);//获取内容面板,获取其中的组件JLabel



        //悔棋图标
        back=new JLabel(new ImageIcon("image/back.jpg"));
        back.setBounds(570, 80, 100, 30);
        getContentPane().add(back);

        //打开音乐图标
        musicTurnon=new JLabel(new ImageIcon("image/turnon.png"));
        musicTurnon.setBounds(603, 220, 32,32);
        getContentPane().add(musicTurnon);

        //关闭音乐图标(在点击音乐图标后变成关闭音乐图标)
        /*musicTurnoff=new JLabel(new ImageIcon("image/turnoff.png"));
        musicTurnoff.setBounds(585, 150, 32, 32);
        getContentPane().add(musicTurnoff);*/

        //新游戏图标
        newGame=new JLabel(new ImageIcon("image/new.jpg"));
        newGame.setBounds(570, 150, 100, 39);
        getContentPane().add(newGame);

        //控制板
        controlPanel =new JLabel(new ImageIcon("image/ControlPanel.jpg"));
        controlPanel.setBounds(558,0,128,620);
        getContentPane().add(controlPanel);


    }

    //初始化棋子位置
    private void initializeChess(){
        //用变量储存参数减少改参数的麻烦
        int initialX=20;
        int initialY=20;
        int gridSize=58;//网格尺寸(宽高相同)
        int chessSize=55;

        placeChess(0,0,"黑车.gif",initialX,initialY,gridSize,chessSize,false);
        placeChess(0,8,"黑车.gif",initialX,initialY,gridSize,chessSize,false);
        placeChess(0,1,"黑马.gif",initialX,initialY,gridSize,chessSize,false);
        placeChess(0,7,"黑马.gif",initialX,initialY,gridSize,chessSize,false);
        placeChess(0,2,"黑象.gif",initialX,initialY,gridSize,chessSize,false);
        placeChess(0,6,"黑象.gif",initialX,initialY,gridSize,chessSize,false);
        placeChess(0,3,"黑士.gif",initialX,initialY,gridSize,chessSize,false);
        placeChess(0,5,"黑士.gif",initialX,initialY,gridSize,chessSize,false);
        placeChess(0,4,"黑将.gif",initialX,initialY,gridSize,chessSize,false);
        placeChess(2,1,"黑炮.gif",initialX,initialY,gridSize,chessSize,false);
        placeChess(2,7,"黑炮.gif",initialX,initialY,gridSize,chessSize,false);
        placeChess(3,0,"黑卒.gif",initialX,initialY,gridSize,chessSize,false);
        placeChess(3,2,"黑卒.gif",initialX,initialY,gridSize,chessSize,false);
        placeChess(3,4,"黑卒.gif",initialX,initialY,gridSize,chessSize,false);
        placeChess(3,6,"黑卒.gif",initialX,initialY,gridSize,chessSize,false);
        placeChess(3,8,"黑卒.gif",initialX,initialY,gridSize,chessSize,false);
        placeChess(9,0,"红车.gif",initialX,initialY,gridSize,chessSize,true);
        placeChess(9,8,"红车.gif",initialX,initialY,gridSize,chessSize,true);
        placeChess(9,1,"红马.gif",initialX,initialY,gridSize,chessSize,true);
        placeChess(9,7,"红马.gif",initialX,initialY,gridSize,chessSize,true);
        placeChess(9,2,"红象.gif",initialX,initialY,gridSize,chessSize,true);
        placeChess(9,6,"红象.gif",initialX,initialY,gridSize,chessSize,true);
        placeChess(9,3,"红士.gif",initialX,initialY,gridSize,chessSize,true);
        placeChess(9,5,"红士.gif",initialX,initialY,gridSize,chessSize,true);
        placeChess(9,4,"红将.gif",initialX,initialY,gridSize,chessSize,true);
        placeChess(7,1,"红炮.gif",initialX,initialY,gridSize,chessSize,true);
        placeChess(7,7,"红炮.gif",initialX,initialY,gridSize,chessSize,true);
        placeChess(6,0,"红卒.gif",initialX,initialY,gridSize,chessSize,true);
        placeChess(6,2,"红卒.gif",initialX,initialY,gridSize,chessSize,true);
        placeChess(6,4,"红卒.gif",initialX,initialY,gridSize,chessSize,true);
        placeChess(6,6,"红卒.gif",initialX,initialY,gridSize,chessSize,true);
        placeChess(6,8,"红卒.gif",initialX,initialY,gridSize,chessSize,true);

    }

    //放置棋子
    private void placeChess(int row,int col,String image,int initialX,int initialY,int gridSize,int chessSize,boolean isRed){
        //得计算棋子在棋盘上的位置,否则无法setBounds
        int x=initialX+col*gridSize+(gridSize-chessSize)/2;
        //得到第col列格子的左侧X坐标+格子左侧与棋子左侧相隔的距离=棋子左侧的坐标
        int y=initialY+row*gridSize+(gridSize-chessSize)/2;

        JLabel chess=new JLabel(new ImageIcon("image/"+image));
        chess.setBounds(x,y,chessSize,chessSize);
        chessPiece[row][col]=chess;
        chess.addMouseListener(this);//this指当前操作的ChessFrame类的实例
        add(chess);//JFrame里默认委托给content pane,所以直接add

        //备份棋子属性
        location[row][col]=new Location(row,col,chessUI[row][col],chess);
    }

    //newGame重置棋子(差一点完成)
    public void setNewGame(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                if (chessPiece[i][j]!=null){
                    getContentPane().remove(chessPiece[i][j]);
                    chessPiece[i][j]=null;
                }
            }
        }
        initializeChess();
        repaint();
    }

    //测试
//  public static void main(String[] args) {
//        ChessFrame chessFrame=new ChessFrame();
//        chessFrame.setVisible(true);
//    }
    //位置是否合法(未接入)
    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < 10 && col >= 0 && col < 9;
    }

    /**
     * 绘制选中棋子时的蓝色外边框效果(未接入)
     */
    private void drawCornerBorders(Graphics2D g, int centerX, int centerY) {
        g.setColor(new Color(0, 100, 255));
        g.setStroke(new BasicStroke(3));

        int cornerSize = 32;
        int lineLength = 12;

        // 选中效果的边框实际上是8条line，每两个line组成一个角落的边框

        // 左上角的边框
        g.drawLine(centerX - cornerSize, centerY - cornerSize,
                centerX - cornerSize + lineLength, centerY - cornerSize);
        g.drawLine(centerX - cornerSize, centerY - cornerSize,
                centerX - cornerSize, centerY - cornerSize + lineLength);

        // 右上角的边框
        g.drawLine(centerX + cornerSize, centerY - cornerSize,
                centerX + cornerSize - lineLength, centerY - cornerSize);
        g.drawLine(centerX + cornerSize, centerY - cornerSize,
                centerX + cornerSize, centerY - cornerSize + lineLength);

        // 左下角的边框
        g.drawLine(centerX - cornerSize, centerY + cornerSize,
                centerX - cornerSize + lineLength, centerY + cornerSize);
        g.drawLine(centerX - cornerSize, centerY + cornerSize,
                centerX - cornerSize, centerY + cornerSize - lineLength);

        // 右下角的边框
        g.drawLine(centerX + cornerSize, centerY + cornerSize,
                centerX + cornerSize - lineLength, centerY + cornerSize);
        g.drawLine(centerX + cornerSize, centerY + cornerSize,
                centerX + cornerSize, centerY + cornerSize - lineLength);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel lblSource = (JLabel) e.getSource();
        //(JLabel):将原组件强制转换成JLabel类型(不然用不了)
        //这里是获取触发鼠标点击事件的源组件

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                //跳过空位置
                if (location[i][j]==null){
                    continue;
                }
                if (lblSource==location[i][j].getLblChess()){
                    System.out.println(location[i][j].getChessName());
                    System.out.println("X:"+location[i][j].getX());
                    System.out.println("Y:"+location[i][j].getY());
                    return;
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

