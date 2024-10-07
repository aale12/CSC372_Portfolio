package CSC273.CSC372_Portfolio;

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
        }
    }
}
