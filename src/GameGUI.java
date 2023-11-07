import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Factory.CharacterFactory;
import Factory.MageFactory;
import Factory.WarriorFactory;
import Factory.PriestFactory;
import Factory.BarbarianFactory;
import Main.Character;

public class GameGUI {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JButton startButton;
    private JButton attackButton;
    private JButton checkStateButton;

    private Character character;

    public GameGUI() {
        mainFrame = new JFrame("Игра RPG");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainFrame.add(mainPanel);

        startButton = new JButton("Начать игру");
        mainPanel.add(startButton, BorderLayout.CENTER);

        attackButton = new JButton("Атака");
        attackButton.setEnabled(false); // По умолчанию кнопка "Атака" отключена
        mainPanel.add(attackButton, BorderLayout.SOUTH);

        checkStateButton=new JButton("Состояние персонажа");
        checkStateButton.setEnabled(false);//По умолчанию кнопка "Состояние" отключена
        mainPanel.add(checkStateButton,BorderLayout.NORTH);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createCharacter();
            }
        });

        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (character != null) {
                    character.performAction();
                }
            }
        });
        checkStateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(character!=null){
                    character.checkState();
                }
            }
        });

        mainFrame.setSize(800, 600);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new GameGUI();
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

        if (characterType == 0) {
            characterFactory = new WarriorFactory();
        } else if (characterType == 1) {
            characterFactory = new MageFactory();
        } else if (characterType == 2) {
            characterFactory = new BarbarianFactory();
        } else if (characterType == 3) {
            characterFactory = new PriestFactory();
        }

        if (characterFactory != null) {
            character = characterFactory.createCharacter(name);
            attackButton.setEnabled(true); // Включаем кнопку "Атака" после создания персонажа
            checkStateButton.setEnabled(true);
            JOptionPane.showMessageDialog(mainFrame, "Персонаж " + character.getName() + " создан!");
        }
    }
}
