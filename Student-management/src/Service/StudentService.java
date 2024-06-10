package Service;
    import DAO.StudentDAO;
    import Model.Student;

    import java.util.List;

    public class StudentService {
        private StudentDAO studentDAO;

        public StudentService(StudentDAO studentDAO) {
            this.studentDAO = studentDAO;
        }

        public void addStudent(Student student) {
            studentDAO.addStudent(student);
        }

        public void updateStudent(Student student) {
            studentDAO.updateStudent(student);
        }

        public void deleteStudent(int id) {
            studentDAO.deleteStudent(id);
        }

        public Student getStudentById(int id) {
            return studentDAO.getStudentById(id);
        }

        public List<Student> getAllStudents() {
            return studentDAO.getAllStudents();
        }
    }
