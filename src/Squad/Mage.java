package Squad;

import Ability.CharacterAbility;
import Main.Character;
import Observer.CharacterObserver;
import State.CharacterState;

public class Mage extends Character implements CharacterObserver {
    public Mage(String name, CharacterState state, CharacterAbility ability) {
        super(name, state, ability);
    }

    @Override
    public void update() {
        System.out.println("aslkdjlask");
    }
}
