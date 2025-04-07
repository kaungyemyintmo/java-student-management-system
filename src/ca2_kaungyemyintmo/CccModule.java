/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2_kaungyemyintmo;

/**
 *
 * @author KAUNG YE MYINT MO 
 */
public class CccModule extends Module {

    // ===========================
    // CONFIG
    // =========================== 
    final String MODULETYPE = "Common Core Curriculum"; 
    
    // ===========================
    // CONSTRUCTOR
    // =========================== 
    public CccModule() {
        super();
        setType(MODULETYPE);
    }

    public CccModule(String moduleCode, String moduleName, int creditUnit, int studentMarks,
            String type) {
        super(moduleCode, moduleName, creditUnit, studentMarks, "Common Core Curriculum");
    }
}
