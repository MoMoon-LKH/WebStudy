<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MoMoon
  Date: 2021-05-03
  Time: 오전 5:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <title>네이버 예약</title>
    <link href="../css/main.css" rel="stylesheet">
    <style>

        li{
            margin-top: 6px;
        }

    </style>

</head>
<body>
<div class="container">
    <div class="header">
        <h2 class="logo">
            <a class="head_img" href="/main"><img class="head_img" src="../../img/spr_title.png"/> </a>
            <a class="head_my" href=""><span class="myInfo">예약 확인</span></a>
        </h2>
    </div>
    <div class="promotion" style=" width: 100%;">
        <div>
            <div class="promotion_visual">
                <ul class="promotion_image"></ul>
            </div>
        </div>
    </div>
    <div class="category">
        <ul id="tabList" class="tabList">
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
            <div class="listNum">바로 예매 가능한 행사가 <span class="list_count">0 개</span> 있습니다.</div>
        </div>
        <div class="list" style=" width: 99%; background-color: #e9ecef; margin-left: 0.5%; display: block; margin-bottom: 15px">
            <ul id="list_items" style=" list-style: none;  width:50%; margin: 0; padding: 0; float: left">
              <%--  <c:forEach items="${list}" var="item" begin="0" end="3" step="2">
                    <li class="item" style="width: 100%; display: inline-block; float: left; overflow: hidden">
                        <a href="products" style="text-decoration: none; display: block">
                            <div class="item_container">
                                <img alt=item.description src="../../img/${item.fileName}" style="width: 200px; margin: 0 auto; padding: 0; opacity: 1">
                                <div class="item_text" style="width: 200px; text-align: left; background: white;  margin: -3px 3px; padding: 0px;">
                                    <h4 class="item_text_des" style=" margin: 0px; padding: 0; color: black; ">
                                        <div style="font-weight: bold; font-size: 14px; padding: 10px 0 3px 5px">${item.description}</div>
                                        <small style="font-weight: normal; word-break: break-all;  font-size: 12px; padding: 0 0 3px 5px">${item.placeName}</small>
                                    </h4>
                                    <hr width="80%" color="lightgray" size="1">
                                    <p style=" margin: 5px; padding: 0; font-size: 12px;
                                    color: grey;  display: -webkit-box; word-wrap: break-word; -webkit-line-clamp: 2; -webkit-box-orient: vertical; overflow: hidden">${item.content}</p>
                                </div>
                            </div>
                        </a>
                    </li>
                </c:forEach>--%>
            </ul>
            <ul id="list_items2" style=" list-style: none; width:50%; margin: 0; padding: 0; float: left">
           <%-- <c:forEach items="${list}" var="item" begin="1" end="3" step="2">
                <li class="item" style="width: 100%;  float: left; overflow: hidden;">
                        <a href="products" style="text-decoration: none; display: block">
                            <div class="item_container">
                                <img alt=item.description src="../../img/${item.fileName}" style="width: 200px; margin: 0 auto; padding: 0; opacity: 1">
                                <div class="item_text" style="width: 200px; text-align: left; background: white; margin: -3px 3px; padding: 0px;">
                                    <h4 class="item_text_des" style="margin: 0; padding: 0; color: black; ">
                                        <div style="font-weight: bold; font-size: 14px; padding: 10px 0 3px 5px">${item.description}</div>
                                        <small style="font-weight: normal; word-break: break-all; font-size: 12px; padding: 0 0 3px 5px">${item.placeName}</small>
                                    </h4>
                                    <hr width="80%" color="lightgray" size="1">
                                    <p style="margin: 5px; font-size: 12px; color: grey; display: -webkit-box;
                                    word-wrap: break-word; -webkit-line-clamp: 2; -webkit-box-orient: vertical; overflow: hidden">${item.content}</p>
                                </div>
                            </div>
                        </a>
                </li>
            </c:forEach>--%>
            </ul>

        </div>
    </div>
    <div style="margin: 0; padding: 0; display: block; clear: both;"></div>
    <div  class="more" style="border: 1px solid lightgray;">
        <button id="btn" class="btn"><span>더보기</span></button>
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

<template id="template-list-item">
    <li class="item" style="width: 100%; display: inline-block; float: left; overflow: hidden">
        <a href="" style="text-decoration: none; display: block">
            <div class="item_container">
                <img alt=item.description src= {fileName} style="width: 200px; margin: 0 auto; padding: 0; opacity: 1">
                <div class="item_text" style="width: 200px; text-align: left; background: white;  margin: -3px 3px; padding: 0;">
                    <h4 class="item_text_des" style=" margin: 0; padding: 0; color: black; ">
                        <div style="font-weight: bold; font-size: 14px; padding: 10px 0 3px 5px">{description}</div>
                        <small style="font-weight: normal; word-break: break-all;  font-size: 12px; padding: 0 0 3px 5px">{placeName}</small>
                    </h4>
                    <hr width="80%" color="lightgray" size="1">
                    <p style=" margin: 5px; padding: 0; font-size: 12px;
                                    color: grey;  display: -webkit-box; word-wrap: break-word; -webkit-line-clamp: 2; -webkit-box-orient: vertical; overflow: hidden">{content}</p>
                </div>
            </div>
        </a>
    </li>
</template>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@splidejs/splide@latest/dist/js/splide.min.js"></script>
<script type="text/javascript" src="../js/products.js"></script>
</body>
</html>