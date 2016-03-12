<div class="row" >
    <div class="col-xs-1"></div>

    <div class=" col-sm-4">
        <ls:showSeriousness topicId="${topicId}"/>
    </div>

    <div class=" col-sm-4">
        <ls:showVisibility topicId="${topicId}"/>
    </div>

    <i class="fa fa-envelope-o nav_icon "></i>
    <span><g:link  class="glyphicon glyphicon-edit nav_icon edit" params="[topicId: topicId]"></g:link></span>
    <g:link name="delete" controller="topic" action="delete" class="glyphicon glyphicon-trash nav_icon"
            params="[topicId: topicId]"></g:link>
</div>