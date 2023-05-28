import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;

public class Main {
    public static void main(String[] args) {

        JFrame swing1 = new JFrame();

        swing1.setBounds(250,70,1600,900);
        swing1.setTitle("Probando la librería Swing en Java");
        //Bloqueamos redimensionamiento para evitar errores
        swing1.setResizable(false); 

        swing1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Menú
        JMenuBar Menu = new JMenuBar();

        JMenu menuArchivo = new JMenu("Archivo");
        JMenu menuAcciones = new JMenu("Acciones");
        JMenu menuAyuda = new JMenu("Ayuda");
        Menu.setBounds(20,20,170,40);
        Menu.add(menuArchivo);
        Menu.add(menuAcciones);
        Menu.add(menuAyuda);

        //Botones

        Button NuevaLiga = new Button();
        NuevaLiga.setLabel("Nueva Liga");
        NuevaLiga.setBounds(20,120,180,50);

        Button JugarLiga = new Button();
        JugarLiga.setLabel("Jugar Liga");
        JugarLiga.setBounds(20,220,180,50);

        Button SiguienteJornada = new Button();
        SiguienteJornada.setLabel("Siguiente jornada");
        SiguienteJornada.setBounds(20,320,180,50);
        SiguienteJornada.setEnabled(false);

        Button SimulacionCompleta = new Button();
        SimulacionCompleta.setLabel("Simulación completa");
        SimulacionCompleta.setBounds(20,420,180,50);
        SimulacionCompleta.setEnabled(false);

        Button Salir = new Button();
        Salir.setLabel("Salir");
        Salir.setBounds(20,670,180,50);

        //Tabla

        String[] campos = {"Nombre", "P. Jugados", "Victorias", "Empates", "Derrotas", "Puntos"};

        Object[][] datos = {
                {"Equipo1", "5", "5", "0", "0", "15"},
                {"Equipo2", "5", "4", "0", "1", "12"},
                {"Equipo3", "5", "3", "0", "2", "9"},
                {"Equipo4", "5", "2", "0", "3", "6"},
                {"Equipo5", "5", "1", "0", "4", "3"},
                {"Equipo6", "5", "0", "0", "5", "0"}};

        JTable tabla = new JTable(datos, campos);
        tabla.setBounds(500, 120, 600, 600);
        tabla.setRowHeight(100);

        JTableHeader cabecera = tabla.getTableHeader();
        cabecera.setBounds(500,80,600,40);
        tabla.setTableHeader(cabecera);   

        // Centramos los datos de la tabla
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        // Eliminamos el layout por defecto para poder especificar nosotros mismos las coordenadas

        swing1.setLayout(null);

        //Elementos empleados

        swing1.add(Menu);
        swing1.add(NuevaLiga);
        swing1.add(JugarLiga);
        swing1.add(SiguienteJornada);
        swing1.add(SimulacionCompleta);
        swing1.add(Salir);
        swing1.add(tabla);
        swing1.add(tabla.getTableHeader());
        swing1.setVisible(true);
    }
}