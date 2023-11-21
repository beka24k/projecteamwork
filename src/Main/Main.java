package Main;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        JFrame window =new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("RPG Harem Game");

        GameWorld gameWorld =new GameWorld();
        window.add(gameWorld);

        window.pack();
        gameWorld.startGameThread();
        window.setLocationRelativeTo(null);
        window.setVisible(true);


    }
}
