/**
 * Created by cp on 2017/8/15.
 */
function checkUser(name) {
    var temp =false;
    $.ajax({
        url: "checkUser",
        async: false,
        data: {name: name},
        type: "POST",
        dataType: "text",
        success: function (data) {
            if (data != "-1") {
                temp = true;
            } else {
            }
        }});
    return temp;
}

function checkProduct(name) {
    var temp =false;
    $.ajax({
        url:"checkProduct",
        async: false,
        data:{productId:name},
        type:"POST",
        dataType:"text",
        success:function(data) {
            if (data != "-1") {
                temp =true;
            } else {

            }
        }});
    return temp;
}