/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package CA2;

import java.awt.Color;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author KAUNG YE MYINT MO 
 * Class : DIT/FT/2A/01
 * Adm No : P2340250
 */
public class View extends javax.swing.JFrame {

    Controller controller;
    View view;

    /**
     * Creates new form View
     */
    
    // =========================== 
    // Constructor
    // =========================== 
    public View() {
        initComponents();
        clearModuleAndStudentDetails();
        createButtonGroup();
        clearButtonsStudents();
        clearButtonsModules();
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    // =========================== 
    // create radio button group for search type - admin, class, name
    // =========================== 
    private void createButtonGroup() {
        JPanel panel = PanelForSearchButtons;
        panel.removeAll();

        ButtonGroup group = new ButtonGroup();
        group.add(RadioButtonForAdmin);
        group.add(RadioButtonForClass);
        group.add(RadioButtonForName);

        panel.add(RadioButtonForAdmin);
        panel.add(RadioButtonForClass);
        panel.add(RadioButtonForName);

        panel.revalidate();
        panel.repaint();
    }

    // =========================== 
    // get value from TextField according to user input
    // =========================== 
    public String getSearchQuery() {
        return TextFieldForSearch.getText();
    }

    // =========================== 
    // update the border title according to resulting data - Student
    // =========================== 
    public void updateStudentPanelTitle(List<Student> students, int i) {
        String title = "Student " + i + " of " + students.size();
        PanelForStudentResults.setBorder(BorderFactory.createTitledBorder(title));
    }

    // =========================== 
    // update the border title according to resulting data - Module
    // =========================== 
    public void updateModulePanelTitle(List<Module> modules, int i) {
        String title = "Module " + i + " of " + modules.size();
        PanelForModuleResults.setBorder(BorderFactory.createTitledBorder(title));
    }

    // =========================== 
    // reset both border titles 
    // =========================== 
    public void resetModuleStudentPanelTitle() {
        String moduleTitle = "Module";
        String studentTitle = "Student";
        PanelForModuleResults.setBorder(BorderFactory.createTitledBorder(moduleTitle));
        PanelForStudentResults.setBorder(BorderFactory.createTitledBorder(studentTitle));
    }

    // =========================== 
    // update the result in the TextArea
    // =========================== 
    public void displaySearchMessage(String result) {
        TextAreaForResults.setText(result);
        TextAreaForResults.setForeground(Color.red);
    }

    // =========================== 
    // change the text area color to green 
    // if the result message is not an error
    // =========================== 
    public void setSearchMessageColorGreen() {
        TextAreaForResults.setForeground(Color.GREEN);
    }

    // =========================== 
    // clear next/prev buttons if the result is null 
    // or result size is only 1 
    // =========================== 
    protected void clearButtonsStudents() {
        NextButtonForStudent.setVisible(false);
        NextButtonForStudent.setEnabled(false);
        PrevButtonForStudent.setEnabled(false);
        PrevButtonForStudent.setVisible(false);
    }

    protected void clearButtonsModules() {
        NextButtonForModule.setVisible(false);
        NextButtonForModule.setEnabled(false);
        PrevButtonForModule.setEnabled(false);
        PrevButtonForModule.setVisible(false);
    }

    // =========================== 
    // add next/prev buttons if the result size is more than 1
    // =========================== 
    protected void addButtonsStudents() {
        NextButtonForStudent.setVisible(true);
        NextButtonForStudent.setEnabled(true);
        PrevButtonForStudent.setEnabled(true);
        PrevButtonForStudent.setVisible(true);
    }

    protected void addButtonsModules() {
        NextButtonForModule.setVisible(true);
        NextButtonForModule.setEnabled(true);
        PrevButtonForModule.setEnabled(true);
        PrevButtonForModule.setVisible(true);
    }

    // =========================== 
    // update details for each student 
    // =========================== 
    public void updateStudentDetails(Student student) {
        String studentGPA = "";

        studentGPA = String.format("%.2f", student.getStudentGPA());

        TextAreaForName.setText(student.getStudentName());
        TextAreaForAdmin.setText(student.getAdminNumber());
        TextAreaForClass.setText(student.getClassName());
        TextAreaForGPA.setText(studentGPA);
        TextAreaForEnrollment.setText(student.getEnrollmentType());
    }

    // =========================== 
    // update details for each module
    // =========================== 
    public void updateModuleDetails(Module module) {
        int credits = module.getCreditUnit();
        int studentMarks = 0;

        studentMarks = module.getStudentMarks();
        char grade = module.getGrade();

        TextAreaForCode.setText(module.getModuleCode());
        TextAreaForCredit.setText(Integer.toString(credits));
        TextAreaForMarks.setText(Integer.toString(studentMarks));
        TextAreaForModType.setText(module.getType());
        TextAreaForGrade.setText(Character.toString(grade));
        TextAreaForModName.setText(module.getModuleName());
    }

    // =========================== 
    // clear details
    // =========================== 
    public void clearModuleDetails() {
        TextAreaForCode.setText(null);
        TextAreaForCredit.setText(null);
        TextAreaForModType.setText(null);
        TextAreaForMarks.setText(null);
        TextAreaForGrade.setText(null);
        TextAreaForModName.setText(null);
    }

    public void clearStudentDetails() {
        TextAreaForName.setText(null);
        TextAreaForAdmin.setText(null);
        TextAreaForClass.setText(null);
        TextAreaForGPA.setText(null);
        TextAreaForEnrollment.setText(null);
    }

    protected void clearModuleAndStudentDetails() {
        clearModuleDetails();
        clearStudentDetails();
        resetModuleStudentPanelTitle();
        clearButtonsStudents();
        clearButtonsModules();
    }

    public void clearMessageOutput() {
        TextAreaForResults.setText(null);
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

        jPanel1 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        PanelForStudentResults = new javax.swing.JPanel();
        LabelForName = new javax.swing.JLabel();
        LabelForClass = new javax.swing.JLabel();
        LabelForAdmin = new javax.swing.JLabel();
        LabelForGPA = new javax.swing.JLabel();
        LabelForEnrollment = new javax.swing.JLabel();
        ScrollPaneForClass = new javax.swing.JScrollPane();
        TextAreaForClass = new javax.swing.JTextArea();
        ScrollPaneForAdmin = new javax.swing.JScrollPane();
        TextAreaForAdmin = new javax.swing.JTextArea();
        ScrollPaneForGPA = new javax.swing.JScrollPane();
        TextAreaForGPA = new javax.swing.JTextArea();
        ScrollPaneForName = new javax.swing.JScrollPane();
        TextAreaForName = new javax.swing.JTextArea();
        ScrollPaneForEnrollment = new javax.swing.JScrollPane();
        TextAreaForEnrollment = new javax.swing.JTextArea();
        NextButtonForStudent = new javax.swing.JButton();
        PrevButtonForStudent = new javax.swing.JButton();
        PanelForModuleResults = new javax.swing.JPanel();
        LabelForCode = new javax.swing.JLabel();
        LabelForModName = new javax.swing.JLabel();
        LabelForMarks = new javax.swing.JLabel();
        LabelForGrade = new javax.swing.JLabel();
        LabelForCredits = new javax.swing.JLabel();
        ScrollPaneForCode = new javax.swing.JScrollPane();
        TextAreaForCode = new javax.swing.JTextArea();
        ScrollPaneForModName = new javax.swing.JScrollPane();
        TextAreaForModName = new javax.swing.JTextArea();
        ScrollPaneForCredit = new javax.swing.JScrollPane();
        TextAreaForCredit = new javax.swing.JTextArea();
        ScrollPaneForMarks = new javax.swing.JScrollPane();
        TextAreaForMarks = new javax.swing.JTextArea();
        ScrollPaneForGrade = new javax.swing.JScrollPane();
        TextAreaForGrade = new javax.swing.JTextArea();
        NextButtonForModule = new javax.swing.JButton();
        PrevButtonForModule = new javax.swing.JButton();
        LabelForModType = new javax.swing.JLabel();
        ScrollPaneForModType = new javax.swing.JScrollPane();
        TextAreaForModType = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        PanelForSearch = new javax.swing.JPanel();
        LabelForSearch = new javax.swing.JLabel();
        PanelForSearchButtons = new javax.swing.JPanel();
        RadioButtonForName = new javax.swing.JRadioButton();
        RadioButtonForClass = new javax.swing.JRadioButton();
        RadioButtonForAdmin = new javax.swing.JRadioButton();
        ButtonForSearch = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        TextFieldForSearch = new javax.swing.JTextField();
        LabelForResults = new javax.swing.JLabel();
        ScrollPaneForResults = new javax.swing.JScrollPane();
        TextAreaForResults = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        ButtonToGetStudentList = new javax.swing.JButton();
        ButtonToExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(900, 600));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setAutoscrolls(true);
        jPanel1.setPreferredSize(new java.awt.Dimension(624, 341));

        jSplitPane1.setDividerLocation(400);
        jSplitPane1.setAutoscrolls(true);
        jSplitPane1.setMinimumSize(new java.awt.Dimension(0, 0));
        jSplitPane1.setName(""); // NOI18N
        jSplitPane1.setPreferredSize(new java.awt.Dimension(624, 341));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setMinimumSize(new java.awt.Dimension(300, 341));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        PanelForStudentResults.setBackground(new java.awt.Color(223, 238, 252));
        PanelForStudentResults.setBorder(javax.swing.BorderFactory.createTitledBorder("Student"));
        PanelForStudentResults.setMinimumSize(new java.awt.Dimension(140, 176));
        PanelForStudentResults.setLayout(new java.awt.GridBagLayout());

        LabelForName.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        PanelForStudentResults.add(LabelForName, gridBagConstraints);

        LabelForClass.setText("Class");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        PanelForStudentResults.add(LabelForClass, gridBagConstraints);

        LabelForAdmin.setText("Admin");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        PanelForStudentResults.add(LabelForAdmin, gridBagConstraints);

        LabelForGPA.setText("GPA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        PanelForStudentResults.add(LabelForGPA, gridBagConstraints);

        LabelForEnrollment.setText("Type");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        PanelForStudentResults.add(LabelForEnrollment, gridBagConstraints);

        ScrollPaneForClass.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPaneForClass.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        ScrollPaneForClass.setHorizontalScrollBar(null);

        TextAreaForClass.setEditable(false);
        TextAreaForClass.setColumns(20);
        TextAreaForClass.setRows(5);
        ScrollPaneForClass.setViewportView(TextAreaForClass);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        PanelForStudentResults.add(ScrollPaneForClass, gridBagConstraints);

        ScrollPaneForAdmin.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPaneForAdmin.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        ScrollPaneForAdmin.setHorizontalScrollBar(null);
        ScrollPaneForAdmin.setInheritsPopupMenu(true);

        TextAreaForAdmin.setEditable(false);
        TextAreaForAdmin.setColumns(20);
        TextAreaForAdmin.setRows(5);
        ScrollPaneForAdmin.setViewportView(TextAreaForAdmin);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        PanelForStudentResults.add(ScrollPaneForAdmin, gridBagConstraints);

        ScrollPaneForGPA.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPaneForGPA.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        ScrollPaneForGPA.setHorizontalScrollBar(null);

        TextAreaForGPA.setEditable(false);
        TextAreaForGPA.setColumns(20);
        TextAreaForGPA.setRows(5);
        ScrollPaneForGPA.setViewportView(TextAreaForGPA);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        PanelForStudentResults.add(ScrollPaneForGPA, gridBagConstraints);

        ScrollPaneForName.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPaneForName.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        ScrollPaneForName.setEnabled(false);
        ScrollPaneForName.setHorizontalScrollBar(null);
        ScrollPaneForName.setWheelScrollingEnabled(false);

        TextAreaForName.setEditable(false);
        TextAreaForName.setColumns(20);
        TextAreaForName.setRows(5);
        ScrollPaneForName.setViewportView(TextAreaForName);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        PanelForStudentResults.add(ScrollPaneForName, gridBagConstraints);

        ScrollPaneForEnrollment.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPaneForEnrollment.setToolTipText("");
        ScrollPaneForEnrollment.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        ScrollPaneForEnrollment.setHorizontalScrollBar(null);

        TextAreaForEnrollment.setEditable(false);
        TextAreaForEnrollment.setColumns(20);
        TextAreaForEnrollment.setRows(5);
        ScrollPaneForEnrollment.setViewportView(TextAreaForEnrollment);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        PanelForStudentResults.add(ScrollPaneForEnrollment, gridBagConstraints);

        NextButtonForStudent.setBackground(new java.awt.Color(222, 222, 255));
        NextButtonForStudent.setForeground(new java.awt.Color(0, 0, 255));
        NextButtonForStudent.setText("Next");
        NextButtonForStudent.setEnabled(false);
        NextButtonForStudent.setOpaque(true);
        NextButtonForStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonForStudentActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        PanelForStudentResults.add(NextButtonForStudent, gridBagConstraints);

        PrevButtonForStudent.setBackground(new java.awt.Color(222, 222, 255));
        PrevButtonForStudent.setForeground(new java.awt.Color(0, 0, 255));
        PrevButtonForStudent.setText("Prev");
        PrevButtonForStudent.setEnabled(false);
        PrevButtonForStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrevButtonForStudentActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        PanelForStudentResults.add(PrevButtonForStudent, gridBagConstraints);

        jPanel2.add(PanelForStudentResults);

        PanelForModuleResults.setBackground(new java.awt.Color(223, 238, 252));
        PanelForModuleResults.setBorder(javax.swing.BorderFactory.createTitledBorder(" Module"));
        PanelForModuleResults.setLayout(new java.awt.GridBagLayout());

        LabelForCode.setText("Code");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        PanelForModuleResults.add(LabelForCode, gridBagConstraints);

        LabelForModName.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        PanelForModuleResults.add(LabelForModName, gridBagConstraints);

        LabelForMarks.setText("Marks");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        PanelForModuleResults.add(LabelForMarks, gridBagConstraints);

        LabelForGrade.setText("Grade");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        PanelForModuleResults.add(LabelForGrade, gridBagConstraints);

        LabelForCredits.setText("Credits");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        PanelForModuleResults.add(LabelForCredits, gridBagConstraints);

        ScrollPaneForCode.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPaneForCode.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        ScrollPaneForCode.setHorizontalScrollBar(null);

        TextAreaForCode.setEditable(false);
        TextAreaForCode.setColumns(20);
        TextAreaForCode.setRows(5);
        ScrollPaneForCode.setViewportView(TextAreaForCode);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        PanelForModuleResults.add(ScrollPaneForCode, gridBagConstraints);

        ScrollPaneForModName.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPaneForModName.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        ScrollPaneForModName.setHorizontalScrollBar(null);

        TextAreaForModName.setEditable(false);
        TextAreaForModName.setColumns(20);
        TextAreaForModName.setRows(5);
        ScrollPaneForModName.setViewportView(TextAreaForModName);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        PanelForModuleResults.add(ScrollPaneForModName, gridBagConstraints);

        ScrollPaneForCredit.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPaneForCredit.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        ScrollPaneForCredit.setHorizontalScrollBar(null);

        TextAreaForCredit.setEditable(false);
        TextAreaForCredit.setColumns(20);
        TextAreaForCredit.setRows(5);
        ScrollPaneForCredit.setViewportView(TextAreaForCredit);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        PanelForModuleResults.add(ScrollPaneForCredit, gridBagConstraints);

        ScrollPaneForMarks.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPaneForMarks.setToolTipText("");
        ScrollPaneForMarks.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        TextAreaForMarks.setEditable(false);
        TextAreaForMarks.setColumns(20);
        TextAreaForMarks.setRows(5);
        ScrollPaneForMarks.setViewportView(TextAreaForMarks);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        PanelForModuleResults.add(ScrollPaneForMarks, gridBagConstraints);

        ScrollPaneForGrade.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPaneForGrade.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        ScrollPaneForGrade.setHorizontalScrollBar(null);

        TextAreaForGrade.setEditable(false);
        TextAreaForGrade.setColumns(20);
        TextAreaForGrade.setRows(5);
        ScrollPaneForGrade.setViewportView(TextAreaForGrade);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        PanelForModuleResults.add(ScrollPaneForGrade, gridBagConstraints);

        NextButtonForModule.setBackground(new java.awt.Color(222, 222, 255));
        NextButtonForModule.setForeground(new java.awt.Color(0, 0, 255));
        NextButtonForModule.setText("Next");
        NextButtonForModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonForModuleActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        PanelForModuleResults.add(NextButtonForModule, gridBagConstraints);

        PrevButtonForModule.setBackground(new java.awt.Color(222, 222, 255));
        PrevButtonForModule.setForeground(new java.awt.Color(0, 0, 255));
        PrevButtonForModule.setText("Prev");
        PrevButtonForModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrevButtonForModuleActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        PanelForModuleResults.add(PrevButtonForModule, gridBagConstraints);

        LabelForModType.setText("Type");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        PanelForModuleResults.add(LabelForModType, gridBagConstraints);

        ScrollPaneForModType.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPaneForModType.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        ScrollPaneForModType.setHorizontalScrollBar(null);

        TextAreaForModType.setEditable(false);
        TextAreaForModType.setColumns(20);
        TextAreaForModType.setRows(5);
        ScrollPaneForModType.setViewportView(TextAreaForModType);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        PanelForModuleResults.add(ScrollPaneForModType, gridBagConstraints);

        jPanel2.add(PanelForModuleResults);

        jSplitPane1.setLeftComponent(jPanel2);

        jPanel3.setBackground(new java.awt.Color(236, 236, 188));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setMinimumSize(new java.awt.Dimension(300, 341));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 341));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        PanelForSearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PanelForSearch.setPreferredSize(new java.awt.Dimension(241, 137));
        PanelForSearch.setLayout(new java.awt.GridBagLayout());

        LabelForSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelForSearch.setForeground(new java.awt.Color(0, 0, 204));
        LabelForSearch.setText("Search");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 150;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        PanelForSearch.add(LabelForSearch, gridBagConstraints);

        PanelForSearchButtons.setLayout(new javax.swing.BoxLayout(PanelForSearchButtons, javax.swing.BoxLayout.LINE_AXIS));

        RadioButtonForName.setText("By Name");
        RadioButtonForName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonForNameActionPerformed(evt);
            }
        });
        PanelForSearchButtons.add(RadioButtonForName);

        RadioButtonForClass.setText("By Class");
        RadioButtonForClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonForClassActionPerformed(evt);
            }
        });
        PanelForSearchButtons.add(RadioButtonForClass);

        RadioButtonForAdmin.setText("By Admin");
        PanelForSearchButtons.add(RadioButtonForAdmin);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        PanelForSearch.add(PanelForSearchButtons, gridBagConstraints);

        ButtonForSearch.setBackground(new java.awt.Color(222, 222, 255));
        ButtonForSearch.setForeground(new java.awt.Color(0, 0, 255));
        ButtonForSearch.setText("Search");
        ButtonForSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonForSearchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_END;
        PanelForSearch.add(ButtonForSearch, gridBagConstraints);

        TextFieldForSearch.setText("jTextField1");
        TextFieldForSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldForSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(TextFieldForSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 15, Short.MAX_VALUE)
                    .addComponent(TextFieldForSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 15, Short.MAX_VALUE)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipady = 10;
        PanelForSearch.add(jPanel5, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        jPanel3.add(PanelForSearch, gridBagConstraints);

        LabelForResults.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelForResults.setForeground(new java.awt.Color(0, 0, 255));
        LabelForResults.setText("Results");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        jPanel3.add(LabelForResults, gridBagConstraints);

        ScrollPaneForResults.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ScrollPaneForResults.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        ScrollPaneForResults.setHorizontalScrollBar(null);

        TextAreaForResults.setEditable(false);
        TextAreaForResults.setColumns(20);
        TextAreaForResults.setRows(5);
        TextAreaForResults.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        ScrollPaneForResults.setViewportView(TextAreaForResults);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel3.add(ScrollPaneForResults, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(236, 236, 188));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        ButtonToGetStudentList.setBackground(new java.awt.Color(222, 222, 255));
        ButtonToGetStudentList.setForeground(new java.awt.Color(0, 0, 255));
        ButtonToGetStudentList.setText("Go to Sorted List Search");
        ButtonToGetStudentList.setVerifyInputWhenFocusTarget(false);
        ButtonToGetStudentList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonToGetStudentListActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_END;
        jPanel4.add(ButtonToGetStudentList, gridBagConstraints);

        ButtonToExit.setBackground(new java.awt.Color(222, 222, 255));
        ButtonToExit.setForeground(new java.awt.Color(0, 0, 255));
        ButtonToExit.setText("Exit");
        ButtonToExit.setVerifyInputWhenFocusTarget(false);
        ButtonToExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonToExitActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_END;
        jPanel4.add(ButtonToExit, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        jPanel3.add(jPanel4, gridBagConstraints);

        jSplitPane1.setRightComponent(jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldForSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldForSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFieldForSearchActionPerformed

    private void RadioButtonForClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonForClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioButtonForClassActionPerformed

    private void RadioButtonForNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonForNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioButtonForNameActionPerformed

    private void ButtonForSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonForSearchActionPerformed
        // TODO add your handling code here:

        // get user input for text field
        String searchString = getSearchQuery();
        System.out.println(searchString);

        // check which button is clicked
        String filterType = RadioButtonForAdmin.isSelected() ? "admin"
                : RadioButtonForClass.isSelected() ? "studentClass"
                : RadioButtonForName.isSelected() ? "studentName" : "none";

        // use switch to redirect each choice to the correct method 
        switch (filterType) {
            case "admin" ->
                controller.handleAdminRadioClicked(searchString);
            case "studentClass" ->
                controller.handleClassRadioClicked(searchString);
            case "studentName" ->
                controller.handleStudentNameRadioClicked(searchString);
            case "none" ->
                displaySearchMessage("An option must be selected.");
        }
    }//GEN-LAST:event_ButtonForSearchActionPerformed

    private void NextButtonForModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonForModuleActionPerformed
        // TODO add your handling code here:
        controller.handleNextModulePage();
    }//GEN-LAST:event_NextButtonForModuleActionPerformed

    private void NextButtonForStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonForStudentActionPerformed
        // TODO add your handling code here:
        controller.handleNextStudentPage();
    }//GEN-LAST:event_NextButtonForStudentActionPerformed

    private void PrevButtonForStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrevButtonForStudentActionPerformed
        // TODO add your handling code here:
        controller.handlePrevStudentPage();
    }//GEN-LAST:event_PrevButtonForStudentActionPerformed

    private void ButtonToGetStudentListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonToGetStudentListActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Model model = new Model(this.view);
        StudentSearchTableView studentSearchTableView = new StudentSearchTableView();
        FileIOModel fileIOModel = new FileIOModel();
        Controller controller = new Controller(model, fileIOModel, this.view, studentSearchTableView);
        studentSearchTableView.setVisible(true);
        studentSearchTableView.setController(controller);
    }//GEN-LAST:event_ButtonToGetStudentListActionPerformed

    private void PrevButtonForModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrevButtonForModuleActionPerformed
        // TODO add your handling code here:
        controller.handlePrevModulePage();
    }//GEN-LAST:event_PrevButtonForModuleActionPerformed

    private void ButtonToExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonToExitActionPerformed
        // TODO add your handling code here:
        
        // =========================== 
        // show message
        // =========================== 
        JOptionPane.showMessageDialog(
                null,
                "Program terminated. \nThank you!",
                "Message",
                JOptionPane.INFORMATION_MESSAGE);

        // =========================== 
        // exit
        // =========================== 
        System.exit(0);
    }//GEN-LAST:event_ButtonToExitActionPerformed

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonForSearch;
    private javax.swing.JButton ButtonToExit;
    private javax.swing.JButton ButtonToGetStudentList;
    private javax.swing.JLabel LabelForAdmin;
    private javax.swing.JLabel LabelForClass;
    private javax.swing.JLabel LabelForCode;
    private javax.swing.JLabel LabelForCredits;
    private javax.swing.JLabel LabelForEnrollment;
    private javax.swing.JLabel LabelForGPA;
    private javax.swing.JLabel LabelForGrade;
    private javax.swing.JLabel LabelForMarks;
    private javax.swing.JLabel LabelForModName;
    private javax.swing.JLabel LabelForModType;
    private javax.swing.JLabel LabelForName;
    private javax.swing.JLabel LabelForResults;
    private javax.swing.JLabel LabelForSearch;
    private javax.swing.JButton NextButtonForModule;
    private javax.swing.JButton NextButtonForStudent;
    private javax.swing.JPanel PanelForModuleResults;
    private javax.swing.JPanel PanelForSearch;
    private javax.swing.JPanel PanelForSearchButtons;
    private javax.swing.JPanel PanelForStudentResults;
    private javax.swing.JButton PrevButtonForModule;
    private javax.swing.JButton PrevButtonForStudent;
    private javax.swing.JRadioButton RadioButtonForAdmin;
    private javax.swing.JRadioButton RadioButtonForClass;
    private javax.swing.JRadioButton RadioButtonForName;
    private javax.swing.JScrollPane ScrollPaneForAdmin;
    private javax.swing.JScrollPane ScrollPaneForClass;
    private javax.swing.JScrollPane ScrollPaneForCode;
    private javax.swing.JScrollPane ScrollPaneForCredit;
    private javax.swing.JScrollPane ScrollPaneForEnrollment;
    private javax.swing.JScrollPane ScrollPaneForGPA;
    private javax.swing.JScrollPane ScrollPaneForGrade;
    private javax.swing.JScrollPane ScrollPaneForMarks;
    private javax.swing.JScrollPane ScrollPaneForModName;
    private javax.swing.JScrollPane ScrollPaneForModType;
    private javax.swing.JScrollPane ScrollPaneForName;
    private javax.swing.JScrollPane ScrollPaneForResults;
    private javax.swing.JTextArea TextAreaForAdmin;
    private javax.swing.JTextArea TextAreaForClass;
    private javax.swing.JTextArea TextAreaForCode;
    private javax.swing.JTextArea TextAreaForCredit;
    private javax.swing.JTextArea TextAreaForEnrollment;
    private javax.swing.JTextArea TextAreaForGPA;
    private javax.swing.JTextArea TextAreaForGrade;
    private javax.swing.JTextArea TextAreaForMarks;
    private javax.swing.JTextArea TextAreaForModName;
    private javax.swing.JTextArea TextAreaForModType;
    private javax.swing.JTextArea TextAreaForName;
    private javax.swing.JTextArea TextAreaForResults;
    private javax.swing.JTextField TextFieldForSearch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}
