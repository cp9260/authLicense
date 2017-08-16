/**
 * Created by cp on 2017/8/14.
 */

var pageSize = 8;  //每页显示的记录条数
var curPage = 1;   //显示第curPage页
var len;         //总行数
var page;        //总页数
var arry = {};

$(function () {
    //获取表头及搜索
    //getTh();
    getchaxun();
    getTable(new Object());
    getfenye({description:"", clientid:"", pagenow:1});
    $(".Preservation").click(function () {
        var add = {};
        // arry.pkey;
        // arry["pkey"];
        // arry[html];
        $(".zeng").children().each(function (idx, ele) {
            // if (idx < 1) {
            //  return;
            // }
            var kay = $(this).children()[0].name;
            var val = $(this).children()[0].value;
            add[kay] = val;

        });
        if(add["userName"] == ""){
            $("#labelName").html("帐号不能为空");
            $("#labelName").show();
            return;
        }
        if(add["password"] == "" || add["password"].length < 6){
            $("#labelpassword").html("密码至少6位");
            $("#labelpassword").show();
            return;
        }
        $.ajax({
            url:"checkUser",
            data:{name:add["userName"]},
            type:"POST",
            dataType:"text",
            success:function(data){
                if(data !="-1")
                {
                    $("#labelName").html("帐号已存在");
                    $("#labelName").show();
                    return;
                }else{
                    $("#labelName").html("帐号可用");
                }
                $("#labelName").show();
                $.ajax({
                    url: "userAdminsave",
                    data: add,
                    type: "POST",
                    dataType: "text",
                    success: function (data) {
                        if (data == "ok") {alert("添加成功");location.reload();}
                        if (data == "error") {alert("添加失败")}
                        if (data == "2") {alert("该设备已存在")}
                    }
                })


            }
        });


//            if(arry["userName"] == ""){
//
//            }
        console.info(add);

    });
});



//添加数据


function setarry(){
    var arry = {};
    console.info($(".search")[0]);

    $(".search").children().each(function (idx, ele) {
        //console.info("aa")
        //console.info($(this)[0]);
        var kay = $(this).children()[0].name;
        var val = $(this).children()[0].value;

        arry[kay] = val;
        //console.info(val);
    });

    arry.pagenow = "1";
    //console.info(arry);
    return arry;
}

//保存功能
function getenter() {
    // $("#show_tab_tr ").each(function(i){
    //var txt=$('input[type="text"]').value;
    //var j = true;
    $('input[kepp="dianji"]').click(function () {
        //alert(toEdit);
        var arry = {}
        // var toEdit = $(this).attr("value") == "编辑";
        //     $(this).attr("value", toEdit ? "保存" : "编辑");
        // var index = $(this).parent().parent().attr("idx");
        // td_arr = $(this).parent().siblings().children().val();

        var toEdit = $(this).attr("value") == "编辑";
        var index = $(this).parent().parent().attr("idx");

        td_arr=$(this).parent().siblings().children().val();

        $(this).attr("value", toEdit ? "保存" : "编辑");
        if (toEdit == false) {
            var flag= true;
            $(this).parent().siblings().each(function (idx, ele) {

                var td_arr = $(ele).children().val();
                var key = $(this).attr("key");
                arry[key] =td_arr;



            });
            if(arry["status"] == "0" || arry["status"] == "1"){

            }else{
                $(this).attr("value", "保存");
                alert("类型只能为1或者0");
                return;;
            }

            console.info(arry);
            $.ajax({
                url:"userAdminUpdate",
                data:arry,
                type:"POST",
                dataType:"text",
                success:function(data){
                    if(data=="ok")
                    {
                        alert("修改成功");
                        location.reload();
                    }
                    if (data=="error") {alert("修改失败");}
                }
            });

        } else { }



        var inputcss = $(this).parent().siblings().children()
        if (toEdit) {
            inputcss.attr("disabled", false);


            inputcss.css("border", "1px solid #51e5fb");
            $(this).parent().siblings('td[key="pkey"]').children().css("border", "0px solid #51e5fb");
            $(this).parent().siblings('td[key="pkey"]').children().attr("disabled", true);

        } else {
            inputcss.attr("disabled", true);
            inputcss.css("border", "0px solid #51e5fb");
        }


    });
}

