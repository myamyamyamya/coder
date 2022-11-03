package com.Jongyeol.coder.Save;

import com.Jongyeol.coder.Code.Code;
import com.Jongyeol.coder.Code.Detail.DrawDetail;
import com.Jongyeol.coder.Code.Event;
import com.Jongyeol.coder.Code.CodeList;
import com.Jongyeol.coder.Code.Language.Language;
import com.Jongyeol.coder.Code.Language.LanguageCode;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 저장 데이터 및 저장
 *
 * @author Jongyeol
 * @author smalljjack
 * @see SaveScreen
 */
public class Save {
    private static String codeFile;
    private static int TabAmount;
    public static String saveLocation = "C:\\Jongyeol\\Main.java";
    /**
     * 저장
     *
     * @author Jongyeol
     * @param language 저장할 언어
     */
    public static void Save(Language language){
        DrawDetail.Save();
        String[] sts = saveLocation.replace("\\", "/").split("/");
        String className = sts[sts.length - 1].replace(" ", "_").replace(".java", "");
        LanguageCode dCode = language.getDefaultCode();
        codeFile = dCode.getPrefix();
        TabAmount = dCode.getTab();
        for(Event event : CodeList.Eventlist) codeParsing(event);
        codeFile += dCode.getSuffix();
        codeFile = codeFile.replace("{class}", className);
        System.out.println(codeFile);
        try {
            OutputStream output = new FileOutputStream(saveLocation);
            byte[] by = codeFile.getBytes();
            output.write(by);
            OutputStream output2 = new FileOutputStream("C://Jongyeol/start.bat");
            String st = language.getStart();
            st = st.replace("{class}", className);
            st = st.replace("{FileLocation}", saveLocation);
            byte[] by2 = st.getBytes();
            output2.write(by2);
            Runtime.getRuntime().exec("cmd /c start C:\\Jongyeol\\start.bat");
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    /**
     * 코드 분석
     *
     * @author Jongyeol
     * @param code 분석할 코드
     */
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
