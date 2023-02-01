<%@ page import="forum.pojo.Post" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>ForumIndex</title>
</head>
<body>
<header>Header</header>

<div class="before-main">
    <main class="">
        <section class="left">
            <div class="search-text">
                <input class="input-text" type="text" placeholder="文字搜尋"/>
                <span type="submit" id="search-text">搜尋按鈕</span>
                <!--${search-text}.click fetch-->
            </div>
            <br/>
            <br/>
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link" href="#">飲食</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">運動</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">教育</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">其他</a>
                </li>
            </ul>
        </section>


        <section class="right">
            <% ArrayList<Post> posts = (ArrayList<Post>) request.getAttribute("posts");
                for (Post post : posts) {%>
            <article id="post">
                <div class="d1">
                    <div class="type" id="type">《<%=post.getType()%>》</div>
                    <div class="topic" id="topic"><%=post.getTopic()%>
                    </div>
                </div>
                <div class="d2">
                    <div class="user" id="user"><%=post.getUserId()%>
                    </div>
                    <div class="date" id="date"><%=post.getTimestamp()%>
                    </div>
                    <!--                        <div class="like" id="like"></div>-->
                </div>
                <hr/>
                <div class="d3">
                    <p class="content" id="content"><%=post.getContent()%>
                    </p>
                    <!--                    <img src=""/>-->
                </div>
            </article>
            <div id="post-container"></div>
            <% } %>
        </section>
    </main>
</div>

</body>

<style>
    * {
        box-sizing: border-box;
    }

    header {
        font-size: 50px;
        text-align: center;
        background-color: pink;
    }

    main {
        margin: 3rem;
        display: flex;
        border: 1px dotted black;
    }
    main section.left {
        background-color: antiquewhite;
        width: 20%;
    }
    main section.left div.search-text {
        border: 1px solid red;
    }
    main section.left ul li {
        border: 1px solid red;
    }

    main section.right {
        background-color: antiquewhite;
        margin-left: 2rem;
        width: 70%;
    }
    main section.right article {
        margin: 1rem;
        background-color: azure;
    }
    main section.right article .d1 {
        display: flex;
        flex-wrap: wrap;
        padding: 0.5rem;
    }
    main section.right article .d1 .type {
        border: 1px solid red;
    }
    main section.right article .d1 .topic {
        border: 1px solid red;
    }
    main section.right article .d2 {
        display: flex;
        flex-wrap: wrap;
        padding: 0.5rem;
    }
    main section.right article .d2 .user {
        border: 1px solid red;
        width: 70%;
    }
    main section.right article .d2 .date {
        border: 1px solid red;
        width: 10%;
    }
    main section.right article .d2 .like {
        border: 1px solid red;
        width: 10%;
    }
    main section.right article .d3 {
        padding: 0.5rem;
    }
    main section.right article .d3 .content {
        border: 1px solid red;
    }/*# sourceMappingURL=index.css.map */

</style>
</html>
