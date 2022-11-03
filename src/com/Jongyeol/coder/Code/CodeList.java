package com.Jongyeol.coder.Code;

import com.Jongyeol.coder.Code.EffectType.Print;
import com.Jongyeol.coder.Screen;

import java.util.ArrayList;

/**
 * 코드 목록에 있는 블록
 *
 * @author Jongyeol
 * @author smalljjack
 */
public class CodeList {
    public static ArrayList<Event> Eventlist = new ArrayList<>();
    public static ArrayList<Code> ListList = new ArrayList<>();
    public static ArrayList<Code> AllList = new ArrayList<>();
    /**
     * 코드 목록에 블록 추가
     *
     * @author Jongyeol
     */
    public static void AddListButton(Screen screen) {
        Print pr = new Print(screen);
        pr.setLocation(50, 50);
        pr.setList(true);
        pr.ButtonCreate();
        ListList.add(pr);
    }
}
