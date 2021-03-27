import java.util.List;

public class exam3 {
    public static void main(String[] args) {
        RoleDao roleDao = new RoleDao();

        List<Role> list = roleDao.getRoles();

        for(Role role : list){
            System.out.println("role = " + role);
        }
    }
}
