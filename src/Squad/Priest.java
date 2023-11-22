package Squad;

import Ability.CharacterAbility;
import Main.Character;
import Observer.CharacterObserver;
import State.CharacterState;

public class Priest extends Character implements CharacterObserver {
    private Priest(String name, CharacterState state, CharacterAbility ability) {
        super(name, state, ability);
    }

    @Override
    public void update() {
        System.out.println("я возле костра ");
    }
}
