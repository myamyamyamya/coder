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
    public Code(){
        code = this;
    }
    public int x;
    public int y;
    public Icon EventIcon;
    public Screen screen;
    public boolean under;
    public boolean up;
    private int mouseX, mouseY;
    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void ButtonCreate(){
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
                screen.setSelectCode(code);
                mouseX = e.getX();
                mouseY = e.getY();
                System.out.println(mouseX);
                System.out.println(mouseY);
            }
        });
        button.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                button.setBounds(x - mouseX, y - mouseY, 190, 50);
                System.out.println(x);
                System.out.println(y);
            }
        });
        screen.add(button);
    }
}
