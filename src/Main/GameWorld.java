package Main;

import Entity.Player;
import Main.KeyHandler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameWorld extends JPanel implements Runnable {
    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
   public  final int screenWidth = tileSize * maxScreenCol;
   public  final int screenHeight = tileSize * maxScreenRow;
    private Image bgImage;
    private JButton attackButtonG = createStyledButton("Атака", Color.RED);
    private JButton checkStateButtonG = createStyledButton("Состояние персонажа", Color.BLUE);

    public ImageIcon monster;
    private JLabel displified;

    int FPS = 60;
    public KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    private int i;
    Player player=new Player(this,keyH,4);
    int playerSpeed = 4;

    private List<Rectangle> walls;

    public GameWorld() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
        this.add(checkStateButtonG);
        this.add(attackButtonG);

        this.monster = new ImageIcon(getClass().getResource("/image-removebg-preview1.png"));
        this.displified = new JLabel(monster);
        this.bgImage = new ImageIcon(getClass().getResource("/2frame.png")).getImage();
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));

        // Initialize the list of walls
        walls = new ArrayList<>();
        walls.add(new Rectangle(200, 200, 100, 50)); // Example wall at (200, 200) with width 100 and height 50
    }

    public JButton createStyledButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 20));
        button.setBackground(color);
        button.setFocusPainted(false);
        return button;
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
public void setPLayer(int y){
    i=y;
     player = new Player(this, keyH,i);
}
public int getPLayer(){
        return i;
}
    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
                System.out.println("FPS" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        checkWallCollisions();
        player.update();
    }

    private void checkWallCollisions() {
        Rectangle playerBounds = player.getBounds();

        for (Rectangle wall : walls) {
            if (playerBounds.intersects(wall)) {
                player.stopMoving();
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);
        g.drawImage(monster.getImage(), 250, 300, this);
        Graphics2D g2 = (Graphics2D) g;
        player.draw(g2);
        g2.dispose();
    }
}
