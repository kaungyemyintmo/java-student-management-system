/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CA2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
// import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
// imported javaswingx autocomplete library

/**
 *
 * @author KAUNG YE MYINT MO 
 * Class : DIT/FT/2A/01
 * Adm No : P2340250
 */
public class StudentSearchTableView extends javax.swing.JFrame {

    Controller controller;
    StudentSearchTableView studentSearchTableView;

    /**
     * Creates new form StudentSearchTable
     *
     */
    // =========================== 
    // Constructor
    // =========================== 
    public StudentSearchTableView() {
        initComponents();
        createSearchTypeButtonGroup();
        createSortTypeButtonGroup();

        ComboBox.setEditable(true);
        // imported javaswingx autocomplete library for ComboBox
      //  AutoCompleteDecorator.decorate(ComboBox);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    // =========================== 
    // create radio button group for search type - diploma , module
    // =========================== 
    private void createSearchTypeButtonGroup() {
        JPanel panel = PanelForSearch;
        panel.removeAll();

        ButtonGroup group = new ButtonGroup();
        group.add(RadioButtonForDiplomaSearch);
        group.add(RadioButtonForModuleSearch);

        panel.add(RadioButtonForDiplomaSearch);
        panel.add(RadioButtonForModuleSearch);

        panel.revalidate();
        panel.repaint();
    }

    // =========================== 
    // create radio button group for sort type 
    // - ascending, descending 
    // =========================== 
    private void createSortTypeButtonGroup() {
        
        // get parent panel
        JPanel panel = PanelForSortType;
        
        // remove all contents
        panel.removeAll();

        // create new button group
        ButtonGroup group = new ButtonGroup();
        
        // add buttons to group 
        group.add(RadioButtonForAscendingSort);
        group.add(RadioButtonForDescedingSort);
        
        // add buttons to panel 
        panel.add(RadioButtonForAscendingSort);
        panel.add(RadioButtonForDescedingSort);
        
        // repaint panel
        panel.revalidate();
        panel.repaint();
    }

    // =========================== 
    // update available options under JComboBox 
    // according to the search radio button
    // =========================== 
    public void updateComboItems(List<String> items) {
        // create new ComboBoxModel
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        
        // add elements
        for (String item : items) {
            model.addElement(item);
        }

        // set model 
        ComboBox.setModel(model);
        
        // set default selected value 
        ComboBox.setSelectedIndex(0);
    }

    // =========================== 
    // check the selected radio button, get list of available options
    // and update the ComboBox
    // =========================== 
    public void addRadioListener() {
        ActionListener radioButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filterType = RadioButtonForDiplomaSearch.isSelected() ? "diploma"
                        : RadioButtonForModuleSearch.isSelected() ? "module" : "none";

                switch (filterType) {
                    case "diploma" ->
                        controller.handleDiplomaSearchListForCombo();
                    case "module" ->
                        controller.handleModuleSearchListForCombo();
                }
            }
        };
    }

    // =========================== 
    // clear the data in the table and add more empty rows for visual purposes 
    // =========================== 
    public void clearTableData() {
        DefaultTableModel model = (DefaultTableModel) TableForStudentSearch.getModel();
        model.setRowCount(0);
        for (int i = 0; i < 25; i++) {
            model.addRow(new Object[]{""});
        }
        TableForStudentSearch.setModel(model);
        TableForStudentSearch.revalidate();
        TableForStudentSearch.repaint();
    }

    // =========================== 
    // to update table according to the result 
    // - search List according to diploma
    // =========================== 
    public void updateDiplomaListTable(List<Student> students) {

        DefaultTableModel model = (DefaultTableModel) TableForStudentSearch.getModel();
        double studentGpa = 0.0;
        String studentGpaStr = "";
        try {
            model.setRowCount(0);
            for (int i = 0, j = 1; i < students.size() && j <= students.size(); i++, j++) {
                studentGpa = students.get(i).getStudentGPA();
                studentGpaStr = String.format("%.2f", studentGpa);

                model.addRow(new Object[]{
                    j,
                    students.get(i).getStudentName(),
                    students.get(i).getAdminNumber(),
                    students.get(i).getClassName(),
                    studentGpaStr});
            }
            // add more empty rows for visual purposes 
            if (students.size() < 25) {
                for (int y = 0; y < 15 - students.size(); y++) {
                    model.addRow(new Object[]{""});
                }
            }
            TableForStudentSearch.setModel(model);
            TableForStudentSearch.revalidate();
            TableForStudentSearch.repaint();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("error in table view : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("error 2");

            e.printStackTrace();
        }
    }

    // =========================== 
    // set table columns for modules
    // =========================== 
    public void setTableForModule() {

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("No");
        model.addColumn("Name");
        model.addColumn("Admin");
        model.addColumn("Class");
        model.addColumn("Module Code");
        model.addColumn("Module Mark");

        model.setRowCount(25);
        TableForStudentSearch.setModel(model);
        TableForStudentSearch.revalidate();
        TableForStudentSearch.repaint();
    }
    // ===========================
    // set table columns for diploma
    // =========================== 

    public void setTableForDiploma() {

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("No");
        model.addColumn("Name");
        model.addColumn("Admin");
        model.addColumn("Class");
        model.addColumn("GPA");
        model.setRowCount(25);

        TableForStudentSearch.setModel(model);
        TableForStudentSearch.revalidate();
        TableForStudentSearch.repaint();
    }
    // =========================== 
    // update the table using the data received - search list using Module
    // =========================== 

    public void updateStudentModuleListTable(String filter, List<Student> students) {

        int studentMarks = 0;
        String studentMarksStr = "";
        String modCode = "";
        DefaultTableModel model = (DefaultTableModel) TableForStudentSearch.getModel();

        try {
            model.setRowCount(0);
            for (int i = 0, j = 1; i < students.size() && j <= students.size(); i++, j++) {
                modCode = students.get(i).getStudentModules().stream()
                        .filter(module -> module.getModuleCode().equals(filter))
                        .findAny()
                        .map(Module::getModuleCode)
                        .orElse("");
                studentMarks = students.get(i).getStudentModules().stream()
                        .filter(module -> module.getModuleCode().equals(filter))
                        .findAny()
                        .map(Module::getStudentMarks)
                        .orElse(-1);

                studentMarksStr = String.valueOf(studentMarks);
                model.addRow(new Object[]{
                    j,
                    students.get(i).getStudentName(),
                    students.get(i).getAdminNumber(),
                    students.get(i).getClassName(),
                    modCode,
                    studentMarksStr});
            }
            if (students.size() < 25) {
                for (int y = 0; y < 15 - students.size(); y++) {
                    model.addRow(new Object[]{""});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        BackButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        PanelForSearch = new javax.swing.JPanel();
        RadioButtonForDiplomaSearch = new javax.swing.JRadioButton();
        RadioButtonForModuleSearch = new javax.swing.JRadioButton();
        ButtonToSearchStudentList = new javax.swing.JButton();
        PanelForSearchBar = new javax.swing.JPanel();
        PanelForSortType = new javax.swing.JPanel();
        RadioButtonForDescedingSort = new javax.swing.JRadioButton();
        RadioButtonForAscendingSort = new javax.swing.JRadioButton();
        PanelForJComboBox = new javax.swing.JPanel();
        ComboBox = new javax.swing.JComboBox<>();
        ScrollPaneForStudentSearch = new javax.swing.JScrollPane();
        TableForStudentSearch = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(900, 600));

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        BackButton.setBackground(new java.awt.Color(222, 222, 255));
        BackButton.setForeground(new java.awt.Color(0, 0, 255));
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel2.add(BackButton, gridBagConstraints);

        jPanel1.setBackground(new java.awt.Color(223, 238, 252));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel4.setBackground(new java.awt.Color(223, 238, 252));
        jPanel4.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), null));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        PanelForSearch.setBackground(new java.awt.Color(223, 238, 252));

        RadioButtonForDiplomaSearch.setBackground(new java.awt.Color(223, 238, 252));
        RadioButtonForDiplomaSearch.setText("Search By Diploma");
        RadioButtonForDiplomaSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonForDiplomaSearchActionPerformed(evt);
            }
        });
        PanelForSearch.add(RadioButtonForDiplomaSearch);

        RadioButtonForModuleSearch.setBackground(new java.awt.Color(223, 238, 252));
        RadioButtonForModuleSearch.setText("Search By Module");
        RadioButtonForModuleSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonForModuleSearchActionPerformed(evt);
            }
        });
        PanelForSearch.add(RadioButtonForModuleSearch);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel4.add(PanelForSearch, gridBagConstraints);

        ButtonToSearchStudentList.setBackground(new java.awt.Color(222, 222, 255));
        ButtonToSearchStudentList.setForeground(new java.awt.Color(0, 0, 255));
        ButtonToSearchStudentList.setText("Search");
        ButtonToSearchStudentList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonToSearchStudentListActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 10;
        jPanel4.add(ButtonToSearchStudentList, gridBagConstraints);

        jPanel1.add(jPanel4);

        PanelForSearchBar.setBackground(new java.awt.Color(223, 238, 252));
        PanelForSearchBar.setLayout(new java.awt.GridBagLayout());

        PanelForSortType.setBackground(new java.awt.Color(223, 238, 252));
        PanelForSortType.setLayout(new javax.swing.BoxLayout(PanelForSortType, javax.swing.BoxLayout.Y_AXIS));

        RadioButtonForDescedingSort.setBackground(new java.awt.Color(223, 238, 252));
        RadioButtonForDescedingSort.setText("Descending");
        RadioButtonForDescedingSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonForDescedingSortActionPerformed(evt);
            }
        });
        PanelForSortType.add(RadioButtonForDescedingSort);

        RadioButtonForAscendingSort.setBackground(new java.awt.Color(223, 238, 252));
        RadioButtonForAscendingSort.setText("Ascending");
        PanelForSortType.add(RadioButtonForAscendingSort);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 10;
        PanelForSearchBar.add(PanelForSortType, gridBagConstraints);

        PanelForJComboBox.setBackground(new java.awt.Color(223, 238, 252));

        ComboBox.setEditable(true);
        ComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ComboBox.setMinimumSize(new java.awt.Dimension(250, 50));
        ComboBox.setPreferredSize(new java.awt.Dimension(250, 50));
        ComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboBoxItemStateChanged(evt);
            }
        });
        ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxActionPerformed(evt);
            }
        });
        PanelForJComboBox.add(ComboBox);

        PanelForSearchBar.add(PanelForJComboBox, new java.awt.GridBagConstraints());

        jPanel1.add(PanelForSearchBar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel2.add(jPanel1, gridBagConstraints);

        jPanel3.add(jPanel2);

        TableForStudentSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Name", "Admin", "Class", "GPA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableForStudentSearch.setEnabled(false);
        TableForStudentSearch.getTableHeader().setResizingAllowed(false);
        TableForStudentSearch.getTableHeader().setReorderingAllowed(false);
        ScrollPaneForStudentSearch.setViewportView(TableForStudentSearch);
        if (TableForStudentSearch.getColumnModel().getColumnCount() > 0) {
            TableForStudentSearch.getColumnModel().getColumn(0).setResizable(false);
            TableForStudentSearch.getColumnModel().getColumn(1).setResizable(false);
            TableForStudentSearch.getColumnModel().getColumn(2).setResizable(false);
            TableForStudentSearch.getColumnModel().getColumn(3).setResizable(false);
            TableForStudentSearch.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel3.add(ScrollPaneForStudentSearch);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxActionPerformed

    private void RadioButtonForDescedingSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonForDescedingSortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioButtonForDescedingSortActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        View view = new View();
        Model model = new Model(view);
        FileIOModel fileIOModel = new FileIOModel();

        Controller controller = new Controller(model, fileIOModel, view, this.studentSearchTableView);
        view.setVisible(true);
        view.setController(controller);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void ButtonToSearchStudentListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonToSearchStudentListActionPerformed
        // TODO add your handling code here:

        // get selected value from ComboBox
        String filter = String.valueOf(ComboBox.getSelectedItem());

        List<Student> studentList = new ArrayList<>();

        String sortType = RadioButtonForAscendingSort.isSelected() ? "ascending"
                : RadioButtonForDescedingSort.isSelected() ? "descending"
                : "none";

        String filterType = RadioButtonForDiplomaSearch.isSelected() ? "diploma"
                : RadioButtonForModuleSearch.isSelected() ? "module" : "none";

        switch (filterType) {
            case "diploma" -> {
                controller.handleStudentDiplomaSearch(sortType, filter);
            }
            case "module" -> {
                controller.handleStudentModuleSearch(sortType, filter);
            }
            case "none" -> {
                JOptionPane.showMessageDialog(
                        null,
                        "Please select search type - diploma or module.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_ButtonToSearchStudentListActionPerformed

    private void RadioButtonForDiplomaSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonForDiplomaSearchActionPerformed
        // TODO add your handling code here:
        controller.handleDiplomaSearchListForCombo();
    }//GEN-LAST:event_RadioButtonForDiplomaSearchActionPerformed

    private void RadioButtonForModuleSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonForModuleSearchActionPerformed
        // TODO add your handling code here:
        controller.handleModuleSearchListForCombo();
    }//GEN-LAST:event_RadioButtonForModuleSearchActionPerformed

    private void ComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentSearchTableView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentSearchTableView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentSearchTableView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentSearchTableView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentSearchTableView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton ButtonToSearchStudentList;
    private javax.swing.JComboBox<String> ComboBox;
    private javax.swing.JPanel PanelForJComboBox;
    private javax.swing.JPanel PanelForSearch;
    private javax.swing.JPanel PanelForSearchBar;
    private javax.swing.JPanel PanelForSortType;
    private javax.swing.JRadioButton RadioButtonForAscendingSort;
    private javax.swing.JRadioButton RadioButtonForDescedingSort;
    private javax.swing.JRadioButton RadioButtonForDiplomaSearch;
    private javax.swing.JRadioButton RadioButtonForModuleSearch;
    private javax.swing.JScrollPane ScrollPaneForStudentSearch;
    private javax.swing.JTable TableForStudentSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
