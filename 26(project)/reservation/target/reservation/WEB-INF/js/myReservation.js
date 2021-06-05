var tem = document.querySelector("#itemTem").innerText;
var bindTem = Handlebars.compile(tem);

Handlebars.registerHelper('ifCond', function(v1, v2, options) {
    if(v1 === v2) {
        return options.fn(this);
    }
    return options.inverse(this);
});

$(document).ready(function () {
    var email = $("#email").text();
    initialAjax(email);
});

function initialAjax(email){
    $.ajax({
        type: 'GET',
        url: "/reservationInfo/myReservation",
        data: {"email": email},
        success: function (data){
            items = data;
            addItems(items.reservationInfo);
        },
        error: function (error){
            console.log(error);
        }
    });
}

function addItems(items) {
    var itemHTML = '';
    var today = new Date();
    var reCount = 0;
    var finishCount = 0;
    var cancelCount = 0;
    $('#tab_all').text(items.length);


    for (var i = 0; i < items.length; i++) {
        var item = initialItem(items[i]);

        if (item.cancelFlag == 0) {
            if (new Date(items[i].reservationDate) > today) {
                itemHTML = bindTem(item);
                addReservation(itemHTML);
                reCount++;
            }
            else {
                item.cancelFlag = 2;
                itemHTML = bindTem(item);
                addFinish(itemHTML);
                finishCount++;
            }
        } else {
            itemHTML = bindTem(item);
            addCancel(itemHTML);
            cancelCount++;
        }
    }

    $('#tab_reservation').text(reCount);
    $('#tab_finish').text(finishCount);
    $('#tab_cancel').text(cancelCount);

}

function initialItem(item) {
    var breakdown = getBreakdown(item.prices);
    var date = getDateFormat(item.reservationDate);
    var price = getPrice(item.prices);
    var obj = {
        id: item.id,
        description: item.display.description,
        date: date,
        breakdown: breakdown,
        placeLot: item.display.placeStreet,
        placeName: item.display.placeName,
        price: price,
        cancelFlag: item.cancelFlag
    }
    console.log(obj);

    return obj;
}

function addReservation(itemHTML) {
    var reList = document.querySelector("#reservation_items");
    reList.innerHTML += itemHTML;
}

function addFinish(itemHTML) {
    var finishList = document.querySelector("#finish_items");
    finishList.innerHTML += itemHTML;
}

function addCancel(itemHTML) {
    var cancelList = document.querySelector("#cancel_items");
    cancelList.innerHTML += itemHTML;
}

function getBreakdown(prices) {
    var breakdown = '';
    for (var i = 0; i < prices.length; i++) {
        switch (prices[i].priceTypeName) {
            case "A":
                breakdown += "성인 " + prices[i].count +"매";
                break;
            case "Y":
                breakdown += "청소년 " + prices[i].count +"매";
                break;
            case "B":
                breakdown += "유아 " + prices[i].count +"매";
                break;
            default:
                breakdown += prices[i].priceTypeName + " " + prices[i].count +"매";
                break;
        }
        if (i != prices.length - 1) {
            breakdown += ", ";
        }
    }
    return breakdown;

}

function getDateFormat(date) {
    var date = new Date(date);
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    month = month >= 10 ? month : '0' + month;
    var day = date.getDate();
    day = day >= 10 ? day : '0' + day;
    var dayOfWeek = getDayOfWeek(date);

    var dateVal = year + '-' + month + '-' + day + '(' + dayOfWeek + ')';

    return dateVal;
}

function getDayOfWeek(date) {
    var week = ['일', '월', '화', '수', '목', '금', '토'];
    var dayOfWeek = week[date.getDay()];
    return dayOfWeek;
}

function getPrice(prices) {
    var total = 0;

    for (var i = 0; i < prices.length; i++) {
        total += parseInt(prices[i].price) * prices[i].count;
    }

    return total.toLocaleString();
}
