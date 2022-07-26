package com.Jongyeol.coder.Code.Detail;

import com.Jongyeol.coder.Code.Detail.event.DStringEvent;
import com.Jongyeol.coder.Screen;

import javax.swing.*;
import java.awt.*;

public class DString implements Detail {
    public String Default = "";
    public JLabel label;
    public JTextField textField;
    public DStringEvent event;
    public String Name;
    public String getString() {
        return string;
    }

    private String string = "";
    public DString(String Name, DStringEvent event){
        this.Name = Name;
        this.event = event;
        setting();
    }
    public DString(String Name, String Default, DStringEvent event){
        this.Name = Name;
        this.Default = Default;
        this.event = event;
        setting();
    }
    private void setting(){
        string = Default;
        label = new JLabel(Name);
        textField = new JTextField(Default);
        label.setVisible(true);
        label.setFont(new Font("Korean", Font.PLAIN, 20));
    }
    @Override
    public void add(Screen screen, int x, int y) {
        label.setBounds(x, y, 270, 25);
        screen.add(label);
        textField.setBounds(x, y+25, 270, 25);
        screen.add(textField);
    }
    @Override
    public void remove(Screen screen) {
        screen.remove(label);
        screen.remove(textField);
    }
    @Override
    public void Save(){
        string = textField.getText();
        event.Save();
    }
}