function getfenye(arry){

    //    $(".search").children().each(function (idx, ele) {
    //    kay = $(this).children()[0].name;
    //   val = $(this).children()[0].value;

    //   arry[kay] = val;
    console.info(arry);
    // });
    // // arry.pagenow = "1";

    pagenow = 1;
    document.getElementById("curPage").value = pagenow;
    // getTable();//显示第一页
    $("#nextpage").click(function () {//下一页
        var arry = setarry();
        //alert(page);
        if (pagenow < countpage) {
            pagenow += 1;
            document.getElementById("curPage").value = pagenow;
        } else {
            pagenow = countpage;
            alert("已是最后一页");
        }
        console.info(arry);
        if (arry["description"] == "" && arry["clientid"] == "") {
            getTable();

        } else {
            arry.pagenow=pagenow;
            getTable(arry);


        }
        //alert(pagenow);

    });
    $("#lastpage").click(function () {//上一页
        var arry = setarry();
        //alert(pagenow);

        if (pagenow != 1) {
            pagenow -= 1;
            document.getElementById("curPage").value = pagenow;
        } else {
            pagenow = 1
            alert("已是首页")
        }

        if (arry["description"] == "" && arry["clientid"] == "") {
            getTable();

        } else {
            arry.pagenow=pagenow;
            getTable(arry);


        }
    });

    $("#npage").click(function () {//跳到固定某一页
        var arry = setarry();
        var npage = parseInt(document.getElementById("curPage").value);
        if (npage > countpage || npage < 1) {
            alert("请输入1-" + countpage + "页");
        }
        else {
            pagenow = npage;
        }
        if (arry["description"] == "" && arry["clientid"] == "") {
            getTable();

        } else {
            arry.pagenow=pagenow;
            getTable(arry);


        }
    });

}

//表身及分页
//获取表格数据
function getTable(data) {
    var pagenow = document.getElementById("curPage").value;

    $.ajax({
        url: "count",
        data: { "name": "user" },
        type: "Post",
        //contentType: "application/json; charset=utf-8",
        dataType: "text",
        success: function (contact) {
            var page=contact % pageSize==0 ? contact/pageSize : Math.floor(contact/pageSize)+1;
            countpage = page;
            $("#pageSum").val(countpage);

        }
    })
    data[ "pagenow"] = pagenow;
    data[ "pagesize"] = pageSize;
    $.ajax({
        url: "users",
        data: data,
        type: "Post",
        //contentType: "application/json; charset=utf-8",
        dataType: "text",
        success: function (contact) {
            allData = JSON.parse(contact);
            temp = allData;
            //temp = allData.data;
            //alert(pagenow);
            //console.info(temp);
            var html = '';
            for (var i = 0; i < allData.length; i++) {
                //alert(temp.length);
                var data = temp[i];
                // console.info(temp[i][0]);
                html += '<tr id="show_tab_tr" idx="' + i + '" >' +
                    '<td key="pkey" title="' + data.pkey +'"><input  type="text" value="' + data.pkey + '"  disabled ></td>' +
                    '<td key="userName"  title="' + data.userName +'"><input  type="text" value="' + data.userName + '"  disabled ></td>' +
                    '<td key="password" title="' + data.password +'" ><input  type="text" value="' + data.password + '" disabled  ></td>' +
                    '<td key="mobile"  title="' + data.mobile +'"><input  type="text" value="' + data.mobile + '" disabled  ></td>' +
                    '<td key="email"  title="' + data.email +'"><input  type="text" value="' + data.email + '" disabled  ></td>' +
                    '<td key="status" title="' + data.status +'" ><input  type="text" value="' + data.status + '" disabled  ></td>' +
                    '<td><input id="center" style="display: inline-block;float:left;width:40px;color:#12a9ef;" kepp="dianji" type="button" value="编辑"> &nbsp &nbsp' +
                    '<input type="button" class = "remove" style="display: inline-block;float:right; width:40px; color:#12a9ef;" det="detlet"   value="删除" ></td>' +
                    '</tr>';

                $("tbody").html(html);
            }

            getenter();
            getdet();
            //  len =temp.length;
            //  page=len % pageSize==0 ? len/pageSize : Math.floor(len/pageSize)+1;
            //alert(page);
           // countpage = allData.countpage
            pagenow = allData.pagenow
            //alert(pagenow);
        }

    });

};

//删除数据
function getdet(){
    $('input[det="detlet"]').click(function(){
        //var key = $('td[key="pkey"]').parent().parent().attr("idx");

        var  pkey = $(this).parent().siblings('td[key="pkey"]').children().val();

        // console.info(pkey,clientid);
        if(confirm('确定删除么')){
            $.ajax({
                url:"userAdminDelete",
                data:{"pkey":pkey},
                type:"POST",
             //   dataType:"text",
                success:function(data){
                    if(data=="ok")
                    {
                        alert("删除成功")
                        location.reload();
                        //window.location.href="test.php";
                    }
                    else
                    {
                        alert("删除失败")

                    }

                }
            });
        }


    });
}

//搜索查询
function getchaxun(){


    //console.info(arry);
    $(".query").click(function(){

        var arry = setarry();
        if (arry["description"] == "" && arry["clientid"] == "") {

            alert("请输入查询内容");
        } else {
            document.getElementById("curPage").value=1;
            getagetable(arry);
            console.info(arry);
            //getfenye(arry);

        }


    });


}