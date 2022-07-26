package com.Jongyeol.coder.Code.EventType;

import com.Jongyeol.coder.Code.Detail.DString;
import com.Jongyeol.coder.Code.Detail.DetailEvent;
import com.Jongyeol.coder.Code.Event;
import com.Jongyeol.coder.Screen;

import javax.swing.*;

public class ProgramStart extends Event implements DetailEvent {
    private DString args;
    public ProgramStart(Screen screen){
        EventIcon = new ImageIcon("C://Jongyeol/ProgramStart.png");
        args = new DString("String[]", "args", this);
        detailList.add(args);
        under = true;
        up = false;
        this.screen = screen;
        prefix = "public static void main(String[] " + args.getString() + "){\n";
        suffix = "}\n";
    }

    @Override
    public void Save() {
        prefix = "public static void main(String[] " + args.getString() + "){\n";
    }
}
