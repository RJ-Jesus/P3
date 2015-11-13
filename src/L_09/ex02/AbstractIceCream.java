package L_09.ex02;

import java.util.Objects;

public abstract class AbstractIceCream implements IceCream {
    private IceCream iceCream;

    AbstractIceCream(final IceCream iceCream) {
        this.iceCream = Objects.requireNonNull(iceCream);
    }

    @Override
    public void base(final int n) {
        iceCream.base(n);
    }
}
