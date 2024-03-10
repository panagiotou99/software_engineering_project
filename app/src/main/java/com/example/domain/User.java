package com.example.domain;

/**
 * Ο χρήστης.
 * @author Panagiotis Panagiotou
 * @author Eleni Fourtouni
 * @author Olga Margeli
 */

public class User {
    private String firstName; //e.g. John
    private String lastName; //e.g. Lamar
    private int age; // e.g. 18
    private String email; //e.g. johnlamar@gmail.com
    private String iban; //e.g. GR9608100010000001234567890
    private String password; // e.g. password1234

    //Constructor #1 (Default)
    /**
     * Προκαθορισμένος κατασκευαστής.
     */
    public User() {
    }

    //Constructor #2
    /**
     * Βοηθητικός κατασκευαστής.
     * @param firstName Όνομα χρήστη.
     * @param lastName Επώνυμο χρήστη.
     * @param age Ηλικία χρήστη.
     * @param email Ηλεκτρονική διεύθυνση χρήστη.
     * @param iban Iban χρήστη.
     * @param password Κωδικός εοσόδου χρήστη.
     */
    public User(String firstName, String lastName, int age, String email, String iban, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.iban = iban;
        this.password = password;
    }

    //Getters

    /**
     * Επιστρέφει το όνομα του χρήστη.
     * @return Το όνομα
     */
    public String getFirstName() { return firstName; }

    /**
     * Επιστρέφει το επώνυμο του χρήστη.
     * @return Το επώνυμο
     */
    public String getLastName() { return lastName; }

    /**
     * Επιστρέφει την ηλικία του χρήστη.
     * @return Η ηλικία
     */
    public int getAge() { return age; }

    /**
     * Επιστρέφει το email του χρήστη.
     * @return Το email
     */
    public String getEmail() { return email; }

    /**
     * Επιστρέφει το iban του χρήστη.
     * @return Το iban
     */
    public String getIban() { return iban; }

    /**
     * Επιστρέφει τον κωδικό εισόδου του χρήστη.
     * @return Ο κωδικός εισόδου
     */
    public String getPassword() { return password; }

    //Setters

    /**
     * Θέτει το όνομα του χρήστη.
     * @param firstName Το όνομα
     */
    public void setFirstName(String firstName) { this.firstName = firstName; }

    /**
     * Θέτει το επώνυμο του χρήστη.
     * @param lastName Το επώνυμο
     */
    public void setLastName(String lastName) { this.lastName = lastName; }

    /**
     * Θέτει την ηλικία του χρήστη.
     * @param age Η ηλικία
     */
    public void setAge(int age) { this.age = age; }

    /**
     * Θέτει το email του χρήστη.
     * @param email Το email
     */
    public void setEmail(String email) { this.email = email; }

    /**
     * Θέτει το iban του χρήστη.
     * @param iban Το iban
     */
    public void setIban(String iban) {this.iban = iban;}

    /**
     * Θέτει τον κωδικό εισόδου του χρήστη.
     * @param password Ο κωδικός εισόδου
     */
    public void setPassword(String password) {this.password = password; }

}
