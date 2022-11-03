package com.Jongyeol.coder.Code;

import com.Jongyeol.coder.Code.Detail.Detail;
import com.Jongyeol.coder.Code.EventType.ProgramStart;
import com.Jongyeol.coder.Code.Language.LanguageCode;
import com.Jongyeol.coder.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

/**
 * 코드 데이터
 *
 * @author Jongyeol
 * @author smalljjack
 */
public class Code {
    public ArrayList<Detail> detailList = new ArrayList<>();
    public String name;
    public int x, y;
    public Icon icon;
    public Screen screen;
    public boolean up;
    public boolean under;
    private int screenX, screenY;
    public Code upCode, underCode;
    private JButton button;
    public LanguageCode java;
    public LanguageCode c;
    public boolean list = false;

    /**
     * 코드 목록에 있는 블록인지 설정
     *
     * @author Jongyeol
     * @param list 코드 목록에 있는 블록인가
     */
    public void setList(boolean list) {
        this.list = list;
    }

    /**
     * 블록 위치 설정
     *
     * @author Jongyeol
     * @param x x좌표
     * @param y y좌표
     */
    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
        if(button != null) loadLocation();
    }

    /**
     * 위치 로딩
     *
     * @author Jongyeol
     */
    public void loadLocation() {
        button.setBounds(x, y, 190, 50);
        if(underCode != null) underCode.setLocation(x, y + 42);
    }

    /**
     * 해당 코드 제거
     *
     * @author Jongyeol
     */
    public void removeCode() {
        screen.remove(button);
        CodeList.AllList.remove(this);
        if(this instanceof Event) {
            CodeList.Eventlist.remove(this);
            if(this instanceof ProgramStart) {
                ProgramStart ps = new ProgramStart(screen);
                ps.setLocation(320, 120);
                ps.ButtonCreate();
                CodeList.Eventlist.add(ps);
            }
        }
        if(underCode != null){
            underCode.removeCode();
        }
        screen.setSelectCode(screen.noneCode);
    }

    /**
     * 해당 코드 버튼화로 추가
     *
     * @author Jongyeol
     */
    public void ButtonCreate(){
        if(!list) CodeList.AllList.add(this);
        button = new JButton(icon);
        button.setVisible(true);
        loadLocation();
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
                screen.setSelectCode(Code.this);
                screenX = e.getXOnScreen();
                screenY = e.getYOnScreen();
                if(list){
                    CodeList.AddListButton(screen);
                    CodeList.ListList.remove(Code.this);
                    list = false;
                    CodeList.AllList.add(Code.this);
                } else if(upCode != null){
                    upCode.underCode = null;
                    upCode = null;
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                if(x <= 190 || x >= 1200 || y <= 40) removeCode();
                if(up){
                    for(Code code1 :CodeList.AllList){
                        if(!code1.under || code1 == Code.this || code1.underCode != null || code1 == underCode) continue;
                        int calX = code1.x - x;
                        if(calX < 0) calX = calX * -1;
                        int calY = code1.y - y;
                        if(calY < 0) calY = calY * -1;
                        if(calX <= 80 && calY <= 80){
                            upCode = code1;
                            code1.underCode = Code.this;
                            x = code1.x;
                            y = code1.y + 42;
                            loadLocation();
                            return;
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
                loadLocation();
            }
        });
        screen.add(button);
    }
}
