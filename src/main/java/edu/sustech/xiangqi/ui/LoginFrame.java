/*
 * Created by JFormDesigner on Tue Nov 04 19:45:01 CST 2025
 */

package edu.sustech.xiangqi.ui;

import java.awt.*;
import javax.swing.*;

import edu.sustech.xiangqi.model.ChessFrame;
import edu.sustech.xiangqi.register.RegisterFrame;
import edu.sustech.xiangqi.validator.validator;
import edu.sustech.xiangqi.model.ChessBoardModel;
import edu.sustech.xiangqi.ui.ChessBoardPanel;
/**
 * @author yanni
 */
public class LoginFrame  {
    //主方法,放置组件+按钮响应
    public LoginFrame() {
        initComponents();
        clickButton();
        //testClickButton();
    }
    //显示可见+exitOnClose
    public void show(){
        loginFrame.setVisible(true);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //打开象棋界面
    private void openChessBoard(){
        loginFrame.dispose();//关闭当前登录界面
        SwingUtilities.invokeLater(() -> {
            //这些是老师给出的实例代码部分,需要改成我的
//            JFrame chessFrame = new JFrame("中国象棋");
//            chessFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//            ChessBoardModel model = new ChessBoardModel();
//            ChessBoardPanel boardPanel = new ChessBoardPanel(model);
//            chessFrame.add(boardPanel);
//            chessFrame.pack();//窗口大小自动适应内容
//            chessFrame.setLocationRelativeTo(null);
//            chessFrame.setVisible(true);
            ChessFrame chessFrame=new ChessFrame();
            chessFrame.setVisible(true);
        });

    }
    //打开注册界面
    private void openRegisterFrame(){
        loginFrame.dispose();
        SwingUtilities.invokeLater(()->{
            RegisterFrame registerFrame=new RegisterFrame();
            registerFrame.setVisible(true);
            registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
    //注册与登录两个按钮功能
    private void clickButton(){
        LoginButton.addActionListener(e -> {
            String username=UsernameField.getText();
            String password=new String(PasswordField.getPassword());
            if (validator.validate(username,password)){
                openChessBoard();
            }else {
                //使用JOptionPane类创建弹出对话框,用showMessageDialog方法显示错误信息
                JOptionPane.showMessageDialog(loginFrame,"Invalid username or password!");
                //this指窗体本身
            }
        });
        RegisterButton.addActionListener(e -> {
            openRegisterFrame();
        });
    }
    /*private void testClickButton(){
        LoginButton.addActionListener(e -> {
            String username=UsernameField.getText();
            String password=new String(PasswordField.getPassword());
            if (validator.testValidate(username,password)){
                openChessBoard();
            }else {
                //使用JOptionPane类创建弹出对话框,用showMessageDialog方法显示错误信息
                JOptionPane.showMessageDialog(loginFrame,"Invalid username or password!");
                //this指窗体本身
            }
        });
    }*/
    //JFormDesigner自带的,写入组件
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - 苏云翼
        loginFrame = new JFrame();
        UsernameLabel = new JLabel();
        PasswordLabel = new JLabel();
        TitleLabel = new JLabel();
        RegisterButton = new JButton();
        LoginButton = new JButton();
        PasswordField = new JPasswordField();
        UsernameField = new JTextField();

        //======== loginFrame ========
        {
            Container loginFrameContentPane = loginFrame.getContentPane();
            loginFrameContentPane.setLayout(null);

            //---- UsernameLabel ----
            UsernameLabel.setText("Username:");
            UsernameLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            loginFrameContentPane.add(UsernameLabel);
            UsernameLabel.setBounds(95, 90, UsernameLabel.getPreferredSize().width, 22);

            //---- PasswordLabel ----
            PasswordLabel.setText("Password:");
            PasswordLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
            loginFrameContentPane.add(PasswordLabel);
            PasswordLabel.setBounds(new Rectangle(new Point(100, 135), PasswordLabel.getPreferredSize()));

            //---- TitleLabel ----
            TitleLabel.setText("The Chinese Chess Login System");
            TitleLabel.setFont(new Font("Segoe Print", Font.PLAIN, 18));
            loginFrameContentPane.add(TitleLabel);
            TitleLabel.setBounds(new Rectangle(new Point(90, 25), TitleLabel.getPreferredSize()));

            //---- RegisterButton ----
            RegisterButton.setText("Register");
            loginFrameContentPane.add(RegisterButton);
            RegisterButton.setBounds(new Rectangle(new Point(130, 185), RegisterButton.getPreferredSize()));

            //---- LoginButton ----
            LoginButton.setText("Login");
            loginFrameContentPane.add(LoginButton);
            LoginButton.setBounds(new Rectangle(new Point(260, 185), LoginButton.getPreferredSize()));
            loginFrameContentPane.add(PasswordField);
            PasswordField.setBounds(190, 140, 175, PasswordField.getPreferredSize().height);
            loginFrameContentPane.add(UsernameField);
            UsernameField.setBounds(190, 95, 175, UsernameField.getPreferredSize().height);

            loginFrameContentPane.setPreferredSize(new Dimension(475, 275));
            loginFrame.pack();
            loginFrame.setLocationRelativeTo(loginFrame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - 苏云翼
    private JFrame loginFrame;
    private JLabel UsernameLabel;
    private JLabel PasswordLabel;
    private JLabel TitleLabel;
    private JButton RegisterButton;
    private JButton LoginButton;
    private JPasswordField PasswordField;
    private JTextField UsernameField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
