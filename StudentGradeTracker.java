import java.util.ArrayList;
import java.util.Scanner;

/**
 * Console-based Student Grade Tracker.
 * Features: add student, update grade, remove student,
 * view summary report (average, highest, lowest).
 */
public class StudentGradeTracker {

    // ArrayList stores all students (grows automatically)
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateGrade();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    showSummaryReport();
                    break;
                case 5:
                    System.out.println("Thank you for using Student Grade Tracker. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-5.");
            }
        } while (choice != 5);
    }

    private static void showMenu() {
        System.out.println("\n===== STUDENT GRADE TRACKER =====");
        System.out.println("1. Add student");
        System.out.println("2. Update student grade");
        System.out.println("3. Remove student");
        System.out.println("4. View summary report");
        System.out.println("5. Exit");
    }

    // Add a new student with a grade
    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }
        if (findStudent(name) != null) {
            System.out.println("This student already exists. Use option 2 to update the grade.");
            return;
        }
        double grade = readGrade("Enter grade (0-100): ");
        students.add(new Student(name, grade));
        System.out.println("Student added successfully.");
    }

    // Change the grade of an existing student
    private static void updateGrade() {
        System.out.print("Enter student name to update: ");
        Student s = findStudent(sc.nextLine().trim());
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        s.setGrade(readGrade("Enter new grade (0-100): "));
        System.out.println("Grade updated successfully.");
    }

    // Delete a student from the list
    private static void removeStudent() {
        System.out.print("Enter student name to remove: ");
        Student s = findStudent(sc.nextLine().trim());
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        students.remove(s);
        System.out.println("Student removed successfully.");
    }

    // Print all students plus average, highest and lowest scores
    private static void showSummaryReport() {
        if (students.isEmpty()) {
            System.out.println("No students added yet.");
            return;
        }

        double total = 0;
        Student highest = students.get(0);
        Student lowest = students.get(0);

        System.out.println("\n----------- SUMMARY REPORT -----------");
        System.out.printf("%-5s %-20s %-10s%n", "No.", "Name", "Grade");
        System.out.println("--------------------------------------");

        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.printf("%-5d %-20s %-10.2f%n", i + 1, s.getName(), s.getGrade());
            total += s.getGrade();
            if (s.getGrade() > highest.getGrade()) {
                highest = s;
            }
            if (s.getGrade() < lowest.getGrade()) {
                lowest = s;
            }
        }

        double average = total / students.size();
        System.out.println("--------------------------------------");
        System.out.println("Total students : " + students.size());
        System.out.printf("Average score  : %.2f%n", average);
        System.out.printf("Highest score  : %.2f (%s)%n", highest.getGrade(), highest.getName());
        System.out.printf("Lowest score   : %.2f (%s)%n", lowest.getGrade(), lowest.getName());
    }

    // Search student by name (ignores upper/lower case)
    private static Student findStudent(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    // Keep asking until the user types a valid whole number
    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    // Keep asking until the user types a grade between 0 and 100
    private static double readGrade(String message) {
        while (true) {
            System.out.print(message);
            try {
                double grade = Double.parseDouble(sc.nextLine().trim());
                if (grade >= 0 && grade <= 100) {
                    return grade;
                }
                System.out.println("Grade must be between 0 and 100.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
