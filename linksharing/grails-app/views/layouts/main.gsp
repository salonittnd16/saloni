<%@ page import="com.ttnd.linksharing.Enum.Visibility" %>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta property="og:url"           content="http://localhost:8080/" />
    <meta property="og:type"          content="website" />
    <meta property="og:title"         content="Your Website Title" />
    <meta property="og:description"   content="Your description" />
    %{--<meta property="og:image"         content="http://www.your-domain.com/path/image.jpg" />--}%
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Grails"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <asset:javascript src="jquery-2.2.1.min.js"/>
    <asset:javascript src="jquery.validate.min.js"/>
    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>


    <g:layoutHead/>
</head>

<body>
<script>
    window.fbAsyncInit = function() {
        FB.init({
            appId      : '1019800851413954',
            xfbml      : true,
            version    : 'v2.5'
        });
    };

    (function(d, s, id){
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) {return;}
        js = d.createElement(s); js.id = id;
        js.src = "//connect.facebook.net/en_US/sdk.js";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));
</script>


<g:if test="${session.user}">

    <nav role="navigation" class="navbar navbar-default">

        <div class="navbar-header">
            <div class="navbar-brand navbar-left"><u><g:link controller="user"
                                                             action="index"><b>LINK SHARING</b></g:link></u>

            </div>

        </div>

        <form class="navbar-form navbar-right">
            <div class="input-group" style="padding-right:30px">
                <span class="input-group-btn">
                    <button id="findSearchPostBox" topicId="${0}"
                            class="btn btn-primary glyphicon glyphicon-search searchButtons findSearchPostBox">
                    </button></span> <input type="text" id="searchPostBox"
                                            class="form-control input-group searchPostBox"
                                            placeholder="Search">
                <span class="input-group-btn">
                    <a id="clearSearchPostBox"
                            class="btn btn-primary glyphicon-searchphicon glyphicon-remove searchButtons">
                    </a></span>
            </div>


            <div class="form-group">
                <button type="button" class="fa fa-comment" data-toggle="modal" data-target="#myModal"></button>
                <button type="button" class="fa fa-envelope " data-toggle="modal" data-target="#myModal1"></button>
                <button type="button" class="fa fa-unlink " data-toggle="modal" data-target="#myModal2"></button>
                <button type="button" class="fa fa-file-o " data-toggle="modal" data-target="#myModal3"></button>



                <span class="glyphicon glyphicon-user" style="font-size:20px; "></span>
            </div>

            <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
               aria-expanded="false">${session.user.name}
                <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><g:link controller="user" action="edit"
                            params="[id: session.user.id, visibility: com.ttnd.linksharing.Enum.Visibility.PUBLIC, topicId: 0]">my profile</g:link></li>
                <li><g:link controller="user" action="list">users</g:link></li>
                <li><g:link controller="login" action="logout">logout</g:link></li>
            </ul>

        </form>
    </nav>


    <g:render template="/topic/create"/>
    <g:render template="/linkResource/createLinkResource"/>
    <g:render template="/documentResource/createDocumentResource"/>
    <g:render template="/layouts/sendInvitation"/>
</g:if>
<g:else>

    <nav role="navigation" class="navbar navbar-default">

        <div class="navbar-header">
            <div class="navbar-brand navbar-left"><u><g:link controller="login"
                                                             action="index"><b>LINK SHARING</b></g:link></u>
            </div>

        </div>

        <div class="container-fluid">
            <form class="navbar-form navbar-right" role="search" style="text-align:right">
                <div class="form group">
                    <input type="text" class="form-control" placeholder="Search"/>

                </div>

            </form>
        </div>
    </nav>
</g:else>


</div>
<div class="container">
    <div class="alert messageAlert" id="alert" style="display:none">
    </div>

    <div class="row">
        <g:if test="${flash.message}">

            <div class="col-xs-12 alert alert-success">
                <button type="button" class="close" data-dismiss="alert">×</button>
                <label><%=flash.message%></label>
            </div>
        </g:if>
    </div>

    <div class="row">
        <g:if test="${flash.error}">
            <div class="col-xs-12 alert alert-danger">
                <button type="button" class="close" data-dismiss="alert">×</button>
                <label><%=flash.error%></label>
            </div>
        </g:if>
    </div>
    <g:layoutBody/>
</div>

<asset:javascript src="jquery-2.2.1.min.js"/>
<asset:javascript src="bootstrap.min.js"/>
<asset:javascript src="application.js"/>

</body>
</html>
