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
public class PartTimeStudent extends Student {
    
    // ===========================
    // CONFIG
    // =========================== 
    final String ENROLLMENTTYPE= "Part-Time"; 

    // ===========================
    // CONSTRUCTOR
    // =========================== 
    public PartTimeStudent(String className, String adminNumber, 
            String studentName,double studentGPA, List<Module> studentModules) {
        super(className, adminNumber, studentName, 
                studentGPA, studentModules, "Part-Time");
    }
    
    public PartTimeStudent() {
        super(); 
        setEnrollmentType(ENROLLMENTTYPE);
    }
    
}
