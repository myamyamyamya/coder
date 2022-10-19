package com.Jongyeol.coder.Variables;

import com.Jongyeol.coder.Main;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class VariableSetting extends JFrame {
    private ImageIcon add1 = new ImageIcon(Main.class.getResource("../../../resource/Variables add1.jpg"));
    private ImageIcon add2 = new ImageIcon(Main.class.getResource("../../../resource/Variables add2.jpg"));
    public ArrayList<Variable> variablelist = new ArrayList<Variable>();
    public VariableSetting() {
        setTitle("Coder Variables");
        setSize(500, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        JButton addVariables = new JButton(add1);
        addVariables.setVisible(true);
        addVariables.setBounds(160, 0, 170, 50);
        addVariables.setBorderPainted(false);
        addVariables.setContentAreaFilled(false);
        addVariables.setFocusPainted(false);
        addVariables.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("test");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                addVariables.setIcon(add2);
            }

            @Override
            public void mouseExited(MouseEvent e){
                addVariables.setIcon(add1);
            }
        });
        //add(background);
        add(addVariables);
    }
    public void variablesShow(){
        setVisible(true);
    }
}
