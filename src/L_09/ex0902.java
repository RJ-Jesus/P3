package L_09;

import L_09.ex02.*;

public class ex0902 {
    public static void main(String[] args) {
        IceCream ice;
        ice = new SimpleIceCream("Vanilla");
        ice.base(2);
        new Cup(ice).base(3);
        new Cone(ice).base(1);
        new Topping(ice, "Cinnamon").base(2);
        ice = new Topping(ice, "Nuts");
        ice.base(1);
        ice = new Topping(new Cone(new SimpleIceCream("Strawberry")), "Fruit");
        ice.base(2);
        ice = new Topping(
                new Topping(
                        new Cup(new SimpleIceCream("Mango")), "Chocolate"), "Cream");
        ice.base(4);
        ice = new Topping(ice, "Chips");
        ice.base(3);
    }
}
