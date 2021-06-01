<%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-05-28
  Time: 오후 1:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>예약 확인</title>
    <link rel="stylesheet" href="../css/loginForm.css">
</head>
<body>
<div class="container">
    <a href="/main"><img id="titleImg" src="../../img/myReservation.png"></a>
    <div class="formContainer">
        <form method="post" action="/login">
            <div id="title">비회원 예약 확인</div>
            <input id="emailInput" name="email" placeholder="예약자 이메일 입력">
            <div id="error">${errorMessage}</div>
            <button id="my_reservation_btn" type="submit">내 예약 확인</button>
        </form>
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
</div>

</body>
</html>
