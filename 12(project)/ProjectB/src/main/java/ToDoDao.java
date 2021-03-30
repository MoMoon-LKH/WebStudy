import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ToDoDao {
    private static final String dbUrl = "http://localhost:3306/projectdb";
    private static final String dbUser = "connectuser";
    private static final String dbPw = "connect123";

    public int addTodo(ToDo toDo){
        int addCount = 0;
        String sql = "insert into todo(title, name, sequence) values(?, ?, ?)";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, dbUser, dbPw);
            ps = con.prepareStatement(sql);

            ps.setString(1, toDo.getTitle());
            ps.setString(2, toDo.getName());
            ps.setInt(3, toDo.getSequence());

            addCount = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return addCount;
    }

    public List<ToDo> getTodos(){
        List<ToDo> list = new ArrayList<>();
        String sql = "select * from todo";
        Connection con  = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, dbUser, dbPw);
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id");
                String title = rs.getString("title");
                String name = rs.getString("name");
                int sq = rs.getInt("sequence");
                String type = rs.getString("type");
                String date = rs.getString("regdate");

                ToDo toDo = new ToDo(id,title,name, sq, type, date);
                list.add(toDo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(ps != null) {
                try {
                    ps.close();
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }

            if(con != null) {
                try {
                    con.close();
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

    public int updateTodo(ToDo toDo){
        int upCount = 0;
        String sql = "update todo set type  = ? where id = ?";

        Connection con  = null;
        PreparedStatement ps = null;

        try {
            Class.forName( "com.mysql.jdbc.Driver" );

            con = DriverManager.getConnection ( dbUrl, dbUser, dbPw );
            ps = con.prepareStatement(sql);

            ps.setString(1, toDo.getType());
            ps.setInt(2, toDo.getId().intValue());

            upCount = ps.executeUpdate();

        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            if(ps != null) {
                try {
                    ps.close();
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }

            if(con != null) {
                try {
                    con.close();
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return upCount;

    }
}
