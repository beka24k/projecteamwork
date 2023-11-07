package State;
public class DeadState implements  CharacterState{
    @Override
    public void change() {
        System.out.println("(X_X)");
    }
}
