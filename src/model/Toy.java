package model;

public class Toy {
    private String name;
    private int rate;
    private int id;
    private int count;

    public Toy(int id, String name, int rate) {
        this.name = name;
        this.rate = rate;
        this.id = id;
    }

    public void add(int amount){
        this.count++;
    }

    public int getProbability(){
        return this.count*this.rate;
    }


    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "" + name + " (" + rate +")";
    }
}
