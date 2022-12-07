package com.testinium.selector;

import com.testinium.model.ElementInfo;
import org.openqa.selenium.By;

public class WebSelector implements Selector{
    @Override
    public By getElementInfoToBy(ElementInfo elementInfo) {
        By by = null;
        if (elementInfo.getType().equals("css")) {
            by = By.cssSelector(elementInfo.getValue());
        } else if (elementInfo.getType().equals("id")) {
            by = By.id(elementInfo.getValue());
        } else if (elementInfo.getType().equals("xpath")) {
            by = By.xpath(elementInfo.getValue());
        } else if (elementInfo.getType().equals("class")) {
            by = By.className(elementInfo.getValue());
        } else if (elementInfo.getType().equals("name")) {
            by = By.name(elementInfo.getValue());
        }else if (elementInfo.getType().equals("linkText")){
            by = By.linkText(elementInfo.getValue());
        }else if (elementInfo.getType().equals("partialLinkText")){
            by = By.partialLinkText(elementInfo.getValue());
        }
        return by;
    }

    @Override
    public int getElementInfoToIndex(ElementInfo elementInfo) {
        return elementInfo.getIndex();
    }
}
