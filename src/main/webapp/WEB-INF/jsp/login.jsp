<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="js/jquery.cookie.js"></script>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
	<title>登陆Calm-Social</title>
	<style type="text/css">	
		#login_panel{
			margin-top:150px;
		}
	</style>
	
</head>
<body background="images/login_bg.jpg" style="background-repeat:no-repeat; background-size:cover;">
	<div class = container>
		<div class = row>
			<div class = "col-lg-offset-8 col-lg-4">
				<div class="panel panel-default" id = "login_panel" style="text-align:center">
				  <div class="panel-heading">
				    <h1 class="panel-title">登陆</h1>
				  </div>
				  <div class="panel-body">
				    <form class="form-horizontal" id = "loginForm" role="form" method = "post" onsubmit="return checkLogin()">
					  <div class="form-group">
					    <label for="firstname" class="col-sm-3 col-md-3 col-lg-3 control-label">用户名</label>
					    <div class="col-sm-8 col-md-8 col-lg-8">
					      <input type="text" class="form-control" name = "username" id="name" placeholder="请输入用户名">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="lastname" class="col-sm-3 col-md-3 col-lg-3 control-label">密码</label>
					    <div class="col-sm-8 col-md-8 col-lg-8">
					      <input  class="form-control" type="password" name = "userpassword" id="password" placeholder="请输入密码">
					    </div>
					  </div>
					  <div class="form-group">
					    <div class="col-sm-offset-2 col-md-offset-2 col-lg-offset-2 col-sm-6 col-md-6 col-lg-6">
					      <div class="checkbox">
					        <label>
					          <input type="checkbox">请记住我
					        </label>
					      </div>
					    </div>
					  </div>
					  <div class="form-group">
					    <div class="col-sm-offset-1 col-md-offset-1 col-lg-offset-1 col-sm-10 col-md-10 col-lg-10">
					      <button type="submit" class="btn btn-primary btn-block" onclick="login();return false;">登录</button>
					    </div>
					  </div>
					</form>
				  </div>
				  <div class="panel-footer"><a href="javascript:toRegist()">注册</a></div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
function checkLogin() {
	if ($("#name").val() == '') {
		$("#name").attr('placeholder', '登录名不能为空！');
		$("#name").focus();
		return false;
	}
	if ($("#password").val() == '') {
		$("#password").attr('placeholder', '密码不能为空！');
		$("#password").focus();
		return false;
	}
	return true;
}

function login() {
	if(checkLogin()){
		$.ajax({
			type : "POST",  //提交方式
			url : "login",//路径
			data : $("#loginForm").serialize(),//数据，这里使用的是Json格式进行传输
			async: false,
			success : function(result) {//返回数据根据结果进行相应的处理
				//进入首页
				location.href = "${pageContext.request.contextPath}/MyHome";
			},
		 	error:function(e){  
			 	alert("出错");
			}  
	    });
	}
}

function toRegist(){
	location.href = "${pageContext.request.contextPath}/MyRegist";
}
</script>

</html>