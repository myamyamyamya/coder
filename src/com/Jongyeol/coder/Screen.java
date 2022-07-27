package com.Jongyeol.coder;

import com.Jongyeol.coder.Code.Code;
import com.Jongyeol.coder.Code.Detail.DrawDetail;
import com.Jongyeol.coder.Code.CodeList;
import com.Jongyeol.coder.Code.EventType.ProgramStart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Screen extends JFrame {
    private Image ScreenImage;
    private Image background = new ImageIcon(Main.class.getResource("../../../resource/BackScreen.png")).getImage();
    private Image Line = new ImageIcon(Main.class.getResource("../../../resource/Line.png")).getImage();
    private Image Line2 = new ImageIcon(Main.class.getResource("../../../resource/Line2.png")).getImage();
    private ImageIcon None = new ImageIcon(Main.class.getResource("../../../resource/None.png"));
    private Graphics screenGraphics;
    private ImageIcon save1 = new ImageIcon(Main.class.getResource("../../../resource/save1.png"));
    private ImageIcon save2 = new ImageIcon(Main.class.getResource("../../../resource/save2.png"));
    private JButton save = new JButton(save1);
    public Code noneCode = new Code();

    public void setSelectCode(Code selectCode) {
        DrawDetail.Save();
        this.selectCode = selectCode;
        DrawDetail.Reload(this);
    }

    public Code getSelectCode() {
        return selectCode;
    }

    private Code selectCode;
    public Screen() {
        setTitle("Coder");
        setSize(1600, 900);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        ProgramStart ps = new ProgramStart(this);
        ps.setLocation(320, 120);
        ps.ButtonCreate();
        CodeList.Eventlist.add(ps);
        CreateSave();
        setSelectCode(noneCode);
        CodeList.AddListButton(this);
    }
    public void paint(Graphics g) {
        ScreenImage = createImage(1600, 900);
        screenGraphics = ScreenImage.getGraphics();
        screenDraw((Graphics2D) screenGraphics);
        g.drawImage(ScreenImage, 0, 0, null);
    }
    public void screenDraw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setFont(new Font("Korean", Font.BOLD, 40));
        paintComponents(g);
        g.drawImage(Line, 300, 0, null);
        g.drawImage(Line, 1300, 91, null);
        g.drawImage(Line2, 300, 91, null);
        //Location.Location();
        try {
            Thread.sleep(5);
        } catch (Exception e){
            e.printStackTrace();
        }
        this.repaint();
    }
    public void CreateSave(){
        save.setBounds(1525, 0, 60, 60);
        save.setBorderPainted(false);
        save.setContentAreaFilled(false);
        save.setFocusPainted(false);
        save.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                save.setIcon(save2);
                save.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                save.setIcon(save1);
                save.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Save.Save();
            }
        });
        add(save);
    }
}
