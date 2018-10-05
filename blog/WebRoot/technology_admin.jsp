<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Xl995_Blog - 技术面试_管理员</title>
<%@ include file="/commons/common.jsp"%>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
	/* border: 1px solid red; */
}
.title {
	margin-bottom: 30px;
	font-size: 24px;
	word-break: break-all;
	white-space: pre-wrap;
}
.content {
	word-break: break-all;
	white-space: pre-wrap;
	font-size: 18px;
}
#main {
	width: 70%;
	margin: 50px auto;
}
.Technology {
	padding: 30px 0px;
	border-bottom: 1px solid gray;
}
.updatediv{
	height: 95%;
	width:800px;
	margin:5px auto;
}
.updatebtn{
	float:right;
}
#addContent{
	margin-bottom:5px;
	height:380px;
}
#updateContent{
	margin-bottom:5px;
	height:380px;
}
#head {
	width: 100%;
	height: 50px;
	z-index: 10px;
	position: fixed;
	top: 0px;
	background-color: rgba(245, 245, 245, 0.8);
	box-shadow: 2px 0px 2px gray;
}
#headconent {
	color: grey;
	display: flex;
	font-size: 20px;
	align-items: center;
	justify-content: space-between;
	font-family: '幼圆';
}
</style>
<script type="text/javascript">
	var layer;
	$(function() {
		layui.use('layer', function(){
		  layer = layui.layer;
		});              
		getTechnology();
	})
	function getTechnology() {
		$.post("http://localhost:8080/blog/queryTechnology", function(res) {
			$.each(JSON.parse(res), function(i, val) {
				$("#main").prepend(
					"<div class='Technology'><div class='title'>"
					+ val.title + "<span class='updatebtn'><button onclick='openUpdateWindow("+i+","+res+")' class='layui-btn layui-btn-warm'><i class='layui-icon layui-icon-username'></i>修改</button><button onclick='delete("+res.id
					+")' class='layui-btn layui-btn-danger'><i class='layui-icon layui-icon-username'></i>删除</button></span></div><pre class='content'>"
					+ val.content + "</pre></div>"
				)
			});
		})
	}
	function search(){
		layer.msg($("#search").val())
	}
	var index;
	function openAddWindow(){
		index = layer.open({
		  title:"添加技术面试题",
		  type: 1, 
		  area: ['924px', '539px'], //宽高
		  content: "<div class='updatediv'><input id='addTitle' type='text' placeholder='标题' style='width: 800px;display: inline;margin: 10px 0px;' class='layui-input'><textarea id='addContent' placeholder='说点什么吧！' style='width: 800px;' class='layui-textarea'></textarea><span style='float: right;'><button onclick='cancel()' class='layui-btn layui-btn-danger'>取消</button><button onclick='addCommit()' class='layui-btn layui-btn-normal'>提交</button> </span></div>",
		  closeBtn: 1,
		}); 
	}
	function openUpdateWindow(i,res){
		index = layer.open({
		  title:"修改技术面试题",
		  type: 1, 
		  area: ['924px', '539px'], //宽高
		  content: "<div class='updatediv'><input id='updateTitle' type='text' placeholder='标题' value='"+res[i].title+"' style='width: 800px;display: inline;margin: 10px 0px;' class='layui-input'><textarea id='updateContent' placeholder='说点什么吧！' style='width:800px;' class='layui-textarea'>"+res[i].content+"</textarea><span style='float: right;'><button onclick='cancel()' class='layui-btn layui-btn-danger'>取消</button><button onclick='updateCommit()' class='layui-btn layui-btn-normal'>提交</button> </span></div>",
		  closeBtn: 1,
		}); 
	}
	function addCommit(){
		if($("#addTitle").val()==""){
			layer.msg("请输入标题！",{icon: 5});
		}else if($("#addContent").val()==""){
			layer.msg("请输入内容！",{icon: 5});
		}else{
			$.post("addTechnology",{
				title:$("#addTitle").val(),
				content:$("#addContent").val()
			},function(res){
				if(res){
					layer.close(index);
					layer.msg("添加成功！",{icon: 1});
				}else{
					layer.msg("添加失败！",{icon: 0});
				}
			})
		}
	}
	function updateCommit(){
		if($("#updateTitle").val()==""){
			layer.msg("请输入标题！",{icon: 5});
		}else if($("#updateContent").val()==""){
			layer.msg("请输入试题内容！",{icon: 5});
		}else{
			$.post("updateTechnology",{
				content:$("#updateContent").val(),
				title:$("#updateTitle").val()
			},function(res){
				if(res){
					layer.close(index);
					layer.msg("修改成功！",{icon: 1});
				}else{
					layer.msg("修改失败！",{icon: 0});
				}
			})
		}
	}
	function cancel(){
		 layer.close(index);
	}
</script>
</head>
<body>
	<!--http://localhost:8080/blog/queryTechnology-->
	<div id="head">
		<div id="headconent"
			style="width: 70%; margin: 0px auto; height: 50px">
			<sapn><a href="index.jsp"><img style="border-radius: 50%;width: 40px;" src="static/img/touxiang.jpg"/></a>&nbsp;&nbsp;XL995_个人博客-管理员</sapn>
			<div id="" style="font-family: '微软雅黑';display: flex;flex-direction:row;">
			    <input id="search" style="border: lightgray 1px solid;width: 200px;font-size: 14px;"  name="search" class="layui-input" type="text" placeholder="请输入标题">&nbsp;
			    <button onclick="search()" class="layui-btn "><i class="layui-icon layui-icon-search"></i>搜索</button>
				<button onclick="openAddWindow()" class="layui-btn layui-btn-normal"><i class="layui-icon layui-icon-survey"></i>添加面试题</button>
			</div>
		</div>
	</div> 
	<div id="main"></div> 
</body>
</html>


