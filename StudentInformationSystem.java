import java.util.Scanner;
import java.util.ArrayList;

class Student {
    private String name;
    private int age;
    private double grade;
    private String studentId;
    private String contact;

    public Student(String name, int age, double grade, String studentId, String contact) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.studentId = studentId;
        this.contact = contact;
    }

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGrade() { return grade; }
    public String getStudentId() { return studentId; }
    public String getContact() { return contact; }

    // Setters
    public void setName(String name) { this.name = name; }

    public void setAge(int age) {
        if (age > 0) this.age = age;
        else System.out.println("Age must be positive!");
    }

    public void setGrade(double grade) { this.grade = grade; }
    public void setContact(String contact) { this.contact = contact; }

    // Display
    public void displayInfo() {
        System.out.println("\nStudent ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
        System.out.println("Contact: " + contact);
        System.out.println("-".repeat(30));
    }
}

public class StudentInformationSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== STUDENT INFORMATION SYSTEM ===");
            System.out.println("1. Add New Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    running = false;
                    System.out.println("Thank you for using Student Information System!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
        scanner.close();
    }

    // Add Student
    private static void addStudent() {
        System.out.println("\n=== ADD NEW STUDENT ===");

        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        // Check duplicate ID
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Contact: ");
        String contact = scanner.nextLine();

        students.add(new Student(name, age, grade, studentId, contact));
        System.out.println("Student added successfully!");
    }

    // View All
    private static void viewAllStudents() {
        System.out.println("\n=== ALL STUDENTS ===");

        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.printf("%-15s %-20s %-8s %-8s %-15s\n",
                "Student ID", "Name", "Age", "Grade", "Contact");
        System.out.println("-".repeat(70));

        for (Student student : students) {
            System.out.printf("%-15s %-20s %-8d %-8.2f %-15s\n",
                    student.getStudentId(),
                    student.getName(),
                    student.getAge(),
                    student.getGrade(),
                    student.getContact());
        }
    }

    // Search
    private static void searchStudent() {
        System.out.print("\nEnter Student ID to search: ");
        String id = scanner.nextLine();

        for (Student student : students) {
            if (student.getStudentId().equals(id)) {
                student.displayInfo();
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Update
    private static void updateStudent() {
        System.out.print("\nEnter Student ID to update: ");
        String id = scanner.nextLine();

        for (Student student : students) {
            if (student.getStudentId().equals(id)) {

                System.out.print("Enter new name: ");
                student.setName(scanner.nextLine());

                System.out.print("Enter new age: ");
                student.setAge(scanner.nextInt());

                System.out.print("Enter new grade: ");
                student.setGrade(scanner.nextDouble());
                scanner.nextLine(); // consume newline

                System.out.print("Enter new contact: ");
                student.setContact(scanner.nextLine());

                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }
}