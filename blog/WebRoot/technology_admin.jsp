<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Xl995_Blog - 技术面试_管理员</title>
<%@ include file="/commons/common.jsp"%>
<style type="text/css">
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
</style>
<script type="text/javascript">
	var layer;
	$(function() {
		layui.use('layer', function(){
		  layer = layui.layer;
		});              
		getTechnology();
	})
	function getTechnology(byString) {
		$("#main").html("");
		$.post("queryTechnology",{
			byString:byString
		}, function(res) {
			if(JSON.parse(res)!=""){
				$.each(JSON.parse(res), function(i, val) {
					$("#main").prepend(
						"<div class='Technology'><div class='title'>"
						+ val.title +"<span style='color:lightgrey'>_"+val.id+"</span><span class='updatebtn'><button onclick='openUpdateWindow("+i+","+res+")' class='layui-btn' style='background: lightseagreen;'>修改</button><button onclick='deleteT("+val.id
						+")' class='layui-btn' style='background-color:lightsalmon'>删除</button></span></div><pre class='content'>"
						+ val.content + "</pre></div>"
					)
				});
			}else{
				$("#main").html("<div class='isempty'><img src='static/img/gantanhao.png'/>&nbsp;没有搜到任何内容，换个词试试？</div>");
			}
		})
	}
	function search(){
		getTechnology($("#search").val());
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
		  title:"修改技术面试题 -"+res[i].id,
		  type: 1, 
		  area: ['924px', '539px'], //宽高
		  content: "<div class='updatediv'><input id='updateTitle' type='text' placeholder='标题' value='"+res[i].title+"' style='width: 800px;display: inline;margin: 10px 0px;' class='layui-input'><textarea id='updateContent' placeholder='说点什么吧！' style='width:800px;' class='layui-textarea'>"+res[i].content+"</textarea><span style='float: right;'><button onclick='cancel()' class='layui-btn layui-btn-danger'>取消</button><button onclick='updateCommit("+res[i].id+")' class='layui-btn layui-btn-normal'>提交</button> </span></div>",
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
					getTechnology();
				}else{
					layer.msg("添加失败！",{icon: 0});
				}
			},"json")
		}
	}
	function updateCommit(id){
		if($("#updateTitle").val()==""){
			layer.msg("请输入标题！",{icon: 5});
		}else if($("#updateContent").val()==""){
			layer.msg("请输入试题内容！",{icon: 5});
		}else{
			$.post("updateTechnology",{
				content:$("#updateContent").val(),
				title:$("#updateTitle").val(),
				id:id
			},function(res){
				if(res){
					layer.close(index);
					getTechnology();
					layer.msg("修改成功！",{icon: 1});
				}else{
					layer.msg("修改失败！",{icon: 0});
				}
			},"json")
		}
	}
	function deleteT(id){
		
		layer.confirm("确定删除技术面试题 - <span style='color:red;'>"+id+"</span> ?",{
			title:"delete"
		},
		function(){
			$.post("deleteTechnology",{
				technologyID:id
			},function(res){
				if(res){
					layer.msg('删除成功！', {icon: 1});
					getTechnology();
				}else{
					layer.msg('删除失败！', {icon: 0});
				}
			},"json")
		})
	}
	function cancel(){
		 layer.close(index);
	}
	$(document).keydown(function(event){
		var keycode = event.keyCode;
		if(keycode==13){ 
			getTechnology($("#search").val());
		}
	});
</script>
</head>
<body>
	<!--http://localhost:8080/blog/queryTechnology-->
	<div id="head">
		<div id="headconent"
			style="width: 70%; margin: 0px auto; height: 50px">
			<sapn><a href="index.jsp"><img style="border-radius: 50%;width: 40px;" src="static/img/touxiang.jpg"/></a>&nbsp;&nbsp;管理员 - 技术面试</sapn>
			<div id="" style="font-family: '微软雅黑';display: flex;flex-direction:row;">
			    <input id="search" style="border: lightgray 1px solid;font-size: 14px;"  name="search" class="layui-input" type="text" placeholder="请输入标题">&nbsp;
			    <a href="technology_admin.jsp" class="layui-btn hc thisPageBtn">技术</a>
			    <a href="personnel_admin.jsp" class="layui-btn ch">人事</a>
			    <a href="log_admin.jsp" class="layui-btn hl">日志</a>
			    <a href="tools_admin.jsp" class="layui-btn lq">工具</a>
			    <a href="advise_admin.jsp" class="layui-btn qd">建议</a>
			    <a href="feedback_admin.jsp" class="layui-btn dz">评论</a>
			    <button onclick="openAddWindow()" class="layui-btn"><i class="layui-icon layui-icon-add-1"></i>添加</button>
				<button onclick="exit()" class="layui-btn layui-btn-danger"><i class="layui-icon layui-icon-close"></i>退出</button>
			</div>  
		</div>
	</div>
	<div id="main"></div> 
</body>
</html>


