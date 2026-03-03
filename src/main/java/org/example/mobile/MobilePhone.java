package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }


    public MobilePhone(String myNumber, List<Contact> contacts) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>(contacts);
    }


    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact) >= 0) {
            System.out.println("⚠ Contact already exists: " + contact.getName());
            return false;
        }

        myContacts.add(contact);
        System.out.println("✓ Contact added: " + contact.getName());
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);

        if (position < 0) {
            System.out.println("✗ Contact not found: " + oldContact.getName());
            return false;
        }

        myContacts.set(position, newContact);
        System.out.println("✓ Contact updated: " + oldContact.getName() +
                " → " + newContact.getName());
        return true;
    }


    public boolean removeContact(Contact contact) {
        int position = findContact(contact);

        if (position < 0) {
            System.out.println("✗ Contact not found: " + contact.getName());
            return false;
        }

        myContacts.remove(position);
        System.out.println("✓ Contact removed: " + contact.getName());
        return true;
    }


    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    public int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);

        if (position >= 0) {
            return myContacts.get(position);
        }

        return null;
    }


    public void printContact() {
        if (myContacts.isEmpty()) {
            System.out.println("\n📱 Contact List is empty!");
            return;
        }

        System.out.println("\n📱 Contact List:");
        System.out.println("─".repeat(45));

        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            System.out.printf("%d. %s -> %s%n",
                    (i + 1),
                    contact.getName(),
                    contact.getPhoneNumber());
        }

        System.out.println("─".repeat(45));
        System.out.println("Total Contacts: " + myContacts.size());
    }
}