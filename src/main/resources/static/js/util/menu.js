/**

 @Name: layuiSimpleBlog - 极简博客模板
 @Author: xuzhiwen
 @Copyright: layui.com

 */


layui.define(['mm', 'jquery'], function (exports) {
    var $ = layui.$, mm = layui.mm;
    var menu = {
        init: function () {
            $('.menu').on('click', function () {
                if ($(this).hasClass('on')) {
                    $(this).removeClass('on')
                    $('.header-down-nav').removeClass('layui-show');
                } else {
                    $(this).addClass('on')
                    $('.header-down-nav').addClass('layui-show');
                }
            })
            window.onresize = function () {
                var curwidth = document.documentElement.clientWidth;
                if (curwidth > 760) {
                    $('.header-down-nav').removeClass('layui-show');
                    $('.menu').removeClass('on');
                }
            };
            var count = $('.list-cont .cont').length;
            $('.volume span').text(count);
            $('.op-list .like').on('click', function () {
                var oSpan = $(this).children('span');
                var num = parseInt($(oSpan).text())
                var off = $(this).attr('off')
                if (off) {
                    $(this).removeClass('active');
                    off = true;
                    $(oSpan).text(num - 1)
                    $(this).attr('off', '')
                } else {
                    $(this).addClass('active');
                    off = false;
                    $(oSpan).text(num + 1)
                    $(this).attr('off', 'true')
                }
            })
        },
        off: function () {
            $('.off').on('click', function () {
                var off = $(this).attr('off');
                var chi = $(this).children('i');
                var text = $(this).children('span');
                var cont = $(this).parents('.item').siblings('.review-version');
                if (off) {
                    $(text).text('展开');
                    $(chi).attr('class', 'layui-icon layui-icon-down');
                    $(this).attr('off', '');
                    $(cont).addClass('layui-hide');
                } else {
                    $(text).text('收起');
                    $(chi).attr('class', 'layui-icon layui-icon-up')
                    $(this).attr('off', 'true')
                    $(cont).removeClass('layui-hide')
                }
            })
        },
        submit: function (username) {
            $('.definite').on('click', function (e) {
                let allcom = $("#allComment").text();
                // 获取当前时间开始
                let date = new Date();
                let seperator1 = "-";
                let seperator2 = ":";
                let month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
                let strDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
                let strHours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
                let strMinu = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
                let strSec = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
                let currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
                    + " " + strHours + seperator2 + strMinu
                    + seperator2 + strSec;
                // 获取当前时间结束
                let event = e || event;
                event.preventDefault();
                let $listcont = $(this).parents('.form').siblings('.list-cont').length ? $(this).parents('.form').siblings('.list-cont') : $(this).parents('.form-box').siblings('.list-cont');
                console.log($listcont);
                let img = parseInt($.cookie('head'));
                //var img = $(this).parents('form').siblings('img').attr('src');
                let textarea = $(this).parents('.layui-form-item').siblings('.layui-form-text').children('.layui-input-block').children('textarea');
                let name = $(textarea).val();
                let html = laytplCont.innerHTML;
                let data = {
                    avatar: img,
                    name: username,
                    cont: name,
                    dta: currentdate
                };
                if (name) {
                    let cont = mm.renderHtml(html, data);
                    $listcont.prepend(cont);
                    var cunt = $(this).parents('.form-box').siblings('.volume').children('span');
                    //var cunts = $(this).parents('.form-box').siblings('.list-cont').children('.cont').length;
                    textarea.val('')
                } else {
                    layer.msg('请输入内容')
                }
                let userId = parseInt($.cookie('userId'));
                let  articleId = parseInt($("#articleId").val());
                let json = {
                    text:name,
                    createTime:currentdate,
                    userId:userId,
                    articleId:articleId
                };
                $.ajax({
                    url: '/incComment',
                    contentType:"application/json;charset=UTF-8",
                    dataType: 'json',
                    type: 'POST',
                    data: JSON.stringify(json),
                    success: function (data) {
                        if (data.status === 0){
                            alert("评论成功");
                            cunt.text(parseInt(allcom)+1)
                        } else {
                            alert("评论失败");
                        }
                    },
                    error: function () {
                        console.log("请求=失败");
                    }
                });

            })
        }
    };
    exports('menu', menu)
});