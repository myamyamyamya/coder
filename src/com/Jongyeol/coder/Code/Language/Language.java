package com.Jongyeol.coder.Code.Language;

/**
 * 언어 데이터
 *
 * @author Jongyeol
 * @author smalljjack
 * @see LanguageCode
 */
public enum Language {
    Java(".java", new LanguageCode("public class {class} {\n", "}", 1), "@echo off\ntitle {class} \njava.exe \"{FileLocation}\"\npause\nexit"),
    C(".c", new LanguageCode(""), "");
    //https://www.mingw-w64.org/downloads/
    private final String extensions;
    private final String start;
    private final LanguageCode defaultCode;

    /**
     * 언어 데이터 생성
     *
     * @author Jongyeol
     * @param extensions 확장자명
     * @param defaultCode 기본 코드 데이터
     * @param start 실행 명령어
     * @see LanguageCode
     */
    Language(String extensions, LanguageCode defaultCode, String start){
        this.extensions = extensions;
        this.defaultCode = defaultCode;
        this.start = start;
    }

    /**
     * 확장자명 불러오기
     *
     * @author Jongyeol
     * @return 확장자명
     */
    public String getExtensions() {
        return extensions;
    }

    /**
     * 기본 코드 데이터 불러오기
     *
     * @author Jongyeol
     * @return 기본 코드 데이터
     * @see LanguageCode
     */
    public LanguageCode getDefaultCode() {
        return defaultCode;
    }

    /**
     * 실행 명령어 불러오기
     *
     * @author Jongyeol
     * @return 실행 명령어
     */
    public String getStart() {
        return start;
    }
}
