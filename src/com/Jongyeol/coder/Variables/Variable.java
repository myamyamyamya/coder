package com.Jongyeol.coder.Variables;

import javax.swing.*;
import java.awt.*;

/**
 * 변수
 *
 * @author Jongyeol
 * @author smalljjack
 * @see VariableSetting
 * @see Class
 */
public class Variable {
    Class clazz;
    Object value;
    private JLabel floor;
    private JTextField name_field;
    private JComboBox<Class> variableList_box;
    private Component variable_value = null;
    private JTextField variable_value_num, variable_value_String;
    private JComboBox<Boolean> variable_value_boolean;
    private VariableSetting setting;
    private String otherNum;

    /**
     * 새로운 변수 생성
     *
     * @param setting 변수설정 및 변수 추가 클래스
     * @param i 변수 번호
     * @author Jongyeol
     */
    public Variable(VariableSetting setting, int i) {
        this.setting = setting;
        floor = new JLabel(setting.line2);
        floor.setBounds(0,50 + 40 * i,500,3);
        floor.setVisible(true);
        setting.add(floor);
        name_field = new JTextField("variable" + i);
        name_field.setBounds(5, 14 + 40 * i, 90, 36);
        name_field.setVisible(true);
        setting.add(name_field);
        variableList_box = new JComboBox<>(Class.values());
        variableList_box.setBounds(107, 14 + 40 * i, 90, 36);
        variableList_box.setVisible(true);
        setting.add(variableList_box);
        clazz = Class.Null;
        variableList_box.addActionListener(e -> {
            clazz = (Class) variableList_box.getSelectedItem();
            loadVariable();
        });
        variable_value_num = new JTextField(15);
        variable_value_num.setBounds(207, 14 + 40 * i, 240, 36);
        variable_value_num.setVisible(true);
        variable_value_num.setText("0");
        otherNum = "0";
        variable_value_String = new JTextField();
        variable_value_String.setBounds(207, 14 + 40 * i, 240, 36);
        variable_value_String.setVisible(true);
        variable_value_boolean = new JComboBox<>(new Boolean[]{true, false});
        variable_value_boolean.setBounds(207, 14 + 40 * i, 240, 36);
        variable_value_boolean.setVisible(true);
        loadVariable();
        new NumberListener(i);
    }

    /**
     * 변수 UI 로딩
     *
     * @author Jongyeol
     * @see Class
     */
    public void loadVariable() {
        if(variable_value != null) setting.remove(variable_value);
        switch (clazz) {
            case Null -> variable_value = null;
            case Integer, Float, Long, Double -> variable_value = variable_value_num;
            case String -> variable_value = variable_value_String;
            case Boolean -> variable_value = variable_value_boolean;
        }
        if(variable_value != null) setting.add(variable_value);
    }

    /**
     * 클래스 이름 불러오기
     *
     * @author Jongyeol
     * @see Class
     */
    public String getClassName() {
        return clazz.name();
    }

    /**
     * 변수 설정 값 불러오기
     *
     * @author Jongyeol
     */
    public Object getValue() {
        return value;
    }

    /**
     * 숫자 변경 리스너
     *
     * @author Jongyeol
     */
    private class NumberListener extends Thread {

        /**
         * 쓰레드 이름 설정
         *
         * @author Jongyeol
         * @param i 번호
         */
        public NumberListener(int i) {
            super("NumberListener-" + i);
        }

        /**
         * 숫자 변경 듣기
         *
         * @author Jongyeol
         */
        public void run() {
            try {
                if(variable_value_num.getText().equals(otherNum)) {
                    String st = variable_value_num.getText();
                    value = null;
                    try {
                        switch (clazz) {
                            case Integer -> value = Integer.valueOf(st);
                            case Long -> value = Long.valueOf(st);
                            case Float -> value = Float.valueOf(st);
                            case Double -> value = Double.valueOf(st);
                        }
                    } catch (NumberFormatException ignored) {}
                    if(value == null) {
                        switch (clazz) {
                            case Integer, Long -> value = 0;
                            case Float, Double -> value = 0.0;
                        }
                    }
                    variable_value_num.setText(value.toString());
                    otherNum = value.toString();
                }
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
