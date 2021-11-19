package com.pageobject.common.menusItems;


public enum Integrations implements TitleEnum {
    CONVERSATION_DASHBOARD("Conversion Dashboard"),
    PUNCH_OUT_STATUS("Punch-out Status"),
    SUMMARY_DASHBOARD("Summary Dashboard");

    private String title;

    Integrations(String operations) {
        this.title = operations;
    }

    public String getTitle() {
        return title;
    }
}
