/*
 * Created by JFormDesigner on Tue Nov 04 19:45:01 CST 2025
 */

package edu.sustech.xiangqi.ui;

import java.awt.*;
import javax.swing.*;

import edu.sustech.xiangqi.register.RegisterFrame;
import edu.sustech.xiangqi.validator.validator;
import edu.sustech.xiangqi.model.ChessBoardModel;
import edu.sustech.xiangqi.ui.ChessBoardPanel;
/**
 * @author yanni
 */
public class LoginFrame  {
    public LoginFrame() {
        initComponents();
        clickButton();
        //testClickButton();
    }
    public void show(){
        loginFrame.setVisible(true);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void openChessBoard(){
        loginFrame.dispose();//关闭当前登录界面
        SwingUtilities.invokeLater(() -> {
            // 创建象棋界面
            JFrame chessFrame = new JFrame("中国象棋");
            chessFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ChessBoardModel model = new ChessBoardModel();
            ChessBoardPanel boardPanel = new ChessBoardPanel(model);

            chessFrame.add(boardPanel);
            chessFrame.pack();
            chessFrame.setLocationRelativeTo(null);
            chessFrame.setVisible(true);
        });

    }
    private void openRegisterFrame(){
        loginFrame.dispose();
        SwingUtilities.invokeLater(()->{
            RegisterFrame registerFrame=new RegisterFrame();
            registerFrame.setVisible(true);
            registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
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
