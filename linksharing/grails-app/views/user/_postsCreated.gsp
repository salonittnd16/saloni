<div class="panel panel-default panel-primary">
    <div class="panel-heading">Posts
    </div>

    <div class="panel-body" id="postsCreated">
        <g:each in="${postsCreated}" var="post">
            <div class="row">
                <div class=" col-xs-2" style="font-size:70px; float:left">
                </div>

                <div class="col-xs-10">
                    ${post.createdBy}<span class="text-muted inline">@saloni 5min</span>
                    <a href="#" class="inline" style="float:right">Grails</a>

                    <p>${post.description}
                    </p>
                    <a href="#"><div class="fa fa-facebook-official"></div></a>
                    <a href="#"><div class="fa fa-twitter inline"></div></a>
                    <a href="#"><div class="fa fa-google-plus inline"></div></a>


                    <span class="inline" style="float:right;padding: 2px"><u><ls:checkResourceType
                            resource="${post.id}"/></u></span>
                    <g:link controller="user" action="post" class="inline"
                            style="float:right;padding: 2px"
                            params="[postId: post.id]"><u>View Post</u></g:link>
                </div>

            </div>
            <hr/>

        </g:each>
        <util:remotePaginate controller="user" action="profile" total="${totalCount}" update="postsCreated" max="5"
                             pageSizes="[5, 10, 15, 20]"
                             params='[id: "${resourceSearchCo.id}", visibility: "${resourceSearchCo.visibility}"]'/>

    </div>

</div>

