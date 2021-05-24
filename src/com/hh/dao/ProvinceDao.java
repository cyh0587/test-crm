package com.hh.dao;

import com.hh.entity.Province;
import com.hh.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProvinceDao {
    private JdbcUtil util = new JdbcUtil();
    //根据id获取一个完整的Province对象
    public Province queryProvinceById(Integer provinceId){
        Province province = null;
        String sql = "select id, name, jiancheng,shenghui from province where id=?";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        try {
            ps.setInt(1,provinceId);
            rs = ps.executeQuery();
            if(rs.next()){
                provinceId = rs.getInt("id");
                String name = rs.getString("name");
                String shenghui = rs.getString("shenghui");
                String jiancheng = rs.getString("jiancheng");
                province = new Province(provinceId,name,shenghui,jiancheng);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return province;
    }
}
