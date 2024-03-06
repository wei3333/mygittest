package util;

import entity.Role;

import java.sql.*;

public final class JDBCUtil {
    private static String  url = "jdbc:mysql://36.133.125.200:3306/happybuffalo";
    private static String user = "root";
    private static String password = "PAss23!@";

    private JDBCUtil(){

    }
    //注册驱动
    static {
        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //注册驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("未找到驱动程序类");
        }
    }
    /**
     * @return 连接对象
     * @throws SQLException
     */
    public static Connection getConn() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    //关闭、释放资源
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {	rs.close();	}
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null){	stmt.close();}
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null){	conn.close();}
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //关闭、释放资源
    public static void close(Statement stmt, Connection conn) {
        JDBCUtil.close(null,stmt,conn);
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = JDBCUtil.getConn();
        Statement stmt = connection.createStatement();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from role where id = ?");
        preparedStatement.setInt(1,1);
        ResultSet resultSet = preparedStatement.executeQuery();
        Role role1 = null;
        if (resultSet.next()) {
            role1 = new Role(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("code")
            );
        }
        //关闭资源
        JDBCUtil.close(resultSet, preparedStatement, connection);
        System.out.println(role1.getName());
    }
}
