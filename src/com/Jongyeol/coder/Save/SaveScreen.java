package com.Jongyeol.coder.Save;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class SaveScreen extends JFrame {
    private SaveScreen screen = this;
    private JFileChooser fileChooser = new JFileChooser(Save.saveLocation);
    private JLabel location = new JLabel("저장 위치 : " + Save.saveLocation);
    public SaveScreen() {
        setTitle("Coder Save");
        setSize(500, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        CreateItem();
    }
    public void CreateItem() {
        JButton save = new JButton("저장");
        save.setBounds(220, 610, 60, 30);
        save.setBorderPainted(true);
        save.setContentAreaFilled(true);
        save.setFocusPainted(false);
        save.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Save.Save();
            }
        });
        add(save);
        location.setText("저장 위치 : " + Save.saveLocation);
        location.setBounds(0, 5, 500, 30);
        add(location);
        JButton locationC = new JButton("위치 변경");
        locationC.setBounds(0, 40, 120, 30);
        locationC.setBorderPainted(true);
        locationC.setContentAreaFilled(true);
        locationC.setFocusPainted(false);
        locationC.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Boolean A = true;
                for(FileFilter f : fileChooser.getChoosableFileFilters()){
                    if(f.getDescription() == "All Files") fileChooser.removeChoosableFileFilter(f);
                    if(f.getDescription() == "*.java") A = false;
                }
                if(A){
                    fileChooser.setFileFilter(new FileFilter() {
                        @Override
                        public boolean accept(File f) {
                            return true;
                        }

                        @Override
                        public String getDescription() {
                            return "*.java";
                        }
                    });
                }
                fileChooser.showSaveDialog(screen);
                Save.saveLocation = fileChooser.getSelectedFile().getPath();
                if(!Save.saveLocation.contains(".java")){
                    Save.saveLocation += ".java";
                }
                location.setText("저장 위치 : " + Save.saveLocation);
                System.out.println(Save.saveLocation);
            }
        });
        add(locationC);
        String[] st = {"Java", "C"};
        JComboBox<String> Jcombo = new JComboBox<>(st);
        Jcombo.setBounds(60, 80, 120, 30);
        add(Jcombo);
        JLabel setlang = new JLabel("언어 선택");
        setlang.setBounds(0, 80, 60, 30);
        add(setlang);

    }
    public void saveShow(){
        setVisible(true);
    }
}
