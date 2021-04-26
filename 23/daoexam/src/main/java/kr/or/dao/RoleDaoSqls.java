package kr.or.dao;

public class RoleDaoSqls {
    public static final String SELECT_ALL =
            "select role_id, description from role order by role_id";
    public static final String UPDATE =
            "update role set description = :description where role_id = :roleId";
    public static final String FIND =
            "select role_id, description from role where role_id = :roleId";
    public static final String DELETE =
            "delete from role where role_id = :roleId";
}
