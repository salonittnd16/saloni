<div class="panel panel-default panel-primary">
    <div class="panel-heading">Subscriptions
        <a href="#" style="float:right" ;>View all</a>
    </div>

    <div class="panel-body">
        <g:each in="${subscriptions}" var="subscription">
            <div class="row" id="subscription_${subscription.topic.id}" style="display: none;padding: 10px">
                <form class="form-inline" role="form" >
                    <div class="form-group">

                        <input type="text" name="topic" class="form-control col-xs-4" placeholder="Grails" id="topicname">
                        <button  name="saveTopic"  class="btn  changeTopicName">save</button>
                        <button type="button" class="btn btn-default">cancel</button>

                    </div>
                </form>
            </div>
            <div class="row" id="${subscription.id}">
                <div class="row">
                    <span class="list-group col-xs-3" style="padding-left: 15px ">
                        <ls:userImage id="${subscription.user?.id}"/>

                    </span>

                    <div class="col-xs-9">
                        <div class="row">
                            <g:link controller="topic" action="show" params='[topicId: "${subscription.topic.id}"]'>
                                ${subscription.topic}</g:link>
                        </div>

                        <br/>

                        <div class="row">
                            <div class="col-xs-4">
                                <small class="col-xs-12"><g:link controller="user" action="profile"
                                                                 params="[id: subscription.topic.createdBy.id, visibility: com.ttnd.linksharing.Enum.Visibility.PUBLIC, topicId: 0]">${subscription.topic.createdBy}</g:link></small>
                                <small class="col-xs-12"><g:link name="${subscription.id}"
                                                                 onclick="unsubscribe(${subscription.id})">Unsubscribe</g:link></small>
                            </div>

                            <div class="col-xs-4">
                                <small class="col-xs-12">Subscriptions</small>
                                <small class="col-xs-12"><ls:subscriptionCount
                                        topicId="${subscription.topic.id}"/></small>
                            </div>

                            <div class="col-xs-4">
                                <small class="col-xs-12">Posts</small>
                                <small class="col-xs-12"><ls:postCount topicId="${subscription.topic.id}"/></small>
                            </div>
                        </br>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <ls:canUpdateTopic topicId="${subscription.topic.id}" parent="subscription"/>
                </div>
                <hr/>

            </div>

        %{--<hr/>--}%

        </g:each>
    </div>
</div>
