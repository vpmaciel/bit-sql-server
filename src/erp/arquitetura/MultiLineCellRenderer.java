package erp.arquitetura;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {

    public MultiLineCellRenderer() {
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {

        setText(value == null ? "" : value.toString());

        setSize(table.getColumnModel().getColumn(column).getWidth(),
                Short.MAX_VALUE);

        int height = getPreferredSize().height;

        if (table.getRowHeight(row) != height) {
            table.setRowHeight(row, height);
        }

        return this;
    }
}