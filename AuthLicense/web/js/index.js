/**
 * Created by cp on 2017/8/16.
 */
$(document).ready(function($){

    //上下滑动选项卡切换
    $("#move-animate-top").tabso({
        cntSelect:"#topcon",
        tabEvent:"mouseover",
        tabStyle:"move-animate",
        direction : "top"
    });

    //左右滑动选项卡切换
    $("#move-animate-left").tabso({
    cntSelect:"#leftcon",
    tabEvent:"mouseover",
    tabStyle:"move-animate",
    direction : "left"
    });

    //淡隐淡现选项卡切换
    $("#fadetab").tabso({
    cntSelect:"#fadecon",
    tabEvent:"mouseover",
    tabStyle:"fade"
    });

    //默认选项卡切换
    $("#normaltab").tabso({
    cntSelect:"#normalcon",
    tabEvent:"mouseover",
    tabStyle:"normal"
    });

    });