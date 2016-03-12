<div class="panel panel-default panel-primary ">

    <div class="panel-body">
        <div class="row">
            <span style="font-size:80px; float:left;padding: 10px">
                <ls:userImage id="${session.user?.id}"/>
            </span>

            <div>${session.user.name}</div>

            <p class="text-muted inline">@saloni</p>

            %{--<p>Subscriptions&nbsp;&nbsp;&nbsp;&nbsp;<span>Topics</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>--}%
            %{--</p>--}%
            <div class="col-xs-4">
                <small class="col-xs-12">Subscriptions</small>
                <ls:subscriptionCountByUser/>
            </div>

            <div class="col-xs-4">
                <small class="col-xs-12">Topics</small>
                <ls:topicCount/>
            </div>

        </div>

    </div>
</div>
<div class="panel panel-default panel-primary ">

    <div class="panel-body">
        <div class="row">
            <span style="font-size:80px; float:left;padding: 10px">
                <ls:userImage id="${session.user?.id}"/>
            </span>

            <div>${session.user.name}</div>

            <p class="text-muted inline">@saloni</p>

            %{--<p>Subscriptions&nbsp;&nbsp;&nbsp;&nbsp;<span>Topics</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>--}%
            %{--</p>--}%
            <div class="col-xs-4">
                <small class="col-xs-12">Subscriptions</small>
                <ls:subscriptionCountByUser/>
            </div>

            <div class="col-xs-4">
                <small class="col-xs-12">Topics</small>
                <ls:topicCount/>
            </div>

        </div>

    </div>
</div>
