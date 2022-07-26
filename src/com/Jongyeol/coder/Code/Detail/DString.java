package com.Jongyeol.coder.Code.Detail;

import com.Jongyeol.coder.Screen;

import javax.swing.*;
import java.awt.*;

public class DString extends Detail {
    public String Default = "";
    public JLabel label;
    public JTextField textField;
    public String getString() {
        return string;
    }

    private String string = "";
    public DString(String Name){
        this.Name = Name;
        setting();
    }
    public DString(String Name, String Default){
        this.Name = Name;
        this.Default = Default;
        setting();
    }
    private void setting(){
        string = Default;
        label = new JLabel(Name);
        textField = new JTextField(Default);
        DetailID = 0;
        label.setVisible(true);
        label.setFont(new Font("Korean", Font.PLAIN, 20));
    }
    public void add(Screen screen, int x, int y) {
        label.setBounds(x, y, 270, 25);
        screen.add(label);
        textField.setBounds(x, y+25, 270, 25);
        screen.add(textField);
    }
    public void remove(Screen screen) {
        screen.remove(label);
        screen.remove(textField);
    }
    public void Save(){
        string = textField.getText();
        System.out.println(string);
    }
}
