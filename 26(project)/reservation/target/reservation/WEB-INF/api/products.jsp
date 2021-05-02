<%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-05-03
  Time: 오전 5:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <title>네이버 예약</title>
    <link href="../css/main.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="header">
        <h2 class="logo">
            <a class="head_img" href="products.jsp"><img class="head_img" src="../../img/spr_title.png"/> </a>
            <a class="head_my" href=""><span class="myInfo">예약 확인</span></a>
        </h2>
    </div>
    <div class="promotion">
        <div class="pre_p" style="display: none">
            <a href="#" class="btn_pre_p" title="이전"></a>
        </div>
        <div class="next_p" style="display: none">
            <a href="#" class="btn_next_p" title="다음"></a>
        </div>
        <div>
            <div class="promotion_visual">
                <ul class="promotion_image"></ul>
            </div>
        </div>
    </div>
    <div class="category">
        <ul class="tabList">
            <li class="item" data-category="0">전체리스트</li>
            <li class="item" data-category="1">전시</li>
            <li class="item" data-category="2">뮤지컬</li>
            <li class="item" data-category="3">콘서트</li>
            <li class="item" data-category="4">클래식</li>
            <li class="item" data-category="5">연극</li>
        </ul>
    </div>
    <div class="list_container">
        <div class="listNumContainer">
            <div class="listNum">바로 예매 가능한 행사가 <span class="list_count">${count} 개</span> 있습니다.</div>
        </div>
        <div class="list">
            <ul class="list_items">

            </ul>
        </div>
        <div class="more">
            <button class="btn"><span>더보기</span></button>
        </div>
    </div>


    <footer class="footer">
        <div class="gototop">
            <a href="#" class="lnk_top"><span class="lnk_top_text">&uarr;TOP</span></a>
        </div>
        <div class="footer_copy">
            <p class="dsc_footer">네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및 환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
            <span class="copyright">©NAVER Corp.</span>
        </div>
    </footer>
</div>
</body>
<script type="text/javascript" src="../js/main.js"></script>
</html>