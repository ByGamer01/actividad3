import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

public class AfegirNota extends JFrame implements ActionListener {
    private JTextField txtNotas;
    private JComboBox<String> txtAsignatura;
    private ArrayList<HashMap<String, String>> llistaNotas;

    public AfegirNota() {
        llistaNotas = new ArrayList<>(); // FIX: inicializar la lista

        this.setTitle("Calculador de Notes - Afegir Nota");
        this.setLayout(new BorderLayout());
        this.setBackground(Color.CYAN);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setDefaultLookAndFeelDecorated(true);

        JPanel agregarNotas = new JPanel();
        this.add(agregarNotas);
        agregarNotas.setLayout(new FlowLayout());

        JLabel lblAsignaturas = new JLabel("Asignatura: ");
        // FIX: asignar al atributo de clase, no a una variable local
        txtAsignatura = new JComboBox<>(
                new String[] { "Matematiques", "Castella", "Angles", "Catala" });

        agregarNotas.add(lblAsignaturas);
        agregarNotas.add(txtAsignatura);

        JLabel lblNotas = new JLabel("Nota: ");
        txtNotas = new JTextField(10);
        agregarNotas.add(lblNotas);
        agregarNotas.add(txtNotas);

        JButton botonAgregarNota = new JButton("Afegir Nota");
        agregarNotas.add(botonAgregarNota);
        botonAgregarNota.addActionListener(this);

        JButton botonCalcular = new JButton("Calcular Mitjana");
        agregarNotas.add(botonCalcular);
        botonCalcular.addActionListener(e -> {
            if (llistaNotas.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No hi ha notes per calcular!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                new CalcularMitjana(llistaNotas);
            }
        });

        this.pack();
        this.setVisible(true);
    }

    // Getter para que otras clases puedan acceder a la lista de notas
    public ArrayList<HashMap<String, String>> getLlistaNotas() {
        return llistaNotas;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String asignatura = (String) txtAsignatura.getSelectedItem();
        String notaText = txtNotas.getText().trim();

        if (notaText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introdueix una nota!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double nota = Double.parseDouble(notaText);

            if (nota < 0 || nota > 10) {
                JOptionPane.showMessageDialog(this, "La nota ha de ser entre 0 i 10.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            HashMap<String, String> entrada = new HashMap<>();
            entrada.put("asignatura", asignatura);
            entrada.put("nota", String.valueOf(nota));
            llistaNotas.add(entrada);

            JOptionPane.showMessageDialog(this,
                    "Nota afegida!\nAsignatura: " + asignatura + "\nNota: " + nota,
                    "Correcte", JOptionPane.INFORMATION_MESSAGE);

            txtNotas.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La nota ha de ser un numero valid.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}