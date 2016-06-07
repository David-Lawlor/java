package example1;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpTableModel extends AbstractTableModel {

    final static int LNAME = 0;
    final static int FNAME = 1;
    final static String[] columnNames = { "EmpFirstName", "EmpLastName" };

    private static ArrayList<Object> rows = new ArrayList();
    final static String sql = "SELECT empID, lastname, firstname FROM Employee ORDER BY lastname, firstname";

    DefaultTableColumnModel columnModel = new DefaultTableColumnModel();

    public EmpTableModel() {
        TableColumn col;

        for (int i = 0; i < columnNames.length; i++) {
            col = new TableColumn(i);
            col.setHeaderValue(columnNames[i]);
            col.setWidth(150);
            columnModel.addColumn(col);
        }
    }

    public void queryTableData(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            EmpRow row = new EmpRow(rs.getInt(1), rs.getString(2), rs.getString(3));
            rows.add(row);
        }
        rs.close();
        stmt.close();
        fireTableChanged(new TableModelEvent(this, -1, -1));
    }

    public int insertRow() {
        EmpRow row = new EmpRow();

        int rowNum = rows.size();
        rows.add(row);

        EmpDatabaseModifier.addToInsert(new ObjectToIntMap(row, rowNum));
        fireTableRowsInserted(rowNum, rowNum);

        return rowNum;
    }

    public void deleteRow(int rowNum) {
        if (rowNum >= 0) {
            EmpRow row = (EmpRow)rows.get(rowNum);

            if (row.Id == EmpRow.INSERTED)
                EmpDatabaseModifier.removeAddToInsert(rowNum);
            else
                EmpDatabaseModifier.addToDelete(row.Id);

            rows.remove(rowNum);
            EmpDatabaseModifier.changeRowNumbers(rowNum);
            fireTableRowsDeleted(rowNum, rowNum);
        }
    }

    public Object getValueAt(int rowNum, int colNum) {
        EmpRow row = (EmpRow)rows.get(rowNum);
        switch (colNum) {
            case LNAME:
                return row.EmpLastName;
            case FNAME:
                return row.EmpFirstName;
            default:
                return "";
        }
    }

    public void setValueAt(Object value, int rowNum, int colNum) {
        EmpRow row = (EmpRow)rows.get(rowNum);
        switch (colNum) {
            case LNAME:
                row.EmpLastName = (String)value;
                if (row.Id != EmpRow.INSERTED)
                    EmpDatabaseModifier.add2ELNUpdates(new ObjectToIntMap(value, row.Id));
                break;
            case FNAME:
                row.EmpFirstName = (String)value;
                if (row.Id != EmpRow.INSERTED)
                    EmpDatabaseModifier.add2EFNUpdates(new ObjectToIntMap(value, row.Id));
                break;
            default:
                break;
        }
    }

    public String getColumnName(int column) {
        if (columnNames[column] != null)
            return columnNames[column];
        else
            return "";
    }

    public boolean isCellEditable(int row, int column) {
        return true;
    }

    public Class getColumnClass(int column) {
        return String.class;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return rows.size();
    }
}
