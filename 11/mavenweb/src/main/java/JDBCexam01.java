public class JDBCexam01 {
    public static void main(String[] args) {
        RoleDao dao = new RoleDao();
        Role role = dao.getRole(100);

        System.out.println("role = " + role);
    }
}
