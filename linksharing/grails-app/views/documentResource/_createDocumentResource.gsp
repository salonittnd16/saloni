<div class="container">

    <div id="myModal3" class="modal fade">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>

                    <h3 class="modal-title">Share Document</h3>
                </div>

                <div class="modal-body">
                    <g:uploadForm class="form-horizontal" controller="documentResource" action="save" method="post">
                        <div class="form-group">
                            <label for="myFile" class="control-label col-xs-2">Document</label>

                            <div class="col-xs-10">

                                <input type="file" name="myFile" required="required"/>

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
                            <label for="topicId" class="control-label col-xs-2">Topic</label>

                            <div class="col-xs-7">
                                <g:select name="topicId" from="${listOfTopics}" optionKey="id"
                                          noSelection="['': '-Select topic-']" required="required"/>

                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-xs-offset-2 col-xs-10" style="float:left">
                                <g:submitButton name="Save" type="submit" class="btn btn-primary"
                                                controller="documentResource" action="save"/>
                            </div>
                        </div>

                    </g:uploadForm>

                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default btn-primary" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>

</div>

