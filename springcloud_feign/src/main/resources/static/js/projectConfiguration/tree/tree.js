/*
$(function () {

   $.ajax({
        url:'../myPersonalTree/treeListMy',
        type:'get',
        dataType:'json',
        success:function (nodes) {
            layui.use('tree', function(){
                layui.tree({
                    elem:'#myTree',
                    nodes:nodes
                });
            });

        }
    });
    
});
*/

$(function () {
    layui.use(['element','layer','jquery','tree'], function(){
        var element = layui.element;
        var layer = layui.layer;
        var $ = layui.jquery;

        $.ajax({
            type : "get",
            url : "../myPersonalTree/treeListMy",
            dataType : "json",

            success : function(data) {
                layui.tree({
                    elem: '#sidemenubar' //传入元素选择器
                    ,nodes: data
                    ,autoRefresh:true
                    ,click: function(node){
                        var exist=$("li[lay-id='"+node.id+"']").length;
                        if (exist > 0) {//判断是否已经发开选项卡
                            element.tabChange('tabs', node.id);// 切换到已有的选项卡
                        } else {//如果没打开就新建一个选项卡
                            if (node.url!=null) {
                                    element.tabAdd('tabs', {
                                        title:node.name,//选项卡的名称
                                        //把这个页面嵌套进选项卡中
                                        content:'<iframe  scrolling="no" frameborder="0" src="' + node.url + '" style="width:100%;height:99%;"></iframe>',
                                        //这是选项卡的id
                                        id:node.id
                                    });
                                    element.tabChange('tabs', node.id);

                            }
                        }
                    }
                });
            }
        });
    });

})