package CSC273.CSC372_Portfolio;

import java.io.FileWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentData {

    public static void main(String[] args) {
        LinkedList<Student> students = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        // boolean invalidInput = true;

        do {
            System.out.println("Enter a student name, enter 'done' to exit");
            String userInputName = sc.nextLine();
            if (userInputName.equalsIgnoreCase("done")) {
                break;
            }
            System.out.println("Enter student address:");
            String userInputAddress = sc.nextLine();

            double userInputGPA = 0.0;
            while (true) {
                try {
                    System.out.println("Enter Student GPA: ");
                    userInputGPA = Double.parseDouble(sc.nextLine());
                    if (userInputGPA < 0.0 || userInputGPA > 4.0) {
                        System.out.println("GPA must be a number between 0.0 and 4.0");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Number. Please enter a number");
                }
            }
            students.add(new Student(userInputGPA, userInputAddress, userInputName));
        } while (true);

        Collections.sort(students, Comparator.comparing(Student::getName));
        for (Student s : students) {
            System.out.println(s.toString());
        }
        try (FileWriter writer = new FileWriter("students.txt")) {
            for (Student s : students) {
                writer.write(s.toString() + "\n");
            }
            System.out.println("Student data written to file.");
        } catch (Exception e) {
            System.out.println("Error occured while writing");
        }
    }
}
