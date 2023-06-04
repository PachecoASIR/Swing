import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {
    public static void main(String[] args) {

        JFrame swing1 = new JFrame();

        swing1.setBounds(250,70,1600,900);
        swing1.setTitle("Probando la librería Swing en Java");
        swing1.setResizable(false);
        swing1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Menú
        JMenuBar menuBar = new JMenuBar();

        JMenu menuArchivo = new JMenu("Archivo");
        JMenu menuAcciones = new JMenu("Acciones");
        JMenu menuAyuda = new JMenu("Ayuda");
        JMenu menuCatalogo = new JMenu("Catalogo");

        JMenuItem menuItemVersion = new JMenuItem("Versión");
        JMenuItem menuItemAcercaDe = new JMenuItem("Acerca de");

        menuItemVersion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Versión del programa: 1.0");
            }
        });

        menuItemAcercaDe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Este programa realiza simulaciones de ligas deportivas.");
            }
        });

        menuAyuda.add(menuItemVersion);
        menuAyuda.add(menuItemAcercaDe);

        menuBar.add(menuArchivo);
        menuBar.add(menuAcciones);
        menuBar.add(menuAyuda);
        menuBar.add(menuCatalogo);

        //Botones
        Button NuevaLiga = new Button();
        NuevaLiga.setLabel("Nueva Liga");
        NuevaLiga.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Creando una nueva liga");
            }
        });

        Button JugarLiga = new Button();
        JugarLiga.setLabel("Jugar Liga");
        JugarLiga.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                // No se implementa en este caso
            }
            public void mousePressed(MouseEvent e) {
                // No se implementa en este caso
            }
            public void mouseReleased(MouseEvent e) {
                // No se implementa en este caso
            }
            public void mouseEntered(MouseEvent e) {
                System.out.println("Al hacer click en este botón se simulará una liga al completo");
            }
            public void mouseExited(MouseEvent e) {
                // No se implementa en este caso
            }
        });

        Button SiguienteJornada = new Button();
        SiguienteJornada.setLabel("Siguiente jornada");
        SiguienteJornada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Se va a proceder a simular una jornada");
            }
        });

        Button SimulacionCompleta = new Button();
        SimulacionCompleta.setLabel("Simulación completa");
        SimulacionCompleta.setEnabled(false);

        Button Salir = new Button();
        Salir.setLabel("Salir");
        Salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //Tabla
        String[] campos = {"Nombre", "P. Jugados", "Victorias", "Empates", "Derrotas", "Puntos"};

        Object[][] datos = {
                {"Equipo1", "5", "5", "0", "0", "15"},
                {"Equipo2", "5", "4", "0", "1", "12"},
                {"Equipo3", "5", "3", "0", "2", "9"},
                {"Equipo4", "5", "2", "0", "3", "6"},
                {"Equipo5", "5", "1", "0", "4", "3"},
                {"Equipo6", "5", "0", "0", "5", "0"}
        };

        JTable tabla = new JTable(datos, campos);
        tabla.setRowHeight(100);

        // Panel para los botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 1, 0, 10));
        panelBotones.add(NuevaLiga);
        panelBotones.add(JugarLiga);
        panelBotones.add(SiguienteJornada);
        panelBotones.add(SimulacionCompleta);

        // Panel principal con BorderLayout
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(menuBar, BorderLayout.NORTH);
        panelPrincipal.add(panelBotones, BorderLayout.WEST);
        panelPrincipal.add(new JScrollPane(tabla), BorderLayout.CENTER);
        panelPrincipal.add(Salir, BorderLayout.SOUTH);

        // Centramos los datos de la tabla
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        swing1.add(panelPrincipal);
        swing1.setVisible(true);
    }
}