/**
 * Created by cp on 2017/8/14.
 */
function login(){
    var userName = $("#userName").val();
    var password = $("#password").val();
    $.ajax({
        url: "/login",
        data:{
            userName:userName,
            password:password
        },
        type: "Post",
        //contentType: "application/json; charset=utf-8",
        //dataType: "text",
        success: function (contact) {
            alert(contact);
        }
    })
}

