<div class="panel panel-default panel-primary">
    <div class="panel-heading">Profile

    </div>

    <div class="panel-body">
    %{--<g:hasErrors bean="${user}">--}%
    %{--<div class="alert alert-danger">--}%
    %{--<g:eachError><g:message error="${it}"/></g:eachError>--}%
    %{--</div>--}%
    %{--</g:hasErrors>--}%
    %{--<g:renderErrors bean="${user}"/>--}%

        <g:uploadForm class="form-horizontal" name="profileForm" id="profileForm" controller="user"
                      action="updateProfile">
            <div class="form-group">
                <label class="control-label col-sm-4" for="firstName">First Name:
                </label>

                <div class="col-sm-8">
                    <g:textField name="firstName" class="form-control" placeholder="Enter first name"
                                 value="${session.user.firstName}"/>
                    <div class="alert-danger" role="alert">
                        <g:fieldError field="firstName" bean="${user}"/>
                    </div>
                </div>

            </div>

            <div class="form-group">
                <label class="control-label col-sm-4" for="pwd">Last Name:</label>

                <div class="col-sm-8">
                    <g:textField name="lastName" class="form-control" placeholder="Enter last name"/>
                    <div class="alert-danger" role="alert">
                        <g:fieldError field="lastName" bean="${user}"/>
                    </div>
                </div>

            </div>


            <div class="form-group">
                <label class="control-label col-sm-4" for="pwd">UserName:</label>

                <div class="col-sm-8">
                    <g:textField name="userName" class="form-control" placeholder="Enter user name"/>
                    <div class="alert-danger" role="alert">
                        <g:fieldError field="userName" bean="${user}"/>
                    </div>
                </div>

            </div>


            <div class="row">
                <div class="form-group">
                    <label class="control-label col-xs-4" for="pwd">Photo:</label>

                    <div class="col-xs-5">
                        <input type="file" name="pic"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <g:actionSubmit action="updateProfile" name="register" type="submit" value="Update"
                                    class="btn btn-default"/>
                </div>
            </div>
        </g:uploadForm>
    </div>
</div>

