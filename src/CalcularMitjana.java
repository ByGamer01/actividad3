import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Event;
import java.awt.event.ActionEvent;
public class CalcularMitjana extends JPanel implements ActionListener{
    public CalcularMitjana(){
        this.setTitle("Calcular Mitjana");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setDefaultLookAndFeelDecorated(true);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
