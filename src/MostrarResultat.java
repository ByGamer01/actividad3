import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MostrarResultat extends JFrame implements ActionListener{
    private String assinatura = "";
    private String nota = "";
    public MostrarResultat() {
        this.setTitle("Mostrar Resultat");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200, 400);
        setLocationRelativeTo(null);
        setDefaultLookAndFeelDecorated(true);
        JLabel lblMostrarResultat = new JLabel("Mostrar Resultat");
        lblMostrarResultat.setText(nota);
        lblMostrarResultat.setHorizontalAlignment(JLabel.CENTER);
        lblMostrarResultat.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 40)); //Canviam la font i el tamany de la lletra.
        this.add(lblMostrarResultat);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new AfegirNota();
    }

}
