/**
 * Created by cp on 2017/8/14.
 */
function register(){
    var userName = $("#userName").val();
    if(userName == ""){

    }
    var password = $("#password").val();
    var password2 = $("#password2").val();

    var mobile = $("#userName").val();

    var email = $("#email").val();
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