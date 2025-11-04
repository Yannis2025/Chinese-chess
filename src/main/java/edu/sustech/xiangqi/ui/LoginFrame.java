/*
 * Created by JFormDesigner on Tue Nov 04 19:45:01 CST 2025
 */

package edu.sustech.xiangqi.ui;

import java.awt.*;
import javax.swing.*;

/**
 * @author yanni
 */
public class LoginFrame {
    public LoginFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - 苏云翼
        LoginFrame = new JFrame();
        UsernameLabel = new JLabel();
        PasswordLabel = new JLabel();
        TitleLabel = new JLabel();
        RegisterButton = new JButton();
        LoginButton = new JButton();
        PasswordField = new JPasswordField();
        UsernameField = new JTextField();

        //======== LoginFrame ========
        {
            Container LoginFrameContentPane = LoginFrame.getContentPane();
            LoginFrameContentPane.setLayout(null);

            //---- UsernameLabel ----
            UsernameLabel.setText("Username:");
            LoginFrameContentPane.add(UsernameLabel);
            UsernameLabel.setBounds(105, 90, UsernameLabel.getPreferredSize().width, 22);

            //---- PasswordLabel ----
            PasswordLabel.setText("Password:");
            LoginFrameContentPane.add(PasswordLabel);
            PasswordLabel.setBounds(new Rectangle(new Point(105, 140), PasswordLabel.getPreferredSize()));

            //---- TitleLabel ----
            TitleLabel.setText("The Chinese Chess Login System");
            TitleLabel.setFont(new Font("Segoe Print", Font.PLAIN, 18));
            LoginFrameContentPane.add(TitleLabel);
            TitleLabel.setBounds(new Rectangle(new Point(90, 25), TitleLabel.getPreferredSize()));

            //---- RegisterButton ----
            RegisterButton.setText("Register");
            LoginFrameContentPane.add(RegisterButton);
            RegisterButton.setBounds(new Rectangle(new Point(130, 185), RegisterButton.getPreferredSize()));

            //---- LoginButton ----
            LoginButton.setText("Login");
            LoginFrameContentPane.add(LoginButton);
            LoginButton.setBounds(new Rectangle(new Point(260, 185), LoginButton.getPreferredSize()));
            LoginFrameContentPane.add(PasswordField);
            PasswordField.setBounds(170, 130, 175, PasswordField.getPreferredSize().height);
            LoginFrameContentPane.add(UsernameField);
            UsernameField.setBounds(170, 85, 175, UsernameField.getPreferredSize().height);

            LoginFrameContentPane.setPreferredSize(new Dimension(475, 275));
            LoginFrame.pack();
            LoginFrame.setLocationRelativeTo(LoginFrame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - 苏云翼
    private JFrame LoginFrame;
    private JLabel UsernameLabel;
    private JLabel PasswordLabel;
    private JLabel TitleLabel;
    private JButton RegisterButton;
    private JButton LoginButton;
    private JPasswordField PasswordField;
    private JTextField UsernameField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
