<div class="panel panel-default panel-primary">
    <div class="panel-heading">Recent Shares
    </div>

    <div class="panel-body">
        <g:each in="${recentshares}" var="resource">
            <div class="row">
                <div class=" col-xs-2 " style=" float:left">
                    <ls:userImage id="${resource.createdBy?.id}"/>
                </div>


                <div class="col-xs-10">
                    ${resource.createdBy}<span class="text-muted inline">"@${resource.createdBy}"</span>
                    <a href="#" class="inline" style="float:right">${resource.topic}</a>

                    <p>${resource.description}</p>
                    <a href="#"><div class="fa fa-facebook-official"></div></a>
                    <a href="#"><div class="fa fa-twitter inline"></div></a>
                    <a href="#"><div class="fa fa-google-plus inline"></div></a>

                    <g:link class="inline" controller="user" action="post" style="float:right"
                            params="[postId: resource?.id]"><u>View Post</u></g:link>

                    <hr/>
                </div>

            </div>
        </g:each>
        <br>
    </div>
</div>