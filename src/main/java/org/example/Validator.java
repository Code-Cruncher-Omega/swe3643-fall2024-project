package org.example;

public class Validator {

    private Validator() {}

    private double[] parseStringToDoubleArray(String text) throws Exception {
        boolean comma = text.contains(",");
        boolean newLine = text.contains("\n");

        String[] snippets;

        if(comma && !newLine) {
            snippets = text.split(",");
        } else if(!comma && newLine) {
            snippets = text.split("\n");
        } else if(!comma) {
            snippets = new String[0];
        } else
            throw new Exception("Invalid input format");

        double[] values = new double[snippets.length];
        for(int i = 0 ; i < snippets.length ; i++) {
            values[i] = Double.parseDouble(snippets[i]);
        }
        return values;
    }

    public String 
}
