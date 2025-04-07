/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2_kaungyemyintmo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 *
 * @author KAUNG YE MYINT MO 
 */
public class DataGenerateModel {

    // ===========================
    // CONFIG
    // =========================== 
    // HashSet for unique admin numbers
    HashSet<String> uniqueAdminNumbers = new HashSet<>();

    public String generateRandomAdminNumber(Random random) {

        // ===========================
        // CONFIG
        // ===========================
        String randomAdminNumber = "";
        String adminNumber = "";
        randomAdminNumber = "P" + (2300000 + random.nextInt(2399999));

        // ===========================
        // PROCESSING
        // ===========================
        uniqueAdminNumbers.add(randomAdminNumber);

        // check if the admin number is unique before adding
        do {
            adminNumber = randomAdminNumber;
            adminNumber += ";";
            return adminNumber;
        } while (!uniqueAdminNumbers.add(randomAdminNumber));
    }

    public String generateRandomClass(Random random) {

        // ===========================
        // CONFIG
        // ===========================
        String[] diplomaAry = {"DIT", "DAAA", "DCDF", "DCITP"};
        int randomDiplomaIndex = random.nextInt(diplomaAry.length);

        String[] enrollmentTypeAry = {"FT", "PT"};
        int randomEnrollmentTypeIndex = random.nextInt(enrollmentTypeAry.length);

        int randomYear = random.nextInt(3) + 1;

        char randomSemester = (char) ('A' + random.nextInt(2));
        int randomClassNumber = random.nextInt(25) + 1;
        String classStr = "";

        // ===========================
        // PROCESSING
        // ===========================
        classStr += diplomaAry[randomDiplomaIndex];
        classStr += "/";
        classStr += enrollmentTypeAry[randomEnrollmentTypeIndex];
        classStr += "/";
        classStr += randomYear;
        classStr += randomSemester;
        classStr += "/";

        if (randomClassNumber < 10) {
            classStr += "0";
        }

        classStr += randomClassNumber;
        classStr += ";";
        return classStr;
    }

    public String generateRandomModules(Random random) {
        // ===========================
        // CONFIG
        // ===========================
        int randomNumber = random.nextInt(5) + 1;
        int randomModuleIndex = 0;
        String[] moduleNameArray = {"Java", "DBSP", "SCP", "PBCA", "EWW", "FOP", "LC5G", "DCI", "TCU"};
        String[] moduleCodeArray = {"ST0509", "ST0508", "ST0527", "CCC_PBCA", "CCC_EWW", "ST0502", "EP0409", "CCC_DCI", "CCC_TCU"};
        
// store added module indexes in here to reduce module redundancy 
        List<Integer> moduleIndices = new ArrayList<>();
        String studentModules = "";

        studentModules += randomNumber;
        studentModules += ";";
        for (int i = 0; i < randomNumber; i++) {
            // to check if the moduleIndices array includes a specific index
            // if so, regenerate
            do {
                randomModuleIndex = random.nextInt(moduleNameArray.length);
            } while (moduleIndices.contains(randomModuleIndex));

            moduleIndices.add(randomModuleIndex);

            int randomMark = random.nextInt(100) + 1;
            studentModules += moduleCodeArray[randomModuleIndex];
            studentModules += ";";
            studentModules += moduleNameArray[randomModuleIndex];
            studentModules += ";";
            studentModules += (random.nextInt(5) + 1);
            studentModules += ";";
            studentModules += randomMark;
            studentModules += ";";
        }

        return studentModules;
    }

    public String generateRandomName(Random random) {
        // ===========================
        // CONFIG
        // =========================== 
        String studentName = "";
        String[] names = {"Alice Johnson", "Bob Mills", "Charlie Ken", "Diana Wills",
            "Eve Banks", "Frank Ocean", "Grace Walter", "Hank Green", "Ivy Ray", "Jack Roberts"};
        int randomNameIndex = random.nextInt(names.length);

        if (names[randomNameIndex].matches("^[A-Za-z ]+$")) {
            studentName = names[randomNameIndex];
        }

        studentName += ";";
        return studentName;
    }
}
