package DAO;

import Model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class CourseDAO{
        private Connection connection;

        public CourseDAO(Connection connection) {
            this.connection = connection;
        }

        public void addCourse(Course course) {
            String query = "INSERT INTO course (name) VALUES (?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, course.getName());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void updateCourse(Course course) {
            String query = "UPDATE course SET name=? WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, course.getName());
                preparedStatement.setInt(2, course.getId());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void deleteCourse(int id) {
            String query = "DELETE FROM course WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public Course getCourseById(int id) {
            String query = "SELECT * FROM course WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Course(resultSet.getInt("id"), resultSet.getString("name"));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        public List<Course> getAllCourses() {
            List<Course> courses = new ArrayList<>();
            String query = "SELECT * FROM course";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    courses.add(new Course(resultSet.getInt("id"), resultSet.getString("name")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return courses;
        }
    }

