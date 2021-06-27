<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/4/29 0029
  Time: 0:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>vue_list</title>
    <script type="text/javascript" src="../framework/jquery-3.0.0.min.js">
    </script>
    <script src="../framework/vue.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#but").click(function(){
                alert('dianji');
            });
            new Vue({
                el: '#app',
                data: {
                    message: 'Hello Vue.js!'
                }
            })
        });
    </script>

</head>
<body>
<div id="app">
    <button id="but">kaishi</button>
    <%--<h2 id="message">{{ message }}</h2>--%>
    <h1>{{ message }}</h1>
</div>
</body>
</html>
