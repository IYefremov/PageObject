package com.pageobject.common;
import com.pageobject.common.menusItems.TitleEnum;
import org.openqa.selenium.WebElement;

import java.util.List;


public class Utilites {
    public static boolean areTwoListsEqual(List<WebElement> firstWebElList, List<TitleEnum> secondEnumValuesList) {
        boolean matchFlag = false;

        // check if Lists sizes are equal
        if (firstWebElList.size() != secondEnumValuesList.size()) {
            return false;
        }

        // check if Lists values are equal
        for (WebElement elemOfList : firstWebElList){
            for (TitleEnum enElem : secondEnumValuesList) {
                if (elemOfList.getAttribute("innerText").equals(enElem.getTitle())) {
                    matchFlag = true;
                    break;
                } else matchFlag = false;
            }
            if (!matchFlag) return false;
        }
        return matchFlag;
    }

    // For debug purpose only
    public static void printListToConsole(List<WebElement> list) {
        for(WebElement l : list) {
            System.out.println(l.getAttribute("innerText"));
        }
        System.out.println("--> " + list.size() + " elements found");
    }
}
