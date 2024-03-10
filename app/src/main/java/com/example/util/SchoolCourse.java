package com.example.util;

public class SchoolCourse {
    String courseName;
    int grade;

    public SchoolCourse(int grade, String courseName) {
        this.grade = grade;
        this.courseName = courseName;
    }

    public int getGrade() { return grade; }

    public String toString(){
        StringBuilder temp =  new StringBuilder();
        switch (courseName) {
            case "LANGUAGE":
                temp.append("Γλώσσα");
                break;
            case "MATHS":
                temp.append("Μαθηματικά");
                break;
            case "ENVIRONMENTALS":
                temp.append("Μελέτη Περιβάλλοντος");
                break;
            case "ENGLISH":
                temp.append("Αγγλικά");
                break;
            case "INFORMATICS":
                temp.append("Πληροφορική");
                break;
            case "HISTORY":
                temp.append("Ιστορία");
                break;
            case "PHYSICS":
                temp.append("Φυσική");
                break;
            case "GERMAN":
                temp.append("Γερμανικά");
                break;
            case "FRENCH":
                temp.append("Γαλλικά");
                break;
            case "ANCIENTGREEK":
                temp.append("Αρχαία Ελληνικά");
                break;
            case "BIOLOGY":
                temp.append("Βιολογία");
                break;
            case "GEOGRAPHY":
                temp.append("Γεωγραφία");
                break;
        }
        switch (grade) {
            case 1:
                temp.append(" , 1η Δημοτικού");
                break;
            case 2:
                temp.append(" , 2α Δημοτικού");
                break;
            case 3:
                temp.append(" , 3η Δημοτικού");
                break;
            case 4:
                temp.append(" , 4η Δημοτικού");
                break;
            case 5:
                temp.append(" , 5η Δημοτικού");
                break;
            case 6:
                temp.append(" , 6η Δημοτικού");
                break;
            case 7:
                temp.append(" , 1η Γυμνασίου");
                break;
            case 8:
                temp.append(" , 2η Γυμνασίου");
                break;
            case 9:
                temp.append(", 3η Γυμνασίου");
                break;
            case 10:
                temp.append(", 1η Λυκείου");
                break;
            case 11:
                temp.append(", 2η Λυκείου");
                break;
            case 12:
                temp.append(", 3η Λυκείου");
                break;
        }
        return temp.toString();
    }
}
