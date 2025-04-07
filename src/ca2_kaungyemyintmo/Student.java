/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2_kaungyemyintmo;

/**
 *
 * @author KAUNG YE MYINT MO 
 */
import java.util.*;
import java.io.Serializable;

public class Student implements Serializable {

    // ===========================
    // CONFIG
    // ===========================    
    private String className = "";
    private String adminNumber = "";
    private String studentName = "";
    private double studentGPA = 0.0;
    private String enrollmentType = "";
    private List<Module> studentModules = new ArrayList<>();

    // ===========================
    // CONSTRUCTOR
    // ===========================    
    public Student(String className, String adminNumber, String studentName,
            double studentGPA, List<Module> studentModules, String enrollmentType) {
        this.adminNumber = adminNumber;
        this.className = className;
        this.enrollmentType = enrollmentType;
        this.studentGPA = studentGPA;
        this.studentName = studentName;
        this.studentModules = studentModules;
    }

    public Student() {
        this.adminNumber = "";
        this.className = "";
        this.studentName = "";
        this.enrollmentType = "";
        this.studentGPA = 0.0;
        this.studentModules = new ArrayList<>();
    }

    // ===========================
    // GETTER/SETTER
    // ===========================    
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAdminNumber() {
        return adminNumber;
    }

    public void setAdminNumber(String adminNumber) {
        this.adminNumber = adminNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    // Double because it is used to change to String datatype in GUI 
    public Double getStudentGPA() {
        calculcateStudentGPA(studentModules);
        return studentGPA;
    }

    public String getEnrollmentType() {
        return enrollmentType;
    }

    public void setEnrollmentType(String enrollmentType) {
        this.enrollmentType = enrollmentType;
    }

    public void setStudentGPA(double studentGPA) {
        this.studentGPA = studentGPA;
    }

    public List<Module> getStudentModules() {
        return studentModules;
    }

    public void setStudentModules(List<Module> studentModules) {
        this.studentModules = studentModules;
    }

    // ===========================
    // EXTRA BEHAVIOURS
    // ===========================    
    public void addStudentModules(Module studentModule) {
        this.studentModules.add(studentModule);
    }

    public void calculcateStudentGPA(List<Module> studentModules) {
        int totalCreditUnit = 0;
        double gradePoints = 0.0;
        String studentGPA = "";
        for (Module module : studentModules) {
            if (module.getCreditUnit() != 0) {
                totalCreditUnit += module.getCreditUnit();
                gradePoints += (module.calculateGradePoint() * module.getCreditUnit());
            }
        }

        if (totalCreditUnit > 0) {
            this.setStudentGPA(gradePoints / totalCreditUnit);
        } else {
            this.setStudentGPA(0);
        }
    }

}
