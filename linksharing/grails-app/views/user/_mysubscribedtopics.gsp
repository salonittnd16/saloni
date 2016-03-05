<div class="row">
    <div class=" col-sm-4">
        <g:select name="visibility" from="${com.ttnd.linksharing.Enum.Seriousness.values()}"
                  noSelection="['': '-Select seriousness-']"/>
    </div>

    <div class=" col-sm-4">
        <g:select name="visibility" from="${com.ttnd.linksharing.Enum.Visibility.values()}"
                  noSelection="['': '-Select visibility-']"/>
    </div>
    <i class="fa fa-envelope-o nav_icon "></i>
    <span class="glyphicon glyphicon-edit nav_icon "></span>
    <g:link name="delete" controller="topic" action="delete" class="glyphicon glyphicon-trash nav_icon"
            params="[subscriptionId: subscriptionId]"></g:link>
</div>