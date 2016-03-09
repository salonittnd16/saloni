<div class="panel panel-primary" xmlns="http://www.w3.org/1999/html">
    <div class="panel-heading">
        <h3 class="panel-title">Topic</h3>
    </div>

    <div class="panel-body ">

        <div>
            <div class="row">
                <div class="list-group col-xs-3">

                    <div style="float:left;padding: 10px">
                        <span  style="font-size:80px; padding: 10px">
                            <ls:userImage id="${topic.createdBy?.id}"/>
                        </span>
                    </div>
                </div>

                <div class="col-xs-9">
                    <div class="row">
                        ${topic}
                    </div>
                    <br/><br/>

                    <div class="row">
                        <div class="col-xs-4">
                            <small class="col-xs-12">@saloni</small>
                            <small class="col-xs-12"><a>Subscribe</a></small>
                        </div>

                        <div class="col-xs-4">
                            <small class="col-xs-12">Subscriptions</small>
                            <ls:subscriptionCount topicId="${topic.id}"/>
                        </div>

                        <div class="col-xs-4">
                            <small class="col-xs-12">Posts</small>
                            <ls:postCount topicId="${topic.id}"/>
                        </div>

                    </div>
                    <br/>


                        <div class="row">
                            <div class=" col-sm-2"></div>

                            <div class=" col-sm-6">
                                <g:select name="visibility" from="${com.ttnd.linksharing.Enum.Seriousness.values()}"
                                          noSelection="['': '-Select seriousness-']"/>
                            </div>

                            <div class=" col-sm-2">
                                <i class="fa fa-envelope-o nav_icon "></i>
                            </div>
                        </div>

                </div>
            </div>
        </div>

        <div>
        </div>

    </div>

</div>




