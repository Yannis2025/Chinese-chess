package edu.sustech.xiangqi;
import edu.sustech.xiangqi.ui.LoginFrame;

import javax.swing.*;

public class XiangqiApplication {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            LoginFrame loginFrame=new LoginFrame();
            loginFrame.show();
        });

    }
}
