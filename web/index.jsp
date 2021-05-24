<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/23
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        /*function doSearch() {
            //1.创建异步对象
            var xmlHttp = new XMLHttpRequest();
            //2.绑定事件
            xmlHttp.onreadystatechange = function () {
                if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
                    var data = xmlHttp.responseText;
                    //更新dom对象
                    var jsonobj = eval("("+data+")");
                    document.getElementById("proname").value = jsonobj.name;
                    document.getElementById("projiancheng").value = jsonobj.jiancheng;
                    document.getElementById("proshenghui").value = jsonobj.shenghui;
                }
            }
            //3.初始异步对象的请求参数
            var proid = document.getElementById("proid").value;
            xmlHttp.open("get","ajax?proid="+proid,true)
            //4.发送请求
            xmlHttp.send();*/
            $(function () {
                $("#btn").click(function () {
                    //获取dom的value值
                    var proid = $("#proid").val();
                    //发起ajax请求
                    $.ajax({
                        url:"ajax",
                        data:{
                            proid:proid
                        },
                        dataType:"json",
                        success:function (resp) {
                            $("#proname").val(resp.name);
                            $("#projiancheng").val(resp.jiancheng);
                            $("#proshenghui").val(resp.shenghui);
                        }
                    })
                })

            })


    </script>
  </head>
  <body>
      <p>ajax请求使用json格式的数据</p>
      <table>
        <tr>
            <td>省份编号：</td>
            <td>
                <input type="text" id="proid">
                <input type="button" value="搜索"  id="btn">
            </td>
        </tr>
        <tr>
            <td>省份名称：</td>
            <td><input type="text" id="proname"></td>
        </tr>
          <tr>
              <td>省份简称：</td>
              <td><input type="text" id="projiancheng"></td>
          </tr>
          <tr>
              <td>省会名称：</td>
              <td><input type="text" id="proshenghui"></td>
          </tr>
      </table>
  </body>
</html>
