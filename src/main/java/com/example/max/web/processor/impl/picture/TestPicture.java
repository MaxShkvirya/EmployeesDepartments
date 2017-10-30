package com.example.max.web.processor.impl.picture;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
public class TestPicture {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("My Panel");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImagePanel pp = new ImagePanel();
        pp.setLayout(new BorderLayout());
        try {
            pp.setImage(ImageIO.read(new File("D:\\EmployeesDepartments\\src\\main\\java\\com\\example\\max\\web\\processor\\impl\\picture\\123.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        JPanel panel = new JPanel();
//        panel.setLayout(new java.awt.GridLayout());
//        panel.setOpaque(false);
//        JLabel label = new JLabel();
//        label.setFont(new java.awt.Font("Tahoma", 0, 54));
//        label.setForeground(new java.awt.Color(255, 0, 0));
//        label.setText("\u042d\u0442\u043e ");
//        panel.add(label);
//        JButton button = new JButton();
//        button.setText("\u0410 \u044d\u0442\u043e \u043a\u043d\u043e\u043f\u043a\u0430!");
//        panel.add(button);
//        pp.add(panel, java.awt.BorderLayout.NORTH);
//        pp.setPreferredSize(new Dimension(100, 100));

        f.add(new JScrollPane(pp));
     //   f.pack();
        f.setSize(600, 500);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}