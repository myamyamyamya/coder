package com.Jongyeol.coder;

import com.Jongyeol.coder.Code.Event;
import com.Jongyeol.coder.Code.EventList;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Save {
    public static void Save(){
        String code = "public class Main {\n";
        int TabAmount = 1;
        for(Event event : EventList.Eventlist){
            for(int i = 0; i < TabAmount; i++){
                code += "    ";
            }
            code += event.prefix;
            for(int i = 0; i < TabAmount; i++){
                code += "    ";
            }
            code += event.suffix;
        }
        code += "}";
        try {
            OutputStream output = new FileOutputStream("C://Jongyeol/Main.java");
            byte[] by = code.getBytes();
            output.write(by);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
