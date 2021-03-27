public class exam04 {
    public static void main(String[] args) {
        RoleDao roleDao = new RoleDao();

        int deleteCount = roleDao.deleteRole(500);

        System.out.println("deleteCount = " + deleteCount);
    }
}
