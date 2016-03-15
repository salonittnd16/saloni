<div class="container">

    <div id="forgot" class="modal fade">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>

                    <h3 class="modal-title">Forgot Password</h3>
                </div>

                <div class="modal-body">
                    <g:form controller="user" action="forgotPassword" class="form-horizontal">
                        <div class="form-group">
                            <label for="email" class="control-label col-xs-2">Email:</label>

                            <div class="col-xs-10">
                                <g:textField name="email" type="email" class="form-control"  placeholder="Enter email"/>
                            </div>
                        </div>



                        <div class="form-group">
                            <div class="col-xs-offset-2 col-xs-10" style="float:left">
                                <g:actionSubmit  id="saveButton" name="save" value="Save" controller="user" action="forgotPassword"
                                         class="btn btn-primary">save</g:actionSubmit>
                            </div>
                        </div>
                    </g:form>

                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default btn-primary" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>

</div>

