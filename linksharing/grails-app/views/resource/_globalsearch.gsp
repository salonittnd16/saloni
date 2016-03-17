<div class="panel panel-default panel-primary">
    <div class="panel-heading">Posts : ${topic.name}
        <div class="input-group">
            <span class="input-group-btn">
                <button id="findSearchPostBox" topicId="${topic.id}"
                        class="btn btn-primary glyphicon glyphicon-search searchButtons findSearchPostBox">
                </button>
            </span>

            <input type="text" id="searchPostBox" class="form-control input-group searchPostBox" placeholder="Search">

            <span class="input-group-btn">
                <button id="clearSearchPostBox"
                        class="btn btn-primary glyphicon-searchphicon glyphicon-remove searchButtons">
                </button>
            </span>
        </div>
    </div>

    <div id="topicPosts" class="panel-body">
        <g:each in="${posts}" var="post">
            <g:render template="/topic/resourceSearch" model="[post: post]"/>
        </g:each>
    </div>

</div>

