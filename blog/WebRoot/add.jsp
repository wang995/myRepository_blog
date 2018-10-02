<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="/commons/common.jsp"%>
<script type="text/javascript">
	$(function(){
	});
	function addTechnology(){
		var title = $("#title").val();
		var content = $("#content").val();
		$.post("http://localhost:8080/blog/addTechnology",{
			"title":title,
			"content":content
		},
		function(res){
			if(res){
				alert("添加成功！");
			}else{
				alert("添加失败！");
			}
		});
	}
</script>
</head>
<body>
	<input id="title" type="text" name="title" value="" /><br />
	<textarea id="content" style="width: 300px;height: 100px;" id="content"></textarea><br />
	<input type="button" onclick="addTechnology()" value="添加"/>
</body>
</html>