import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import Model.Course;
import Model.Student;
import DAO.CourseDAO;
import DAO.EnrollmentDAO;
import DAO.StudentDAO;
import DBUtill.DBConnection;
import Service.CourseService;
import Service.EnrollmentService;
import Service.StudentService;

public class Main {

    public static void main(String[] args) {
        try (Connection connection = DBConnection.getConnection()) {
            Scanner scanner = new Scanner(System.in);
            StudentDAO studentDAO = new StudentDAO(connection);
            CourseDAO courseDAO = new CourseDAO(connection);
            EnrollmentDAO enrollmentDAO = new EnrollmentDAO(connection);
            StudentService studentService = new StudentService(studentDAO);
            CourseService courseService = new CourseService(courseDAO);
            EnrollmentService enrollmentService = new EnrollmentService(enrollmentDAO);

            boolean exit = false;
            while (!exit) {
                System.out.println("\nMain Menu");
                System.out.println("1. Manage Students");
                System.out.println("2. Manage Courses");
                System.out.println("3. Manage Enrollments");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        manageStudents(scanner, studentService);
                        break;
                    case 2:
                        manageCourses(scanner, courseService);
                        break;
                    case 3:
                        manageEnrollments(scanner, enrollmentService);
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void manageStudents(Scanner scanner, StudentService studentService) {
        boolean backToMenu = false;
        while (!backToMenu) {
            System.out.println("\nManage Students");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View All Students");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    studentService.addStudent(new Student(0, studentName));
                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    System.out.print("Enter student ID to update: ");
                    int updateStudentId = scanner.nextInt();
                    scanner.nextLine();
                    String updatedStudentName = scanner.nextLine();
                    studentService.updateStudent(new Student(updateStudentId, updatedStudentName));
                    System.out.println("Student updated successfully.");
                    break;
                case 3:
                    System.out.print("Enter student ID to delete: ");
                    int deleteStudentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    studentService.deleteStudent(deleteStudentId);
                    System.out.println("Student deleted successfully.");
                    break;
                case 4:
                    List<Student> students = studentService.getAllStudents();
                    System.out.println("\nAll Students:");
                    for (Student student : students) {
                        System.out.println("ID: " + student.getId() + ", Name: " + student.getName());
                    }
                    break;
                case 5:
                    backToMenu = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void manageCourses(Scanner scanner, CourseService courseService) {
            boolean backToMenu = false;
            while (!backToMenu) {
            System.out.println("\nManage Courses:");
            System.out.println("1. Add Course");
            System.out.println("2. Update Course");
            System.out.println("3. Delete Course");
            System.out.println("4. View Courses");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                case 1:
                    System.out.print("Enter course name: ");
                    String CourseName = scanner.nextLine();
                    courseService.addCourse(new Course( 0, CourseName));
                    System.out.println("Course added successfully.");

                    break;
                case 2:
                    System.out.print("Enter Course ID to update: ");
                    int updateCourseId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new Course name: ");
                    String updatedCourseName = scanner.nextLine();
                    courseService.updateCourse(new Course(updateCourseId, updatedCourseName));
                    System.out.println("Student updated successfully.");
                    break;
                case 3:
                    System.out.print("Enter Course ID to delete: ");
                    int deleteCourseId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    courseService.deleteCourse(deleteCourseId);
                    System.out.println("Student deleted successfully.");
                    break;
                case 4:
                    List<Course> courses = courseService.getAllCourses();
                    System.out.println("\nAll Courses:");
                    for (Course course : courses) {
                        System.out.println("ID: " + course.getId() + ", Course Name: " + course.getName());
                    }
                case 5:
                    backToMenu = true;
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static <Enrollments> void manageEnrollments (Scanner scanner, EnrollmentService enrollmentService){
        boolean backToMenu = false;
        while (!backToMenu) {
            System.out.println("\nManage Enrollments:");
            System.out.println("1. Add Enrollments");
            System.out.println("2. Update Enrollments");
            System.out.println("3. Delete Enrollments");
            System.out.println("4. View Enrollments");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter enrollments name: ");
                    String EnrollmentsName = scanner.nextLine();
                    enrollmentService.addEnrollments(new Course( 0, EnrollmentsName));
                    System.out.println("Enrollments added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Enrollments  ID to update: ");
                    int updateEnrollmentsId = scanner.nextInt();
                    scanner.nextLine(); //
                    System.out.print("Enter new Enrollments name: ");
                    String updatedEnrollmentsName = scanner.nextLine();
                    enrollmentService.updateEnrollments(new Course(updateEnrollmentsId, updatedEnrollmentsName));
                    System.out.println("Student updated successfully.");
                    break;
                case 3:
                    System.out.print("Enter Enrollments  ID to delete: ");
                    int deleteEnrollmentsId = scanner.nextInt();
                    scanner.nextLine(); //
                    enrollmentService.deleteEnrollments(deleteEnrollmentsId);
                    System.out.println("Student deleted successfully.");
                    break;

                case 4:
                    List<Enrollments > enrollments  = enrollmentService.getAllEnrollments ();
                    System.out.println("\nAll Enrollments :");
                    for (Enrollments  enrollments1 : enrollments ) {
                        System.out.println("ID: " + enrollments1.getClass() + ", Enrollments Name: " + enrollments1.getClass());
                    }


                case 5:
                    backToMenu = true;
                    break;

                default:
                    System.out.println("Invalid choice");

             }

           }

        }
    }





