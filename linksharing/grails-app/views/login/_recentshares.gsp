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
                    <a href="#"><div class="fa fa-facebook-official share_button"></div></a>
                    <a class="fa fa-twitter" href="https://twitter.com/intent/tweet"/>
                    <script>window.twttr = (function (d, s, id) {
                        var js, fjs = d.getElementsByTagName(s)[0],
                                t = window.twttr || {};
                        if (d.getElementById(id)) return t;
                        js = d.createElement(s);
                        js.id = id;
                        js.src = "https://platform.twitter.com/widgets.js";
                        fjs.parentNode.insertBefore(js, fjs);

                        t._e = [];
                        t.ready = function (f) {
                            t._e.push(f);
                        };

                        return t;
                    }(document, "script", "twitter-wjs"));</script>
                    <a href="https://plus.google.com/share?url={URL}" onclick="javascript:window.open(this.href,
                            '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');return false;"><img
                            src="https://www.gstatic.com/images/icons/gplus-16.png" alt="Share on Google+"/></a>
                    <g:link class="inline" controller="user" action="post" style="float:right"
                            params="[postId: resource?.id]"><u>View Post</u></g:link>

                    <hr/>
                </div>

            </div>
        </g:each>
        <br>
    </div>
</div>