var id = document.querySelector("#idValue").value;
var priceTem = document.querySelector("#priceTemplate").innerText;
var productTem = document.querySelector("#productTemplate").innerText;
var bindProduct = Handlebars.compile(productTem);
var bindPrice = Handlebars.compile(priceTem);



$(document).ready(function () {

    var items = initialAjax(id);
    var price = new Object();
    price["prices"] = items.itemPrices;
    var image = "../../img/" + items.image;

    price.prices = getPrices(price.prices);

    var priceHTML = bindPrice(price);
    var productHTML = bindProduct(items.display[0]);

    var priceContent = document.querySelector(".priceControl");
    priceContent.innerHTML = priceHTML;

    var productContent = document.querySelector(".product_info");
    productContent.innerHTML = productHTML;

    var regDate = document.querySelector("#re_date");
    $("#regDate_input").val(items.reservationDate);
    regDate.innerText = items.reservationDate;

    setBackground(image);
    getPeriod(items.display[0].openingHours);
    getCheck();
    setGlasses();
    getNumBtn();
});

function initialAjax(id){
    var items;
    $.ajax({
        url: "/reservationInfo/" + id,
        type: 'GET',
        async: false,
        success: function (data){
            items = data;
        },
        error: function (error){
            console.log(error);
        }
    });
    return items;
}

function getPrices(prices){

    for (var i = 0; i < prices.length; i++) {
        prices[i] = getPriceType(prices[i]);

    }
    return prices;
}

function getPriceType(price) {
    switch (price.priceTypeName) {
        case "A" :
            price.priceTypeName = "성인";
            break;
        case "B":
            price.priceTypeName = "유아";
            break;
        case "Y":
            price.priceTypeName = "청소년";
            break;
        default :
            break;
    }
    return price;
}

function setBackground(imageSrc) {

    $("#product_back").css({
        "background-image": "url('" + imageSrc + "')",
        "width": "100%",
        "height" : "400px",
        "background-repeat" : "no-repeat",
            "background-size": "cover",
            "opacity": "0.7"
    });
}

function getPeriod(period){
    console.log(period)

    var periodEx = "/\d{4}.\d{1,2}.\d{1,2}[(][월,화,수,목,금,토,일][)]/g";
    var per = period.match(periodEx);
    console.log(per);

}

function getCheck(){
    var cbox = document.getElementById("term_check");
    var reBtn = document.getElementById("reservation_submit");

    cbox.addEventListener('click', function () {
        if (cbox.checked === true) {
            reBtn.disabled = false;
            $("#reservation_submit").css({
                "background-color": "#2DC700"
            });
        } else{
            reBtn.disabled = true;
            $("#reservation_submit").css({
                "background-color": "lightgray"
            });
        }
    });
}

function setGlasses(){
    $('.glass').on('click', function () {
        var glass = $(this).closest(".term_container").find(".term_content");
        if($(this).text() == "보기"){
            $(this).text("접기");
        } else{
            $(this).text("보기");
        }
        glass.toggle();
    });
}

function getNumBtn(){


    $('.btn_minus').on('click', function () {
        var num = $(this).closest(".buttons").find(".ticket_num");
        var totalPrice = $(this).closest(".price_btnG").find(".total_priceVal");
        var price = $(this).closest(".price_content").find(".onePrice");
        var totalPriceText = $(this).closest(".price_btnG").find(".total_price");

        var numVal = parseInt(num.text()) - 1;
        var priceVal = parseInt(price.text());
        var totalPriceVal = parseInt(totalPrice.text());

        if (numVal >= 0) {
            totalPriceVal -= priceVal;
            totalTicketNum(-1);

        }else {
            numVal = 0;
            totalPriceVal = 0;
        }

        if (numVal === 0) {
            $(this).css({
                "border": "#d4dadf 1px solid",
                "color": "gray"
            });

            num.css({
                "border": "#d4dadf 1px solid",
                "color": "gray"
            });

            totalPriceText.css({
                "color": "lightgray"
            });
        }

        num.text(numVal);
        totalPrice.text(totalPriceVal);
    });

    $('.btn_plus').on('click', function () {
        var num = $(this).closest(".buttons").find(".ticket_num");
        var minus = $(this).closest(".buttons").find(".btn_minus");
        var totalPrice = $(this).closest(".price_btnG").find(".total_priceVal");
        var totalPriceText = $(this).closest(".price_btnG").find(".total_price");
        var price = $(this).closest(".price_content").find(".onePrice");

        var numVal = parseInt(num.text()) + 1;
        var priceVal = parseInt(price.text());
        var totalPriceVal = parseInt(totalPrice.text());

        minus.css({
            "color": "#2DC700",
            "border": "#2DC700 1px solid"
        });
        num.css({
            "color": "#2DC700",
            "border": "#2DC700 1px solid"
        });

        totalPriceText.css({
            "color": "black"
        });

        totalPriceVal += priceVal;
        num.text(numVal);
        totalPrice.text(totalPriceVal);
        totalTicketNum(+1);
    });
}

function totalTicketNum(value) {
    var totalNum = document.getElementById("re_total");
    var num = parseInt(totalNum.innerText) + value;
    totalNum.innerText = num;
}
