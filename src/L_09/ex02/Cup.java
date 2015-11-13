package L_09.ex02;

public class Cup extends AbstractIceCream {

    public Cup(final IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public void base(final int n) {
        super.base(n);
        System.out.print(" in cup");
    }
}
