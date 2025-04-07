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
