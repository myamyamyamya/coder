package com.Jongyeol.coder.Code.Language;

/**
 * 언어 코드 데이터
 *
 * @author Jongyeol
 * @author smalljjack
 * @see LanguageCode
 */
public class LanguageCode {
    private String prefix;
    private String suffix;
    private byte tab;

    /**
     * 접두사 불러오기
     *
     * @author Jongyeol
     * @return 접두사
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * 접미사 불러오기
     *
     * @author Jongyeol
     * @return 접미사
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * Tab 횟수 불러오기
     *
     * @author Jongyeol
     * @return Tab 횟수
     */
    public byte getTab() {
        return tab;
    }

    /**
     * 접두사 설정하기
     *
     * @author Jongyeol
     * @param prefix 접두사
     */

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * 접미사 설정하기
     *
     * @author Jongyeol
     * @param suffix 접미사
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * Tab 횟수 설정하기
     *
     * @author Jongyeol
     * @param tab Tab 횟수
     */
    public void setTab(byte tab) {
        this.tab = tab;
    }

    /**
     * 데이터 생성
     *
     * @author Jongyeol
     * @param prefix 접두사
     * @param suffix 접미사
     * @param tab Tab 횟수
     */
    public LanguageCode(String prefix, String suffix, int tab){
        this.prefix = prefix;
        this.suffix = suffix;
        this.tab = (byte) tab;
    }

    /**
     * 데이터 생성
     *
     * @author Jongyeol
     * @param prefix 접두사
     * @param tab Tab 횟수
     */
    public LanguageCode(String prefix, int tab){
        this.prefix = prefix;
        this.tab = (byte) tab;
    }

    /**
     * 데이터 생성
     *
     * @author Jongyeol
     * @param prefix 접두사
     */
    public LanguageCode(String prefix){
        this.prefix = prefix;
    }
}
