package com.plucial.company.model;

public class LangModel {
    
    private String key;
    
    private String value;
    
    public LangModel(String value, String key) {
        this.setKey(key);
        this.setValue(value);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
