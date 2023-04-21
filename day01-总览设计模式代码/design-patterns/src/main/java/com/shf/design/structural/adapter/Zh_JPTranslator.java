package com.shf.design.structural.adapter;

public class Zh_JPTranslator implements Translator{
    @Override
    public String translate(String content) {
        if ("你好".equals(content)) {
            return "空你几哇";
        }
        if ("什么".equals(content)) {
            return "纳里";
        }
        return "*********";
    }

}
