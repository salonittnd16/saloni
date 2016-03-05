<div class="panel panel-default panel-primary">
    <div class="panel-body">
        <div class="row">
            <div class="glyphicon glyphicon-user col-xs-2" style="font-size:70px; float:left"></div>

            <g:form params="[resourceId:post.id]" controller="resourceRating" action="saveRatings" class="col-xs-10">
                ${post.createdBy}<span class="text-muted inline">@saloni 5min</span>
                <a href="#" class="inline" style="float:right"></a>

                <p>${post.description}
                </p>
                <a href="#"><div class="fa fa-facebook-official"></div></a>
                <a href="#"><div class="fa fa-twitter inline"></div></a>
                <a href="#"><div class="fa fa-google-plus inline"></div></a>
                <g:select name="rate" from="${1..5}" style="padding: 5px"
                          noSelection="['': '-Select rating-']"/>
                <g:submitButton name="vote" value="Vote" controller="resourceRating" action="saveRatings"
                                style="padding: 3px"/>
                <div class="inline" style="float:right;padding: 2px">
                    <ls:deleteResource resourceId="${post.id}"/>
                </div>
                <a href="#" class="inline" style="float:right;padding: 2px"><u>Edit</u></a>
            %{--<ls:checkIsRead isRead="${post.isRead}">--}%
            %{--<g:link class="inline" style="float:right;padding: 2px"><u>Mark As Unread</u></g:link>--}%
            %{--</ls:checkIsRead>--}%

            %{--<ls:checkIsUnRead isRead="${post.isRead}">--}%
            %{--<a href="#" class="inline" style="float:right;padding: 2px"><u>Mark As read</u></a>--}%
            %{--</ls:checkIsUnRead>--}%
                <ls:checkResourceType resource="${post.id}"/>
            </g:form>

        </div>

    </div>

</div>

