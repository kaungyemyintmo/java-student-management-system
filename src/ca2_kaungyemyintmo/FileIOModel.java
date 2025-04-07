/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2_kaungyemyintmo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author KAUNG YE MYINT MO 
 */
public class FileIOModel {

    // ===========================
    // CONFIG
    // =========================== 
    final Random random = new Random();
    final DataGenerateModel dataModel = new DataGenerateModel();

    // ===========================
    // write dummy data to file 
    // =========================== 
    public void writeStudentsFile(String fileName) throws IOException {

        File studentFile = new File(fileName);
        
        // create new file if not found
        if (!studentFile.exists()) {
         //   studentFile.createNewFile();
            if (studentFile.createNewFile()) {
                System.out.println("File created: " + studentFile.getName());
            } else {
                System.out.println("File already exists.");
            }
}
      // } else {
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(studentFile));

            try {

                // create 1000 entry 
                writer.write("1000");
                writer.newLine();
                for (int i = 0; i < 1000; i++) {
                    String line = "";
                    try {
                        line += dataModel.generateRandomClass(random);
                        line += dataModel.generateRandomAdminNumber(random);
                        line += dataModel.generateRandomName(random);
                        line += dataModel.generateRandomModules(random);
                        writer.write(line);
                    } catch (NumberFormatException e) {
                        System.out.print(e.getMessage());
                    }
                    writer.newLine();
                }
                System.out.println("Success");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (writer != null) {
                    try {
                        writer.close();
                        System.out.println("Writer has closed.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
      // }
    }

    // ===========================
    // read data from file
    // =========================== 
    public List<String> readFile(File studentFile) throws IOException {
        // ===========================
        // CONFIG
        // =========================== 
        List<String> lines = new ArrayList<>();

        if (!studentFile.exists()) {
            System.out.println("File does not exist");
        } else {
            BufferedReader br = new BufferedReader(new FileReader(studentFile));

            try {
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return lines;
    }
}
