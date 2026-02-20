
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AfegirNota extends JFrame implements ActionListener {
    private JLabel lblNotas;

    // Funcionalidad Afegir Nota: Permetre afegir una nota d’un estudiant.
    public AfegirNota() {
        this.setTitle("Calculador de Notes");
        this.setLayout(new BorderLayout());
        this.setBackground(Color.CYAN);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setDefaultLookAndFeelDecorated(true);

        JPanel agregarNotas = new JPanel();
        this.add(agregarNotas);
        agregarNotas.setLayout(new FlowLayout());

        JLabel lblAsignaturas = new JLabel("Asignatura: ");
        JComboBox<String> txtAsignatura = new JComboBox<>(
                new String[] { "Matematicas", "Castellano", "Ingles", "Catalan" });

        agregarNotas.add(lblAsignaturas);
        agregarNotas.add(txtAsignatura);

        JLabel lblNotas = new JLabel("Nota: ");
        JTextField txtNotas = new JTextField(10);
        agregarNotas.add(lblNotas);
        agregarNotas.add(txtNotas);

        JButton botonAgregarNota = new JButton("Pulsa Aqui"); // Boton donde el usuario si presiona comienza la logica.
        agregarNotas.add(new JLabel());
        agregarNotas.add(botonAgregarNota);

        botonAgregarNota.addActionListener(this);

        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    public static void main(String[] args) {
        new AfegirNota();
    }
}