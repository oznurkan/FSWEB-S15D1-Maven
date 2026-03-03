package org.example.mobile;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Constructor 1: Empty List ===");
        MobilePhone phone1 = new MobilePhone("555-1234");
        phone1.addNewContact(Contact.createContact("Alice", "11111111"));
        phone1.addNewContact(Contact.createContact("Bob", "22222222"));
        phone1.printContact();
        System.out.println();

        System.out.println("=== Constructor 2: With Existing Contacts ===");
        ArrayList<Contact> existingContacts = new ArrayList<>();
        existingContacts.add(Contact.createContact("Charlie", "33333333"));
        existingContacts.add(Contact.createContact("Diana", "44444444"));
        existingContacts.add(Contact.createContact("Eve", "55555555"));

        MobilePhone phone2 = new MobilePhone("999-8888", existingContacts);
        phone2.printContact();
        System.out.println();

        System.out.println("=== Adding New Contact ===");
        phone2.addNewContact(Contact.createContact("Frank", "66666666"));
        phone2.printContact();
        System.out.println();


        System.out.println("=== Find Contact ===");
        int position = phone2.findContact("Charlie");
        System.out.println("Position of Charlie: " + position);
        System.out.println();

        System.out.println("=== Query Contact ===");
        Contact found = phone2.queryContact("Diana");
        System.out.println("Found: " + (found != null ? found : "Not found"));
        System.out.println();

        System.out.println("=== Update Contact ===");
        Contact oldEve = phone2.queryContact("Eve");
        Contact newEve = Contact.createContact("Eve Johnson", "55555555");
        phone2.updateContact(oldEve, newEve);
        phone2.printContact();
        System.out.println();

        System.out.println("=== Remove Contact ===");
        Contact toRemove = phone2.queryContact("Charlie");
        phone2.removeContact(toRemove);
        phone2.printContact();
    }
}
