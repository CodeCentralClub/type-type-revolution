import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TTRGame extends Panel implements In{

    private Image offScreenImage;
    private Dimension offScreenSize;
    private Graphics offScreenGraphics;
    private Row1 field = new Row1(0, 0);

    private InputHandler inputHandler = new InputHandler(this)

    public static void main(String[] args) {
        Frame f = new Frame();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        TTRGame window = new TTRGame();
        window.setSize(1050, 650);
        f.add(window);
        f.pack();
        window.init();
        f.setSize(1050, 650);
        f.setVisible(true);
    }

    @Override
    protected void processKeyEvent(KeyEvent keyEvent) {
        super.processKeyEvent(keyEvent);
        inputHandler.
    }

    @Override
    public boolean keyDown(Event e, int key) {
        return InputHandler.onKeyChange(e, key, true);
    }

    @Override
    public boolean keyUp(Event e, int key) {
        return InputHandler.onKeyChange(e, key, false);
    }

    @Override
    public void update(Graphics g) {
        Dimension d = getSize();
        if ((offScreenImage == null) || (d.width != offScreenSize.width) || (d.height != offScreenSize.height)) {
            offScreenImage = createImage(d.width, d.height);
            offScreenSize = d;
            offScreenGraphics = offScreenImage.getGraphics();
        }
        offScreenGraphics.clearRect(0, 0, d.width, d.height);
        paint(offScreenGraphics);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        field.draw(g);
        field.generateLetters();
        try {
            Thread.sleep(4);
        } catch (Exception ignored) {
            // TODO: 11/6/17 Handle thread error properly
        }
        repaint();
    }

    public void init() {
        requestFocus();

    }

    public static class Letter {
        private Image pic;
        int x;
        private int y;
        private int xd = -3;
        private int speedTimer = 0;
        private String value = "";
        int charValue;
        private Font leFont = new Font("TimesRoman", Font.BOLD, 90);


        public Letter(int x, int y, String letter) {
            this.x = x;
            this.y = y;
            value = letter;
            charValue = (int) (letter.charAt(0));
            try {
                pic = ImageIO.read(getClass().getResource(letter));
            } catch (Exception e) {
            }
        }

        public void draw(Graphics g) {
            g.setFont(leFont);
            g.drawString("" + (char) charValue, x, y + 60);
            move();
        }

        public void move() {
            x += xd;

            if (speedTimer <= 3050) {
                speedTimer++;
            }
            if (speedTimer >= 1000) {
                xd = -4;
            }
            if (speedTimer >= 2000) {
                xd = -5;
            }
            if (speedTimer >= 3000) {
                xd = -6;
            }
        }
    }

    public static class Row1 {
        private List<Letter> listofLetters = new ArrayList<>();
        private int x;
        private int y;
        private int exitTimer = 0;
        private Color t = new Color(115, 142, 172);
        private int score = 0;
        private Font myFont = new Font("TimesRoman", Font.BOLD, 20);
        int lives = 3;
        private int exciteA = 0;

        public Row1(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void draw(Graphics g) {
            exitTimer--;

            g.setColor(new Color(0, 0, 0));
            g.setFont(myFont);
            g.drawString("" + score, x + 350, y + 36);
            g.drawString("Type Type Revolution", x + 650, y + 36);

            g.setColor(t);
            g.fillRect(x, y + 59, 1285, 60);
            g.setColor(Color.black);
            g.fillRect(60, 59, 7, 60);
            g.fillRect(300, 59, 7, 60);
            g.setColor(t);
            g.fillRect(x, y + 178, 1285, 60);
            g.setColor(Color.black);
            g.fillRect(60, 178, 7, 60);
            g.fillRect(300, 178, 7, 60);
            g.setColor(t);
            g.fillRect(x, y + 297, 1285, 60);
            g.setColor(Color.black);
            g.fillRect(60, 297, 7, 60);
            g.fillRect(300, 297, 7, 60);
            g.setColor(t);
            g.fillRect(x, y + 416, 1285, 60);
            g.setColor(new Color(0, 0, 0));
            g.fillRect(60, 416, 7, 60);
            g.fillRect(300, 416, 7, 60);
            g.setColor(t);
            g.fillRect(x, y + 535, 1285, 60);
            g.setColor(new Color(0, 0, 0));
            g.fillRect(60, 535, 7, 60);
            g.fillRect(300, 535, 7, 60);
            g.setColor(t);
            g.fillRect(x, y + 654, 1285, 60);
            g.setColor(new Color(0, 0, 0));
            g.fillRect(60, 654, 7, 60);
            g.fillRect(300, 654, 7, 60);
            g.setColor(t);
            g.fillRect(x, y + 773, 1285, 60);
            g.setColor(new Color(0, 0, 0));
            g.fillRect(60, 773, 7, 60);
            g.fillRect(300, 773, 7, 60);
            g.setColor(t);
            g.fillRect(x, y + 892, 1285, 60);
            g.setColor(new Color(0, 0, 0));
            g.fillRect(60, 892, 7, 60);
            g.fillRect(300, 892, 7, 60);


            for (int a = 0; a < listofLetters.size(); a++) {
                listofLetters.get(a).draw(g);
                listofLetters.get(a).move();
                if (listofLetters.get(a).x <= -60) {
                    lives--;
                    listofLetters.remove(a--);
                    continue;
                }

                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.A && exciteA == 0) {
                        score++;
                        exciteA = 0;
                        listofLetters.remove(a--);
                        continue;
                    }
                }

                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.B) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }

                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.C) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }
                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.D) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }
                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.E) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }
                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.F) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }
                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.G) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }
                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.H) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }
                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.I) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }
                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.J) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }
                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.K) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }
                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.L) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }
                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.M) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }
                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.N) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }
                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.O) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }
                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.P) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }
                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.Q) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }
                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.R) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }
                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.S) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }
                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.T) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }
                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.U) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }
                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.V) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }
                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.W) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }
                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.X) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }
                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.Y) {
                        score++;
                        listofLetters.remove(a--);
                        continue;
                    }
                }
                if (listofLetters.get(a).x < 300 && key(listofLetters.get(a).charValue)) {
                    if (InputHandler.Z)
                        score++;
                    listofLetters.remove(a--);
                    continue;
                }
            }

        }

        public boolean key(int i) {

            if (InputHandler.A && i == 65)
                return true;

            if (InputHandler.B && i == 66)
                return true;

            if (InputHandler.C && i == 67)
                return true;

            if (InputHandler.D && i == 68)
                return true;

            if (InputHandler.E && i == 69)
                return true;

            if (InputHandler.F && i == 70)
                return true;

            if (InputHandler.G && i == 71)
                return true;

            if (InputHandler.H && i == 72)
                return true;

            if (InputHandler.I && i == 73)
                return true;

            if (InputHandler.J && i == 74)
                return true;

            if (InputHandler.K && i == 75)
                return true;

            if (InputHandler.L && i == 76)
                return true;

            if (InputHandler.M && i == 77)
                return true;

            if (InputHandler.N && i == 78)
                return true;

            if (InputHandler.O && i == 79)
                return true;

            if (InputHandler.P && i == 80)
                return true;

            if (InputHandler.Q && i == 81)
                return true;

            if (InputHandler.R && i == 82)
                return true;

            if (InputHandler.S && i == 83)
                return true;

            if (InputHandler.T && i == 84)
                return true;

            if (InputHandler.U && i == 85)
                return true;

            if (InputHandler.V && i == 86)
                return true;

            if (InputHandler.W && i == 87)
                return true;

            if (InputHandler.X && i == 88)
                return true;

            if (InputHandler.Y && i == 89)
                return true;

            if (InputHandler.Z && i == 90)
                return true;

            return false;
        }

        public void generateLetters() {
            if (exitTimer < 0) {
                char rnd = (char) (Math.random() * 1 + 65);

                String f = "" + rnd + "_key.png";

                int rnd2 = (int) (Math.random() * 9);

                if (rnd2 == 1)
                    listofLetters.add(new Letter(x + 1285, y + 59, f));
                exitTimer = 30;
                if (rnd2 == 2)
                    listofLetters.add(new Letter(x + 1285, y + 178, f));
                exitTimer = 30;
                if (rnd2 == 3)
                    listofLetters.add(new Letter(x + 1285, y + 297, f));
                exitTimer = 30;
                if (rnd2 == 4)
                    listofLetters.add(new Letter(x + 1285, y + 416, f));
                exitTimer = 30;
                if (rnd2 == 5)
                    listofLetters.add(new Letter(x + 1285, y + 535, f));
                exitTimer = 30;
                if (rnd2 == 6)
                    listofLetters.add(new Letter(x + 1285, y + 654, f));
                exitTimer = 30;
                if (rnd2 == 7)
                    listofLetters.add(new Letter(x + 1285, y + 773, f));
                exitTimer = 50;
                if (rnd2 == 8)
                    listofLetters.add(new Letter(x + 1285, y + 892, f));
                exitTimer = 50;
            }
        }
    }
}
