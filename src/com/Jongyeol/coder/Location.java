package com.Jongyeol.coder;

import com.Jongyeol.coder.Code.Event;
import com.Jongyeol.coder.Code.EventList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Location {
    public static void Location(){
        for(int i = 0; i < EventList.Eventlist.size(); i++){
            JButton button = Screen.buttonlist.get(i);
            if(button.isVisible()){ continue; }
            Event event = EventList.Eventlist.get(i);
            button.setIcon(event.EventIcon);
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    button.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    button.setIcon(event.EventIcon);
                    button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }
            });
            button.setVisible(true);
        }
    }
}
