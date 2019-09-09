//在地图上添加一个marker方法
//point marker在地图上的位置
//imgUrl Icon 使用的图片
//iconSize Icon的大小,即可视区域的大小
//anchorSize point相对于Icon左上角的偏移量

function addMarker(point, imgUrl, iconSize, anchorSize) { // 创建图标对象   
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
        console.log(e.point);
        addInfoWindow(250, 250, "当前车辆信息:", addBikeWindowInfoContent(), point)
    });
}
//设置地图样式
function setBMapStyle(styleId) {
    map.setMapStyleV2({
        styleId: '3d71dc5a4ce6222d3396801dee06622d'
    });
}