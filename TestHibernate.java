public class TestHibernate {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        Student s1 = new Student("Amit", 22);
        dao.createStudent(s1);

        Student s2 = dao.readStudent(s1.getId());
        System.out.println(s2.getName());

        dao.updateStudent(s1.getId(), "Amit Sharma");

        dao.deleteStudent(s1.getId());
    }
}
