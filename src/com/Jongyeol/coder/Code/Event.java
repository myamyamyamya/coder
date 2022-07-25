package com.Jongyeol.coder.Code;

import com.Jongyeol.coder.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Event {
    public Icon EventIcon;
    public byte EventId;
    public int x;
    public int y;
    public Screen screen;

    public String prefix;
    public String suffix;
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
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }
            });
            screen.add(button);
        }
    }
}
