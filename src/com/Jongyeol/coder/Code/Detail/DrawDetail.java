package com.Jongyeol.coder.Code.Detail;

import com.Jongyeol.coder.Code.Code;
import com.Jongyeol.coder.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawDetail {
    private static Code lastCode = null;
    public static void Reload(Screen screen) {
        int x = 1305;
        int y = 61;
        if(lastCode != null) for(Detail detail : lastCode.detailList) detail.remove(screen);
        Code code = screen.getSelectCode();
        lastCode = code;
        for(Detail detail : code.detailList) detail.add(screen, x, y);
    }
    public static void Save() {
        if(lastCode != null) for(Detail detail : lastCode.detailList) detail.Save();
    }
}
