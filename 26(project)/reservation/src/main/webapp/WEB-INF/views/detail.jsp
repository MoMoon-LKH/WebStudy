<%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-05-12
  Time: 오후 4:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>상세페이지</title>
</head>
<div class="container">
    <div class="head">

    </div>

    <div class="rating">

    </div>
    <div class="bottoms">

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

<input type="hidden" id="idValue" value="${id}"/>
<!------------------------- 템플릿 ------------------------------------>

<script type="myTemplate" id="dis">
    <div class="header">
        <h2 class="logo">
            <a class="head_img" href="/detail"><img class="head_img" src="../../img/spr_title.png"/> </a>
            <a class="head_my" href=""><span class="myInfo">예약 확인</span></a>
        </h2>
        <div class="imgNum">1/</div>
        <div class="btnGroup">
            <button class="pre_btn"><</button>
            <button class="next_btn">></button>
        </div>
        {{#display}}
        <h2>{{description}}</h2>
    </div>
    <div class="explanation">
        <div clas="explainContent">{{content}}</div>
        <button class="moreBtn">펼쳐보기&or;</button>
        <button class="foldBtn">접기&and;</button>
    </div>
    <div class="eventInfo">
        <div>이벤트 정보</div>
        <div class="evtInformation">
            {{#if event}}
                <div>{{event}}</div>
            {{else}}
                <div>이벤트가 없습니다.</div>
            {{/if}}
        </div>
        <button id="reservation"><span>예매하기</span></button>
    </div>
    {{/display}}
    <div class="bottomExplain">
    </div>
</script>

<script type="myTemplate" id="comment">
    <div class="ratingContainer">
        <div class="allScore">
            <span>스코어 </span><span>{{avgScore}}</span><span> / 5.0</span>
            <span><span>건</span><span> 등록</span> </span>
        </div>
        <ul class="commentItems">
            {{#each comments}}
            <li class="commentItem">
                <div class="comment_description"></div>
                <div>{{comment}}</div>
                <span> {{score}} </span><span> {{reservation_email}} </span><span> {{reservation_date}} 방문</span>
            </li>
            {{/each}}
        </ul>
    </div>

</script>

<script type="myTemplate" id="bottom">
    <div class="btTab">
        <ul>
            <li>상세정보</li>
            <li>오시는길</li>
        </ul>
    </div>
    <div class="detailInfo">
        <div>
            <div class="_head">[소개]</div>
            {{#display}}
                <div class="detail_content">{{content}}</div>
            {{/display}}
        </div>
        <div>
            <div class="detail_head">[공지사항]</div>
            <img class="detail_notice" src="../../img/notice.jpg">
        </div>
    </div>

    <div class="directions">
        <div class="direction_image">
            <img src="../../img_map">
        </div>
        <div class="direction_content">
            {{#display}}
                <div class="direction_title"></div>
                <div class="direction_addr">{{placeStreet}}</div>
                <div class="direction_street"><span>지번 </span>{{placeLot}}</div>
                <div class="direction_place">{{placeName}}</div>
                <div class="direction_tel">{{tel}}</div>
            {{/display}}
        </div>
    </div>
    <div class="direction_btn">
        <button class="findRoad">길찾기</button>
        <button class="navi">내비게이션</button>
    </div>
    </div>
</script>
<script
        src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js" integrity="sha512-RNLkV3d+aLtfcpEyFG8jRbnWHxUqVZozacROI4J2F1sTaDqo1dPQYs01OMi1t1w9Y2FdbSCDSQ2ZVdAC8bzgAg==" crossorigin="anonymous"></script>
<script src="../js/detail.js" type="text/javascript"></script>

</body>
</html>