package com.pageobject.common.menusItems;

public enum Operations implements TitleEnum {
    INSPECTIONS("Inspections"),
    INVOICES("Invoices"),
    BASIC_PARTS_MANAGEMENT("Basic Parts Management"),
    PARTS_INVENTORY("Parts Inventory"),
    SERVICE_REQUESTS("Service Requests"),
    PARTS_MANAGEMENT("Parts Management"),
    SERVICE_CONTRACTS("Service Contracts"),
    VEHICLE_INVENTORY("Vehicle Inventory");

    private String title;

    Operations(String operations) {
        this.title = operations;
    }

    public String getTitle() {
        return title;
    }
}

