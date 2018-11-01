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
				    <h1 class="panel-title">注册</h1>
				  </div>
				  <div class="panel-body">
				    <form class="form-horizontal" id = "registForm" role="form" method = "post" onsubmit="return checkRegist()">
					  <div class="form-group">
					    <label for="firstname" class="col-sm-3 col-md-3 col-lg-3 control-label">用户名</label>
					    <div class="col-sm-8 col-md-8 col-lg-8">
					      <input type="text" class="form-control" name = "username" id="name" placeholder="请输入用户名">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="password" class="col-sm-3 col-md-3 col-lg-3 control-label">密码</label>
					    <div class="col-sm-8 col-md-8 col-lg-8">
					      <input  class="form-control" type="password" name = "userpassword" id="password" placeholder="请输入密码">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="password" class="col-sm-3 col-md-3 col-lg-3 control-label">确认密码</label>
					    <div class="col-sm-8 col-md-8 col-lg-8">
					      <input  class="form-control" type="password" name = "s_userpassword" id="sure_password" placeholder="请再次输入密码">
					    </div>
					  </div>
					  <div class="form-group">
					    <div class="col-sm-offset-1 col-md-offset-1 col-lg-offset-1 col-sm-10 col-md-10 col-lg-10">
					      <button type="submit" class="btn btn-danger btn-block" onclick="regist(); return false;">注册</button>
					    </div>
					  </div>
					</form>
				  </div>
				  <div class="panel-footer"><a href="javascript:toLogin()">返回登陆</a></div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
function checkRegist() {
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
	if ($("#sure_password").val() == '') {
		$("#sure_password").attr('placeholder', '请再次输入密码！');
		$("#sure_password").focus();
		return false;
	}
	if ($("#sure_password").val() != $("#password").val()) {
		$("#sure_password").val('');
		$("#sure_password").attr('placeholder', '两次输入密码不一致！');
		$("#sure_password").focus();
		return false;
	}
	return true;
}

function regist() {
	if(checkRegist()){
		$.ajax({
			type : "POST",  //提交方式
			url : "regist",//路径
			data : $("#registForm").serialize(),//数据，这里使用的是Json格式进行传输
			async: false,
			success : function(result) {//返回数据根据结果进行相应的处理
				if(result.status == 411){
					alert("用户名重复");
				}else if(result.status == 200){
					alert("注册成功,即将返回登陆页面");
					location.href = "${pageContext.request.contextPath}/MyLogin";
				}
			},
		 	error:function(e){  
			 	alert("出错");
			}  
	    });
	}
}

function toLogin(){
	location.href = "${pageContext.request.contextPath}/MyLogin";
}

</script>
</html>