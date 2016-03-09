<div class="panel panel-default panel-primary">
    <div class="panel-heading">Subscriptions
        <a href="#" style="float:right" ;>View all</a>
    </div>

    <div class="panel-body">
        <g:each in="${subscriptions}" var="subscription">
            <div class="row">
                <div class="list-group col-xs-3">
                    <ls:userImage id="${subscription.user?.id}"/>
                </div>

                <div class="col-xs-9">

                    <br/>

                    <div class="row">
                        <div class="col-xs-4">
                            <small class="col-xs-12">@saloni</small>
                            <small class="col-xs-12"><a>Unsubscribe</a></small>
                        </div>

                        <div class="col-xs-4">
                            <small class="col-xs-12">Subscriptions</small>
                            <small class="col-xs-12">50</small>
                        </div>

                        <div class="col-xs-4">
                            <small class="col-xs-12">Topics</small>
                            <small class="col-xs-12">10</small>
                        </div>
                    </br>
                    </div>
                </div>
            </div>

            <ls:subscriptionsShow subscriptionId="${subscription.id}"/>
            <hr/>

        </g:each>
    </div>
</div>
