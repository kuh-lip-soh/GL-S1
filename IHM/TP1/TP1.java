import javax.swing.*;

public class TP1 extends javax.swing.JFrame {
    public static void main(String[] args) {
        JFrame f = new JFrame();

        JButton b1 = new JButton("Ajouter");
        b1.setBounds(200, 400, 100, 40);
        JButton b2 = new JButton("Fermer");
        b2.setBounds(400, 400, 100, 40);

        f.add(b1);
        f.add(b2);

        f.setSize(600, 700);
        f.setLayout(null);
        f.setVisible(true);
    }
}