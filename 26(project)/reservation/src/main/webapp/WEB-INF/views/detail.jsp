<%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-05-12
  Time: 오후 4:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>상세페이지</title>
</head>
<body>
<div class="container">
    <div class="header">
        <h2 class="logo">
            <a class="head_img" href="/detail"><img class="head_img" src="../../img/spr_title.png"/> </a>
            <a class="head_my" href=""><span class="myInfo">예약 확인</span></a>
        </h2>
        <div class="imgNum">{{imgNum}}</div>
        <div class="btnGroup">
            <button class="pre_btn"><</button>
            <button class="next_btn">></button>
        </div>
        <h2>{{title}}</h2>
    </div>
    <div class="explanation">
        <div class="explainContent">{{content}}</div>
        <button class="moreView">펼쳐보기</button>
    </div>
    <div class="eventInfo">
        <div>이벤트 정보</div>
        <div class="evtInformation">
            <div>{{evt}}</div>
        </div>
        <button id="reservation"><span>예매하기</span></button>
    </div>
    <div class="rating">

    </div>

    <div class="bottomExplain">
        <div class="btTab">
            <ul>
                <li>상세정보</li>
                <li>오시는길</li>
            </ul>
        </div>
        <div class="detailInfo">
            <div>
                <div class="_head">[소개]</div>
                <div class="detail_content">{{content}}</div>
            </div>
            <div>
                <div class="detail_head">[공지사항]</div>
                <img class="detail_notice" src="../../img/notice.jpg">
            </div>
        </div>

        <div class="directions">
            <div class="direction_image">
                <img src="">
            </div>
            <div class="direction_content">
                <div class="direction_title">{{description}}</div>
                <div class="direction_addr">{{place_street}}</div>
                <div class="direction_street"><span>지번</span>{{place_lot}}</div>
                <div class="direction_place">{{place_name}}</div>
                <div class="direction_tel">{{tel}}</div>
            </div>
        </div>
        <div class="direction_btn">
            <button class="findRoad">길찾기</button>
            <button class="navi">내비게이션</button>
        </div>
    </div>

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
</body>
</html>