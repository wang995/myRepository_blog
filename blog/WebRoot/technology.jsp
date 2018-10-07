<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Xl995_Blog - 个人网站</title>
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
.feedbackdiv{
	height: 95%;
	width:350px;
	margin:5px auto;
}
.smbtn{
	z-index: 0px;
	float:right;
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
			$.each(JSON.parse(res), function(i, val) {
				$("#main").prepend(
						"<div class='Technology'><div class='title'>"
								+ val.title + "<span style='color:lightgrey'>_"+val.id+"</spna><span class='smbtn'><button onclick='openFeedBackWindow("+val.id
								+")' class='layui-btn layui-btn-primary feedback'><i class='layui-icon layui-icon-username'></i>反馈 / 纠错 / 评论</button><button onclick='showhide_s(this)' class='layui-btn layui-btn-primary'><i class='layui-icon layui-icon-username'></i>查看答案</button></span></div><pre class='content'>"
								+ val.content + "</pre></div>")
			});
		})
	}
	function search(){
		getTechnology($("#search").val());
	} 
	function advice(){
		layer.open({
	        type: 1
	        ,title: false //不显示标题栏
	        ,closeBtn: false
	        ,area: '300px;'
	        ,shade: 0.8
	        ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
	        ,btn: ['我知道了',]
	        ,btnAlign: 'r'
	        ,moveType: 1 //拖拽模式，0或者1
	        ,content: '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">你知道吗？亲！<br>layer ≠ layui<br><br>layer只是作为Layui的一个弹层模块，由于其用户基数较大，所以常常会有人以为layui是layerui<br><br>layer虽然已被 Layui 收编为内置的弹层模块，但仍然会作为一个独立组件全力维护、升级。<br><br>我们此后的征途是星辰大海 ^_^</div>'
	        ,success: function(layero){
	        }
	      });
	}
	var index;
	function openFeedBackWindow(technologyId){
		index = layer.open({
		  title:"反馈 / 纠错 / 评论 - "+technologyId,
		  type: 1, 
		  area: ['420px', '245px'], //宽高
		  content: "<div class='feedbackdiv'><textarea id='feedbackContent' placeholder='说点什么吧！' style='width: 350px;' class='layui-textarea'></textarea><input id='feedbackName' type='text' placeholder='Your Name' style='width: 350px;display: inline;margin: 5px 0px;' class='layui-input'><span style='float: right;'><button onclick='cancel()' class='layui-btn layui-btn-danger'>取消</button><button onclick='feedbackCommit("+technologyId+")' class='layui-btn layui-btn-normal'>提交</button> </span></div>",
		  closeBtn: 1,
		}); 
	}
	function feedbackCommit(technologyId){
		if($("#feedbackContent").val()==""){
			layer.msg("请写点东西再提交！",{icon: 5});
		}else if($("#feedbackName").val()==""){
			layer.msg("请输入你的名字！",{icon: 5});
		}else if($("#feedbackName").val()=="王晓磊"){
			layer.msg("此名字被系统保留！",{icon: 5});
		}else{
			$.post("addFeedBack",{
				questionID:technologyId,
				content:$("#feedbackContent").val(),
				name:$("#feedbackName").val()
			},function(res){
				if(res){
					layer.msg("提交成功，感谢您的支持！",{icon: 1});
				}else{
					layer.msg("提交失败！",{icon: 0});
				}
			})
			layer.close(index);
		}
	}
	var isShowFlag = true;
	function showorhidden(){
		if(isShowFlag){
			$(".content").hide();
			isShowFlag = false;
		}else{
			$(".content").show();
			isShowFlag = true;
		} 
	}
	var isshowdom = true;
	function showhide_s(this_dom){
		if(isshowdom){
			$(this_dom).parent().parent().parent().parent().find(".content").hide();
			isshowdom = false;			
		}else{
			$(this_dom).parent().parent().parent().parent().find(".content").show();
			isshowdom = true;	
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
			<div><a href="index.jsp"><img style="border-radius: 50%;width: 40px;" src="static/img/touxiang.jpg"/></a>&nbsp;个人博客 - 技术面试题</div>
			<div id="" style="font-family: '微软雅黑';display: flex;flex-direction:row;">
			    <input id="search" style="border: lightgray 1px solid;width: 200px;font-size: 14px;"  name="search" class="layui-input" type="text" placeholder="请输入标题">&nbsp;
			    <button onclick="search()" class="layui-btn layui-btn-normal"><i class="layui-icon layui-icon-search"></i>搜索</button>
				<button onclick="showorhidden()" class="layui-btn" style="background-color:#00bab4">隐藏 / 显示答案</button>
			</div>
		</div>
	</div>
	<div id="main"></div> 
</body>
</html>


