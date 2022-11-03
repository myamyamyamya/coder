package com.Jongyeol.coder.Code.EffectType;

import com.Jongyeol.coder.Code.Detail.DString;
import com.Jongyeol.coder.Code.Detail.DetailEvent;
import com.Jongyeol.coder.Code.Effect;
import com.Jongyeol.coder.Code.Event;
import com.Jongyeol.coder.Code.Language.LanguageCode;
import com.Jongyeol.coder.Main;
import com.Jongyeol.coder.Screen;

import javax.swing.*;

/**
 * 출력
 *
 * @author Jongyeol
 * @author smalljjack
 * @see DString
 * @see DetailEvent
 * @see Effect
 */
public class Print extends Effect implements DetailEvent {
    private DString string;

    /**
     * 데이터 생성
     *
     * @author Jongyeol
     * @param screen 표시할 스크린
     * @see Effect
     */
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

    /**
     * 데이터 저장시
     *
     * @author Jongyeol
     * @see DString
     * @see DetailEvent
     */
    @Override
    public void Save() {
        java.setPrefix("System.out.println(\"" + string.getString() + "\");\n");
    }
}
