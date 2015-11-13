package L_09.ex02;

public class Cone extends AbstractIceCream {

    public Cone(final IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public void base(final int n) {
        super.base(n);
        System.out.printf(" in cone");
    }
}
