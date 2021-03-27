public class exam05 {
    public static void main(String[] args) {
        RoleDao roleDao = new RoleDao();
        Role role = new Role(500, "CEO");

        int updateCount = roleDao.updateRole(role);
        System.out.println("updateCount = " + updateCount);
    }
}
