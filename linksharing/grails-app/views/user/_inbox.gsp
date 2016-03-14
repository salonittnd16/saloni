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
                    <g:link controller="user" action="profile"
                            params="[id: session.user.id, visibility: com.ttnd.linksharing.Enum.Visibility.PUBLIC, topicId: 0]">
                        ${readingItem.resource.createdBy}
                    </g:link>
                    <span class="text-muted inline">"@${readingItem.resource.createdBy}"</span>
                    <a href="#" class="inline" style="float:right">Grails</a>

                    <p>${readingItem.resource.description}
                    </p>
                    <a href="#"><div class="fa fa-facebook-official"></div></a>
                    <a href="#"><div class="fa fa-twitter inline"></div></a>
                    <a href="#"><div class="fa fa-google-plus inline"></div></a>


                    <span class="inline" style="float:right;padding: 2px"><u><ls:checkResourceType
                            resource="${readingItem.resource.id}"/></u></span>
                    <ls:checkIsRead isRead="${readingItem.isRead}">
                        <g:link class="inline  ${readingItem.id}" style="float:right;padding: 2px"
                                controller="readingItem"
                                action="changeIsRead" id="unread"
                                params="[id: readingItem.id, isRead: !readingItem.isRead]"
                                onclick="changeUnread(${readingItem.id},${!readingItem.isRead})"><u>Mark As Unread</u></g:link>
                    </ls:checkIsRead>

                    <ls:checkIsUnRead isRead="${readingItem.isRead}">
                        <g:link controller="readingItem" action="changeIsRead" class="inline ${readingItem.id}"
                                style="float:right;padding: 2px" id="read"
                                params="[id: readingItem.id, isRead: !readingItem.isRead]"
                                onclick="changeRead(${readingItem.id},${!readingItem.isRead})"><u>Mark As read</u></g:link>
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

