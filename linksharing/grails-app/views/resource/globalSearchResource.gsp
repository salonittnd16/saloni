<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>dashboard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <meta name="layout" content="main">
</head>

<body>

<div class="col-xs-5">
</div>

<div class="col-xs-6" style="float: right">
    <g:render template="/resource/globalsearch" model="${posts}"/>
</div>
</body>
</html>