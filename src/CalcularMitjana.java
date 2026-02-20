import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CalcularMitjana extends JFrame {

    public CalcularMitjana(ArrayList<HashMap<String, String>> llistaNotas) {
        this.setTitle("Calcular Mitjana");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setDefaultLookAndFeelDecorated(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Agrupar notes per asignatura: asignatura -> lista de notas
        LinkedHashMap<String, ArrayList<Double>> notesPorAsignatura = new LinkedHashMap<>();

        for (HashMap<String, String> entrada : llistaNotas) {
            String asignatura = entrada.get("asignatura");
            double nota = Double.parseDouble(entrada.get("nota"));

            notesPorAsignatura
                .computeIfAbsent(asignatura, k -> new ArrayList<>())
                .add(nota);
        }

        // Calcular i mostrar la mitjana per cada asignatura
        double sumaTotal = 0;
        int countTotal = 0;

        for (Map.Entry<String, ArrayList<Double>> entry : notesPorAsignatura.entrySet()) {
            String asignatura = entry.getKey();
            ArrayList<Double> notes = entry.getValue();

            double suma = 0;
            for (double n : notes) {
                suma += n;
            }
            double mitjana = suma / notes.size();
            sumaTotal += suma;
            countTotal += notes.size();

            JLabel lblAsignatura = new JLabel(
                asignatura + " (" + notes.size() + " notes): Mitjana = " + String.format("%.2f", mitjana)
            );
            lblAsignatura.setFont(new Font("SansSerif", Font.PLAIN, 16));
            lblAsignatura.setAlignmentX(Component.LEFT_ALIGNMENT);
            panel.add(lblAsignatura);
            panel.add(Box.createVerticalStrut(5));
        }

        // Mitjana global
        double mitjanaGlobal = sumaTotal / countTotal;

        panel.add(Box.createVerticalStrut(10));
        JSeparator separator = new JSeparator();
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        panel.add(separator);
        panel.add(Box.createVerticalStrut(10));

        JLabel lblGlobal = new JLabel("Mitjana Global: " + String.format("%.2f", mitjanaGlobal));
        lblGlobal.setFont(new Font("Serif", Font.BOLD, 20));
        lblGlobal.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(lblGlobal);

        // Mostrar aprovat o suspes
        String resultat = mitjanaGlobal >= 5 ? "APROVAT ✓" : "SUSPES ✗";
        Color colorResultat = mitjanaGlobal >= 5 ? new Color(0, 128, 0) : Color.RED;

        JLabel lblResultat = new JLabel(resultat);
        lblResultat.setFont(new Font("Serif", Font.BOLD, 22));
        lblResultat.setForeground(colorResultat);
        lblResultat.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(Box.createVerticalStrut(5));
        panel.add(lblResultat);

        this.add(panel);
        this.pack();
        this.setMinimumSize(new Dimension(350, 200));
        this.setVisible(true);
    }
}