package com.pageobject.common.menusItems;

public enum Main implements TitleEnum {

    OPERATIONS("Operations"),
    SETTINGS("Settings"),
    MONITOR("Monitor"),
    REPORTS("Reports"),
    INTEGRATIONS("Integrations"),
    ADDONS("Add-ons");

    private String title;

    Main(String operations) {
        this.title = operations;
    }

    public String getTitle() {
        return title;
    }
}

