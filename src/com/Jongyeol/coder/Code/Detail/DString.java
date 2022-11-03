package com.Jongyeol.coder.Code.Detail;

import com.Jongyeol.coder.Screen;

import javax.swing.*;
import java.awt.*;

/**
 * 세부 문자열 입력창
 *
 * @author Jongyeol
 * @author smalljjack
 * @see Detail
 * @see DetailEvent
 */
public class DString implements Detail {
    public String Default = "";
    public JLabel label;
    public JTextField textField;
    public DetailEvent event;
    public String Name;

    private String string = "";

    /**
     * 설정된 문자열 받기
     *
     * @author Jongyeol
     * @return 설정된 문자열
     */
    public String getString() {
        return string;
    }

    /**
     * 데이터 생성
     *
     * @author Jongyeol
     * @param Name 변수 이름
     * @param event 저장 리스너
     * @see DetailEvent
     */
    public DString(String Name, DetailEvent event){
        this.Name = Name;
        this.event = event;
        setting();
    }

    /**
     * 데이터 생성
     *
     * @author Jongyeol
     * @param Name 변수 이름
     * @param Default 기본 값
     * @param event 저장 리스너
     * @see DetailEvent
     */
    public DString(String Name, String Default, DetailEvent event){
        this.Name = Name;
        this.Default = Default;
        this.event = event;
        setting();
    }

    /**
     * UI설정
     *
     * @author Jongyeol
     */
    private void setting(){
        string = Default;
        label = new JLabel(Name);
        textField = new JTextField(Default);
        label.setVisible(true);
        label.setFont(new Font("Korean", Font.PLAIN, 20));
    }

    /**
     * UI추가
     *
     * @author Jongyeol
     * @see Detail
     */
    @Override
    public void add(Screen screen, int x, int y) {
        label.setBounds(x, y, 270, 25);
        screen.add(label);
        textField.setBounds(x, y+25, 270, 25);
        screen.add(textField);
    }
    /**
     * UI제거
     *
     * @author Jongyeol
     * @see Detail
     */
    @Override
    public void remove(Screen screen) {
        screen.remove(label);
        screen.remove(textField);
    }
    /**
     * 저장
     *
     * @author Jongyeol
     * @see Detail
     */
    @Override
    public void Save(){
        string = textField.getText();
        event.Save();
    }
}
