//创建一个模拟类来实现存储当前车辆信息
function StationDetail() {}

//在地图上添加一个marker方法
//point marker在地图上的位置
//imgUrl Icon 使用的图片
//iconSize Icon的大小,即可视区域的大小
//anchorSize point相对于Icon左上角的偏移量

function addMarker(stationId, point, imgUrl, iconSize, anchorSize) { // 创建图标对象   
    var opts = {
        anchor: anchorSize,
        imageSize: iconSize
    };
    // 创建标注对象并添加到地图   
    var myIcon = new BMap.Icon(imgUrl, iconSize, opts);
    var marker = new BMap.Marker(point, { icon: myIcon });
    marks.push(marker);
    map.addOverlay(marker);

    marker.addEventListener("click", function(e) {

        addInfoWindow(250, 250, "当前站点信息:", addBikeWindowInfoContent(detailMap.get(stationId)), point)
    });
}

//设置地图样式
function setBMapStyle(styleId) {
    map.setMapStyleV2({
        styleId: styleId
    });
}
//接收一个站点的车辆等级
function getBikeLevel(arr) {
    $(arr).each(function(index, data) {
        var stationId = data.station_id;

        var level;
        if (data.num_docks_available + data.num_bikes_available == 0 || data.num_docks_available == 0) {
            level = 0;

        }
        var abi = (data.num_bikes_available / (data.num_docks_available + data.num_bikes_available));
        if (0 < data.num_bikes_available < 5) level = 1;
        if (abi < 0.5) level = 2
        if (0.5 <= abi < 1) level = 3;
        if (abi >= 1) level = 4

        levelMap.set(stationId, level);





        //以下用于将车的信息封装到sDetail对象中
        var sDetail = new StationDetail();
        var nba = data.num_bikes_available;
        var nda = data.num_docks_available;
        sDetail.stationId = stationId;
        sDetail.nba = nba;
        sDetail.nda = nda;
        detailMap.set(stationId, sDetail);

    })

}

//根据不同的等级设置不同的标准
function setBileLevel(arr) {
    $(arr).each(function(index, data) {
        var stationId = data.station_id;
        var point_temp = new BMap.Point(data.lon, data.lat);
        var imgUrl = "img/si_" + levelMap.get(stationId) + ".png";
        addMarker(stationId, point_temp, imgUrl, iconsmallSize);
        detailMap.get(stationId).name = data.name;
        detailMap.get(stationId).short_name = data.short_name;



    })
}

//设置地图的缩放监听事件
function setListenByZoom() {

    map.addEventListener("zoomend", function() {
        if (this.getZoom() > 14) {
            isBigIcon = true; //说明此时是大图标
            switchIcon(this.getZoom(), isBigIcon);

        } else {
            isBigIcon = false; //说明此时是小图标
            switchIcon(this.getZoom(), isBigIcon);

        }

    });
}

//设置缩放之后的图标变化
function switchIcon(zoomSize, iconType) {
    $(marks).each(function(index, data) {
        var iconColor = data.getIcon().imageUrl.substring(data.getIcon().imageUrl.length - 5, data.getIcon().imageUrl.length);

        if (iconType == false) {

            var imageUrl = "img/si_" + iconColor;

            if (5 < zoomSize < 15) {
                var opts = {
                    anchor: achosmallSize,
                    imageSize: iconsmallSize
                };

                var icon = new BMap.Icon(imageUrl, iconsmallSize, opts);
                this.setIcon(icon);
            }
            if (zoomSize < 13) {
                var opts = {
                    anchor: achovsmallSize,
                    imageSize: iconvsmallSize
                };

                var icon = new BMap.Icon(imageUrl, iconsmallSize, opts);
                this.setIcon(icon);
            }


        } else {
            var imageUrl = "img/bi_" + iconColor;


            var opts = {
                anchor: achobigSize,
                imageSize: iconbigSize
            };

            var icon = new BMap.Icon(imageUrl, iconbigSize, opts);
            this.setIcon(icon);
        }

    })
}

//添加信息窗口
function addInfoWindow(width, height, title, cotent, point) {
    var opts = {
        width: width, // 信息窗口宽度    
        height: height, // 信息窗口高度    
        title: title // 信息窗口标题   
    }
    var infoWindow = new BMap.InfoWindow(cotent, opts); // 创建信息窗口对象 
    map.openInfoWindow(infoWindow, point); // 打开信息窗口

}