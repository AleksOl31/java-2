package ru.alexanna.lesson_3;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    private List<Contact> phonebook = new ArrayList<>();

    private class Contact {
        private String surname;
        private String phoneNumber;

        public Contact(String surname, String phoneNumber) {
            this.surname = surname;
            this.phoneNumber = phoneNumber;
        }

        public String getSurname() {
            return surname;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }
    }

    public boolean add(String surname, String phoneNumber) {
        Contact contact = new Contact(surname, phoneNumber);
        return phonebook.add(contact);
    }

    public List<String> get(String surname) {
        List<String> phoneNumbers = new ArrayList<>();
        for (int i = 0; i < phonebook.size(); i++) {
            if (phonebook.get(i).getSurname().equals(surname))
                phoneNumbers.add(phonebook.get(i).getPhoneNumber());
        }
        return phoneNumbers;
    }
}
