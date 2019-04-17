$(function () {

    $.ajax({
        url:'../myPersonalTree/treeListMy',
        type:'get',
        dataType:'json',
        success:function (nodes) {
            layui.use('tree', function(){
                layui.tree({
                    elem:"#demo",
                    nodes:nodes
                });
            });


        }
    })
})