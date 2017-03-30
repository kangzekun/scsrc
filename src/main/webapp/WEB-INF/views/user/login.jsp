<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>

    <script type="text/javascript" src="http://cdn.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">

        function myfun(){
            var mydata={"name":"zhou","age":"23"};
            $.ajax( {
                url : "/spark/sparkShow",
                dataType:"json",
                data : mydata,
                success : function(data) {
                    var dtol=data.dtol;
                    var iter=data.iter;
                    for(var i=0;i<dtol.length;i++) {
                        alert(dtol[i]);
                    }
                }
            });
        }
    </script>
</head>
<body>
<input onclick="myfun()" type="button" value="click here">
</body>
</html>