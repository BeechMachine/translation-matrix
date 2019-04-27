package com.brokenprotocol.poemcreator;

public class TranslationItem {

    private String sourceLanguage;
    private String targetLanguage;
    private int orderNumber;

    TranslationItem(String sourceLanguage, String targetLanguage, int orderNumber) {

    }

    public String getSourceLanguage() {
        return sourceLanguage;
    }

    public void setSourceLanguage(String sourceLanguage) {
        this.sourceLanguage = sourceLanguage;
    }

    public String getTargetLanguage() {
        return targetLanguage;
    }

    public void setTargetLanguage(String targetLanguage) {
        this.targetLanguage = targetLanguage;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
}
