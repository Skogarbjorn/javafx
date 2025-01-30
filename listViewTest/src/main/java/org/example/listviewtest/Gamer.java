package org.example.listviewtest;

public class Gamer implements Comparable<Gamer> {
    private final String data;

    public Gamer(String data) {
        this.data = data;
    }

    public String toString() {
        return data;
    }

    public int compareTo(Gamer that) {
        return data.compareTo(that.data);
    }
}
