package com.example.giftideas;

import java.util.ArrayList;

public class Row {
    private String mName;
    private boolean mOnline;

    public Row(String name, boolean online) {
        mName = name;
        mOnline = online;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }

    private static int lastContactId = 0;

    public static ArrayList<Row> createContactsList(int numContacts) {
        ArrayList<Row> rows = new ArrayList<Row>();

        for (int i = 1; i <= numContacts; i++) {
            rows.add(new Row("Item Number " + ++lastContactId, i <= numContacts / 2));
        }

        return rows;
    }



}

