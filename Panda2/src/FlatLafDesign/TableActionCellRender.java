package FlatLafDesign;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
//
//public class TableActionCellRender extends AbstractCellEditor implements TableCellRenderer, TableCellEditor {
//    private PanelAction action;
//    private int clickedColumn = -1;
//
//    public TableActionCellRender(TableActionEvent event) {
//        action = new PanelAction();
//        action.initViewEvent(event, -1); // Initialize with row -1 for editing
//        action.addMouseListener(new MouseAdapter() {
//        	@Override
//        	public void mouseClicked(MouseEvent e) {
//        	    Component source = (Component) e.getSource();
//        	    JTable table = (JTable) SwingUtilities.getAncestorOfClass(JTable.class, source);
//        	    if (table != null) {
//        	        int column = table.columnAtPoint(e.getPoint());
//        	        clickedColumn = column;
//        	        fireEditingStopped();
//        	    }
//        	}
//
//        });
//    }
//
//    @Override
//    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//        if (!isSelected && row % 2 == 0) {
//            action.setBackground(Color.decode("#c2ffe9"));
//        } else if (isSelected) {
//            action.setBackground(Color.decode("#f8ccff"));
//        } else if (row % 2 == 1) {
//            action.setBackground(Color.WHITE);
//        } else {
//            action.setBackground(Color.decode("#c2ffe9"));
//        }
//        action.repaint();
//        return action;
//    }
//
//    @Override
//    public Object getCellEditorValue() {
//        return null;
//    }
//
//    @Override
//    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//        action.setBackground(Color.decode("#f8ccff")); // Change to your desired color when editing
//        action.repaint();
//        return action;
//    }
//
//    @Override
//    public boolean stopCellEditing() {
//        clickedColumn = -1;
//        return super.stopCellEditing();
//    }
//
//    @Override
//    public boolean isCellEditable(EventObject e) {
//        return true;
//    }
//}

import FlatLafDesign.*;

public class TableActionCellRender extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSeleted, boolean bln1, int row, int column) {
        Component com = super.getTableCellRendererComponent(jtable, o, isSeleted, bln1, row, column);
        PanelAction action = new PanelAction();
        if (isSeleted == false && row % 2 == 0) {
            action.setBackground( Color.decode("#c2ffe9"));
        } else {
            action.setBackground(Color.WHITE);
        }
        return action;
    }
}
