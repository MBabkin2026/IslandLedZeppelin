package com.javarush.island.babkin.servises;

public abstract class Color {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static final String FILL_RED = "\u001B[41m";
    public static final String FILL_GREEN = "\u001B[42m";
    public static final String FILL_YELLOW = "\u001B[43m";
    public static final String FILL_BLUE = "\u001B[44m";
    public static final String FILL_PURPLE = "\u001B[45m";
    public static final String FILL_CYAN = "\u001B[46m";
    public static final String FILL_WHITE = "\u001B[47m";

    public static String getPercentAnimal(double val){

        String color = "";
        if(val <= 10) {
            color = Color.CYAN;
        } else if (val <= 20) {
            color = Color.BLUE;
        } else if (val <= 30) {
            color = Color.GREEN;
        } else if (val <= 40) {
            color = Color.YELLOW;
        } else if (val <= 50) {
            color = Color.RED;
        } else if (val <= 60) {
            color = Color.FILL_CYAN;
        } else if (val <= 70) {
            color = Color.FILL_BLUE;
        } else if (val <= 80) {
            color = Color.FILL_GREEN;
        } else if (val <= 90) {
            color = Color.FILL_YELLOW;
        } else {
            color = Color.FILL_RED;
        }

        return color;
    }
}
