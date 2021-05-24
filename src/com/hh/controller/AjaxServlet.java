package com.hh.controller;

import com.hh.dao.ProvinceDao;
import com.hh.entity.Province;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AjaxServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数省份ID
        String proid = request.getParameter("proid");
        //默认值，{}表示json格式的数据
        String json = "{}";
        ProvinceDao dao = new ProvinceDao();
        if(proid != null && proid.trim().length() > 0){
            Province P = dao.queryProvinceById(Integer.valueOf(proid));
            //需要使用jackson把Province对象转换为json

        }
        //指定服务器返回给浏览器的是json格式的数据
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(json);
    }
}
