package org.example.dolistviewshavetobeparameterizedinfxml;

public class Gamer {
    private int n;
    private String gamer;

    public Gamer(int n, String gamer) {
        this.n = n;
        this.gamer = gamer;
    }

    public String toString() {
        return gamer + " " + n;
    }
}
