package edu.sustech.xiangqi.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChessFrame extends JFrame implements MouseListener {

    private Location selectedPiece = null;
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
    //棋子坐标:可通过locatoin找到被点击棋子的位置和名称并储存棋子的完整信息
    private Location[][] location = new Location[10][9];
    //决定红黑
    private int count = 0;
    //显示框框
    private JLabel selectedChess;

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
        chessboard.addMouseListener(this);
        getContentPane().add(chessboard);//获取内容面板,获取其中的组件JLabel

        //初始化选中框
        selectedChess=new JLabel(new ImageIcon("image/redhint.png"));
        selectedChess.setBounds(0,0,51,47);
        selectedChess.setVisible(false);
        chessboard.add(selectedChess);

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
//    public static void main(String[] args) {
//        ChessFrame chessFrame=new ChessFrame();
//        chessFrame.setVisible(true);
//    }

    //移动棋子
    public void movePiece(Location formerLocation, int toRow, int toCol){
        int formerRow=formerLocation.getX();
        int formerCol=formerLocation.getY();

        if (chessPiece[toRow][toCol]!=null){
            //使用JLabel的移除方法
            remove(chessPiece[toRow][toCol]);
            chessPiece[toRow][toCol]=null;
        }
        JLabel selectedPiece = chessPiece[formerRow][formerCol];
        if (selectedPiece == null) {
            return;
        }
        //计算新位置坐标并更新位置
        int initialX = 20;
        int initialY = 20;
        int gridSize = 58;
        int chessSize = 55;
        int newX = initialX + toCol * gridSize + (gridSize - chessSize) / 2;
        int newY = initialY + toRow * gridSize + (gridSize - chessSize) / 2;
        selectedPiece.setBounds(newX,newY,chessSize,chessSize);

        //更新数组数据
        chessPiece[toRow][toCol]=selectedPiece;
        chessPiece[formerRow][formerCol]=null;
        location[toRow][toCol]=new Location(toRow,toCol,formerLocation.getChessName(),selectedPiece);
        location[formerRow][formerCol]=new Location(formerRow,formerCol,"",null);

        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel lblSource = (JLabel) e.getSource();
        //情况1:点击棋子
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 9; j++) {
                if (location[i][j] != null && lblSource == location[i][j].getLblChess()) {//防止在null的地方调用getLblChess会报错
                    // 情况1A：已经选中了棋子
                    if (selectedPiece != null) {
                        boolean isSelectedRed = selectedPiece.getChessName().contains("红");
                        boolean isTargetRed = location[i][j].getChessName().contains("红");
                        if (isSelectedRed!=isTargetRed) {
                            // 颜色不同就吃子
                            movePiece(selectedPiece, i, j);
                            selectedPiece = null;
                            selectedChess.setVisible(false);
                            count++;
                        } else {
                            // 颜色相同就切换选中
                            if ((count % 2 == 0 && location[i][j].getChessName().contains("红")) || (count % 2 == 1 && location[i][j].getChessName().contains("黑"))) {
                                selectedChess.setBounds(lblSource.getX(), lblSource.getY() + 2, 51, 47);
                                selectedChess.setVisible(true);
                                selectedPiece = location[i][j];
                            }
                        }
                    }
                    // 情况1B：没有选中的棋子
                    else {
                        if ((count % 2 == 0 && location[i][j].getChessName().contains("红"))||(count % 2 == 1 && location[i][j].getChessName().contains("黑"))) {
                            selectedChess.setBounds(lblSource.getX(), lblSource.getY() + 2, 51, 47);
                            selectedChess.setVisible(true);
                            selectedPiece = location[i][j];
                        }
                    }
                    return;
                }
            }
        }
        //情况2:点击到chessboard
        if (selectedPiece!=null&&lblSource==chessboard){
            //计算点击的棋盘坐标
            Point clickPoint = e.getPoint();//获取点击处的坐标
            int col = Math.round((float)(clickPoint.x - MARGIN) / CELL_SIZE);
            int row = Math.round((float)(clickPoint.y - MARGIN) / CELL_SIZE);
            //这个公式的意义:(clickPoint.x - MARGIN) :减去棋盘左边距,得到相对于棋盘网格左上角的X坐标
            //(float):除以格子宽度后得到小数形式的列数(e.g.99/58~1.706)
            //round:四舍五入到最接近的整数(1.706~2),不用round将会等于1,显然不能实现四舍五入

            if (row>=0&&row<10&&col>=0&&col<9){
                movePiece(selectedPiece,row,col);
                selectedPiece = null;
                selectedChess.setVisible(false);
                count++;
            }
            return;
        }
        // 点击空白处取消选中
        selectedPiece=null;
        selectedChess.setVisible(false);
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

