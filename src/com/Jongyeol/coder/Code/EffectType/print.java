package com.Jongyeol.coder.Code.EffectType;

import com.Jongyeol.coder.Code.Detail.DString;
import com.Jongyeol.coder.Code.Detail.DetailEvent;
import com.Jongyeol.coder.Code.Effect;
import com.Jongyeol.coder.Screen;

import javax.swing.*;

public class print extends Effect implements DetailEvent {
    private DString string;
    public print(Screen screen){
        EffectIcon = new ImageIcon("C://Jongyeol/ProgramStart.png");
        string = new DString("String", this);
        detailList.add(string);
        this.screen = screen;
        prefix = "System.out.println(\"" + string.getString() + "\")";
    }

    @Override
    public void Save() {
        prefix = "System.out.println(\"" + string.getString() + "\")";
    }
}
