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
    <link href="../css/commentForm.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="header">
        <button id="back_btn" onclick="history.back()">&#8592;</button>
        <div class="description">${description}</div>
    </div>
    <form method="post" action="commentUpload" enctype="multipart/form-data">
        <input type="hidden" name="reservationId" value="${reservationId}">
        <div class="comment_container">
            <div class="con">
                <div class="score_container">
                    <div class="score_title">별점과 이용경험을 남겨주세요.</div>
                    <div class="score">
                        <div class="star_score">
                            <span class="stars" value="1"></span>
                            <span class="stars" value="2"></span>
                            <span class="stars" value="3"></span>
                            <span class="stars" value="4"></span>
                            <span class="stars" value="5"></span>
                            <span class="star_num">0</span>
                        </div>
                    </div>
                    <input type="hidden" id="score_input" name="score" value="0">
                </div>
                <div class="comment_div">
                    <textarea type="text" id="comment" name="comment" placeholder="내용을 입력해주세요."
                              maxlength="400" minlength="5"></textarea>
                </div>
                <div class="img_container">
                    <div class="file_container">
                        <label class="btn_file">
                            사진 추가
                            <input type="file" name="file" id="imgInput" accept="image/png, image/jpg" style="display: none"/>
                        </label>
                        <div class="file_text"><span id="stringLength">0</span>/400 (최소 5자 이상)</div>
                    </div>
                    <div class="clear_div"></div>
                </div>
                <div class="thumb_container">
                    <img src="" style="display: none; border: 1px lightgray solid" width="100" class="thumb_img"/>
                </div>
                <div class="clear_div2"></div>
            </div>
        </div>
        <div>
            <input type="submit" id="review_submit" value="리뷰 등록">
        </div>
    </form>
    <footer class="footer">
        <div class="gototop" >
            <a href="#" class="lnk_top"><span class="lnk_top_text">&uarr;TOP</span></a>
        </div>
        <div class="footer_copy">
            <p class="dsc_footer">네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및 환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
            <span class="copyright">©NAVER Corp.</span>
        </div>
    </footer>

</div>
<script
        src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js" integrity="sha512-RNLkV3d+aLtfcpEyFG8jRbnWHxUqVZozacROI4J2F1sTaDqo1dPQYs01OMi1t1w9Y2FdbSCDSQ2ZVdAC8bzgAg==" crossorigin="anonymous"></script>
<script src="../js/commentForm.js" type="text/javascript"></script>
</body>
</html>
