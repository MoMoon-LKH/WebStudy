<%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-06-01
  Time: 오후 2:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>나의 예약 현황</title>
</head>
<body>
<div class="container">
    <div class="header">
        <h2 class="logo">
            <a class="head_img" href="/main"><img class="head_img" src="../../img/spr_title.png"/> </a>
            <span class="myInfo">${email}</span>
        </h2>
    </div>
    <div id="tab_info">
        <ul class="tab">
            <li class="tab_item">
                <div class="tab_title">전체</div>
                <div class="tab_num">0</div>
            </li>
            <li class="tab_item">
                <div class="tab_title">이용예정</div>
                <div class="tab_num">0</div>
            </li>
            <li class="tab_item">
                <div class="tab_title">이용완료</div>
                <div class="tab_num">0</div>
            </li>
            <li class="tab_item">
                <div class="tab_title">취소 환불</div>
                <div class="tab_num">0</div>
            </li>
        </ul>
    </div>

    <div class="reservation">
        <div class="re_title">예약 확정</div>
        <ul id="reservation_items">

        </ul>
    </div>

    <div class="finish">
        <div class="finish_title">이용 완료</div>
        <ul id="finish_items">

        </ul>
    </div>

    <div class="cancel">
        <div class="cancel_title">취소된 예약</div>
        <ul id="cancel_items">

        </ul>
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

<script type="myTemplate">
<li>
    <div class="items_content">
        <div class="items_header">
            <div class="items_number">No.<span class="item_number"></span></div>
            <div class="item_description"></div>
        </div>
        <div class="items_content">
            <div class="items_period">
                <span class="period_title">일정</span>
                <span class="item_period"></span></div>
            <div class="items_breakdown">
                <span class="breakdown_title">내역</span>
                <span class="item_breakdown"></span></div>
            <div class="items_product">
                <span class="product_title">상품</span>
                <span class="item_product"></span></div>
            <div class="items_company">
                <span class="company_title">업체</span>
                <span class="item_company"></span></div>
        </div>
        <div class="items_price">
            <div class="price_title">결제 예정금액</div>
            <div class="item_price_div"><span class="item_price"></span> 원</div>
        </div>
        <div><button id="list_btn">취소</button></div>
    </div>
</li>
</script>

<script
        src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
        crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js" integrity="sha512-RNLkV3d+aLtfcpEyFG8jRbnWHxUqVZozacROI4J2F1sTaDqo1dPQYs01OMi1t1w9Y2FdbSCDSQ2ZVdAC8bzgAg==" crossorigin="anonymous"></script>

</body>
</html>