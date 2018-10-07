function totechnology_admin(){
	window.location.href="technology_admin.jsp";
}
function topersonnel_admin(){
	window.location.href="personnel_admin.jsp";
}
function tolog_admin(){
	window.location.href="log_admin.jsp";
}
function toadvise_admin(){
	window.location.href="advise_admin.jsp";
}
function tofeedback_admin(){
	window.location.href="feedback_admin.jsp";
}
function totools_admin(){
	window.location.href="tools_admin.jsp";
}
function exit(){
	$.post("admin/exit_admin",function(res){
		if(res){
			window.location.href="index.jsp"
		}else{
			layer.msg("退出失败！",{icon: 0});
		}
	},"json")
}