package gui; /**
 * Created by Patricia on 17/02/2015.
 */
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import model.Student.Grade;

public class GradeRenderer extends JLabel implements TableCellRenderer
{

    public GradeRenderer()
    {
        super.setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column)
    {
        Grade grade = (Grade) value;
        if(grade == Grade.A) {
            super.setBackground(Color.GREEN);
        }
        else if(grade == Grade.B) {
            super.setBackground(Color.BLUE);
        }
        else if(grade == Grade.C) {
            super.setBackground(Color.RED);
        }

        return this;
    }

}
