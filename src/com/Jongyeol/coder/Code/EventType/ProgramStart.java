package com.Jongyeol.coder.Code.EventType;

import com.Jongyeol.coder.Code.Event;
import com.Jongyeol.coder.Screen;

import javax.swing.*;

public class ProgramStart extends Event {
    public ProgramStart(Screen screen){
        EventIcon = new ImageIcon("C://Jongyeol/ProgramStart.png");
        EventId = 0;
        this.screen = screen;
        prefix = "public static void main(String[] args){\n";
        suffix = "}\n";
    }
}
