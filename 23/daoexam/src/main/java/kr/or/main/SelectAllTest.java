package kr.or.main;

import kr.or.config.ApplicationConfig;
import kr.or.dao.RoleDao;
import kr.or.dto.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SelectAllTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        RoleDao roleDao = ac.getBean(RoleDao.class);

        List<Role> list = roleDao.selectAll();

        for(Role role : list){
            System.out.println("role = " + role);
        }
    }
}
