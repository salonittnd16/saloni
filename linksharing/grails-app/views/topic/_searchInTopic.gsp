<g:each in="${posts}" var="post">
    <g:render template="resourceSearch" model="[post: post]"/>
</g:each>