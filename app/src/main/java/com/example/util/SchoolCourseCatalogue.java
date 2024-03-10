package com.example.util;

import java.util.*;
import java.io.*;

public class SchoolCourseCatalogue {
    Set<SchoolCourse> catalogue = new HashSet<>();

    public SchoolCourseCatalogue(){
    }

    public int getCatalogueSize(){
        return catalogue.size();
    }

    public Set<SchoolCourse> getSchoolCourse(int grade) {
        Set<SchoolCourse> minicatalogue = new HashSet<>();
        for (SchoolCourse x : catalogue) {
            if (x.getGrade() == grade) {
                minicatalogue.add(x);
                System.out.println(x);
            }
        }
        return minicatalogue;
    }

    public Set<SchoolCourse> loadCatalogue(String data) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(data));
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line!=null){
                    int temp1= Integer.parseInt(line.split(" ")[0]);
                    String temp2=line.split(" ")[1];
                    SchoolCourse temp3 = new SchoolCourse(temp1,temp2);
                    catalogue.add(temp3);
                }
            }
        } finally {
            reader.close();
        }
        return catalogue;
    }
}