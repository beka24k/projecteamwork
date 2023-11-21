package Comand;

import Main.Character;

public class AttackComand implements CharacterCommand {
    private Character character;

    public AttackComand(Character character) {
        this.character = character;
    }

    @Override
    public void execute() {
         character.hitPoint=false;
        character.performAction(); // Например, вызов метода атаки вашего персонажа
    }
}
