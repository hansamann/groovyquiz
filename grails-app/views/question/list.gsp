

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Question List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Question</g:link></span>
        </div>
        <div class="body">
            <h1>Question List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="title" title="Title" />
                        
                   	        <g:sortableColumn property="content" title="Content" />
                        
                   	        <g:sortableColumn property="level" title="Level" />
                        
                   	        <g:sortableColumn property="created" title="Created" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${questionList}" status="i" var="question">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${question.id}">${fieldValue(bean:question, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:question, field:'title')}</td>
                        
                            <td>${fieldValue(bean:question, field:'content')}</td>
                        
                            <td>${fieldValue(bean:question, field:'level')}</td>
                        
                            <td>${fieldValue(bean:question, field:'created')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${Question.count()}" />
            </div>
        </div>
    </body>
</html>
