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
    <div class="row" style="margin:9px">
        <g:render template="/user/userinfo"/>
    </div>

    <div class="row" style="margin:9px">
        <g:render template="/user/subscriptions" model="${subscriptions}"/>
    </div>

    <div class="row" style="margin:9px">
        <ls:showTrendingTopics/>
    </div>

</div>

<div class="col-xs-6" style="float: right">
    <g:render template="/user/inbox" model="${readingItems}"/>
</div>
</body>
</html>