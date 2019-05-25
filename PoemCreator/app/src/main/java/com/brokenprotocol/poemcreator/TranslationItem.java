package com.brokenprotocol.poemcreator;

public class TranslationItem {

    private String sourceLanguage = "";
    private String targetLanguage = "";

    TranslationItem(String sourceLanguage, String targetLanguage) {
        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;
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

    @Override
    public String toString() {
        return new StringBuilder()
                .append("{Translate")
                .append(" sourceLanguage=").append(sourceLanguage)
                .append(", targetLanguage=").append(targetLanguage)
                .append("}").toString();
    }
}
