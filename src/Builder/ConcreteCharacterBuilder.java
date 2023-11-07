package Builder;

import Ability.CharacterAbility;
import Main.Character;
import State.CharacterState;

public class ConcreteCharacterBuilder implements CharacterBuilder {
    private Character character = new Character();

    @Override
    public CharacterBuilder setName(String name) {
        character.setName(name);
        return this;
    }

    @Override
    public CharacterBuilder setState(CharacterState state) {
        character.setState(state);
        return this;
    }

    @Override
    public CharacterBuilder setAbility(CharacterAbility ability) {
        character.setAbility(ability);
        return this;
    }

    @Override
    public CharacterBuilder setCamp(String camp) {
        character.setCamp(camp);
        return this;
    }

    @Override
    public Character build() {
        return character;
    }
}
