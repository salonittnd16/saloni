<div id="myModal1" class="modal fade">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>

                <h3 class="modal-title">Send Invitation</h3>
            </div>

            <div class="modal-body">
                <g:form class="form-horizontal" controller="topic" action="invite">
                    <div class="form-group">
                        <label for="email" class="control-label col-xs-2">Email</label>

                        <div class="col-xs-10">
                            <g:textField name="email" class="form-control" id="inputEmail" placeholder="Email"
                                         required="required"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputText" class="control-label col-xs-2">Topic</label>

                        <div class="col-xs-7">
                            <g:select name="id" from="${listOfTopics}" optionKey="id"
                                      noSelection="['': '-Select topic-']" required="required" id="topic"/>

                        </div>

                    </div>

                    <div class="form-group">
                        <div class="col-xs-offset-2 col-xs-10" style="float:left">
                            <g:actionSubmit name="invite" value="invite" controller="topic" action="invite"
                                            type="submit" class="btn btn-primary"/>
                        </div>
                    </div>

                    <div class="form-group">
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

