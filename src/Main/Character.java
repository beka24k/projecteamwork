package Main;

import Ability.CharacterAbility;
import Comand.CharacterCommand;
import Observer.CharacterObserver;
import State.CharacterState;

import java.util.ArrayList;
import java.util.List;

public class Character implements CharacterObserver {
    private CharacterState state;
    private CharacterAbility ability;
    private String name;
    private List<CharacterObserver> observers = new ArrayList<CharacterObserver>();


    public void setAbility(CharacterAbility ability) {
        this.ability = ability;
    }

    public void setState(CharacterState state) {
        this.state = state;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String camp;

    public Character(){}

    public String getName() {
        return name;
    }

    public void setCamp(String camp) {
        this.camp = camp;
        notifyAllObservers();
    }

    public String getCamp() {
        return camp;
    }

    public Character(String name, CharacterState state, CharacterAbility ability) {
        this.name = name;
        this.state = state;
        this.ability = ability;

    }
    private CharacterCommand attackCommand;

    public void setAttackCommand(CharacterCommand attackCommand) {
        this.attackCommand = attackCommand;
    }
    public void performAttack() {
        if (attackCommand != null) {
            attackCommand.execute();
        }
    }
    public void performAction() {

        ability.performAbility();
        notifyAllObservers();
    }
    public void checkState(){
        state.change();
    }

    public void attach(CharacterObserver observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (CharacterObserver observer : observers) {
            observer.update();
        }
    }

    @Override
    public void update() {

    }
}
