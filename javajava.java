// おみくじプログラム

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class javajava extends JFrame {

    public Image im;
    private JButton bt;
    int num;
    int checkmun = 0;
    int result = 0;

    public static void main(String[] args) {
        javajava f = new javajava();
    }

    public javajava() {
        super("javajava");

        bt = new JButton("おみくじ");
        add(bt, BorderLayout.NORTH);

        bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Anime().start();
            }
        });

        setSize(600, 1000);
        setVisible(true);

    }

    class Anime extends Thread {
        public void run() {
            try {
                result = new Random().nextInt(6);
                for (int i = 0; i <= 14;i++) {
                    num = i;
                    repaint();
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                System.out.println("おみくじを引くのをやめました");
            }
        }
    }

    public void paint(Graphics g) {
        Toolkit tk = getToolkit();
        if(num == 1){
            g.setColor(Color.white);
            g.fillRect( 0,57, 600,1000 );
        }
        im = tk.getImage("omikuzi_" + num + ".png");
        g.drawImage(im, -80, 100, this);
        if (num == 14) {
            switch(result){
                case 0:
                    g.drawImage(tk.getImage("daikiti.png"), 50, 50, this);;
                    break;
                case 1:
                    g.drawImage(tk.getImage("kiti.png"), 50, 50, this);
                    break;
                case 2:
                    g.drawImage(tk.getImage("suekiti.png"), 50, 50, this);
                    break;
                case 3:
                    g.drawImage(tk.getImage("syoukiti.png"), 50, 50, this);
                    break;
                case 4:
                    g.drawImage(tk.getImage("tyuukiti.png"), 50, 50, this);
                    break;
                case 5:
                    g.drawImage(tk.getImage("kyou.png"), 50, 50, this);
                    break;
                default:
                    g.drawImage(tk.getImage("daikyou.png"), 50, 50, this);
                    break;
            }
        }
    }

    class SampleWindowListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}