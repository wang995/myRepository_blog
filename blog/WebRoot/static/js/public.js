function exit(){
	layer.confirm("确定退出管理员权限？",{
		title:"Exit"
	},
	function(){
		$.post("admin/exit_admin",function(res){
			if(res){
				location.replace("index.jsp");
			}else{
				layer.msg("退出失败！",{icon: 0});
			}
		},"json")
	})
};
function keycode(){
	//键盘事件
	var keycode
	$(document).keydown(function(event){
		var keycode = event.keyCode;
	});
	return keycode;
}
function tips(content,icon){
	layer.msg(content,{icon: icon});
}