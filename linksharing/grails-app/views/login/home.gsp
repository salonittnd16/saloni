<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>home page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <meta name="layout" content="main">
</head>

<body>
<div class="row" style="margin:9px">
    <div class="col-xs-6" style="float: left">
        <g:render template="recentshares"/>


        <div class="col-xs-5 col-xs-offset-1" style="float:right">
            <g:render template="loginform"/>
        </div>

    </div>
</br>
</br>
</br>

    <div class="row" style="margin:9px">
        <div class="col-xs-6">
          <ls:showTopPosts/>
        </div>

        <div class="col-xs-5 col-xs-offset-1" style="float:right">
            <g:render template="register" model="${user}"/>
        </div>

    </div>
</body>
</html>