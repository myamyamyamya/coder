package com.Jongyeol.coder.Code;

import com.Jongyeol.coder.Screen;

import javax.swing.*;

public class Event {
    public Icon EventIcon;
    public byte EventId;
    public int x;
    public int y;
    public Screen screen;
    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void ButtonCreate(){
        for(int i = 0; i<10; i++){
            JButton button = new JButton(EventIcon);
            button.setVisible(true);
            button.setBounds(x, y, 190, 50);
            button.setBorderPainted(false);
            button.setContentAreaFilled(false);
            button.setFocusPainted(false);
            screen.add(button);
        }
    }
}
