package com.Jongyeol.coder.Save;

import com.Jongyeol.coder.Code.Language.Language;
import com.Jongyeol.coder.Variables.Variable;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

/**
 * 저장 화면
 *
 * @author Jongyeol
 * @author smalljjack
 * @see Save
 */
public class SaveScreen extends JFrame {
    private SaveScreen screen = this;
    private JFileChooser fileChooser = new JFileChooser(Save.saveLocation);
    private JLabel location = new JLabel("저장 위치 : " + Save.saveLocation);
    private Language selectedLanguage = Language.Java;

    /**
     * 화면 설정 & 표시
     *
     * @author Jongyeol
     * @author smalljjack
     */
    public SaveScreen() {
        setTitle("Coder Save");
        setSize(500, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        CreateItem();
    }

    /**
     * 저장화면 기본적인 아이템 생성
     *
     * @author Jongyeol
     */
    public void CreateItem() {
        JButton save = new JButton("저장");
        save.setBounds(220, 610, 60, 30);
        save.setBorderPainted(true);
        save.setContentAreaFilled(true);
        save.setFocusPainted(false);
        save.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Save.Save(selectedLanguage);
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
                boolean A = true;
                for(FileFilter f : fileChooser.getChoosableFileFilters()){
                    if(f.getDescription().equals(selectedLanguage.getExtensions())) {
                        A = false;
                    } else {
                        fileChooser.removeChoosableFileFilter(f);
                    }
                }
                if(A){
                    fileChooser.setFileFilter(new FileFilter() {
                        @Override
                        public boolean accept(File f) {
                            return true;
                        }

                        @Override
                        public String getDescription() {
                            return selectedLanguage.getExtensions();
                        }
                    });
                }
                fileChooser.showSaveDialog(screen);
                if(fileChooser.getSelectedFile() == null){
                    JOptionPane.showMessageDialog(getParent(), "파일이 지정되지 않았습니다.", "오류", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                String fileName = fileChooser.getSelectedFile().getName().toLowerCase();
                if(fileName.contains(" ")){
                    JOptionPane.showMessageDialog(getParent(), "파일에 이름이 잘못 설정되어있습니다.", "오류", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Save.saveLocation = fileChooser.getSelectedFile().getPath();
                if(!fileName.toLowerCase().contains(selectedLanguage.getExtensions())){
                    Save.saveLocation += selectedLanguage.getExtensions();
                }
                location.setText("저장 위치 : " + Save.saveLocation);
                System.out.println(Save.saveLocation);
            }
        });
        add(locationC);
        ArrayList<String> arrayList = new ArrayList<>();
        for(Language language : Language.values()){
            arrayList.add(language.name());
        }
        String[] st = arrayList.toArray(new String[0]);
        JComboBox<String> jcombo = new JComboBox<>(st);
        jcombo.setBounds(60, 80, 120, 30);
        add(jcombo);
        jcombo.addActionListener(e -> {
            String before = selectedLanguage.getExtensions();
            selectedLanguage = Language.valueOf(jcombo.getSelectedItem().toString());
            System.out.println(selectedLanguage);
            Save.saveLocation = Save.saveLocation.replaceAll(before, selectedLanguage.getExtensions());
            location.setText("저장 위치 : " + Save.saveLocation);
        });
        JLabel setlang = new JLabel("언어 선택");
        setlang.setBounds(0, 80, 60, 30);
        add(setlang);

    }

    /**
     * 저장 창 켜기
     *
     * @author Jongyeol
     */
    public void saveShow(){
        setVisible(true);
    }
}
