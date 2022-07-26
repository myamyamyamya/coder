package com.Jongyeol.coder.Code.Detail;

import com.Jongyeol.coder.Code.Code;
import com.Jongyeol.coder.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawDetail {
    private static Code lastCode = null;
    private static JButton saveButton = new JButton("데이터 저장하기");
    public static void Reload(Screen screen) {
        int x = 1305;
        int y = 61;
        if(lastCode != null){
            for(Detail detail : lastCode.detailList){
                if(detail.DetailID == 0){
                    DString dString = (DString) detail;
                    dString.remove(screen);
                }
            }
        }
        Code code = screen.getSelectCode();
        lastCode = code;
        for(Detail detail : code.detailList){
            if(detail.DetailID == 0){
                DString dString = (DString) detail;
                dString.add(screen, x, y);
            }
        }
    }
    public static void CodeSetting(Screen screen) {
        saveButton.setVisible(true);
        saveButton.setBounds(1355, 800, 180, 30);
        saveButton.setFont(new Font("Korean", Font.PLAIN, 20));
        saveButton.setBorderPainted(false);
        saveButton.setContentAreaFilled(true);
        saveButton.setFocusPainted(false);
        saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                saveButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Save();
            }
        });
        screen.add(saveButton);
    }
    private static void Save() {
        if(lastCode != null){
            for(Detail detail : lastCode.detailList){
                if(detail.DetailID == 0){
                    DString dString = (DString) detail;
                    dString.Save();
                }
            }
        }
    }
}
