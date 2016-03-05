<div class="panel panel-default panel-primary">
    <div class="panel-heading">Inbox
    </div>

    <div class="panel-body">
        <g:each in="${readingItems}" var="readingItem">
            <div class="row">
                <div class="glyphicon glyphicon-user col-xs-2" style="font-size:70px; float:left"></div>

                <div class="col-xs-10">
                    ${readingItem.resource.createdBy}<span class="text-muted inline">@saloni 5min</span>
                    <a href="#" class="inline" style="float:right">Grails</a>

                    <p>${readingItem.resource.description}
                    </p>
                    <a href="#"><div class="fa fa-facebook-official"></div></a>
                    <a href="#"><div class="fa fa-twitter inline"></div></a>
                    <a href="#"><div class="fa fa-google-plus inline"></div></a>


                    <a href="#" class="inline" style="float:right;padding: 2px"><u>Download</u></a>
                    <a href="#" class="inline" style="float:right;padding: 2px"><u>Full size</u></a>
                    <ls:checkIsRead isRead="${readingItem.isRead}">
                        <g:link class="inline" style="float:right;padding: 2px"><u>Mark As Unread</u></g:link>
                    </ls:checkIsRead>

                    <ls:checkIsUnRead isRead="${readingItem.isRead}">
                        <a href="#" class="inline" style="float:right;padding: 2px"><u>Mark As read</u></a>
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

