package com.Jongyeol.coder.Code.EffectType;

import com.Jongyeol.coder.Code.Detail.DString;
import com.Jongyeol.coder.Code.Detail.DetailEvent;
import com.Jongyeol.coder.Code.Effect;
import com.Jongyeol.coder.Code.Language.LanguageCode;
import com.Jongyeol.coder.Main;
import com.Jongyeol.coder.Screen;

import javax.swing.*;

public class Print extends Effect implements DetailEvent {
    private DString string;
    public Print(Screen screen){
        icon = new ImageIcon(Main.class.getResource("../../../resource/Print.png"));
        string = new DString("String", this);
        detailList.add(string);
        under = true;
        up = true;
        java = new LanguageCode("System.out.println(\"" + string.getString() + "\");\n" + "){\n", 0);
        name = "메시지 띄우기";
        this.screen = screen;
    }

    @Override
    public void Save() {
        java.setPrefix("System.out.println(\"" + string.getString() + "\");\n");
    }
}
