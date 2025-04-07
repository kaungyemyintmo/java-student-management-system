/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author KAUNG YE MYINT MO 
 * Class : DIT/FT/2A/01 
 * Adm No : P2340250
 */
public class Controller {

    // ===========================
    // CONFIG
    // ===========================  
    private View view;
    private StudentSearchTableView studentSearchTableView;
    private Student student;
    private Model model;
    private FileIOModel fileIOModel;
    private List<String> lines = new ArrayList<>();
    private List<Student> allStudentList = new ArrayList<>();
    private List<Student> studentList = new ArrayList<>();
    private List<Module> moduleList = new ArrayList<>();

    // txt file for file input/output
    private final String studentFile = "students.txt";
    File file = new File(studentFile);

    // for pagination 
    int page = 0;
    int modulePage = 0;
    int pageSerial = 1;
    int modulePageSerial = 1;

    // ===========================
    // CONSTRUCTOR
    // ===========================
    public Controller(Model model, FileIOModel fileIOModel, View view, StudentSearchTableView studentSearchTableView) {
        this.model = model;
        this.view = view;
        this.studentSearchTableView = studentSearchTableView;
        this.fileIOModel = fileIOModel;
        try {
            // read the file 
            lines = fileIOModel.readFile(file);
            // create students according to the file
            allStudentList = model.loadStudents(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ===========================
    // write data into file
    // ===========================
    public void initializeFile() {
        try {
            fileIOModel.writeStudentsFile(studentFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ===========================
    // display individual student
    // ===========================    
    // (before executing, the studentList would have been updated 
    // according to the search and operations)
    public void controllerDisplayStudent() {

        // clear before updating 
        view.clearStudentDetails();
        view.clearModuleDetails();
        view.clearButtonsStudents();

        List<Module> modules = new ArrayList<>();

        try {

            // add next/prev buttons if size is more than 1
            if (studentList.size() > 1) {
                view.addButtonsStudents();
            }

            // update student panel title 
            view.updateStudentPanelTitle(studentList, pageSerial);

            // update student details according to page
            view.updateStudentDetails(studentList.get(page));

            // get individual student module list 
            modules = studentList.get(page).getStudentModules();

            // update the Module list for each student
            updateModuleList(modules);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    // ===========================
    // display individual module    
    // ===========================
    // (before executing, the moduleList would have been updated 
    // according to the search and operations)
    public void controllerDisplayModule() {

        // clear before updating
        view.clearButtonsModules();
        try {

            // if size is greater than 1, add next/prev buttons
            if (moduleList.size() > 1) {
                view.addButtonsModules();
            }

            // update individual module details
            view.updateModuleDetails(moduleList.get(modulePage));

            // update the panel border title 
            view.updateModulePanelTitle(moduleList, modulePageSerial);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    // ===========================
    // update the Lists    
    // ===========================
    public void updateStudentList(List<Student> updatedStudents) {
        // reset message output from previous operations
        // view.clearMessageOutput();

        // update the studentList with the data received from operations 
        this.studentList = updatedStudents;
        page = 0; // reset to the first page when updating the list
        pageSerial = 1; // reset the pagination number 
        controllerDisplayStudent();
    }

    public void updateModuleList(List<Module> updateModules) {
        // reset message output from previous operations
        // view.clearMessageOutput();

        // update the moduleList with the data received from operations 
        this.moduleList = updateModules;

        modulePage = 0; // reset to the first page when updating the list
        modulePageSerial = 1; // reset the pagination number 
        controllerDisplayModule();
    }

    // ===========================
    // 'Next' student button operation   
    // ===========================
    public void handleNextStudentPage() {
        // if page is not more than the size 
        if (page < studentList.size() - 1) {
            ++page;
            ++pageSerial;
        } else {
            // if page number is more than the size, reset 
            page = 0;
            pageSerial = 1;
        }
        controllerDisplayStudent();
    }

    // ===========================
    // 'Prev' student button operation   
    // ===========================
    public void handlePrevStudentPage() {

        if (page >= 1) {

            --page;
            --pageSerial;
        } else {
            // if page number is less than the size, go to the last page 
            page = studentList.size() - 1;
            pageSerial = studentList.size();
        }
        controllerDisplayStudent();
    }

    // ===========================
    // 'Next' module button operation   
    // ===========================
    public void handleNextModulePage() {
        if (modulePage < moduleList.size() - 1) {
            ++modulePage;
            ++modulePageSerial;
        } else {
            modulePage = 0;
            modulePageSerial = 1;
        }
        controllerDisplayModule();
    }

    // ===========================
    // 'Prev' module button operation   
    // ===========================
    public void handlePrevModulePage() {
        if (modulePage >= 1) {
            --modulePage;
            --modulePageSerial;
        } else {
            modulePage = moduleList.size() - 1;
            modulePageSerial = moduleList.size();
        }
        controllerDisplayModule();
    }

    // ===========================
    // search student according to name
    // ===========================
    public void handleStudentNameRadioClicked(String userInput) {
        // ===========================
        // config
        // ===========================
        List<Student> students = new ArrayList<>();
        String outputString = "";

        // ===========================
        // processing
        // ===========================
        students = model.searchStudentByStudentName(userInput, allStudentList);
        
        // ===========================
        // presentation
        // ===========================
        if (!students.isEmpty()) {
            outputString = model.getStudentSize(students);
            updateStudentList(students);
            controllerDisplayStudent();
            controllerDisplayModule();
            
            // previous functions clear the result text area
            view.displaySearchMessage(outputString);
            view.setSearchMessageColorGreen();
        }
    }

    // ===========================
    // search student according to class
    // ===========================
    public void handleClassRadioClicked(String userInput) {
        // ===========================
        // config
        // ===========================
        List<Student> students = new ArrayList<>();
        String outputString = "";

        // ===========================
        // processing 
        // ===========================
        students = model.searchStudentByClass(userInput, allStudentList);

        // ===========================
        // presentation 
        // ===========================
        if (!students.isEmpty()) {
            updateStudentList(students);
            controllerDisplayStudent();
            controllerDisplayModule();
            // view.enableButtonToGetStudentList();
            outputString = model.getClassSummaryString(students);

            // previous functions clear the result text area
            view.displaySearchMessage(outputString);
            view.setSearchMessageColorGreen();
        }
    }

    // ===========================
    // search student according to admin 
    // ===========================
    public void handleAdminRadioClicked(String userInput) {
        // ===========================
        // config
        // ===========================
        List<Student> students = new ArrayList<>();
        String outputString = "";

        // ===========================
        // processing  
        // ===========================
        students = model.searchStudentByAdmin(userInput, allStudentList);

        // ===========================
        // presentation
        // ===========================
        if (!students.isEmpty()) {
            outputString = model.getStudentSize(students);
            updateStudentList(students);
            controllerDisplayStudent();
            controllerDisplayModule();
            
            // previous functions clear the result text area
            view.displaySearchMessage(outputString);
            view.setSearchMessageColorGreen();
        }
    }

    // ===========================
    // search available options - diploma
    // ===========================
    public void handleDiplomaSearchListForCombo() {

        // ===========================
        // config
        // ===========================      
        List<String> diplomaAry = new ArrayList<>();

        // clear data when a new radio button is selected
        studentSearchTableView.clearTableData();
        studentSearchTableView.setTableForDiploma();

        // ===========================
        // processing
        // ===========================  
        diplomaAry = model.getAvailableDiploma(allStudentList);

        // ===========================
        // presentation
        // ===========================  
        studentSearchTableView.updateComboItems(diplomaAry);
    }

    public void handleModuleSearchListForCombo() {
        // ===========================
        // config
        // ===========================  
        List<String> moduleAry = new ArrayList<>();
        // clear data when a new radio button is selected
        studentSearchTableView.clearTableData();
        studentSearchTableView.setTableForModule();

        // ===========================
        // processing 
        // ===========================  
        moduleAry = model.getAvailableModules(allStudentList);

        // ===========================
        // presentation
        // ===========================  
        studentSearchTableView.updateComboItems(moduleAry);
    }

    // ===========================
    // search student according to the diploma selected
    // ===========================  
    public void handleStudentDiplomaSearch(String sort, String filter) {

        // ===========================
        // config
        // ===========================  
        List<Student> studentSearchList = new ArrayList<>();

        // ===========================
        // processing
        // ===========================  
        studentSearchList = model.getDiplomaStudentListAscending(allStudentList, filter);

        // ===========================
        // presentation
        // ===========================  
        if (sort.equals("ascending")) {
            studentSearchTableView.updateDiplomaListTable(studentSearchList);
        }
        if (sort.equals("descending")) {
            Collections.reverse(studentSearchList);
            studentSearchTableView.updateDiplomaListTable(studentSearchList);
        } else if (sort.equals("none")) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please select sort type.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // ===========================
    // search student according to the module selected
    // ===========================  
    public void handleStudentModuleSearch(String sortStr, String filter) {
        // ===========================
        // config
        // ===========================  
        List<Student> studentSearchList = new ArrayList<>();

        // ===========================
        // processing
        // ===========================  
        studentSearchList = model.getModuleStudentListAscending(allStudentList, filter);

        // ===========================
        // presentation
        // ===========================  
        if (sortStr.equals("ascending")) {
            studentSearchTableView.updateStudentModuleListTable(filter, studentSearchList);
        }
        if (sortStr.equals("descending")) {
            Collections.reverse(studentSearchList);
            studentSearchTableView.updateStudentModuleListTable(filter, studentSearchList);
        } else if (sortStr.equals("none")) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please select sort type.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void getData(String input) { 
        String output = ""; 
        int inputNum = 0;
        List<Module> modules = new ArrayList<>(); 
        Module mod = new Module(); 
        
        
        try { 
            inputNum = Integer.parseInt(input); 
        } catch (NumberFormatException e) { 
            e.printStackTrace();
        }
        Student student = allStudentList.get(inputNum-1); 
        output += "# " + input ; 
        output += student.getStudentName(); 
        
        modules= student.getStudentModules(); 
        
        mod = modules.get(0); 
        
        output += "\n1st Module : " ; 
        output += mod.getModuleCode();
        System.out.println(output); 
        
        view.showOutput (output); 
    }
    // ===========================
    // run controller || write file
    // ===========================  
    public void run() {
        initializeFile();
    }
}
