<div class="panel panel-default panel-primary">
    <div class="panel-heading">Top-posts

    </div>

    <div class="panel-body" style="padding:20px">
        <g:each in="${topPosts}" var="post">
            <div  style="font-size:60px; float:left">
                <ls:userImage id="${post.createdBy?.id}"/>
            </div>

            <div class="col-xs-10">
                ${post.createdBy}<span class="text-muted inline">@saloni 5min</span>
                <a href="#" class="inline" style="float:right">${post.topic}</a>

                <p>${post.description}
                </p>
                <a href="#"><div class="fa fa-facebook-official"></div></a>
                <a href="#"><div class="fa fa-twitter inline"></div></a>
                <a href="#"><div class="fa fa-google-plus inline"></div></a>
                <g:link controller="user" action="post" class="inline"
                        style="float:right;padding: 2px"
                        params="[postId: post?.id]"><u>View Post</u></g:link>
                <hr/>
            </div>
            %{--<hr/>--}%
        </g:each>

    </div>

</div>