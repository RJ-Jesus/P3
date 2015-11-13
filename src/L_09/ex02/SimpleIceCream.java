package L_09.ex02;

import java.util.Objects;

public class SimpleIceCream implements IceCream {
    private final String flavor;

    public SimpleIceCream(final String flavor) {
        this.flavor = Objects.requireNonNull(flavor);
    }

    @Override
    public void base(final int n) {
        System.out.printf("\n%d ice cream balls of %s", n, flavor);
    }
}
