




<div class="panel panel-default panel-primary">
    <div class="panel-heading">Register

    </div>

    <div class="panel-body">
        <div>${flash.message}</div>
        <g:uploadForm class="form-horizontal" name="registerForm" id="registerForm" controller="user" action="register">
            <div class="form-group">
                <label class="control-label col-sm-4" for="firstName">First Name:
                </label>

                <div class="col-sm-8">
                    <g:textField name="firstName" class="form-control" placeholder="Enter first name"/>
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
                <label class="control-label col-sm-4" for="pwd">Email-id:</label>

                <div class="col-sm-8">
                    <g:textField name="email" class="form-control" placeholder="Enter email"/>
                    <div class="alert-danger" role="alert">
                        <g:fieldError field="email" bean="${user}"/>
                    </div>
                </div>

            </div>


            <div class="form-group">
                <label class="control-label col-sm-4" for="pwd">UserName:</label>

                <div class="col-sm-8">
                    <g:textField name="userName" class="form-control" placeholder="Enter user name" />
                    <div class="alert-danger" role="alert">
                        <g:fieldError field="userName" bean="${user}"/>
                    </div>
                </div>

            </div>

            <div class="form-group">
                <label class="control-label col-sm-4" for="pwd">Password:</label>

                <div class="col-sm-8">
                    <g:passwordField name="password" type="password" class="form-control" id="pwd"
                                     placeholder="Enter password"/>
                    <div class="alert-danger" role="alert">
                        <g:fieldError field="password" bean="${user}"/>
                    </div>
                </div>
            </div>


            <div class="form-group">
                <label class="control-label col-sm-4" for="pwd">Confirm Password:</label>

                <div class="col-sm-8">
                    <g:passwordField name="confirmPassword" type="password" class="form-control" id="pwd1"
                                     placeholder="Enter password again"/>
                    <div class="alert-danger" role="alert">
                        <g:fieldError field="confirmPassword" bean="${user}"/>
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="form-group">
                    <label class="control-label col-xs-4" for="photo">Photo:</label>

                    <div class="col-xs-5">
                        <input type="file" name = "pic" class="form-control"/>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <g:submitButton name="register" controller="user" action="register" type="submit" value="Register"
                                    class="btn btn-default"/>
                </div>
            </div>
            <div>${flash.error}</div>
        </g:uploadForm>
    </div>
</div>

