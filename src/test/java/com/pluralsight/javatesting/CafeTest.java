package com.pluralsight.javatesting;

import org.junit.Assert;
import org.junit.Test;

public class CafeTest {
    @Test
    public void canBrewEspresso() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(CoffeeType.Espresso.getRequiredBeans());

        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        Assert.assertEquals("Wrong coffee type", CoffeeType.Espresso, coffee.getCoffeeType());
        Assert.assertEquals("Wrong amount of milk",0, coffee.getMilk());
        Assert.assertEquals("Wrong number of beans", CoffeeType.Espresso.getRequiredBeans(), coffee.getBeans());
    }

    @Test
    public void brewingEspressoConsumesBeans() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(CoffeeType.Espresso.getRequiredBeans());

        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        Assert.assertEquals(0, cafe.getBeansInStock());
    }

    @Test(expected = IllegalStateException.class)
    public void lattesRequiresMilk() {
        Cafe cafe = new Cafe();
        cafe.restockBeans(CoffeeType.Latte.getRequiredBeans());

        Coffee coffee = cafe.brew(CoffeeType.Latte);
    }
}
