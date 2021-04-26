package kr.or.main;

import kr.or.config.ApplicationConfig;
import kr.or.dao.RoleDao;
import kr.or.dto.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class jdbcTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        RoleDao roleDao = ac.getBean(RoleDao.class);

        Role role = new Role();
        role.setRoleId(102);
        role.setDescription("Programmer");

        /*int count = roleDao.insert(role);
        System.out.println("insert 수 = " + count);*/
        /*int count = roleDao.update(role);
        System.out.println("update 수 = " + count);*/

        /*int count = roleDao.delete(510);
        System.out.println("delete 수 = " + count);*/

        Role resultRole = roleDao.selectOne(102);
        System.out.println("resultRole = " + resultRole);

    }
}
