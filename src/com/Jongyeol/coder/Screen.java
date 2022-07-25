package com.Jongyeol.coder;

import com.Jongyeol.coder.Code.EventList;
import com.Jongyeol.coder.Code.EventType.ProgramStart;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Screen extends JFrame {
    private Image ScreenImage;
    private Image background = new ImageIcon(Main.class.getResource("../../../resource/BackScreen.png")).getImage();
    private Image Line = new ImageIcon(Main.class.getResource("../../../resource/Line.png")).getImage();
    private Image Line2 = new ImageIcon(Main.class.getResource("../../../resource/Line2.png")).getImage();
    private ImageIcon None = new ImageIcon(Main.class.getResource("../../../resource/None.png"));
    private Graphics screenGraphics;
    public static ArrayList<JButton> buttonlist = new ArrayList<JButton>();
    public Screen() {
        setTitle("Coder");
        setSize(1600, 900);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        ProgramStart ps = new ProgramStart(this);
        ps.setLocation(320, 120);
        ps.ButtonCreate();
        EventList.Eventlist.add(ps);
    }
    public void paint(Graphics g) {
        ScreenImage = createImage(1600, 900);
        screenGraphics = ScreenImage.getGraphics();
        screenDraw((Graphics2D) screenGraphics);
        g.drawImage(ScreenImage, 0, 0, null);
    }
    public void screenDraw(Graphics2D g) {
        paintComponents(g);
        g.drawImage(Line, 300, 0, null);
        g.drawImage(Line2, 300, 100, null);
        g.setColor(Color.BLACK);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setFont(new Font("Korean", Font.BOLD, 40));
        //Location.Location();
        try {
            Thread.sleep(5);
        } catch (Exception e){
            e.printStackTrace();
        }
        this.repaint();
    }
}
