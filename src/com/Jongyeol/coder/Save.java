package com.Jongyeol.coder;

import com.Jongyeol.coder.Code.Code;
import com.Jongyeol.coder.Code.Event;
import com.Jongyeol.coder.Code.CodeList;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Save {
    public static void Save(){
        String code = "public class Main {\n";
        int TabAmount = 1;
        for(Event event : CodeList.Eventlist){
            for(int i = 0; i < TabAmount; i++){
                code += "    ";
            }
            Code code1 = (Code) event;
            code += code1.prefix;
            for(int i = 0; i < TabAmount; i++){
                code += "    ";
            }
            code += code1.suffix;
        }
        code += "}";
        try {
            OutputStream output = new FileOutputStream("C://Jongyeol/Main.java");
            byte[] by = code.getBytes();
            output.write(by);
            OutputStream output2 = new FileOutputStream("C://Jongyeol/start.bat");
            byte[] by2 = "@echo off\ntitle Java\njava.exe C:\\Jongyeol\\Main.java\npause\nexit".getBytes();
            output2.write(by2);
            Runtime.getRuntime().exec("cmd /c start C:\\Jongyeol\\start.bat");
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
