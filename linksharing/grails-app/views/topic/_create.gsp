<div class="container">

    <div id="myModal" class="modal fade">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>

                    <h3 class="modal-title">Create Topic</h3>
                </div>

                <div class="modal-body">
                    <g:form controller="topic" action="save" class="form-horizontal">
                        <div class="form-group">
                            <label for="topic" class="control-label col-xs-2">Name</label>

                            <div class="col-xs-10">
                                <g:textField name="name" class="form-control" id="Enter Topic" placeholder="Name"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="inputText" class="control-label col-xs-2">visiblity</label>

                            <div class="col-xs-7">
                                <g:select name="visibility" from="${com.ttnd.linksharing.Enum.Visibility.values()}"
                                          noSelection="['': '-Select visibility-']"/>

                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-offset-2 col-xs-10" style="float:left">
                                <g:submitButton name="save" value="Save" controller="topic" action="save"
                                                class="btn btn-primary">save</g:submitButton>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-offset-5 col-xs-10" style="float:right">
                                <button type="submit" class="btn btn-primary">cancel</button>
                            </div>

                        </div>
                    </g:form>

                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>

</div>

