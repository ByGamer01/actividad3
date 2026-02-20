import javax.swing.JFrame;
import javax.swing.JLabel;

public class CalcularMitjana {
    public CalcularMitjana(){
        this.setTitle("Calcular Mitjana");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200, 400);
        setLocationRelativeTo(null);
        setDefaultLookAndFeelDecorated(true);
        JLabel lblMostrarResultat = new JLabel("Calcular Mitjana");
        lblMostrarResultat.setText(nota);
        lblMostrarResultat.setHorizontalAlignment(JLabel.CENTER);
        lblMostrarResultat.setFont(new java.awt.Font("Serif", java.awt.Font.BOLD, 40)); //Canviam la font i el tamany de la lletra.
        this.add(lblMostrarResultat);
        this.setVisible(true);
    }
}
