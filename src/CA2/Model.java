/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author KAUNG YE MYINT MO 
 * Class : DIT/FT/2A/01
 * Adm No : P2340250
 */
public class Model {

    // ===========================
    // CONFIG
    // =========================== 
  //  final List<Student> allStudents = new ArrayList<>();
    private View view;

    // ===========================
    // CONSTRUCTOR
    // =========================== 
    public Model(View view) {
        this.view = view;
    }

    // ===========================
    // CREATE STUDENT OBJECTS 
    // =========================== 
    public List<Student> loadStudents(List<String> lines) {

        int studentCount = 0;
        List<Student> allStudents = new ArrayList<>();
      
        for (String line : lines) {
            // ===========================
            // config
            // =========================== 
            String adminNumber = "";
            String studentName = "";
            String className = "";
            List<Module> studentModuleList = new ArrayList<>();
            
            // ===========================
            // processing
            // =========================== 
            if (!line.contains(";")) {
                try {
                    studentCount = Integer.parseInt(line.trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            } else if (line.contains(";")) {
                String[] parts = line.split(";");
                int partLength = parts.length;
                className = parts[0];
                adminNumber = parts[1];
                studentName = parts[2];

                try {
                    for (int j = 4; j < partLength; j++) {
                        String moduleCodeStr = parts[j];
                        String moduleNameStr = parts[++j];
//                        System.out.println("module name : " + moduleNameStr);

                        String moduleCreditUnitStr = parts[++j];
//                        System.out.println("module credit : " + moduleCreditUnitStr);

                        String moduleStudentMarksStr = parts[++j];
//                        System.out.println("module marks : " + moduleStudentMarksStr);

                        try {
                            int creditUnitInt = Integer.parseInt(moduleCreditUnitStr);
                            int studentMarksInt = Integer.parseInt(moduleStudentMarksStr);
                            if (moduleCodeStr.contains("CCC")) {
                                CccModule module = new CccModule();
                                module.setCreditUnit(creditUnitInt);
                                module.setModuleCode(moduleCodeStr);
                                module.setModuleName(moduleNameStr);
                                module.setStudentMarks(studentMarksInt);
                                studentModuleList.add(module);
                            } else {
                                MainModule module = new MainModule();
                                module.setCreditUnit(creditUnitInt);
                                module.setModuleCode(moduleCodeStr);
                                module.setModuleName(moduleNameStr);
                                module.setStudentMarks(studentMarksInt);
                                studentModuleList.add(module);
                            }
                            // System.out.println("Module " + moduleCodeStr + " successfully added.\n");
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }

                    if (className.contains("PT")) {
                        PartTimeStudent student = new PartTimeStudent();
                        student.setAdminNumber(adminNumber);
                        student.setStudentModules(studentModuleList);
                        student.setClassName(className);
                        student.setStudentName(studentName);
                        allStudents.add(student);
                    } else if (className.contains("FT")) {
                        FullTimeStudent student = new FullTimeStudent();
                        student.setAdminNumber(adminNumber);
                        student.setStudentModules(studentModuleList);
                        student.setClassName(className);
                        student.setStudentName(studentName);
                        allStudents.add(student);
                    }

//                    System.out.println("Student " + studentName + " FROM "
//                            + className
//                            + " successfully added.\n");

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        return allStudents;
    }

    // ===========================
    // search students by class
    // =========================== 
    public List<Student> addStudentListAccordingToClass(String classInput, 
            List<Student> studentInClass, List<Student> allStudents) {
        classInput = classInput.toUpperCase();

        for (Student student : allStudents) {
            if (classInput.equals(student.getClassName())) {
                studentInClass.add(student);
            }
        }

        return studentInClass;
    }

    // ===========================
    // search students by name
    // =========================== 
    public List<Student> addStudentAccordingToName(String studentSearchStr, 
            List<Student> allStudents, List<Student> searchSet) {
        
        for (Student student : allStudents) {
            if (student.getStudentName().equals(studentSearchStr)) {
                searchSet.add(student);
            }
        }
        return searchSet;
    }

    // ===========================
    // search students by admin
    // ===========================
    public List<Student> addStudentAccordingToAdminNumber(String adminInput, 
             List<Student> studentInClass, List<Student> allStudents) {
        adminInput = adminInput.toUpperCase();

        for (Student student : allStudents) {
            if (student.getAdminNumber().equals(adminInput)) {
                studentInClass.add(student);
            }
        }
        return studentInClass;
    }

    public String reformatStudentNameInput(String studentSearchInput) {
        // ===========================
        // CONFIG 
        // ===========================
        String studentSearchFormatStr = "";
        studentSearchInput = studentSearchInput.toLowerCase();
        studentSearchInput = studentSearchInput.replaceFirst("^\\s+", "");
        String[] nameWords = studentSearchInput.split(" ");

        StringBuilder studentSearchFormat = new StringBuilder();

        // ===========================
        // PROCESSING
        // ===========================
        for (String word : nameWords) {
            studentSearchFormat.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append(" ");
        }

        studentSearchFormatStr = studentSearchFormat.toString().trim();

        return studentSearchFormatStr;
    }

    public List<Student> searchStudentByStudentName(String studentSearchInput,
            List<Student> allStudents) {

        String nameFormatStr = "^(?i)[a-z ]+";
        // Pattern nameFormat = Pattern.compile(nameFormatStr);

        List<Student> searchSet = new ArrayList<>();

        String studentSearchStr = "";

        if (studentSearchInput.isBlank()) {
            view.displaySearchMessage("The search cannot be blank.");
            view.clearModuleAndStudentDetails();
        } else if (!studentSearchInput.isBlank()) {
            if (studentSearchInput.matches(nameFormatStr)) {
                studentSearchStr = reformatStudentNameInput(studentSearchInput);
                try {
                    searchSet = addStudentAccordingToName(studentSearchStr, allStudents, searchSet);

                     if (searchSet.isEmpty()) {
                        view.displaySearchMessage("No Student Found with the name.");
                        view.clearModuleAndStudentDetails();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                view.displaySearchMessage("Input should be all alphabetical letters.");
                view.clearModuleAndStudentDetails();
            }
        } else {
            view.displaySearchMessage("The input is invalid.");
            view.clearModuleAndStudentDetails();
        }
        return searchSet;
    }

    public List<Student> searchStudentByAdmin(String adminInput, List<Student> allStudents) {
        // ===========================
        // CONFIG 
        // ===========================
        List<Student> studentInClass = new ArrayList<>();
        String adminFormatStr = "^(?i)p\\d{6,7}$";
        String numberFormat = "^\\d+$";

        // ===========================
        // PROCESSING
        // ===========================
        if (adminInput.isBlank()) {
            view.displaySearchMessage("The search cannot be blank.");
            view.clearModuleAndStudentDetails();
        } else if (!adminInput.isBlank()) {
            //adminInput = adminInput.replaceFirst(" ", "");
            adminInput = adminInput.trim();

            if (adminInput.matches(numberFormat)) {
                adminInput = "p" + adminInput;
            }

            if (adminInput.matches(adminFormatStr)) {
                try {
                    studentInClass = addStudentAccordingToAdminNumber(adminInput, studentInClass, allStudents);

                    if (!studentInClass.isEmpty() && studentInClass.size() == 1) {

                    } else if (studentInClass.isEmpty()) {
                        view.displaySearchMessage("No Student Found with the admin number.");
                        view.clearModuleAndStudentDetails();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                view.displaySearchMessage("Input should be all digits or\nin this format : P1234567.");
                view.clearModuleAndStudentDetails();
            }
        } else {
            view.displaySearchMessage("The input is invalid.");
            view.clearModuleAndStudentDetails();

        }
        return studentInClass;
    }

    public List<Student> searchStudentByClass(String userInput, List<Student> allStudents) {

        List<Student> studentInClass = new ArrayList<>();
        String classFormatStr = "^(?i)[a-z]+/(FT|PT)/[0-9][a-z]/[0-9]{2}$";

        if (userInput.isBlank()) {
            view.clearModuleAndStudentDetails();
            view.displaySearchMessage("The search cannot be blank.");
        } else if (!userInput.isBlank()) {
            userInput = userInput.replaceFirst("^\\s+", "");
            userInput = userInput.trim();

            if (userInput.matches(classFormatStr)) {
                try {
                    studentInClass = addStudentListAccordingToClass(userInput, studentInClass, allStudents);

                    if (studentInClass.size() < 1) {
                        view.displaySearchMessage("No Student Found from class.");
                        view.clearModuleAndStudentDetails();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                view.displaySearchMessage("Input should be in this format : DIT/FT/1A/01.");
                view.clearModuleAndStudentDetails();
            }
        } else {
            view.displaySearchMessage("The input is invalid.");
            view.clearModuleAndStudentDetails();
        }
        return studentInClass;
    }

    // ===========================
    // get available diplomas for ComboBox
    // ===========================  
    public List<String> getAvailableDiploma(List<Student> studentList) {
        // ===========================
        // config
        // ===========================  
        List<String> diplomaAry = new ArrayList<>();
        String diploma = "";

        // ===========================
        // processing
        // ===========================  
        for (Student student : studentList) {
            diploma = student.getClassName().split("/")[0];
            if (!diplomaAry.contains(diploma)) {
                diplomaAry.add(diploma);
            }
        }
        return diplomaAry;
    }

    // ===========================
    // get available modules for ComboBox
    // ===========================  
    public List<String> getAvailableModules(List<Student> studentList) {
        // ===========================
        // config
        // ===========================  
        List<Module> studentModules = new ArrayList<>();
        List<String> moduleAry = new ArrayList<>();
        String moduleCode = "";
        
        // ===========================
        // processing
        // ===========================  
        for (Student student : studentList) {
            studentModules = student.getStudentModules();
            for (Module moduleObj : studentModules) {
                moduleCode = moduleObj.getModuleCode();
                if (!moduleAry.contains(moduleCode)) {
                    moduleAry.add(moduleCode);
                }
            }
        }
        return moduleAry;
    }

    // ===========================
    // get student list by corresponding diploma
    // ===========================  
    public List<Student> getDiplomaStudentListAscending(List<Student> studentList, String filter) {
        
        // ===========================
        // config
        // ===========================  
        List<Student> studentSearchList = new ArrayList<>();

        // ===========================
        // processing
        // =========================== 
        for (Student studentItem : studentList) {
            if (studentItem.getClassName().contains(filter)) {
                studentSearchList.add(studentItem);
            }
        }
        
        // sort in ascending order 
        Collections.sort(studentSearchList, (a, b) -> a.getStudentGPA() < b.getStudentGPA() ? -1
                : Objects.equals(a.getStudentGPA(), b.getStudentGPA()) ? 0 : 1);
        
        return studentSearchList;
    }

    // ===========================
    // get student list by corresponding module
    // ===========================  
    public List<Student> getModuleStudentListAscending(List<Student> studentList, String filter) {
        // ===========================
        // config
        // =========================== 
        List<Student> studentSearchList = new ArrayList<>();
        List<Module> studentModules = new ArrayList<>();

        // ===========================
        // processing
        // =========================== 
        for (Student studentItem : studentList) {
            studentModules = studentItem.getStudentModules();
            for (Module studentModule : studentModules) {
                if (studentModule.getModuleCode().equals(filter)
                        && !studentSearchList.contains(studentItem)) {
                    studentSearchList.add(studentItem);
                }
            }
        }

        // sort in ascending order
        studentSearchList.sort((a, b) -> {
            int marksA = a.getStudentModules().stream()
                    .filter(module -> module.getModuleCode().equals(filter))
                    .findFirst()
                    .map(Module::getStudentMarks)
                    .orElse(-1); // Handle case where module is not found

            int marksB = b.getStudentModules().stream()
                    .filter(module -> module.getModuleCode().equals(filter))
                    .findFirst()
                    .map(Module::getStudentMarks)
                    .orElse(-1); // Handle case where module is not found

            return Double.compare(marksA, marksB);
        });
        return studentSearchList;
    }
    
    // ===========================  
    // get the size of results found in String datatype 
    // ===========================  
    public String getStudentSize(List<Student> students) { 
        String str = ""; 
        int studentSize = 0; 
        
        studentSize = students.size();
        str = String.valueOf(studentSize); 
        
        if (students.size() > 1) {
        str += " students found.";
        } else if (students.size() == 1) { 
            str += " student found.";
        }
        return str;
    }

    public String getClassSummaryString(List<Student> studentInClass) {

        // ===========================
        // CONFIG 
        // ===========================
        StringBuilder displayStr = new StringBuilder();
        double avgGPA = 0.0;
        double totalGPA = 0.0;
        double highestGPA = 0.0;
        String displayString = "";

        // ===========================
        // PROCESSING 
        // ===========================
        highestGPA = studentInClass.get(0).getStudentGPA();

        for (int i = 0; i < studentInClass.size(); i++) {
            totalGPA += studentInClass.get(i).getStudentGPA();

            if (studentInClass.get(i).getStudentGPA() > highestGPA) {
                highestGPA = studentInClass.get(i).getStudentGPA();
            }
        }

        avgGPA = totalGPA / studentInClass.size();
        displayStr.append("Number of student(s) in ");
        displayStr.append(studentInClass.get(0).getClassName());
        displayStr.append(": ");
        displayStr.append(studentInClass.size());
        displayStr.append("\nAverage GPA : ");
        displayStr.append(String.format("%.2f", avgGPA));
        displayStr.append("\nHighest in-class GPA : ");
        displayStr.append(String.format("%.2f", highestGPA));

        displayString = displayStr.toString().trim();

        return displayString;
    }
}
