<%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-06-09
  Time: 오후 1:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>한줄 평 등록</title>
</head>
<body>
<div class="container">
    <div class="header">
        <button></button>
        <div>${description}</div>
    </div>
    <form method="post" action="commentUpload" enctype="multipart/form-data">
        <input type="hidden" name="reservationId" value="${reservationId}">
        <div class="comment_container">
            <div class="score_container">
                <div>별점과 이용경험을 남겨주세요.</div>
                <div class="star_score">

                </div>
                <div class="score">

                </div>
                <input type="hidden" id="score_input" name="score" >
            </div>
            <div class="comment_div">
                <input type="text" id="comment" name="comment" placeholder="내용을 입력해주세요."
                 maxlength="400" minlength="5"/>
            </div>
            <div class="img_container">
                <div>
                    <input type="file" name="file" id="img" accept="image/png, image/jpg"/>
                    <div><span id="stringLength">0</span>/400 (최소 5자 이상)</div>
                </div>
                <div class="thumb_container">
                    <img src="" style="display: none" width="100" class="thumb_img"/>
                </div>
            </div>
        </div>
        <div>
            <input type="submit" id="review_submit">리뷰 등록</input>
        </div>
    </form>

</div>

</body>
</html>
