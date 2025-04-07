/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA2;

/**
 *
 * @author KAUNG YE MYINT MO 
 * Class : DIT/FT/2A/01
 * Adm No : P2340250
 */

public class Module { 
    // ===========================
    // CONFIG
    // ===========================    
    private String moduleCode = "";
    private String moduleName = "";
    private int creditUnit = 0;
    private int studentMarks = 0;
    private String type = "";

    // ===========================
    // CONSTRUCTOR
    // ===========================    
    public Module(String moduleCode, String moduleName, int creditUnit, int studentMarks,
            String type) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.creditUnit = creditUnit;
        this.studentMarks = studentMarks;
        this.type = type; 
    }

    public Module() {
        this.moduleCode = "";
        this.moduleName = "";
        this.creditUnit = 0;
        this.studentMarks = 0;
        this.type = "";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // ===========================
    // GETTER/SETTER
    // ===========================    
    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getCreditUnit() {
        return creditUnit;
    }

    public void setCreditUnit(int creditUnit) {
        this.creditUnit = creditUnit;
    }

    public int getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(int studentMarks) {
        this.studentMarks = studentMarks;
    }
    
    // ===========================
    // EXTRA BEHAVIOURS
    // ===========================    
    public char getGrade() {
        if (this.studentMarks >= 80) {
            return 'A'; 
        }
        else if (this.studentMarks >= 70) {
            return 'B'; 
        }
        else if (this.studentMarks >= 60) {
            return 'C'; 
        }
        else if (this.studentMarks >= 50) {
            return 'D'; 
        }
        else {
            return 'F';
        }
    }
    
    public int calculateGradePoint () {
        if (this.studentMarks >= 80) {
            return 4; 
        }
        else if (this.studentMarks >= 70) {
            return 3; 
        }
        else if (this.studentMarks >= 60) {
            return 2; 
        }
        else if (this.studentMarks >= 50) {
            return 1; 
        }
        else {
            return 0;
        }        
    }
}


