package com.Jongyeol.coder.Variables;

import com.Jongyeol.coder.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * 변수 설정 화면
 *
 * @author Jongyeol
 * @author smalljjack
 * @see Variable
 */
public class VariableSetting extends JFrame {
    private ImageIcon add1 = new ImageIcon(Main.class.getResource("../../../resource/Variables add1.jpg"));
    private ImageIcon add2 = new ImageIcon(Main.class.getResource("../../../resource/Variables add2.jpg"));
    private ImageIcon line = new ImageIcon(Main.class.getResource("../../../resource/Line.png"));
    ImageIcon line2 = new ImageIcon(Main.class.getResource("../../../resource/Line2.png"));
    public ArrayList<Variable> variableList = new ArrayList<>();

    /**
     * 화면 설정 & 표시
     *
     * @author Jongyeol
     * @author smalljjack
     * @see Variable
     */
    public VariableSetting() {
        setTitle("Coder Variables");
        setSize(500, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        JButton addVariables = new JButton(add1);
        addVariables.setVisible(true);
        addVariables.setBounds(160, 0, 170, 50);
        addVariables.setBorderPainted(false);
        addVariables.setContentAreaFilled(false);
        addVariables.setFocusPainted(false);
        JLabel floor0 = new JLabel(line2);
        floor0.setBounds(0,50,500,3);
        floor0.setVisible(true);
        add(floor0);

        JLabel wall1 = new JLabel(line);
        wall1.setBounds(100,50,3,650);
        wall1.setVisible(true);
        add(wall1);

        JLabel wall2 = new JLabel(line);
        wall2.setBounds(200,50,3,650);
        wall2.setVisible(true);
        add(wall2);

        JLabel wall3 = new JLabel(line);
        wall3.setBounds(450,50,3,650);
        wall3.setVisible(true);
        add(wall3);

        addVariables.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                variableList.add(new Variable(VariableSetting.this, variableList.size() + 1));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                addVariables.setIcon(add2);
            }

            @Override
            public void mouseExited(MouseEvent e){
                addVariables.setIcon(add1);
            }
        });
        //add(background);
        add(addVariables);
    }

    /**
     * 변수 창 켜기
     *
     * @author Jongyeol
     */
    public void variablesShow(){
        setVisible(true);
    }

    /**
     * 표시 그래픽
     *
     * @param g 그래픽
     * @author Jongyeol
     */
    public void paint(Graphics g) {
        repaint((Graphics2D) g);
    }

    /**
     * 그래픽 그리기
     *
     * @author Jongyeol
     * @param g 그래픽 2D
     */
    public void repaint(Graphics2D g) {
        paintComponents(g);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        repaint();
    }
}
