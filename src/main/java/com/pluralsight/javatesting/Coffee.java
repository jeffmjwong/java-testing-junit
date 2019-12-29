package com.pluralsight.javatesting;

public final class Coffee {
    private final CoffeeType coffeeType;
    private final int beans;
    private final int milk;

    public Coffee(CoffeeType coffeeType, int beans, int milk) {
        this.coffeeType = coffeeType;
        this.beans = beans;
        this.milk = milk;
    }

    public CoffeeType getCoffeeType() {
        return this.coffeeType;
    }
    public int getBeans() {
        return this.beans;
    }
    public int getMilk() {
        return this.milk;
    }

    @Override
    public String toString() {
        return "Coffee{" + "type=" + this.coffeeType + ", beans=" + this.beans + ", milk=" + this.milk + "}";
    }
}
