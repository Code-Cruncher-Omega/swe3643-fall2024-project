package com.instance;

public class Interpreter {

    private Interpreter() {}

    public static String[] splitString(String text, boolean comma, boolean newLine) throws Exception {

        if(text.isEmpty()) {
            return new String [0];
        }

        String[] pieces = {};
        boolean foundComma = text.contains(",");
        boolean foundNewLine = text.contains("\n");

        if(comma && !newLine && foundComma && !foundNewLine) {
            pieces = text.split(",");
        } else if(!comma && newLine && !foundComma && foundNewLine) {
            pieces = text.split("\n");
        } else if(comma && newLine && foundComma && foundNewLine) {
            String temp = text.replace("\n", ",");
            pieces = temp.split(",");
        } else if(comma && !foundComma && !foundNewLine && !newLine) {
            throw new Exception("Invalid input format\nSeparate values by commas");
        } else if(newLine && !foundNewLine && !foundComma && !comma){
            throw new Exception("Invalid input format\nSeparate values by lines");
        } else if(comma && foundComma && foundNewLine && !newLine) {
            throw new Exception("Invalid input format\nCan't use new lines, separate values by commas");
        } else if(newLine && foundNewLine && foundComma && !comma) {
            throw new Exception("Invalid input format\nCan't use commas, separate values by new lines");
        } else if(newLine && comma && !foundNewLine && !foundComma) {
            throw new Exception("Invalid input format\nSeparate pair values by commas, and separate pairs by new lines");
        } else if(comma && !foundComma && foundNewLine && !newLine) {
            throw new Exception("Invalid input format\nSeparate values by commas not new lines");
        } else if(!comma && foundComma && !foundNewLine && newLine) {
            throw new Exception("Invalid input format\nSeparate values by new lines not commas");
        }

        for(int i = 0 ; i < pieces.length ; i++) {
            pieces[i] = pieces[i].replace(" ", "");
        }

        return pieces;
    }

    public static double[] parseStringArrayToDoubleArray(String[] elements) throws Exception {

        if(elements.length == 0) {
            return new double [0];
        }

        double[] values = new double[elements.length];
        try {
            for(int i = 0 ; i < elements.length ; i++) {
                if(elements[i].isEmpty()) {
                    values[i] = Double.NEGATIVE_INFINITY;   // Negative infinity used to indicate that a parameter was left empty
                }   else {
                    values[i] = Double.parseDouble(elements[i]);
                }
            }
        }   catch (Exception e) {
            throw new Exception("Invalid input format\nUse numbers only, don't use letters");
        }
        return values;
    }


}
