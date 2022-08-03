package com.Jongyeol.coder.Code.Language;

public class Java {
    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public byte getTab() {
        return tab;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setTab(byte tab) {
        this.tab = tab;
    }

    private String prefix, suffix;
    private byte tab;
    public Java(String prefix, String suffix, byte tab){
        this.prefix = prefix;
        this.suffix = suffix;
        this.tab = tab;
    }
    public Java(String prefix, byte tab){
        this.prefix = prefix;
        this.tab = tab;
    }
    public Java(String prefix){
        this.prefix = prefix;
    }
}
