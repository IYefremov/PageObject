package com.pageobject.common.menusItems;

public enum Settings implements TitleEnum {
    SERVICES("Services"),
    COMPANY_INFO("Company Info"),
    USERS("Users"),
    ROLES("Roles"),
    CLIENTS("Clients"),
    QUICK_NOTES("Quick Notes"),
    QUICK_ACTIONS("Quick Actions"),
    DEVICE_MANAGEMENT("Device Management"),
    WAREHOUSES("Warehouses"),
    SERVICE_CONTRACT_TYPES("Service Contract Types"),
    CATALOG_MANAGEMENT("Catalog Management"),
    CATALOGS("Catalogs"),
    LABOR_SKILLS("Labor Skills"),
    PAYMENTS("Payments"),
    STATUSES_TRANSITIONS("Statuses & Transitions"),
    VEHICLE_INVENTORY("Vehicle Inventory"),
    PARTS_INVENTORY("Parts Inventory"),
    MARKUPS("Markups");

    private String title;

    Settings(String operations) {
            this.title = operations;
        }

        public String getTitle() {
            return title;
        }
    }


