/*
 * data.java
 * sample class with data, constructors, getters, setters, toString
 * lehman
 */
public class data {

    // data
    private boolean found;
    private int years;

    // constructors

    // default constructor
    // data x = new data();
    public data() {
        found = false;
        years = 0;
    }

    // alternate constructor
    // data y = new data(true, 17);
    public data(boolean status, int num) {
        found = status;
        years = num;
    }

    // getters and setters
    public boolean isFound() {
        return found;
    }

    public void setFound(boolean status) {
        found = status;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int y) {
        years = y;
    }

    // toString
    public String toString() {
        return "found: " + found + ", years: " + years;
    }

}// class