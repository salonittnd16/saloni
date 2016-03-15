<div class="container">

    <div id="myModal2" class="modal fade">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>

                    <h3 class="modal-title">Share Link</h3>
                </div>

                <div class="modal-body">
                    <g:form class="form-horizontal" controller="linkResource" action="save">
                        <div class="form-group">
                            <label for="url" class="control-label col-xs-2">Link</label>

                            <div class="col-xs-10">
                                <g:textField name="url" class="form-control" id="inputLink" placeholder="Link"
                                             required="required"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="description" class="control-label col-xs-2">Description</label>

                            <div class="col-xs-10">
                                <g:textArea name="description" class="form-control" placeholder="Description" rows="5"
                                            id="comment" required="required"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="topic" class="control-label col-xs-2">Topic</label>

                            <div class="col-xs-7">
                                <g:select name="topic" from="${listOfTopics}" optionKey="id"
                                          noSelection="['': '-Select topic-']" required="required"/>

                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-offset-2 col-xs-10" style="float:left">
                                <g:submitButton name="Save" type="submit" class="btn btn-primary"
                                                controller="linkResource" action="save"/>
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

