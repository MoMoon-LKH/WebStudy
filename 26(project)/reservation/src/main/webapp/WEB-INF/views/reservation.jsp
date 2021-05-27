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

    <link href="../css/reservation.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <form action="/reservationInfo" method="post">
        <input type="hidden" name="id" id="idValue" value="${id}">
        <div class="product_info">

        </div>

        <div class="price">
            <ul class="priceControl">

            </ul>
        </div>

        <div class="reservation_info">
            <div class="reservation_title">
                <span class="title_info">예매자 정보</span>
                <span class="right_text"><span class="check">&#10003; </span>필수입력</span>
            </div>
            <div class="reservation_content">
                <div class="reservation_val">
                    <span class="check">&#10003; </span><span class="re_title">예매자</span>
                    <input class="reservation_info_input" type="text" name="name" id="name" required>
                </div>
                <div class="reservation_val">
                    <span class="check">&#10003; </span><span class="re_title">연락처</span>
                    <input class="reservation_info_input" type="text" name="tel" id="tel" pattern="0[0-9]{2}-[0-9]{3,4}-[0-9]{4}" required>
                </div>
                <div class="reservation_val">
                    <span class="check">&#10003; </span><span class="re_title">이메일</span>
                    <input class="reservation_info_input" type="text" name="email" id="email" required>
                </div>
                <div class="reservation_val">
                    <span id="re_title">예매내용</span>
                    <span id="re_date"></span><span>, </span>
                    <span>총 </span><span id="re_total">0</span><span>매</span>
                    <input type="hidden" name="regDate" id="regDate_input">
                </div>
            </div>
        </div>
            <div class="term_and_condition">
                <div class="term_title">
                    <span class="title_info">
                        <input type="checkbox" id="term_check">이용자 약관 전체동의
                    </span>
                    <span class="right_text">필수동의</span>
                </div>
                <div class="term">
                    <div class="term_widthDiv">
                        <div class="term_container">
                            <div class="term_sub">
                                <span class="term_subTitle">ㄴ 개인정보 수집 및 이용 동의</span>
                                <span class="glass" >보기</span>
                            </div>
                            <div class="term_content">
                                <div>< 개인정보 수집 및 이용 동의 ></div>
                                <div>1.수집 항목 : [필수]이름, 연락처, [선택] 이메일주소</div>
                                <div>2.수집 및 이용목적: 사업자 회원과 예약이용자의 원할한 거래 진행, 고객상담, 불만처리
                                 등 민원 처리, 분쟁조정 해결을 위한 기록보존, 네이버 예약 이용 후 리뷰작성</div>
                            </div>
                        </div>
                        <div class="term_container">
                            <div class="term_sub">
                                <span class="term_subTitle">ㄴ 개인정보 제3자 제공 동의</span>
                                <span class="glass">보기</span>
                            </div>
                            <div class="term_content">
                                <div>< 개인정보 제3자 제공 동의 ></div>
                                <div>1.수집 항목 : [필수]이름, 연락처, [선택] 이메일주소</div>
                                <div>2.수집 및 이용목적: 사업자 회원과 예약이용자의 원할한 거래 진행, 고객상담, 불만처리
                                    등 민원 처리, 분쟁조정 해결을 위한 기록보존, 네이버 예약 이용 후 리뷰작성</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <button type="submit" id="reservation_submit" disabled="disabled">예약하기</button>
    </form>

</div>

<!-------------------- 템플릿 ------------------------------------------>

<script type="myTemplate" id="productTemplate">

    <div id="product_back">
        <div id="product">
            <div class="title">{{description}}</div>
            <div class="cost">12200원~</div>
            <div class="date"></div>
        </div>
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
        <li class="price_content">
            <div class="price_val">
                <div class="priceType">{{priceTypeName}}</div>
                <div class="price"><span class="onePrice">{{price}}</span><span>원</span></div>
                <div class="priceSale">{{price}}원 {{discountRate}}% 할인가</div>
            </div>
            <div class="price_btnG">
                <div class="buttons">
                    <button type="button" class="btn_minus">-</button>
                    <button type="button" class="ticket_num" value="0" disabled>0</button>
                    <button type="button" class="btn_plus">+</button>
                </div>
                <div class="total_price"><span class="total_priceVal">0</span><span>원</span></div>
                <input type="hidden" name="total_price" id="totalPrice_input"/>
            </div>
        </li>
        <div class="border"></div>
    {{/each}}
</script>


<script
        src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
        crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js" integrity="sha512-RNLkV3d+aLtfcpEyFG8jRbnWHxUqVZozacROI4J2F1sTaDqo1dPQYs01OMi1t1w9Y2FdbSCDSQ2ZVdAC8bzgAg==" crossorigin="anonymous"></script>
<script type="text/javascript" src="../js/reservation.js"></script>
</body>
</html>
