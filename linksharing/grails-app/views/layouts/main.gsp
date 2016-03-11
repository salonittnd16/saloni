<%@ page import="com.ttnd.linksharing.Enum.Visibility" %>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title><g:layoutTitle default="Grails"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <asset:javascript src="jquery-2.2.1.min.js"/>
    <asset:javascript src="jquery.validate.min.js"/>
    <asset:javascript src="additional-methods.min.js"/>
    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>

    <g:layoutHead/>
</head>

<body>
<g:if test="${session.user}">

    <nav role="navigation" class="navbar navbar-default">

        <div class="navbar-header">
            <div class="navbar-brand navbar-left"><u><a href="#"><b>LINK SHARING</b></a></u>

            </div>

            <form class="navbar-form navbar-right" role="search" style="text-align:right">
                <div class="form group">
                    <input type="text" class="form-control" placeholder="Search"/>

                </div>

            </form>

        </div>

        <form class="navbar-form navbar-right">

            <div class="form-group">
                <button type="button" class="fa fa-comment" data-toggle="modal" data-target="#myModal"></button>
                <button type="button" class="fa fa-envelope " data-toggle="modal" data-target="#myModal1"></button>
                <button type="button" class="fa fa-unlink " data-toggle="modal" data-target="#myModal2"></button>
                <button type="button" class="fa fa-file-o " data-toggle="modal" data-target="#myModal3"></button>



                <span class="glyphicon glyphicon-user" style="font-size:20px; "></span>
            </div>

            <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
               aria-expanded="false">Saloni
                <span class="caret"></span></a>
            <ul class="dropdown-menu">
                <li><g:link controller="user" action="edit">my profile</g:link></li>
                <li><a href="#">users</a></li>
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
            <div class="navbar-brand navbar-left"><u><a href="#"><b>LINK SHARING</b></a></u>
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
<div class="alert messageAlert" id="alert" style="display:none">
</div>
<g:layoutBody/>
<asset:javascript src="jquery-2.2.1.min.js"/>
<asset:javascript src="bootstrap.min.js"/>
<asset:javascript src="application.js"/>

</body>
</html>
