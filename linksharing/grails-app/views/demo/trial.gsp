<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main">
</head>
%{--<g:each in="${users}" var="user">--}%
    %{--${user.id} hello user--}%
%{--</g:each>--}%

<body>
<g form action="">
<div class="form-group">
    <div class="row">
        <div class="col-md-2">
            <label>name:</label>
        </div>
        <div class="col-md-2">
            <g:textField name="name" value="enter your name">name:</g:textField>
        </div>
    </div>
</div>
</g>
<ls:showAdmin admin="${session.user.admin}">The user is an admin</ls:showAdmin>

</body>
</html>