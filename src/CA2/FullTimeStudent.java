/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA2;

import java.util.List;

/**
 *
 * @author KAUNG YE MYINT MO 
 * Class : DIT/FT/2A/01 
 * Adm No : P2340250
 */
public class FullTimeStudent extends Student {

    // ===========================
    // CONFIG
    // =========================== 
    final String ENROLLMENTTYPE = "Full-Time";

    // ===========================
    // CONSTRUCTOR
    // =========================== 
    public FullTimeStudent(String className, String adminNumber,
            String studentName, double studentGPA, List<Module> studentModules) {
        super(className, adminNumber, studentName,
                studentGPA, studentModules, "Full-Time");
    }

    public FullTimeStudent() {
        super();
        setEnrollmentType(ENROLLMENTTYPE);
    }
}
