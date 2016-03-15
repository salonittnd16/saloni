<div class="panel panel-default panel-primary">
    <div class="panel-heading">Change Password

    </div>

    <div class="panel-body">
    %{--<g:hasErrors bean="${user}">--}%
    %{--<div class="alert alert-danger">--}%
    %{--<g:eachError><g:message error="${it}"/></g:eachError>--}%
    %{--</div>--}%
    %{--</g:hasErrors>--}%
    %{--<g:renderErrors bean="${user}"/>--}%

        <g:uploadForm class="form-horizontal" name="registerForm" id="registerForm" controller="user"
                      action="updatePassword" method="post">
            <div class="form-group">
                <label class="control-label col-sm-4" for="pwd">Password:
                </label>

                <div class="col-sm-8">
                    <g:passwordField name="oldPassword" class="form-control" placeholder="Enter first name"/>
                    <div class="alert-danger" role="alert">


                    </div>
                </div>

            </div>

            <div class="form-group">
                <label class="control-label col-sm-4" for="changePwd">Change Password:</label>

                <div class="col-sm-8">
                    <g:passwordField name="password" class="form-control" placeholder="Enter last name"/>
                    <div class="alert-danger" role="alert">
                    </div>
                </div>

            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <g:hiddenField name="id" value="${session.user.id}"/>
                    <g:submitButton name="register" controller="user" action="updatePassword" type="submit"
                                    value="Update     "
                                    class="btn btn-default"/>
                </div>
            </div>
        </g:uploadForm>
    </div>
</div>

