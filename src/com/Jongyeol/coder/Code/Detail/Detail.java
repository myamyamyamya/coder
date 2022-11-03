package com.Jongyeol.coder.Code.Detail;

import com.Jongyeol.coder.Screen;

/**
 * 세부요소 창
 *
 * @author Jongyeol
 */
public interface Detail {

    /**
     * UI에 추가했을 떄
     *
     * @author Jongyeol
     */
    void add(Screen screen, int x, int y);

    /**
     * UI에 제거했을 때
     *
     * @author Jongyeol
     */
    void remove(Screen screen);

    /**
     * 데이터를 저장했을 때
     *
     * @author Jongyeol
     */
    void Save();
}
