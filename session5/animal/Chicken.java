package session5.animal;

import session5.animal.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "ChicKen : cluck - cluck";
    }

    @Override
    public String howtoeat() {
        return "Coule be fried";
    }
}
