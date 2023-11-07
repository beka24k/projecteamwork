package Builder;

import Ability.CharacterAbility;
import Main.Character;
import State.CharacterState;

public interface CharacterBuilder {
    CharacterBuilder setName(String name);
    CharacterBuilder setState(CharacterState state);
    CharacterBuilder setAbility(CharacterAbility ability);
    CharacterBuilder setCamp(String camp);
    Character build();
}