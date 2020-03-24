package model;

enum Lang {
    English,
    Vietnamese,
    Japanese,
    Chinese
}

public class HomThu {
    private Lang lang;
    private int pageSize;
    private boolean enbaleSpam;
    private String signature;

    public HomThu() {
    }

    public Lang getLang() {
        return lang;
    }

    public void setLang(Lang lang) {
        this.lang = lang;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isEnbaleSpam() {
        return enbaleSpam;
    }

    public void setEnbaleSpam(boolean enbaleSpam) {
        this.enbaleSpam = enbaleSpam;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
