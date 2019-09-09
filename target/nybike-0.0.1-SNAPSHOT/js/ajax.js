
//设置ajax，并返回结果值
function ajax(sendMethod,url,data){  
	var info;
	$.ajax({ 
		url: url, 
		data:data,
		type:sendMethod,
		//此处若不是携带cooki参数进行传送，无需添加
		xhrFields:{
			withCredentials:true
		},
		crossDomain:true,
		async:false,//将同步标志改为false，代表执行完后续代码才返回结果
		   
		success: function(data){
			 info=data;
	},
		error:function(data){
			 info=data;
		}
	  });
	
	return info;
}  
