package com.Jongyeol.coder.Code.EventType;

import com.Jongyeol.coder.Code.Detail.DString;
import com.Jongyeol.coder.Code.Event;
import com.Jongyeol.coder.Screen;

import javax.swing.*;

public class ProgramStart extends Event {
    private DString args;
    public ProgramStart(Screen screen){
        EventIcon = new ImageIcon("C://Jongyeol/ProgramStart.png");
        EventId = 0;
        args = new DString("String[]", "args");
        detailList.add(args);
        this.screen = screen;
        prefix = "public static void main(String[] " + args.getString() + "){\n";
        suffix = "}\n";
    }
}
