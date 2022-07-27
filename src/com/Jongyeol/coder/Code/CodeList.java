package com.Jongyeol.coder.Code;

import com.Jongyeol.coder.Code.EffectType.Print;
import com.Jongyeol.coder.Screen;

import java.util.ArrayList;

public class CodeList {
    public static ArrayList<Event> Eventlist = new ArrayList<Event>();
    public static ArrayList<Code> ListList = new ArrayList<Code>();
    public static ArrayList<Code> AllList = new ArrayList<Code>();
    public static void AddListButton(Screen screen) {
        Print pr = new Print(screen);
        pr.setLocation(50, 50);
        pr.setList(true);
        pr.ButtonCreate();
        ListList.add(pr);
    }
}
