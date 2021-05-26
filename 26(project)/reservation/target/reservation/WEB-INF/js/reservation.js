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