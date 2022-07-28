package com.Jongyeol.coder.Variables;

import javax.swing.*;
import java.util.ArrayList;

public class VariableSetting extends JFrame {
    public ArrayList<Variable> variablelist = new ArrayList<Variable>();
    public VariableSetting(){
        setTitle("Coder Variables");
        setSize(500, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
    }
    public void variablesShow(){
        setVisible(true);
    }
}
