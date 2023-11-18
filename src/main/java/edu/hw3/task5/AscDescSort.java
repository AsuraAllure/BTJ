package edu.hw3.task5;

import java.util.ArrayList;
import java.util.List;

public class AscDescSort {
    private final static String ASC_ORDER = "ASC";
    private final static String DESC_ORDER = "DESC";
    private AscDescSort() {
    }

    public static Object[] parseContact(String[] rawContacts, String order) {
        if (rawContacts == null || order == null) {
            throw new NullPointerException();
        }

        if (rawContacts.length == 0) {
            return new Object[0];
        }

        List<Contact> contacts = new ArrayList<>(rawContacts.length);
        for (var rawContact : rawContacts) {
            String[] fio = rawContact.split("\s");
            if (fio.length == 2) {
                contacts.add(new Contact(fio[0], fio[1]));
            } else {
                contacts.add(new Contact(fio[0], ""));
            }
        }

        if (ASC_ORDER.equals(order)) {
            return contacts.stream().sorted((s1, s2) ->
                s1.surname.compareTo(s2.surname) == 0
                    ? s1.name.compareTo(s2.name)
                    : s1.surname.compareTo(s2.surname)
            ).toArray();
        }

        if (DESC_ORDER.equals(order)) {
            return contacts.stream().sorted((s1, s2) ->
                s1.surname.compareTo(s2.surname) == 0
                    ? -s1.name.compareTo(s2.name)
                    : -s1.surname.compareTo(s2.surname)
            ).toArray();
        }
        return new Contact[0];
    }

    record Contact(String name, String surname) {
    }

}
