<%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-05-22
  Time: 오후 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>예약 페이지</title>
    <script
            src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
    <input type="hidden" id="idValue" value="${id}">
    <form action="/" method="post">
    <div class="product_info">

    </div>

    <div class="priceControl">

    </div>

    <div class="reservation_info">
        <div class="title_info">예매자 정보</div><div class="detail_info"><span class="check">&#10003;</span>필수입력</div>
        <hr>
        <div class="reservation_val">
            <span class="check">&#10003;</span><span class="re_title">예매자</span>
            <input type="text" id="name">
        </div>
        <div class="reservation_val">
            <span class="check">&#10003;</span><span class="re_title">연락처</span>
            <input type="text" id="tel">
        </div>
        <div class="reservation_val">
            <span class="check">&#10003;</span><span class="re_title">이메일</span>
            <input type="text" id="email">
        </div>
        <div class="reservation_val">
            <span class="re_title">예매내용</span>
            <span id="re_date"></span><span>, </span>
            <span>총 </span><span id="re_total">0</span><span>매</span>
        </div>
    </div>
        <div class="term_and_condition">
            <div>
                <div class="title_info">
                    <input type="checkbox">이용자 약관 전체동의
                </div>
                <div class="left_text">필수동의</div>
            </div>
            <div>
                <div>ㄴ 개인정보 수집 및 이용 동의</div>
                <div class="left_text">보기</div>
                <div class="term_content">
                    <div>< 개인정보 수집 및 이용 동의 ></div>
                    <div>1.수집 항목 :[필수]이름, 연락처, [선택] 이메일주소</div>
                    <div>2.수집 및 이용목적: 사업자회우너과 예약이용자의 원할한 거래 진행, 고객상담, 불만처리
                     등 민원 처리, 분쟁조정 해결을 위한 기록보존, 네이버 예약 이용 후 리뷰작성</div>
                </div>
            </div>
            <div>
                <div>ㄴ 개인정보 제3자 제공 동의</div>
                <div class="left_text">보기</div>
                <div class="term_content">
                    <div>< 개인정보 수집 및 이용 동의 ></div>
                    <div>1.수집 항목 :[필수]이름, 연락처, [선택] 이메일주소</div>
                    <div>2.수집 및 이용목적: 사업자회우너과 예약이용자의 원할한 거래 진행, 고객상담, 불만처리
                        등 민원 처리, 분쟁조정 해결을 위한 기록보존, 네이버 예약 이용 후 리뷰작성</div>
                </div>
            </div>
        </div>

        <button type="submit">예약하기</button>
    </form>

</div>

<!-------------------- 템플릿 ------------------------------------------>

<script type="myTemplate" id="productTemplate">
    <div id="title_info"></div>
    <div id="product">
        <div class="title">{{description}}</div>
        <div class="cost">12200원~</div>
        <div class="date"></div>
    </div>
    <div class="infoList">
        <div class="info">
            <div class="info_title">{{description}}</div>
            <div class="info_content">
                <div>
                    <span>장소: </span><span id="place">{{placeStreet}}</span>
                </div>
                <div>
                    <span>기간: </span><span id="date"></span>
                </div>
            </div>
        </div>
        <div class="info">
            <div class="info_title">관람시간</div>
            <div class="info_content" id="opening_hours">{{openingHours}}</div>
        </div>
        <div class="info">
            <div class="info_title">요금</div>
            <div class="info_content"></div>
        </div>
    </div>
</script>

<script type="myTemplate" id="priceTemplate">
    {{#each prices}}
        <div class="price_content">
            <div class="cost_val">
                <div id="costType">{{priceTypeName}}</div>
                <div id="price">{{price}}원</div>
                <div id="costSale">{{price}}원 {{discountRate}}% 할인가</div>
            </div>
            <div class="cost_btnG">
                <div>
                    <button id="btn_minus">-</button>
                    <span id="ticket_num">0</span>
                    <button id="btn_plus">+</button>
                </div>
                <div id="total_cost">0원</div>
            </div>
        </div>
    {{/each}}
</script>





<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js" integrity="sha512-RNLkV3d+aLtfcpEyFG8jRbnWHxUqVZozacROI4J2F1sTaDqo1dPQYs01OMi1t1w9Y2FdbSCDSQ2ZVdAC8bzgAg==" crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/reservation.js"></script>
</body>
</html>
