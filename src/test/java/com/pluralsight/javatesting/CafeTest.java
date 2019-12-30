package com.pluralsight.javatesting;

import org.junit.Assert;
import org.junit.Test;

public class CafeTest {
    @Test
    public void canBrewEspresso() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(CoffeeType.Espresso.getRequiredBeans());

        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        Assert.assertEquals(CoffeeType.Espresso, coffee.getCoffeeType());
        Assert.assertEquals(0, coffee.getMilk());
        Assert.assertEquals(CoffeeType.Espresso.getRequiredBeans(), coffee.getBeans());
    }

    @Test
    public void brewingEspressoConsumesBeans() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(CoffeeType.Espresso.getRequiredBeans());

        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        Assert.assertEquals(0, cafe.getBeansInStock());
    }
}
