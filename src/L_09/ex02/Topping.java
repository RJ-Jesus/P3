package L_09.ex02;

import java.util.Objects;

public class Topping extends AbstractIceCream {
    private String topping;

    public Topping(final IceCream iceCream, final String topping) {
        super(iceCream);
        this.topping = Objects.requireNonNull(topping);
    }

    @Override
    public void base(final int n) {
        super.base(n);
        System.out.printf(" with %s", topping);
    }
}
