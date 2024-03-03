package FlatLafDesign;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author RAVEN
 */
public class PanelAction extends javax.swing.JPanel {

    private JButton cmdView;

    /**
     * Creates new form PanelAction
     */
    public PanelAction() {
        initComponents();
    }

    public void initViewEvent(TableActionEvent event, int row) {
        cmdView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.onView(row);
            }
        });
    }

    private void initComponents() {
        
        cmdView = new FlatLafDesign.ActionButton();
        // Load the view icon and resize it
        ImageIcon icon = new ImageIcon(getClass().getResource("/View/img/view.png"));
        Image scaledIcon = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        cmdView.setIcon(new ImageIcon(scaledIcon)); // Set resized view icon

        add(cmdView);
    }
}
