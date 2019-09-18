function StationDetail(){
	
}

function switchIcon(isBigIcon){
	
	for(var index in markerArr){
		var imageUrl= markerArr[index].getIcon().imageUrl;
		/*console.log("before:"+imageUrl);*/
		/*var bikeLevel=imageUrl.substring();*/
		var anchorSize;
		var iconSize;
		if(isBigIcon==true){
			if(isPileType==false){
			imageUrl=imageUrl.replace(/s/,"b");
			iconSize=bigIconSize;
			anchorSize=bigAnchorSize;
		}
		else{
			imageUrl=imageUrl.replace(/s/,"z");
			iconSize=bigIconSize;
			anchorSize=bigAnchorSize;
		}
	}
		if(isBigIcon==false){
			imageUrl=imageUrl.replace(/b/,"s");
			imageUrl=imageUrl.replace(/z/,"s");
			iconSize=smallIconSize;
			anchorSize=smallAnchorSize;
		}
		
		/*var anchorSize=new BMap.Size(20, 50);
		var iconSize=new BMap.Size(41, 50);*/
		/*console.log("after:"+imageUrl);*/
		var opts={
				anchor:anchorSize,
				imageSize:iconSize
		};
		//以给定的图像地址和大小创建图标对象实例
	    var myIcon = new BMap.Icon(imageUrl, iconSize, opts);      
	    // 创建标注对象并添加到地图   
	   markerArr[index].setIcon(myIcon);                                                                              
	}
}
function switchIcon1(isBigIcon){
	
	
	for(var index in markerArr){
		var imageUrl= markerArr[index].getIcon().imageUrl;
		/*console.log("before:"+imageUrl);*/
		/*var bikeLevel=imageUrl.substring();*/
		var anchorSize;
		var iconSize;
		if(isBigIcon==true){
			imageUrl=imageUrl.replace(/s/,"z");
			iconSize=bigIconSize;
			anchorSize=bigAnchorSize;
		}
		if(isBigIcon==false){
			imageUrl=imageUrl.replace(/z/,"s");
			iconSize=smallIconSize;
			anchorSize=smallAnchorSize;
		}
		
	
		var opts={
				anchor:anchorSize,
				imageSize:iconSize
		};
		//以给定的图像地址和大小创建图标对象实例
	    var myIcon = new BMap.Icon(imageUrl, iconSize, opts);      
	    // 创建标注对象并添加到地图   
	   markerArr[index].setIcon(myIcon);                                                                              
	}
}

function changeMarker(isPileType,id,i){
	if(isBigIcon==false){
		
	if(isPileType == true){
				//获取imageUrl
		
				var imageUrl = markerArr[i].getIcon().imageUrl;
				imageUrl =  "img/si_"+pileMap.get(id)+".png";
				//获取marker下标
				var anchorSize = new BMap.Size(5, 10);//偏移距离大小
				var iconSize = new BMap.Size(10, 10);//标注大小
				var opts =
			    {  
			        anchor : anchorSize,//横向偏移0.5个宽度，高度便宜一个高度
			        imageSize : iconSize
			    }; 
				var myIcon= new BMap.Icon(imageUrl,iconSize,opts);
				   //设置新的Icon
				markerArr[i].setIcon(myIcon);
				
				//console.log(markerArr[index].getIcon().imageUrl);		
	}else{
		if(isPileType == false){
			//获取imageUrl
			var imageUrl = markerArr[i].getIcon().imageUrl;
			imageUrl =  "img/si_"+bikeMap.get(id)+".png";
			//获取marker下标
			var anchorSize = new BMap.Size(5, 10);//偏移距离大小
			var iconSize = new BMap.Size(10, 10);//标注大小
			var opts =
		    {  
		        anchor : anchorSize,//横向偏移0.5个宽度，高度便宜一个高度
		        imageSize : iconSize
		    }; 
			var myIcon= new BMap.Icon(imageUrl,iconSize,opts);
			   //设置新的Icon
			markerArr[i].setIcon(myIcon);
			
			//console.log(markerArr[index].getIcon().imageUrl);		
		}
	}
}
	else{
// 	if(isPileType == true){
// 		//获取imageUrl
// 		var imageUrl = markerArr[i].getIcon().imageUrl;
// 		imageUrl =  "img/zi_"+bikeMap.get(id)+".png";
// 		//获取marker下标
// 		var anchorSize = new BMap.Size(20, 50);//偏移距离大小
// 		var iconSize = new BMap.Size(41, 50);//标注大小
// 		var opts =
// 	    {
// 	        anchor : anchorSize,//横向偏移0.5个宽度，高度便宜一个高度
// 	        imageSize : iconSize
// 	    };
// 		var myIcon= new BMap.Icon(imageUrl,iconSize,opts);
// 		   //设置新的Icon
// 		markerArr[i].setIcon(myIcon);
// 		//console.log(markerArr[index].getIcon().imageUrl);
// }
		if(isPileType == true){
			//获取imageUrl
			var imageUrl = markerArr[i].getIcon().imageUrl;
			imageUrl =  "img/zi_"+pileMap.get(id)+".png";

			//获取marker下标
			var anchorSize = new BMap.Size(20, 50);//偏移距离大小
			var iconSize = new BMap.Size(41, 50);//标注大小
			var opts =
				{
					anchor : anchorSize,//横向偏移0.5个宽度，高度便宜一个高度
					imageSize : iconSize
				};
			var myIcon= new BMap.Icon(imageUrl,iconSize,opts);
			//设置新的Icon
			markerArr[i].setIcon(myIcon);}

			//console.log(markerArr[index].getIcon().imageUrl);
	else{
		//获取imageUrl
		var imageUrl = markerArr[i].getIcon().imageUrl;
		imageUrl =  "img/bi_"+bikeMap.get(id)+".png";
		//获取marker下标
		var anchorSize = new BMap.Size(20, 50);//偏移距离大小
		var iconSize = new BMap.Size(41, 50);//标注大小
		var opts =
	    {  
	        anchor : anchorSize,//横向偏移0.5个宽度，高度便宜一个高度
	        imageSize : iconSize
	    }; 
		var myIcon= new BMap.Icon(imageUrl,iconSize,opts);
		   //设置新的Icon
		markerArr[i].setIcon(myIcon);
		//console.log(markerArr[index].getIcon().imageUrl);	
			}
		}
	}

