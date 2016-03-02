
    <div class="panel panel-default panel-primary">
        <div class="panel-heading">Register

        </div>

        <div class="panel-body">

            <g:form class="form-horizontal" controller="user" action="register">
                <div class="form-group">
                    <label class="control-label col-sm-4" for="firstName">First Name:
                    </label>

                    <div class="col-sm-8">
                        <g:textField name="firstName" class="form-control" placeholder="Enter first name"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-4" for="pwd">Last Name:</label>

                    <div class="col-sm-8">
                        <g:textField name="lastName" class="form-control" placeholder="Enter last name"/>
                    </div>
                </div>


                <div class="form-group">
                    <label class="control-label col-sm-4" for="pwd">Email-id:</label>

                    <div class="col-sm-8">
                        <g:textField name="email" class="form-control" placeholder="Enter email"/>
                    </div>
                </div>


                <div class="form-group">
                    <label class="control-label col-sm-4" for="pwd">UserName:</label>

                    <div class="col-sm-8">
                        <g:textField name="userName" class="form-control" placeholder="Enter user name"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-4" for="pwd">Password:</label>

                    <div class="col-sm-8">
                        <g:passwordField name="password" type="password" class="form-control" id="pwd"
                                         placeholder="Enter password"/>
                    </div>
                </div>


                <div class="form-group">
                    <label class="control-label col-sm-4" for="pwd">Confirm Password:</label>

                    <div class="col-sm-8">
                        <g:passwordField name="confirmPassword" type="password" class="form-control" id="pwd1"
                                         placeholder="Enter password again"/>
                    </div>
                </div>


                <div class="row">
                    <div class="form-group">
                        <label class="control-label col-xs-4" for="pwd">Photo:</label>

                        <div class="col-xs-5">
                            <input  class="form-control" id="pwd2" placeholder="Upload Photo">
                        </div>
                        <button type="submit" class="btn btn-default">Browse</button>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <g:submitButton name="register" controller="user" action="register" type="submit" value="Register"
                                        class="btn btn-default"/>
                    </div>
                </div>
            </g:form>

        </div>
    </div>

