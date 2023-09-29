package com.management.sys.entity;

public class Attributes implements Comparable<Attributes> {
    public String AttriName;
    public int score;
    public Attributes(String AttriName, int score) {
        this.AttriName = AttriName;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Attributes{" +
                "AttriName='" + AttriName + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Attributes o) {
        return score > o.score ? -1 : 1;
    }

}
