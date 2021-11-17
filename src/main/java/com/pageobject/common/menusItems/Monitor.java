package com.pageobject.common.menusItems;

public enum Monitor implements TitleEnum {

    REPAIR_ORDERS("Repair Orders");

    private String title;

    Monitor(String operations) {
        this.title = operations;
    }

    public String getTitle() {
        return title;
    }

}
