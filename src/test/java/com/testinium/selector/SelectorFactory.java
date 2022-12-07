package com.testinium.selector;

public class SelectorFactory {
    private SelectorFactory() {

    }

    public static Selector createElementHelper() {
        return new WebSelector();
    }
}
