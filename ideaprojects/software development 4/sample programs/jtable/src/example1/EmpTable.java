package example1;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class EmpTable extends JTable {
    public JScrollPane scrollPane = null;

    //Set the table height
    protected static final int tableHeight = 350;

    public EmpTable(Connection conn) throws SQLException {
        EmpTableModel tableModel = new EmpTableModel();
        this.setModel(tableModel);
        scrollPane = new JScrollPane(this);

        // Set the table width, depending upon the width of
        // the columns
        int tableWidth = 0;
        int columnCount = tableModel.columnModel.getColumnCount();
        for (int i = 0; i < columnCount; i++)
            tableWidth += tableModel.columnModel.getColumn(i).getWidth();

        scrollPane.setPreferredSize(new Dimension(tableWidth, tableHeight));
        scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED));

        // Get the data!
        tableModel.queryTableData(conn);
    }
}
