<div class="row">
    <div class=" col-sm-2"></div>

    <div class=" col-sm-4">
        <g:select name="visibility" from="${com.ttnd.linksharing.Enum.Seriousness.values()}"
                  noSelection="['': '-Select seriousness-']"/>
    </div>


    <div class=" col-sm-4">
        <a href="" class="fa fa-envelope-o nav_icon " data-toggle="modal" data-target="#myModal1" id="invitation"
           topicName="${topicName}"></a>
    </div>
</div>