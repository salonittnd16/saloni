<div class="panel panel-default panel-primary">
    <div class="panel-heading">Login
    </div>

    <div class="panel-body">

        <g:form class="form-horizontal" name="login" controller="login" action="login" method="post">
            <div class="form-group">
                <label class="control-label col-sm-4" for="username">Username:
                </label>

                <div class="col-sm-8">
                    <g:textField name="username" class="form-control" id="email" placeholder="Enter user name"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-4" for="pwd">Password:</label>

                <div class="col-sm-8">
                    <g:passwordField name="password" class="form-control" id="pwd" placeholder="Enter password"/>
                </div>
            </div>


            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <g:link controller="login" action="forgotPassword"><u> Forgot Password</u></g:link>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <g:actionSubmit type="submit" controller="login" action="login" name="login" value="Login"/>
                </div>

            </div>
        </g:form>

    </div>
</div>

