<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">Trending topic</h3>
    </div>

    <div class="panel-body " style="overflow-y: auto;height: 238px">
        <g:each in="${trendingTopics}" var="topic">

            <div>
                <div class="row" id="trendingEdit_${topic.id}" style="display: none;padding: 10px">
                    <form class="form-inline" role="form">
                        <div class="form-group">

                            <input type="text" name="topic" class="form-control col-xs-4" placeholder="${topic.name}"
                                   id="trending_${topic.id}" required="required">
                            <button name="saveTopic" class="btn  changeTopicName" parent="trending"
                                    topicId="${topic.id}">save</button>
                            <button type="button" class="btn btn-default">cancel</button>

                        </div>
                    </form>
                </div>
                <br/>

                <div class="row">
                    <div class="list-group col-xs-3">

                        <span style="font-size:80px; padding: 10px">
                            <ls:userImage id="${topic.createdBy?.id}"/>
                        </span>

                    </div>

                    <div class="col-xs-9">
                        <div class="row">

                            <g:link controller="topic" action="show" params='[topicId: "${topic.id}"]'>
                                ${topic} ${topic.id}
                                <span class="topicName_${topic.id}"></span></g:link>
                        </div>
                        <br/><br/>

                        <div class="row">
                            <div class="col-xs-4">
                                <small class="col-xs-12">"@${topic.createdBy}"</small>
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
                <ls:canUpdateTopic topicId="${topic.id}" parent="trending"/>
            </div>
            <hr/>

        </g:each>
    </div>
</div>