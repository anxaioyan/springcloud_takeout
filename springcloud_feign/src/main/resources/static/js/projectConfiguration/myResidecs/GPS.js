/*
* @Author: Administrator
* @Date:   2019-04-25 16:02:08
* @Last Modified by:   Administrator
* @Last Modified time: 2019-04-25 17:10:00
*/
function  search(ress,city){
        var geo = new qq.maps.Geocoder()
        console.log(geo)
        var guo="中国";
         
        geo.getLocation(guo+","+city+","+ress)//地址
        geo.setComplete(function(res){
            console.log(res,res.detail.location)//得到经纬度
            var map = new qq.maps.Map(document.getElementById('map'),{
                center: res.detail.location,//将经纬度加到center属性上
                zoom: 16,//缩放   
                draggable: true,//是否可拖拽
                scrollwheel: true,//是否可滚动缩放
                disableDoubleClickZoom: false
            })
            var marker = new qq.maps.Marker({
                position: res.detail.location,//标记的经纬度
                animation: qq.maps.MarkerAnimation.BOUNCE,//标记的动画
                map: map//标记的地图
            })

            var citylocation = new qq.maps.CityService({
                //设置地图
                map : map,

                complete : function(results){
                    console.log(9999,results)
                }
            });
        })
    }