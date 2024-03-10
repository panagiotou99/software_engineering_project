package com.example.domain;

/**
 * Η απάντηση σε μια ερώτηση.
 * @author Panagiotis Panagiotou
 * @author Eleni Fourtouni
 * @author Olga Margeli
 */

public class Answer {
    private String description; //e.g. "16"
    private boolean validity; // True

    /**
     * Προκαθορισμένος κατασκευαστής.
     */
    //Constructor #1 (Default)
    Answer(){
    }

    /**
     * Βοηθητικός κατασκευαστής.
     * @param description Τα λόγια της απάντησης.
     * @param validity Αν είναι σωστή ή όχι η απάντηση.
     */
    //Constructor #2
    Answer(String description, boolean validity){
        this.description=description;
        this.validity=validity;
    }

    //Getters

    /**
     * Επιστρέφει την περιγραφή της απάντησης.
     * @return Η περιγραφή της απάντησης
     */
    public String getDescription() { return description; }

    /**
     * Επιστρέφει την εγκυρότητα της απάντησης.
     * @return Η εγκυρότητα της απάντησης
     */
    public boolean getValidity() { return validity; }

    //Setters

    /**
     * Θέτει την περιγραφή της απάντησης.
     * @param description Η περιγραφή της απάντησης
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * Θέτει την εγκυρότητα της απάντησης.
     * @param validity Η εγκυρότητα της απάντησης
     */
    public void setValidity(boolean validity) { this.validity = validity; }

}

