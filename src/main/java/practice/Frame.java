package practice;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    public Frame(String name, int width, int height) throws HeadlessException {
        super(name);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width,height);
        setLocationRelativeTo(null);
        setResizable(false);
    }
}
