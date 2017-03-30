import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws SQLException {

        // Frame

        JFrame frame = new JFrame("Data");

        // Panel within frame

        JPanel panel = new JPanel();

        // Create sql connection



        // Table

        Vector<String> headers = new Vector<String>();

        headers.add("lagerid");

        headers.add("shortname");

        headers.add("productionType");

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        Vector<Object> vector = new Vector<Object>();

        data.add(vector);

        JTable table = new JTable(data, headers);

        // Put table to scrollpane which then put to panel

        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane, BorderLayout.CENTER);

        // Put panel to the frame

        frame.getContentPane().add(panel);

        // Visualize the frame

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();

        frame.setVisible(true);
    }

}
