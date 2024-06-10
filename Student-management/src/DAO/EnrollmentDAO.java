package DAO;

import Model.Course;
import Model.Enrollment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class EnrollmentDAO{
        public Object getAllEnrollments;
        private Connection connection;

        public EnrollmentDAO(Connection connection) {
            this.connection = connection;
        }

        public void enrollStudent(int studentId, int courseId) {
            String query = "INSERT INTO enrollment (student_id, course_id) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, studentId);
                preparedStatement.setInt(2, courseId);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public List<Enrollment> getEnrollmentsByStudent(int studentId) {
            List<Enrollment> enrollments = new ArrayList<>();
            String query = "SELECT * FROM enrollment WHERE student_id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, studentId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        enrollments.add(new Enrollment(resultSet.getInt("id"),
                                resultSet.getInt("student_id"), resultSet.getInt("course_id")));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return enrollments;
        }

        public List<Enrollment> getEnrollmentsByCourse(int courseId) {
            List<Enrollment> enrollments = new ArrayList<>();
            String query = "SELECT * FROM enrollment WHERE course_id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, courseId);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        enrollments.add(new Enrollment(resultSet.getInt("id"),
                                resultSet.getInt("student_id"), resultSet.getInt("course_id")));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return enrollments;
        }

        public void addEnrollment(Course enrollment) {

        }

        public void addEnrollment(Enrollment enrollment) {


        }

        public void updateEnrollments(Course enrollment) {


        }

        public void getEnrollmentsBy(int id) {


        }

        public List<Enrollment> getAllEnrollment() {
            return null;
        }

        public void deleteEnrollments(int id) {

        }
    }

