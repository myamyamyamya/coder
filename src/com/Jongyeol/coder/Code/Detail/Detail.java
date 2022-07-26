package com.Jongyeol.coder.Code.Detail;

import com.Jongyeol.coder.Screen;

public interface Detail {
    String Name = null;

    void add(Screen screen, int x, int y);

    void remove(Screen screen);

    void Save();
}
