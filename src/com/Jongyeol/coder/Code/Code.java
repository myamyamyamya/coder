package com.Jongyeol.coder.Code;

import com.Jongyeol.coder.Code.Detail.Detail;
import com.Jongyeol.coder.Code.EventType.ProgramStart;
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
    public boolean up;
    public boolean under;
    private int screenX, screenY;
    public Code upCode, underCode;
    public byte tab;

    public void setList(boolean list) {
        this.list = list;
    }

    public boolean list = false;
    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void ButtonCreate(){
        if(!list) CodeList.AllList.add(this);
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
                if(list){
                    CodeList.AddListButton(screen);
                    CodeList.ListList.remove(code);
                    list = false;
                    CodeList.AllList.add(code);
                } else if(upCode != null){
                    upCode.underCode = null;
                    underCode = null;
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                if(x <= 190 || x >= 1200 || y <= 40) {
                    screen.remove(button);
                    CodeList.AllList.remove(code);
                    if(code instanceof Event) {
                        CodeList.Eventlist.remove(code);
                        if(code instanceof ProgramStart) {
                            ProgramStart ps = new ProgramStart(screen);
                            ps.setLocation(320, 120);
                            ps.ButtonCreate();
                            CodeList.Eventlist.add(ps);
                        }
                    }
                    screen.setSelectCode(screen.noneCode);
                }
                if(up){
                    for(Code code1 :CodeList.AllList){
                        if(!code1.under || code1 == code || code1.underCode != null){
                            continue;
                        }
                        int calX = code1.x - x;
                        if(calX < 0) calX = calX * -1;
                        int calY = code1.y - y;
                        if(calX < 0) calY = calY * -1;
                        if(calX <= 100 && calY <= 100){
                            upCode = code1;
                            code1.underCode = code;
                            x = code1.x;
                            y = code1.y + 42;
                            button.setBounds(x, y, 190, 50);
                        }
                    }
                }
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
