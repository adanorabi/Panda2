package FlatLafDesign;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class TableActionCellRender extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {
    private PanelAction action;
    private int clickedColumn = -1;

        private int row; // Add a field to store the row value
        public TableActionCellRender(TableActionEvent event) {
            this.row = row; // Assign the row value passed from the constructor
            action = new PanelAction();
            action.initViewEvent(event, row); // Initialize with the provided row for editing
            action.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JTable table = (JTable) e.getComponent().getParent();
                    int clickedRow = table.rowAtPoint(e.getPoint());
                    if (clickedRow >= 0 && clickedRow < table.getRowCount()) {
                        fireEditingStopped();
                        ((TableActionEvent) event).onView(clickedRow);
                    }
                }
            });
        }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (!isSelected && row % 2 == 0) {
            action.setBackground(Color.decode("#c2ffe9"));
        } else if (isSelected) {
            action.setBackground(Color.decode("#f8ccff"));
        } else if (row % 2 == 1) {
            action.setBackground(Color.WHITE);
        } else {
            action.setBackground(Color.decode("#c2ffe9"));
        }
        action.repaint();
        return action;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        action.setBackground(Color.decode("#ffffff")); // Change to your desired color when editing
        action.repaint();
        return action;
    }

    @Override
    public boolean stopCellEditing() {
        clickedColumn = -1;
        return super.stopCellEditing();
    }

    @Override
    public boolean isCellEditable(EventObject e) {
        return true;
    }
}
