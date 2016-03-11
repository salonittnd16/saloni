<div class="panel panel-default panel-primary">
    <div class="panel-heading">Inbox
    </div>

    <div class="panel-body">
        <g:each in="${readingItems}" var="readingItem">
            <div class="row">
                <div class=" col-xs-2" style="font-size:70px; float:left">
                    <ls:userImage id="${readingItem.resource.createdBy?.id}"/>
                </div>

                <div class="col-xs-10">
                    ${readingItem.resource.createdBy}<span class="text-muted inline">@saloni 5min</span>
                    <a href="#" class="inline" style="float:right">Grails</a>

                    <p>${readingItem.resource.description}
                    </p>
                    <a href="#"><div class="fa fa-facebook-official"></div></a>
                    <a href="#"><div class="fa fa-twitter inline"></div></a>
                    <a href="#"><div class="fa fa-google-plus inline"></div></a>


                    <span class="inline" style="float:right;padding: 2px" ><u><ls:checkResourceType resource="${readingItem.resource.id}"/> </u></span>
                    %{--<a href="#" class="inline" style="float:right;padding: 2px"><u>Full size</u></a>--}%
                    <ls:checkIsRead isRead="${readingItem.isRead}">
                        <g:link class="inline" style="float:right;padding: 2px"><u>Mark As Unread</u></g:link>
                    </ls:checkIsRead>

                    <ls:checkIsUnRead isRead="${readingItem.isRead}">
                        <g:link  controller="readingItem" action="changeIsRead" class="inline" style="float:right;padding: 2px" params="[id: readingItem.id,isRead:!readingItem.isRead]"><u>Mark As read</u></g:link>
                    </ls:checkIsUnRead>
                    <g:link controller="user" action="post" class="inline"
                            style="float:right;padding: 2px"
                            params="[postId: readingItem.resource?.id]"><u>View Post</u></g:link>
                </div>

            </div>
            <hr/>

        </g:each>
    </div>

</div>

