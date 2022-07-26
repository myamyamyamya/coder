package com.Jongyeol.coder.Code;

import com.Jongyeol.coder.Code.Detail.Detail;
import com.Jongyeol.coder.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class Code {
    public ArrayList<Detail> detailList = new ArrayList<Detail>();
    private Code code;
    public String prefix, suffix;
    public Code(){
        code = this;
    }
    public int x, y;
    public Icon icon;
    public Screen screen;
    public boolean up, under;
    private int screenX, screenY;
    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void ButtonCreate(){
        JButton button = new JButton(icon);
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
                screen.setSelectCode(code);
                screenX = e.getXOnScreen();
                screenY = e.getYOnScreen();
            }
        });
        button.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                x += e.getXOnScreen() - screenX;
                y += e.getYOnScreen() - screenY;
                screenX = e.getXOnScreen();
                screenY = e.getYOnScreen();
                button.setBounds(x, y, 190, 50);
            }
        });
        screen.add(button);
    }
}
