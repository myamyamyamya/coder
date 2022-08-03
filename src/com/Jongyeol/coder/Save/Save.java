package com.Jongyeol.coder.Save;

import com.Jongyeol.coder.Code.Code;
import com.Jongyeol.coder.Code.Detail.DrawDetail;
import com.Jongyeol.coder.Code.Event;
import com.Jongyeol.coder.Code.CodeList;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Save {
    private static String codeFile;
    private static int TabAmount;
    public static String saveLocation = "C:\\Jongyeol\\Main.java";
    public static void Save(){
        DrawDetail.Save();
        String[] sts = saveLocation.replace("\\", "/").split("/");
        String className = sts[sts.length - 1].replace(" ", "_").replace(".java", "");
        codeFile = "public class " + className + " {\n";
        TabAmount = 1;
        for(Event event : CodeList.Eventlist) codeParsing(event);
        codeFile += "}";
        System.out.println(codeFile);
        try {
            OutputStream output = new FileOutputStream(saveLocation);
            byte[] by = codeFile.getBytes();
            output.write(by);
            OutputStream output2 = new FileOutputStream("C://Jongyeol/start.bat");
            String st = "@echo off\ntitle " + className + "\njava.exe \"" + saveLocation + "\"\npause\nexit";
            byte[] by2 = st.getBytes();
            output2.write(by2);
            Runtime.getRuntime().exec("cmd /c start C:\\Jongyeol\\start.bat");
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
    private static void codeParsing(Code code) {
        codeFile += "    ".repeat(TabAmount);
        codeFile += code.java.getPrefix();
        TabAmount += code.java.getTab();
        if(code.underCode != null) codeParsing(code.underCode);
        TabAmount -= code.java.getTab();
        if(code.java.getSuffix() != null) {
            codeFile += "    ".repeat(TabAmount);
            codeFile += code.java.getSuffix();
        }
    }
}
