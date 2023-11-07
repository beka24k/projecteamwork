package Main;

import Ability.FireMagick;
import Squad.Mage;
import State.AliveState;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Character mage=new Mage("Papirusio",new AliveState(),new FireMagick());
        Character as=new Character("as",new AliveState(),new FireMagick());
        as.attach(mage);
        mage.performAction();

        as.setCamp("bebe");

    }
}