package role;

import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleDao {
    private static String dbUrl = "jdbc:mysql://localhost:3306/connectdb";
    private static String dbUser = "connectuser";
    private static String dbpwd = "connect123";

    public Role getRole(Integer roleId) {
        Role role = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, dbUser, dbpwd);
            String sql = "select role_id, description from role where role_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, roleId); //parameterIndex = sql 문에서 몇번째 ?
            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt(1);
                String desc = rs.getString(2);
                role = new Role(id, desc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
            }
        }

        return role;
    }

    public int addRole(Role role){
        int insertCount = 0;

        Connection con = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, dbUser, dbpwd);
            String sql = "insert into role(role_id, description) values(?, ?)";

            ps = con.prepareStatement(sql);
            ps.setInt(1, role.getRoleId());
            ps.setString(2, role.getDescription());

            insertCount = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return insertCount;
    }

    public List<Role> getRoles(){
        List<Role> list = new ArrayList<>();

        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
        }

        String sql = "select role_id, description from role order by role_id desc";

        try {
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbpwd);
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String desc = rs.getString(2);

                Role role = new Role(id, desc);
                list.add(role);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }


        return list;
    }

    public int deleteRole(Integer roleId){
        int deleteCount = 0;

        Connection con = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, dbUser, dbpwd);
            String sql = "delete from role where role_id = ?";
            ps = con.prepareStatement(sql);

            ps.setInt(1, roleId);
            deleteCount = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return deleteCount;
    }

    public int updateRole(Role role) {
        int updateCount = 0;

        Connection con = null;
        PreparedStatement ps = null;

        try {
            //Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(dbUrl, dbUser, dbpwd);
            String sql = "update role set description = ? where role_id = ?";

            ps = con.prepareStatement(sql);

            ps.setString(1, role.getDescription());
            ps.setInt(2,role.getRoleId());

            updateCount = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return updateCount;
    }

}
