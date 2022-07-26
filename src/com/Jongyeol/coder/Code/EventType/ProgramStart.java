package com.Jongyeol.coder.Code.EventType;

import com.Jongyeol.coder.Code.Detail.DString;
import com.Jongyeol.coder.Code.Detail.DrawDetail;
import com.Jongyeol.coder.Code.Detail.event.DStringEvent;
import com.Jongyeol.coder.Code.Event;
import com.Jongyeol.coder.Screen;

import javax.swing.*;

public class ProgramStart extends Event implements DStringEvent {
    private DString args;
    public ProgramStart(Screen screen){
        EventIcon = new ImageIcon("C://Jongyeol/ProgramStart.png");
        args = new DString("String[]", "args", this);
        detailList.add(args);
        this.screen = screen;
        prefix = "public static void main(String[] " + args.getString() + "){\n";
        suffix = "}\n";
    }

    @Override
    public void Save() {
        prefix = "public static void main(String[] " + args.getString() + "){\n";
    }
}
