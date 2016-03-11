<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Topics : Subscribed</h3>
    </div>
    <g:each in="${subscribedTopics}" var="topic">

        <div class="panel-body ">
            <div>
                <div class="row">
                    <div class="list-group col-xs-3">

                        <span style="font-size:80px; padding: 10px">
                        </span>

                    </div>

                    <div class="col-xs-9">
                        <div class="row">

                            <g:link controller="topic" action="show" params='[topicId: "${topic.id}"]'>
                                ${topic}</g:link>
                        </div>
                        <br/><br/>

                        <div class="row">
                            <div class="col-xs-4">
                                <small class="col-xs-12">@saloni</small>
                                <small class="col-xs-12"><ls:showUnsuscribe topicId="${topic.id}"/></small>
                            </div>

                            <div class="col-xs-4">
                                <small class="col-xs-12">Subscriptions</small>
                                <small class="col-xs-12"><ls:subscriptionCount topicId="${topic.id}"/></small>
                            </div>

                            <div class="col-xs-4">
                                <small class="col-xs-12">Posts</small>
                                <small class="col-xs-12"><ls:postCount topicId="${topic.id}"/></small>
                            </div>
                        </div>
                    </div>
                    <br/>
                </div>
            </div>
            <hr/>
        </div>
    </g:each>
</div>