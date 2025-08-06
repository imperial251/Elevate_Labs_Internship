import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private double marks;
    
    public Student() {
    }

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public double getMarks() {
        return marks;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setMarks(double marks) {
        this.marks = marks;
    }
    
    @Override
    public String toString() {
        return String.format("Student [ID: %d, Name: %s, Marks: %.2f]", id, name, marks);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}

class StudentManager {
    private ArrayList<Student> students;
    private Scanner scanner;
    
    public StudentManager() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public void addStudent() {
        
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        
        if (findStudentById(id) != null) {
            System.out.println("Error: Student with ID " + id + " already exists!");
            return;
        }
        
        scanner.nextLine(); 
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Student Marks: ");
        double marks = scanner.nextDouble();
        
        if (marks < 0 || marks > 100) {
            System.out.println("Error: Marks should be between 0 and 100!");
            return;
        }
        
        Student student = new Student(id, name, marks);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void viewAllStudents() {
        
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        
        System.out.println("Total Students: " + students.size());
        
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
    }

    public void viewStudentById() {
        System.out.println("\n--- View Student by ID ---");
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        
        Student student = findStudentById(id);
        if (student != null) {
            System.out.println("Student found:");
            System.out.println(student);
        } else {
            System.out.println("Student with ID " + id + " not found!");
        }
    }

    public void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        
        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student with ID " + id + " not found!");
            return;
        }
        
        System.out.println("Current student details:");
        System.out.println(student);
        
        System.out.println("\nWhat would you like to update?");
        System.out.println("1. Name");
        System.out.println("2. Marks");
        System.out.println("3. Both Name and Marks");
        System.out.print("Enter your choice (1-3): ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        
        switch (choice) {
            case 1:
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                student.setName(newName);
                System.out.println("Name updated successfully!");
                break;
                
            case 2:
                System.out.print("Enter new marks: ");
                double newMarks = scanner.nextDouble();
                if (newMarks >= 0 && newMarks <= 100) {
                    student.setMarks(newMarks);
                    System.out.println("Marks updated successfully!");
                } else {
                    System.out.println("Error: Marks should be between 0 and 100!");
                }
                break;
                
            case 3:
                System.out.print("Enter new name: ");
                String updatedName = scanner.nextLine();
                System.out.print("Enter new marks: ");
                double updatedMarks = scanner.nextDouble();
                
                if (updatedMarks >= 0 && updatedMarks <= 100) {
                    student.setName(updatedName);
                    student.setMarks(updatedMarks);
                    System.out.println("Student information updated successfully!");
                } else {
                    System.out.println("Error: Marks should be between 0 and 100!");
                }
                break;
                
            default:
                System.out.println("Invalid choice!");
        }
    }
    public void deleteStudent() {
        System.out.println("\n--- Delete Student ---");
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        
        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student with ID " + id + " not found!");
            return;
        }
        
        System.out.println("Student to be deleted:");
        System.out.println(student);
        System.out.print("Are you sure you want to delete this student? (y/n): ");
        
        scanner.nextLine(); 
        String confirmation = scanner.nextLine().toLowerCase();
        
        if (confirmation.equals("y") || confirmation.equals("yes")) {
            students.remove(student);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Delete operation cancelled.");
        }
    }
    
   
    private Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    
 
    public void displayMenu() {
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. View Student by ID");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
        System.out.print("Enter your choice (1-6): ");
    }

    public void run() {
        System.out.println("Welcome to Student Management System!");
        
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    viewStudentById();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    System.out.println("Thank you for using Student Management System!");
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a number between 1-6.");
            }
                        System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
            if (choice != 6) {
                scanner.nextLine();
            }
        }
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.run();
    }
}
