import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import Entity.Player;
import Factory.CharacterFactory;
import Factory.MageFactory;
import Factory.WarriorFactory;
import Factory.PriestFactory;
import Factory.BarbarianFactory;
import Main.Character;
import Main.GameWorld;
import State.AliveState;
import State.CharacterState;

public class GameGUI {
    private JFrame mainFrame;
    private JFrame gameFrame;
    private JPanel mainPanel;
    private JButton startButton;
    private Character character;
    private ImageIcon imagePLayers = null;
    private ImageIcon imageNPC = null;
    private int attackCount = 0;
    private JPanel gamePanel;
    private GameWorld gameWorld = new GameWorld();
    Player player = new Player(gameWorld, gameWorld.keyH, gameWorld.getPLayer());

    public GameGUI() {

        mainFrame = new JFrame("Игра RPG");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon(getClass().getResource("/icon.png"));
        mainFrame.setIconImage(icon.getImage());

        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon(getClass().getResource("/header.jpg"));
                background.paintIcon(this, g, 0, 0);
            }
        };
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));
        mainFrame.add(mainPanel);
        playSound("src/8 Bit RPG Game Music (Retro Chiptune) MP3 Download - Zelda Style.wav");
        playSound("src/interface-124464.wav");

        startButton = gameWorld.createStyledButton("Начать игру", Color.GREEN);
        mainPanel.add(startButton);


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createCharacter();
                openGameWindow();

            }
        });

        mainFrame.setSize(610, 343);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
    }


    private void createCharacter() {
        // Диалог для ввода имени персонажа
        String name = JOptionPane.showInputDialog(mainFrame, "Введите имя персонажа:");
        if (name == null || name.isEmpty()) {
            return;
        }

        // Выбор типа персонажа
        Object[] options = {"Воин", "Маг", "Варвар", "Жрец"};
        int characterType = JOptionPane.showOptionDialog(mainFrame, "Выберите тип персонажа:", "Выбор класса",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        CharacterFactory characterFactory = null;
        gameWorld.setPLayer(characterType);
        System.out.println(characterType);
        if (characterType == 0) {
            characterFactory = new WarriorFactory();
            imagePLayers = new ImageIcon(getClass().getResource("/warior.png"));


        } else if (characterType == 1) {
            characterFactory = new MageFactory();
            imagePLayers = new ImageIcon(getClass().getResource("/mage.png"));
        } else if (characterType == 2) {
            characterFactory = new BarbarianFactory();
            imagePLayers = new ImageIcon(getClass().getResource("/barbarian (1)photoAid-removed-background.png"));
        } else if (characterType == 3) {
            characterFactory = new PriestFactory();
            imagePLayers = new ImageIcon(getClass().getResource("/priest.png"));
        }
        if (characterFactory != null) {
            character = characterFactory.createCharacter(name);
            JOptionPane.showMessageDialog(mainFrame, "Персонаж " + character.getName() + " создан!");
        }
    }

    public static void playSound(String soundFilePath) {
        try {
            File soundFile = new File(soundFilePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);

            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private void openGameWindow() {
        mainFrame.setVisible(false); // Скрываем главное окно
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame = new JFrame("Игровое окно - " + character.getName());
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setTitle("Rpg Harem Game");

        gameFrame.add(gameWorld);

        gameFrame.pack();
        gameWorld.startGameThread();
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
        gameFrame.setResizable(true);
        JFrame buttonForPlay = new JFrame();
        JPanel panel = new JPanel();
        JButton attackButtonG = gameWorld.createStyledButton("Атака", Color.RED);
        panel.add(attackButtonG);

        JButton checkStateButtonG = gameWorld.createStyledButton("Состояние Монстра", Color.BLUE);
        panel.add(checkStateButtonG);
        JButton checkStateButtonG2 = gameWorld.createStyledButton("Состояние Персонажа", Color.BLUE);

        JTextField inputField = new JTextField(20);
        panel.add(inputField);

        JButton submitButton = gameWorld.createStyledButton("Поменять лагерь", Color.ORANGE);
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = inputField.getText();
                character.setCamp(userInput);
                System.out.println("User input: " + userInput);
            }
        });
        panel.add(checkStateButtonG2);
        attackButtonG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (character != null) {
                    character.performAction();
                    if (character.hitPoint == true) {
                        if (attackCount < 4) {
                            playSound("src/mixkit-exclamation-of-pain-from-a-zombie-2207.wav");
                        }
                        attackCount++;
                    }
                    // Обновление интерфейса с учетом урона
                    JOptionPane.showMessageDialog(gameFrame, "Урон: -25");
                    checkStateButtonG.setText("Состояние монстра (" + character.getHealth() + " HP, Урон: " + character.getDamage() + ")");

                    // Проверка на четыре атаки для смены картинки
                    if (attackCount == 4) {
                        playSound("src/mixkit-monster-demon-dark-ritual-voice-287.wav");
                        gameWorld.monster = new ImageIcon(getClass().getResource("/image-removebg-preview.png"));


                    } else if (attackCount == 5) {
                        gameWorld.monster = new ImageIcon(getClass().getResource("/image-removebg-preview3.png"));
                    }
                }
            }
        });

        checkStateButtonG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (character != null) {
                    character.checkState();
                }
            }
        });

        checkStateButtonG2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (character != null) {
                    System.out.println("(Y_Y)");
                }
            }
        });

        buttonForPlay.add(panel);
        buttonForPlay.setVisible(true);
        buttonForPlay.setSize(200, 200);

    }


    public static void main(String[] args) {
        new GameGUI();
    }


}
