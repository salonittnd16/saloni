<div class="row">
    <div class="col-xs-1"></div>

    <div class=" col-sm-4">
        <ls:showSeriousness topicId="${topicId}"/>
    </div>

    <div class=" col-sm-4">
        <ls:showVisibility topicId="${topicId}"/>
    </div>

    <i class="fa fa-envelope-o nav_icon "></i>
    <span><a href="javascript:void (0)" id="edit=${topicId}" class="glyphicon glyphicon-edit nav_icon edit"
             topicId="${topicId}" parent="${parent}"></a></span>

    <g:link id="${topicId}" name="delete" controller="topic" action="delete" class="glyphicon glyphicon-trash nav_icon"
         onclick="topicDelete(${topicId})"   params="[topicId: topicId]"></g:link>
</div>