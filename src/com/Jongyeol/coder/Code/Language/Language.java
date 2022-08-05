package com.Jongyeol.coder.Code.Language;

public enum Language {
    Java(".java", new LanguageCode("public class \" + className + \" {\\n", "}", (byte)1)),
    C(".c", new LanguageCode(""));
    Language(String extensions, LanguageCode defaultCode){
        this.extensions = extensions;
        this.defaultCode = defaultCode;
    }
    private final String extensions;

    private final LanguageCode defaultCode;
    public String getExtensions() {
        return extensions;
    }

    public LanguageCode getDefaultCode() {
        return defaultCode;
    }
}