//获取bikeLevel
function getBikeLevel(nba,nda){
	
	var bikeLevel = 0;
	var abi = nba/(nba+nda);
	var adi = nda/(nda+nba);
	//保存桩和车的等级
	var arr= [];
	//根据可用车辆和可用桩的数量来确定级别
	if(nba==0||(nba==0&&nda==0))
	{
		bikeLevel = 0;//红色
	}
	else if(nba<5){
		bikeLevel = 1;//黄色
	}
	else if(abi<0.5){
		bikeLevel = 2;//少绿
	}
	else if(abi>=0.5&&abi<1){
		bikeLevel = 3;//多绿
	}
	else{
		bikeLevel = 4;//全绿
	}
	
	
	//根据可用车辆和可用桩的数量来确定级别
	if(nda==0||(nba==0&&nda==0))
	{
		pileLevel = 0;//红色
	}
	else if(nda<5){
		pileLevel = 1;//黄色
	}
	else if(adi<0.5){
		pileLevel = 2;//少绿
	}
	else if(adi>=0.5&&adi<1){
		pileLevel = 3;//多绿
	}
	else{
		pileLevel = 4;//全绿
	}
	//返回leaval值
	arr.push(bikeLevel);
	arr.push(pileLevel)
	return arr;
}



//为一个marker添加单击事件，弹出信息窗
function addMarkerInfoWindow(marker,id){
	
	var sDetail=detailMap.get(id);
	
	var sContent="<div class='mapbox-content'>"+
	"<div class='mapbox-content-top'>"+
	"<span class='window_lastUpdate'> 0 ms ago </span> "+
	"<span class='window_info_button'></span>"+		
"</div>"+
"<div class='mapbox-content-header'>"+
	"<h1 class='mapbox-content-header-stationName'>"+sDetail.name+"</h1>"+
"</div>"+
"<div class='mapbox-content-detail'>"+
	"<div class='mapbox-content-detail-bikes-available'>"+
		"<span class='mapbox-content-detail-bikes-available-val'> "+sDetail.nba+"</span>"+
		"<span class='mapbox-content-detail-bikes-available-lbl'>Bikes</span>"+
	"</div>"+
	"<div class='mapbox-content-detail-docks-available'>"+
		"<span class='mapbox-content-detail-docks-available-val'> "+sDetail.nda+" </span>"+ 
		"<span class='mapbox-content-detail-docks-available-lbl'>Docks</span>"+
	"</div>"+
"</div>"+
"<div class='mapbox-content-footer'>"+
	"<span class='mapbox-content-footer-shortName'> Bike station:"+
	+sDetail.shoreName+" </span>"+
"</div>"+
"</div>";
	var infoWindow = new BMap.InfoWindow(sContent, {offset: new BMap.Size(0, -45)});
    
    marker.addEventListener("click", function(){
    	this.openInfoWindow(infoWindow);
    });
    
}

//在地图上添加一个marker的方法
//point marker在地图的位置
//imgUrl Icon使用图片的url
//iconSize Icon的大小，即可视区域大小
//anchorSize相对于icon左上角的偏移量
function addMarker(point,imageUrl, iconsize, anchorSize,id){  // 创建图标对象  
		
	var opts={
			anchor:anchorSize,
			imageSize:iconsize
	};
    var myIcon = new BMap.Icon(imageUrl, iconsize, opts);      
    // 创建标注对象
    var marker = new BMap.Marker(point, {icon: myIcon}); 
  //将marker对象添加到marker的数组中
    markerArr.push(marker);
    //调用方法为marker添加信息窗
    addMarkerInfoWindow(marker,id); 
    //将标注添加到地图  
    map.addOverlay(marker);    
}    