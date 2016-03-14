<div class="panel panel-default panel-primary">
    <div class="panel-body">
        <div class="row">
            <div class=" col-xs-2" style="font-size:70px; float:left">
                <ls:userImage id="${post.createdBy?.id}"/>
            </div>

            <g:form params="[resourceId: post.id]" controller="resourceRating" action="saveRatings" class="col-xs-10">
                ${post.createdBy}<span class="text-muted inline">@saloni 5min</span>
                <a href="#" class="inline" style="float:right"></a>

                <p>${post.description}
                </p>
                <a href="#"><div class="fa fa-facebook-official"></div></a>
                <a href="#"><div class="fa fa-twitter inline"></div></a>
                <a href="#"><div class="fa fa-google-plus inline"></div></a>
                <g:if test="${session.user}">
                    <g:select name="rate" from="${1..5}" style="padding: 5px"
                              noSelection="['': '-Select rating-']"/>
                    <g:submitButton name="vote" value="Vote" controller="resourceRating" action="saveRatings"
                                    style="padding: 3px"/>
                </g:if>
                <div class="inline" style="float:right;padding: 2px">
                    <ls:deleteResource resourceId="${post.id}"/>
                </div>
                <g:if test="${session.user}"><a href="" class="inline" style="float:right;padding: 2px" href=""
                                                data-toggle="modal" data-target="#edit">Edit</a>
                </g:if>
            %{--<ls:checkIsRead isRead="${post.isRead}">--}%
            %{--<g:link class="inline" style="float:right;padding: 2px"><u>Mark As Unread</u></g:link>--}%
            %{--</ls:checkIsRead>--}%

            %{--<ls:checkIsUnRead isRead="${post.isRead}">--}%
            %{--<a href="#" class="inline" style="float:right;padding: 2px"><u>Mark As read</u></a>--}%
            %{--</ls:checkIsUnRead>--}%
                <span class="inline" style="float:right;padding: 2px"><ls:checkResourceType
                        resource="${post.id}"/></span>
            </g:form>
            <g:render template="/resource/edit" model="${post}"/>
        </div>
    </div>
</div>

