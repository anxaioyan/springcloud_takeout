/*
function Location() {};

Location.prototype.getLocation = function (callback) {
    var options = {
        enableHighAccuracy: true,
        maximumAge: 1000
    };
    this.callback = Object.prototype.toString.call(callback) == "[object Function]" ?
        callback :
        function (address) {
            alert(address.province + address.city);
            console.log("getocation(callbackFunction) 可获得定位信息对象");
        };
    var self = this;
    if (navigator.geolocation) {
        //浏览器支持geolocation
        navigator.geolocation.getCurrentPosition(function (position) {
            //经度
            var longitude = position.coords.longitude;
            //纬度
            var latitude = position.coords.latitude;
            self.loadMapApi(longitude, latitude);
        }, self.onError, options);
    } else {
        //浏览器不支持geolocation
    }
};

Location.prototype.loadMapApi = function (longitude, latitude) {
    var self = this;
    var oHead = document.getElementsByTagName('HEAD').item(0);
    var oScript = document.createElement("script");
    oScript.type = "text/javascript";
    oScript.src = "http://api.map.baidu.com/getscript?v=2.0&ak=A396783ee700cfdb9ba1df281ce36862&services=&t=20140930184510";
    oHead.appendChild(oScript);
    oScript.onload = function (date) {
        var point = new BMap.Point(longitude, latitude);
        var gc = new BMap.Geocoder();
        gc.getLocation(point, function (rs) {
            var addComp = rs.addressComponents;
            self.callback(addComp);
        });
    }
};

Location.prototype.onError = function (error) {
    switch (error.code) {
        case 1:
            alert("位置服务被拒绝");
            break;
        case 2:
            alert("暂时获取不到位置信息");
            break;
        case 3:
            alert("获取信息超时");
            break;
        case 4:
            alert("未知错误");
            break;
    }
};

//调用
var local = new Location();
local.getLocation(function (res) {
    //此处就是返回的地理位置信息
    console.log(res);
    //JSON.stringify(res)，把返回的对象转为字符串了，自己根据需求截取下就好 street  district  city province
    var resstr = JSON.stringify(res);
    alert(res.province+"-"+"-"+res.city+"-"+res.district+"-"+res.street);
    $("#areaReside").val(res.province+"-"+"-"+res.city+"-"+res.district+"-"+res.street)
});*/
var map = new AMap.Map('container', {
    resizeEnable: true
});
//定位
if(localStorage.getItem("xcity") != null || localStorage.getItem("xcity") != "") {//如果存储了city就使用上一次存储的city
    var xcity = localStorage.getItem("xcity")
} else {   //否则重新定位
    map.plugin('AMap.Geolocation', function() {
        geolocation = new AMap.Geolocation({
            enableHighAccuracy: true, //是否使用高精度定位，默认:true
            timeout: 10000, //超过10秒后停止定位，默认：无穷大
            noIpLocate: 0,
            maximumAge: 0, //定位结果缓存0毫秒，默认：0
            convert: true, //自动偏移坐标，偏移后的坐标为高德坐标，默认：true
            showButton: true, //显示定位按钮，默认：true
            buttonPosition: 'LB', //定位按钮停靠位置，默认：'LB'，左下角
            buttonOffset: new AMap.Pixel(10, 20), //定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
            showMarker: true, //定位成功后在定位到的位置显示点标记，默认：true
            showCircle: true, //定位成功后用圆圈表示定位精度范围，默认：true
            panToLocation: true, //定位成功后将定位到的位置作为地图中心点，默认：true
            zoomToAccuracy: true //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
        });
        map.addControl(geolocation);
        geolocation.getCurrentPosition();
        AMap.event.addListener(geolocation, 'complete', onComplete); //返回定位信息
        AMap.event.addListener(geolocation, 'error', onError); //返回定位出错信息
    });

    function onComplete(data) {
        var xcity = data.addressComponent.city; //定位的城市名称
        //经纬度
        var lng = data.position.getLng();
        var lat = data.position.getLat();

        localStorage.setItem("xcity", xcity) //把定位存在localStorage，下次进入不会重新定位

    }
    //解析定位错误信息
    function onError(data) {
        	alert("定位失败")
        var xcity = "北京市" //在这里可以添加一个默认城市，在定位出错之后使用此默认城市（或者返回定位出错）
    }
}

