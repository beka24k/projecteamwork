package Factory;

import Ability.CharacterAbility;
import Ability.FireMagick;
import Main.Character;
import State.AliveState;
import State.CharacterState;

public class MageFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        CharacterState state = new AliveState();
        CharacterAbility ability = new FireMagick();
        Character mage = new Character(name, state, ability);
        return mage;
    }
    public String getStr(){
        return "Mage";
    }
}
