package com.Jongyeol.coder.Code.Detail;

import com.Jongyeol.coder.Code.Code;
import com.Jongyeol.coder.Screen;

/**
 * 세부요소 표시
 *
 * @author Jongyeol
 */
public class DrawDetail {
    private static Code lastCode = null;

    /**
     * 세부요소 로딩
     *
     * @author Jongyeol
     */
    public static void Reload(Screen screen) {
        int x = 1305;
        int y = 61;
        if(lastCode != null) for(Detail detail : lastCode.detailList) detail.remove(screen);
        Code code = screen.getSelectCode();
        lastCode = code;
        for(Detail detail : code.detailList) detail.add(screen, x, y);
    }

    /**
     * 세부요소 저장
     *
     * @author Jongyeol
     */
    public static void Save() {
        if(lastCode != null) for(Detail detail : lastCode.detailList) detail.Save();
    }
}
