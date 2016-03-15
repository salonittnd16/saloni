    <div class="row">
        <div class=" col-xs-2" style="font-size:70px; float:left">
            <ls:userImage id="${post.createdBy?.id}"/>
        </div>

        <div class="col-xs-10">
            ${post.createdBy}<span class="text-muted inline">@saloni 5min</span>
            <a href="#" class="inline" style="float:right">Grails</a>

            <p>${post.description}
            </p>
            <a href="#"><div class="fa fa-facebook-official"></div></a>
            <a href="#"><div class="fa fa-twitter inline"></div></a>
            <a href="#"><div class="fa fa-google-plus inline"></div></a>


            <a href="#" class="inline" style="float:right;padding: 2px"><u>Download</u></a>
            <a href="#" class="inline" style="float:right;padding: 2px"><u>Full size</u></a>
            %{--<ls:checkIsRead isRead="${post.isRead}">--}%
            %{--<g:link class="inline" style="float:right;padding: 2px"><u>Mark As Unread</u></g:link>--}%
            %{--</ls:checkIsRead>--}%

            %{--<ls:checkIsUnRead isRead="${post.isRead}">--}%
            %{--<a href="#" class="inline" style="float:right;padding: 2px"><u>Mark As read</u></a>--}%
            %{--</ls:checkIsUnRead>--}%
            <g:link controller="user" action="post" class="inline"
                    style="float:right;padding: 2px"
                    params="[postId: post.id]"><u>View Post</u></g:link>
        </div>

    </div>
    <hr/>


