package Factory;

import Ability.CharacterAbility;
import Ability.SwordAttack;
import Main.Character;
import State.AliveState;
import State.CharacterState;

public class BarbarianFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        CharacterState alive=new AliveState();
        CharacterAbility abil=new SwordAttack();
        Character chrc=new Character(name,alive,abil);
        return chrc;
    }
    public String getStr(){
        return "Barbarian";
    }
}
