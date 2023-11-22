package Squad;

import Ability.CharacterAbility;
import Main.Character;
import Observer.CharacterObserver;
import State.CharacterState;

public class Warior extends Character implements CharacterObserver {
    private Warior(String name, CharacterState state, CharacterAbility ability) {
        super(name, state, ability);
    }

    @Override
    public void update() {
        System.out.println("Я возле речки");
    }
}
