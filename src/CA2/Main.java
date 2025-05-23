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
public class Main {

    private View view;
    private Model model;
    private FileIOModel fileIOModel;

    public static void main(String[] args) {

        // ===========================    
        // CONFIG
        // ===========================    
        View view = new View();
        StudentSearchTableView studentSearchTableView = new StudentSearchTableView();
        Model model = new Model(view);
        FileIOModel fileIOModel = new FileIOModel();
        Controller controller = new Controller(model, fileIOModel, view, studentSearchTableView);

        // ===========================    
        // SET CONTROLLER
        // ===========================    
        view.setController(controller);
        studentSearchTableView.setController(controller);

        // ===========================    
        // RUN CONTROLLER - initialize file
        // ===========================    
        controller.run();

        // ===========================    
        // PRRESENTATION
        // ===========================    
        view.setVisible(true);
    }
}
