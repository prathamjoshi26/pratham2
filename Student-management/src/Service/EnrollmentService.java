package Service;
import DAO.EnrollmentDAO;
import Model.Course;
import Model.Enrollment;

import java.util.List;

public class EnrollmentService {
    private EnrollmentDAO enrollmentDAO;

    public EnrollmentService(EnrollmentDAO enrollmentDAO) {
        this.enrollmentDAO = enrollmentDAO;
    }

    public void enrollStudent(int studentId, int courseId) {
        enrollmentDAO.enrollStudent(studentId, courseId);
    }

    public List<Enrollment> getEnrollmentsByStudent(int studentId) {
        return enrollmentDAO.getEnrollmentsByStudent(studentId);
    }

    public List<Enrollment> getEnrollmentsByCourse(int courseId) {
        return enrollmentDAO.getEnrollmentsByCourse(courseId);
    }

    public void addEnrollments(Course enrollment) {
        enrollmentDAO.addEnrollment(enrollment);
    }

    public void updateEnrollments(Course enrollment) {
        enrollmentDAO.updateEnrollments(enrollment);

    }

    public void deleteEnrollments(int id) {
        enrollmentDAO.deleteEnrollments(id);

    }

      public List<Enrollment> getAllEnrollment() {
        return enrollmentDAO.getAllEnrollment();

    }

    public <Enrollments> Object EnrollmentService() {
        return enrollmentDAO.getAllEnrollments ;
    }


    public <Enrollments> List<Enrollments> getAllEnrollments() {
        return null;
    }
}

