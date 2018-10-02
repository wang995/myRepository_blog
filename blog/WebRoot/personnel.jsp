<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Xl995_Blog - 人事面试</title> 
<link rel="stylesheet" type="text/css"
	href="http://localhost:8080/blog/static/layui/css/layui.css" />
<script src="http://localhost:8080/blog/static/js/jquery-1.8.2.js"
	type="text/javascript" charset="utf-8"></script>
<script src="http://localhost:8080/blog/static/layui/layui.js"
	type="text/javascript" charset="utf-8"></script>
<style type="text/css">
	
</style>
</head>
<body>
	<div style="width: 420px;height: 240px;border: 1px solid gray;">
		<div class="feedbackdiv">
			<input type="text" style="width: 350px;display: inline;margin: 5px 0px;" readonly="readonly" class="layui-input">
			<textarea placeholder="说点什么吧！" style="width: 350px;" class="layui-textarea" name="feedbackContent"></textarea>
			<input type="text" placeholder="Your Name" style="width: 350px;display: inline;margin: 5px 0px;" readonly="readonly" class="layui-input">
			<span style="float: right;">
				<button onclick="cancel()" class="layui-btn layui-btn-normal">取消</button>
				<button onclick="feedbackCommit()" class="layui-btn layui-btn-normal">提交</button> 
			</span>
		</div>
	</div>
</body>
</html>  