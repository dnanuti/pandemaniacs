package com.ing.pandemaniacs.hackathon.model;

public enum Category {
    FOOD_BEVERAGES("Food&Beverages"),
    BILLS("Bills"),
    ENTERTAINMENT("Entertainment"),
    SHOPPING("Shopping"),
    HEALTH("Health"),
    OTHERS("Others");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public static Category fromValue(String text) {
        for (Category c : Category.values()) {
            if (String.valueOf(c.name).equals(text)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Not a valid category");
    }

    @Override
    public String toString() {
        return name;
    }
}
