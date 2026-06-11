package com.mycompany.jframe_syntaxmasters;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.net.URISyntaxException;

public class JFrame_SyntaxMasters {
    public static void main(String[] args) throws URISyntaxException {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        JFrame_HomeMenu home_Menu = new JFrame_HomeMenu(gc);
        home_Menu.setVisible(true);
    }
}