public class jdbcexam2 {
    public static void main(String[] args) {
        int roleId =500;
        String desc = "CTO";

        Role role = new Role(roleId, desc);

        RoleDao roleDao = new RoleDao();
        int insertCount = roleDao.addRole(role);
        System.out.println("insertCount = " + insertCount);
    }
}
