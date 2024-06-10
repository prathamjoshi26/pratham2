package DAO;

    import Model.Student;

    import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class StudentDAO {
        private Connection connection;

        public StudentDAO(Connection connection) {
            this.connection = connection;
        }

        public void addStudent(Student student) {
            String query = "INSERT INTO student (name) VALUES (?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, student.getName());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void updateStudent(Student student) {
            String query = "UPDATE student SET name=? WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, student.getName());
                preparedStatement.setInt(2, student.getId());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void deleteStudent(int id) {
            String query = "DELETE FROM student WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public Student getStudentById(int id) {
            String query = "SELECT * FROM student WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new Student(resultSet.getInt("id"), resultSet.getString("name"));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        public List<Student> getAllStudents() {
            List<Student> students = new ArrayList<>();
            String query = "SELECT * FROM student";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    students.add(new Student(resultSet.getInt("id"), resultSet.getString("name")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return students;
        }
    }
