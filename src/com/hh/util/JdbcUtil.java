package com.hh.util;

import java.sql.*;

/**
 * 将JDBC规范下相关的对象创建与销毁功能封装到方法
 *
 * 一。JDBC开发步骤：
 *     1.注册数据库服务器提供的Driver接口实现类
 *     2.创建一个连接通道交给Connection接口的实例对象【JDBC4Connection】管理
 *     3.创建一个交通工具交给PreparedStatement接口的实例对象【JDBC4PreparedStatement】管理
 *     4.由交通工具在Java工程与数据库服务器之间进行传输，推送SQL命令并带回执行结果
 *     5.交易结束后，销毁相关资源【Connection，PreparedStatement，ResultSet】
 */
public class JdbcUtil {
    private Connection con = null;
    private PreparedStatement ps = null;
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //封装Connection对象创建的细节
    public Connection createCon(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","7850");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    //封装PreparedStatement对象
    public PreparedStatement createStatement(String sql){
        Connection con = createCon();
        try {
            ps = con.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }
    public void close(){
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void close(ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close();
    }
}
