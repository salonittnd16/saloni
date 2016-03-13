<g:each in="${posts}" var="post">
    <g:render template="/topic/resourceSearch" model="[post: post]"/>
</g:each>