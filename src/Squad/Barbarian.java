package Squad;

import Ability.CharacterAbility;
import Main.Character;
import Observer.CharacterObserver;
import State.CharacterState;

public class Barbarian extends Character implements CharacterObserver {
    public Barbarian(String name, CharacterState state, CharacterAbility ability) {
        super(name, state, ability);
    }

    @Override
    public void update() {
        System.out.println("я в палатке");
    }
}
