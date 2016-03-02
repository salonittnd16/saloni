<div class="panel panel-default panel-primary">
    <div class="panel-heading">Recent Shares
    </div>

    <div class="panel-body">
    <div class="row">
        <g:each in="${recentshares}" var="resource">
            <div class="glyphicon glyphicon-user col-xs-2 " style="font-size:70px; float:left"></div>

            <div class="col-xs-10">
                ${resource.createdBy}<span class="text-muted inline">@saloni 5min</span>
                <a href="#" class="inline" style="float:right">${resource.topic}</a>

                <p>${resource.description}</p>
                <a href="#"><div class="fa fa-facebook-official"></div></a>
                <a href="#"><div class="fa fa-twitter inline"></div></a>
                <a href="#"><div class="fa fa-google-plus inline"></div></a>
                <a href="#" class="inline" style="float:right"><u>View Post</u></a>
                <hr/>

            </div>

            </div>
        </g:each>
        <br>

    </div>
</div>