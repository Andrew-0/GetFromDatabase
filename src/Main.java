import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class Main {
    public static void main(String[] args)
            throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        // Frame

        JFrame frame = new JFrame("Data");

        // Panel within frame

        JPanel panel = new JPanel();

        // Create sql connection

        Connection con = DriverManager.getConnection("" +
                "jdbc:sqlserver://s-kv-center-s64;" +
                "databaseName=PlanRC;" +
                "integratedSecurity=true"
                );

        PreparedStatement preparedStatement = con.prepareStatement("" +
                "select lagerid, fullname, productionType from planrc.._plt_tblagersclassification"
                );

        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getResultSet();

        ResultSetMetaData metaData = resultSet.getMetaData();

        final int numOfColumns = metaData.getColumnCount();

        Vector headers = new Vector();

        for (int i = 0; i < numOfColumns; i++) {
            headers.addElement(metaData.getColumnLabel(i + 1));
        }

        Vector rows = new Vector();

        while(resultSet.next()){

            Vector row = new Vector();

            for (int i = 0; i < numOfColumns; i++) {
                row.addElement(resultSet.getObject(i + 1));
            }

            rows.addElement(row);
        }

        con.close();

        // Table

        JTable table = new JTable(rows, headers);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

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
