
//设置地图样式
function setBMapStyle(styleId){  
	map.setMapStyleV2({     
		  styleId: styleId
		});
}  
//接收一个站点的车辆等级
function getBikeLevel(arr){
	$(arr).each(function(index,data){
		var stationId=data.station_id;
		
		var level;
		if(data.num_docks_available+data.num_bikes_available==0||data.num_docks_available==0){
			level=0;
			
		}
		var abi=(data.num_bikes_available/(data.num_docks_available+data.num_bikes_available));
		 if(0<data.num_bikes_available<5) level= 1;
		 if(abi<0.5) level= 2 
		 if(0.5<=abi<1)level= 3;
		 if(abi>=1) level= 4 
		
		levelMap.set(stationId, level);
		
	})
}

//根据不同的等级设置不同的标准
function setBileLevel(arr){
	$(arr).each(function(index,data){
		var stationId=data.station_id;
		var point_temp=new BMap.Point(data.lon,data.lat);
		var imgUrl="img/si_"+levelMap.get(stationId)+".png";
		addMarker(point_temp,imgUrl,iconsmallSize);
		
	})
}

//设置地图的缩放监听事件
function setListenByZoom(){
	 
	map.addEventListener("zoomend", function(){    
		  if(this.getZoom()>14) {
			  isBigIcon=true;//说明此时是大图标
			  switchIcon(this.getZoom(),isBigIcon);
			  
		  }else {
			  isBigIcon=false;//说明此时是小图标
			  switchIcon(this.getZoom(),isBigIcon);
			  
		  }
		  
	});
}

//设置缩放之后的图标变化
function switchIcon(zoomSize,iconType){
	$(marks).each(function(index,data){
		iconColor=data.getIcon().imageUrl.substring(data.getIcon().imageUrl.length-5,data.getIcon().imageUrl.length);
		
		if(iconType==false){
			
			var imageUrl="img/si_"+iconColor;
			console.log("开始变小")
			console.log(imageUrl)
			if(5<zoomSize<15){
			var opts={
			    		 anchor:achosmallSize,
			     		 imageSize:iconsmallSize
			     }; 
			console.log("当前zoom为"+zoomSize);
			var icon = new BMap.Icon(imageUrl,iconsmallSize,opts);
			this.setIcon(icon);
			}
			if(zoomSize<13){
				var opts={
			    		 anchor:achovsmallSize,
			     		 imageSize:iconvsmallSize
			     }; 
				console.log("当前zoom为"+zoomSize);
			var icon = new BMap.Icon(imageUrl,iconsmallSize,opts);
			this.setIcon(icon);
			}
			  
			
		}else{
			var imageUrl="img/bi_"+iconColor;
			console.log("开始变大")
			console.log(imageUrl)
			
			  var opts={
			    		 anchor:achobigSize,
			     		 imageSize:iconbigSize
			     }; 
			console.log("当前zoom为"+zoomSize);
			var icon = new BMap.Icon(imageUrl,iconbigSize,opts);
			this.setIcon(icon);
		}
		
	})
}

//添加信息窗口
function addInfoWindow(width,height,title,cotent,point){
	var opts = {    
		    width : width,     // 信息窗口宽度    
		    height: height,     // 信息窗口高度    
		    title : title  // 信息窗口标题   
		}  
	var infoWindow = new BMap.InfoWindow(cotent, opts);  // 创建信息窗口对象 
	map.openInfoWindow(infoWindow, point);      // 打开信息窗口
	
}