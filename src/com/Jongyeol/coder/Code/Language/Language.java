package com.Jongyeol.coder.Code.Language;

public enum Language {
    Java(".java", new LanguageCode("public class {class} {\n", "}", 1), "@echo off\ntitle {class} \njava.exe \"{FileLocation}\"\npause\nexit"),
    C(".c", new LanguageCode(""), "");
    //https://www.mingw-w64.org/downloads/
    Language(String extensions, LanguageCode defaultCode, String start){
        this.extensions = extensions;
        this.defaultCode = defaultCode;
        this.start = start;
    }
    private final String extensions;

    private final String start;

    private final LanguageCode defaultCode;
    public String getExtensions() {
        return extensions;
    }

    public LanguageCode getDefaultCode() {
        return defaultCode;
    }

    public String getStart() {
        return start;
    }
}
