package org.example;

public class Validator {

    private Validator() {}

    private String[] splitString(String text) throws Exception {
        boolean comma = text.contains(",");
        boolean newLine = text.contains("\n");

        String[] pieces = new String[0];

        if(comma && !newLine) {
            pieces = text.split(",");
        } else if(!comma && newLine) {
            pieces = text.split("\n");
        } else if(comma) {
            throw new Exception("Invalid input format");
        }

        for(int i = 0 ; i < pieces.length ; i++) {
            pieces[i] = pieces[i].replace(" ", "");
        }

        return pieces;
    }

    private double[] parseStringArrayToDoubleArray(String[] elements) {
        double[] values = new double[elements.length];
        for(int i = 0 ; i < elements.length ; i++) {
            if(elements[i].isEmpty()) {
                values[i] = Double.NEGATIVE_INFINITY;   // Negative infinity used to indicate that a parameter was left empty
            }   else {
                values[i] = Double.parseDouble(elements[i]);
            }
        }
        return values;
    }


}
