package Service;

    import DAO.CourseDAO;
    import Model.Course;

    import java.util.List;

    public class CourseService {
        private CourseDAO courseDAO;

        public CourseService(CourseDAO courseDAO) {
            this.courseDAO = courseDAO;
        }

        public void addCourse(Course course) {
            courseDAO.addCourse(course);
        }

        public void updateCourse(Course course) {
            courseDAO.updateCourse(course);
        }

        public void deleteCourse(int id) {
            courseDAO.deleteCourse(id);
        }

        public Course getCourseById(int id) {
            return courseDAO.getCourseById(id);
        }

        public List<Course> getAllCourses() {
            return courseDAO.getAllCourses();
        }
    }