<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Xl995_Blog - 个人网站</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/blog/static/css/style.css"/>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/blog/static/layui/css/layui.css" />
<script src="http://localhost:8080/blog/static/js/jquery-1.8.2.js" type="text/javascript" charset="utf-8"></script>
<script src="http://localhost:8080/blog/static/layui/layui.js" type="text/javascript" charset="utf-8"></script>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
	/* border: 1px solid red; */
}
#main {
	width: 70%;
	margin: 70px auto;
	display: flex;
	flex-direction:row;
	flex-wrap: wrap;
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
.BiaoQian{
	border: 1px solid darkgray;
	border-radius: 6px;
	width: 220px;
	height: 120px;
	margin: 20px;
}
.advicediv{
	height: 95%;
	width:350px;
	margin:5px auto;
}
.advice{
	float: right;
}
</style>
<script type="text/javascript">
	var layer;
	$(function() {
		layui.use('layer', function(){
		  layer = layui.layer;
		});              
	})
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
	function openAdviceWindow(){
		index = layer.open({
		  title:"网站建议",
		  type: 1, 
		  area: ['420px', '245px'], //宽高
		  content: "<div class='advicediv'><textarea id='adviceContent' placeholder='说点什么吧！' style='width: 350px;' class='layui-textarea'></textarea><input id='adviceName' type='text' placeholder='Your Name' style='width: 350px;display: inline;margin: 5px 0px;' class='layui-input'><span style='float: right;'><button onclick='cancel()' class='layui-btn layui-btn-danger'>取消</button><button onclick='adviceCommit()' class='layui-btn layui-btn-normal'>提交</button> </span></div>",
		  closeBtn: 1,
		}); 
	}
	function adviceCommit(){
		if($("#adviceContent").val()==""){
			layer.msg("请写点东西再提交！",{icon: 5});
		}else if($("#adviceName").val()==""){
			layer.msg("请输入你的名字！",{icon: 5});
		}else{
			layer.close(index);
			layer.msg("提交成功，感谢您的支持！",{icon: 1});
		}
	}
	function cancel(){
		 layer.close(index);
	}
</script>
</head>
<body style="background-image: url(static/img/Cg-4WVWfL9iIQ0KbAANtj3O_pdEAAG1UAHfCP8AA22n759.jpg);background-size: 100%; background-repeat: no-repeat;">
	<!--http://localhost:8080/blog/queryTechnology-->
	<div id="head">
		<div id="headconent" style="width: 70%; margin: 0px auto; height: 50px">
			<sapn><a href="index.jsp"><img style="border-radius: 50%;width: 40px;" src="static/img/touxiang.jpg"/></a>&nbsp;&nbsp;XL995-个人博客</sapn>
			<div id="" style="font-family: '微软雅黑';display: flex;flex-direction:row;">
				<button onclick="openAdviceWindow()" class="layui-btn"><i class="layui-icon layui-icon-survey"></i>网站建议</button>
				<button onclick="advice()" class="layui-btn layui-btn-normal"><i class="layui-icon layui-icon-survey"></i>公告</button>
			</div>  
		</div>
	</div> 
	<div id="main">
		 <div class="he_border1 BiaoQian">
                <img class="he_border1_img" src="static/img/bd315c6034a85edff2c9d81942540923dd547546.png" alt="Image 01">
                <div class="he_border1_caption">
		 		<h1>50</h1>
                    <h3 class="he_border1_caption_h">技术面试题</h3>
					<p class="he_border1_caption_p">个人总结,仅供参考</p>
                    <a class="he_border1_caption_a" href="technology.jsp"></a>
                </div>
         </div>
		<div class="he_border1 BiaoQian">
                <img class="he_border1_img" src="static/img/timg.png" alt="">
                <div class="he_border1_caption">
		 			<img width="28px" src="static/img/lock.png"/>
                    <h3 class="he_border1_caption_h">人事面试</h3>
					<p class="he_border1_caption_p">人事面试,暂未开放</p>
                    <a class="he_border1_caption_a" href="http://www.baidu.com"></a>
                </div>  
         </div>
         <div class="he_border1 BiaoQian">
                <img class="he_border1_img" src="static/img/tooopen_sy_171619983217.jpg" alt="Image 01">
                <div class="he_border1_caption">
		 			<img width="28px" src="static/img/lock.png"/>
                    <h3 class="he_border1_caption_h">个人日志</h3>
					<p class="he_border1_caption_p">个人日志,暂未开放</p>
                    <a class="he_border1_caption_a" href="http://www.baidu.com"></a>
                </div>
         </div>
         <div class="he_border1 BiaoQian">
                <img class="he_border1_img" src="static/img/1448590774537.jpg" alt="Image 01">
                <div class="he_border1_caption">
		 		<h1>50</h1>
                    <h3 class="he_border1_caption_h">软件工具下载</h3>
					<p class="he_border1_caption_p">学习办公工具-网盘链接</p>
                    <a class="he_border1_caption_a" href="http://www.baidu.com"></a>
                </div>
         </div>
         <div class="he_border1 BiaoQian">
                <img class="he_border1_img" src="static/img/14485907831000.jpg" alt="Image 01">
                <div class="he_border1_caption">
		 		<img width="32px" src="static/img/dep.png"/>
                    <h3 class="he_border1_caption_h">其它模块+</h3>
					<p class="he_border1_caption_p">博主正在努力开发中...</p>
                    <a class="he_border1_caption_a" href="http://www.baidu.com"></a>
                </div>
         </div>
	</div>
</body>
</html>


