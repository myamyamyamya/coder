package com.Jongyeol.coder.Code.EventType;

import com.Jongyeol.coder.Code.Detail.DString;
import com.Jongyeol.coder.Code.Detail.DetailEvent;
import com.Jongyeol.coder.Code.Event;
import com.Jongyeol.coder.Code.Language.LanguageCode;
import com.Jongyeol.coder.Main;
import com.Jongyeol.coder.Screen;

import javax.swing.*;

/**
 * 프로그램이 시작했을때
 *
 * @author Jongyeol
 * @author smalljjack
 * @see DString
 * @see DetailEvent
 * @see Event
 */
public class ProgramStart extends Event implements DetailEvent {
    private DString args;

    /**
     * 데이터 생성
     *
     * @author Jongyeol
     * @param screen 표시할 스크린
     * @see Event
     */
    public ProgramStart(Screen screen){
        icon = new ImageIcon(Main.class.getResource("../../../resource/ProgramStart.png"));
        args = new DString("String[]", "args", this);
        detailList.add(args);
        under = true;
        up = false;
        java = new LanguageCode("public static void main(String[] " + args.getString() + "){\n", "}\n", 1);
        name = "프로그램이 시작되었을때";
        this.screen = screen;
    }

    /**
     * 데이터 저장시
     *
     * @author Jongyeol
     * @see DString
     * @see DetailEvent
     */
    @Override
    public void Save() {
        java.setPrefix("public static void main(String[] " + args.getString() + "){\n");
    }
}
