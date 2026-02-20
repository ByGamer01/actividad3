
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
    private JComboBox<String> txtAsignatura; // Atributos para poder usar en los botones
    private ArrayList<HashMap<String, String>> llistaNotas; // Asignaturas key-valor


    // Funcionalidad Afegir Nota: Permetre afegir una nota d’un estudiant.
    public AfegirNota() {
        llistaNotas = new ArrayList<>(); // Inicializamos el arraylist


        this.setTitle("Calculador de Notes");
        this.setLayout(new BorderLayout());
        this.setBackground(Color.CYAN);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setDefaultLookAndFeelDecorated(true);

        JPanel agregarNotas = new JPanel();
        this.add(agregarNotas);
        agregarNotas.setLayout(new FlowLayout()); // Este layout me gusta mucho usarlo, solamente si luego le pongo un this.pack(); o, pack();

        JLabel lblAsignaturas = new JLabel("Asignatura: ");
        txtAsignatura = new JComboBox<>( // Variable local eliminada, sino nunca se cambia su valor
                new String[] { "Matematicas", "Castellano", "Ingles", "Catalan" });

        agregarNotas.add(lblAsignaturas);
        agregarNotas.add(txtAsignatura);

        JLabel lblNotas = new JLabel("Nota: ");
        txtNotas = new JTextField(10);
        agregarNotas.add(lblNotas);
        agregarNotas.add(txtNotas);

        JButton botonAgregarNota = new JButton("Pulsa Aqui"); // Boton donde el usuario si presiona comienza la logica.
        agregarNotas.add(new JLabel());
        agregarNotas.add(botonAgregarNota);

        botonAgregarNota.addActionListener(this);

        this.pack();
        this.setVisible(true);
    }

    // Getter para que otras clases puedan acceder a la lista de notas
    public ArrayList<HashMap<String, String>> getLlistaNotas() {
        return llistaNotas;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String asignatura = (String) txtAsignatura.getSelectedItem(); // Obtenemos la asignatura elegida de nuestro combobox
        String notaText = txtNotas.getText().trim(); // Obtenemos la nota que ha puesto el usuario, y sin espacios

        if (notaText.isEmpty()) { // Si la string de las notas esta vacia, sale un aviso y/o error especificando que ponga una nota
            JOptionPane.showMessageDialog(this, "Introdueix una nota!", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Y regresa, porque sino se queda en iteración todo el rato
        }

        try {
            double nota = Double.parseDouble(notaText);

            if (nota < 0 || nota > 10) {
                JOptionPane.showMessageDialog(this, "La nota ha de ser entre 0 i 10.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            HashMap<String, String> entrada = new HashMap<>(); // HashMap debido a que lo utilizamos en otra actividad de Programacion; para juntar la asignatura con su bvalor
            entrada.put("asignatura", asignatura); // Introduccimos en el primer puesto, la asignatura y la que elija el usuario
            entrada.put("nota", String.valueOf(nota)); // la nota ira vinculada con la nota que haya introducido el usuario
            llistaNotas.add(entrada); // lo añadimos a la lista global (otro hashmap) valor = asignaturas ; key = notas

            JOptionPane.showMessageDialog(this,
                    "Nota afegida!\nAsignatura: " + asignatura + "\nNota: " + nota,
                    "Correcte", JOptionPane.INFORMATION_MESSAGE); // Mostramos un mensaje de que el usuario lo ha entregado con exito

            txtNotas.setText(""); // Y volvemos a resetear el valor del textfield

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La nota ha de ser un número vàlid.", "Error", JOptionPane.ERROR_MESSAGE);
        } // ponemos un catch por si hay errores, o por si el usuario pone una letra en vez de un numero, si es asi, se le pondra un 
    }
}