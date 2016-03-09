<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Topic : Users</h3>
    </div>

    <div class="panel-body ">
        <g:each in="${subscribedUsers}" var="user">

            <div>
                <div class="row">
                    <div class="list-group col-xs-3">

                        <div style="float:left;padding: 10px">
                            <span  style="font-size:80px; padding: 10px">
                                <ls:userImage id="${user?.id}"/>
                            </span>
                        </div>
                    </div>

                    <div class="col-xs-9">
                        <div class="row">

                            ${user}
                        </div>
                        <br/><br/>

                        <div class="row">
                            <div class="col-xs-4">
                                <small class="col-xs-12">@saloni</small>
                                <small class="col-xs-12"><a>Subscribe</a></small>
                            </div>

                            <div class="col-xs-4">
                                <small class="col-xs-12">Subscriptions</small>
                                <small class="col-xs-12">50</small>
                            </div>

                            <div class="col-xs-4">
                                <small class="col-xs-12">Posts</small>
                                <small class="col-xs-12">10</small>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <hr/>
        </g:each>
        <div>
        </div>

    </div>

</div>
