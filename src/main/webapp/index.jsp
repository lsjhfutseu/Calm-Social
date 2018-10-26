<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.cookie.js"></script>
    
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
	
	<title>Calm-Social</title>
	
	<style type="text/css">
		.modal-dialog {  
	   		margin: 200px auto;  
		}  
	</style>
	
</head>

<body>

<div class="container"> 
 <div class="row"> 
  <nav class="navbar navbar-default" style="background-color: #e3f2fd;"> 
   <div class="container-fluid"> 
    <!-- Brand and toggle get grouped for better mobile display --> 
    <div class="navbar-header"> 
     <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button> 
     <a class="navbar-brand" href="#">Calm-Social</a> 
    </div> 
    <!-- Collect the nav links, forms, and other content for toggling --> 
    <div class="collapse navbar-collapse" id=""> 
     <ul class="nav navbar-nav"> 
      <form class="navbar-form navbar-left"> 
       <div class="form-group"> 
        <input type="text" class="form-control" placeholder="Search" /> 
       </div> 
       <button type="submit" class="btn btn-default">搜索</button> 
      </form> 
      <li id = "loginBtn"><a href="#" data-toggle="modal" data-target="#loginModal">登陆</a></li> 
      <li id = "registBtn"><a href="#" data-toggle="modal" data-target="#registModal">注册</a></li> 
      <li><a id = "personalBtn" href="#" ></a></li>
      <li id = "exitBtn"><a href="javascript:exit();">退出</a></li>
     </ul> 
     <ul class="nav navbar-nav navbar-right"> 
      <li><a href="#">关于Calm-Social</a></li> 
     </ul> 
    </div>
    <!-- /.navbar-collapse --> 
   </div>
   <!-- /.container-fluid --> 
  </nav> 
 </div> 
 
 <div class="row"> 
 
  <div class="col-sm-2 col-md-2 col-lg-2" style = "text-align:center;"> 
   <div class="row">
   <ul class="list-group">
	  <li class="list-group-item"><a href="#"><span class="glyphicon glyphicon-user"></span>个人中心</a> </li>
	  <li class="list-group-item"><a href="#"><span class="glyphicon glyphicon-eye-open"></span>新鲜事儿</a> </li>
	  <li class="list-group-item"><a href="#"><span class="glyphicon glyphicon-film"></span>我的相册</a>  </li>
	  <li class="list-group-item"><a href="#"><span class="glyphicon glyphicon-user"></span>与我相关</a> </li>
	  <li class="list-group-item"><a href="#"><span class="glyphicon glyphicon-film"></span>那年今日</a> </li>
	</ul> 
   </div> 
  </div> 
  
  <div class="col-sm-offset-1 col-md-offset-1 col-lg-offset-1 col-md-5 col-lg-5 col-sm-5">
    <div class="row">
    	<div class = "col-lg-10 col-sm-10 col-md-10">
		    <form role="form">
			  <div class="form-group">
			    <textarea class="form-control" rows="2" placeholder = "说些什么吧"></textarea>
			  </div>
			</form>
		</div>
		<div class = "col-lg-2 col-sm-2 col-md-2">
			<button class="btn btn-default btn-lg">发表</button> 
		</div>
    </div>
    <div class="row">
    	<div class="panel panel-default">
	    	<div class="panel-heading">
		        <h3 class="panel-title"><span class="glyphicon glyphicon-user"></span>李世俊</h3>
		    </div>
		    <div class="panel-body">
		         真的是千呼万唤始出来，院儿刚进去得到最终结果。恭喜工大锦鲤是为豌豆射手，中奖号码是1000999。(说明:工大锦鲤在开奖前换了微信名和头像，院儿已经核对过)
另外50名幸运粉丝福利奖也已经揭晓，名单如图。请各位中奖粉丝填写小程序中的收货地址，方便之后联系送奖!
		    </div>
		</div>
    </div>
    <div class="row">
    	<div class="panel panel-default">
	    	<div class="panel-heading">
		        <h3 class="panel-title"><span class="glyphicon glyphicon-user"></span>曹斌</h3>
		    </div>
		    <div class="panel-body">
		         【王东司马】
他的父亲（吴炳松）在今年9月28日查出患有脑胶质瘤，目前已经经过几次大型的手术和化疗，但巨额的治疗费用让原本普通的家庭陷入了绝境。希望大家能够多多支持和转发，相信大家每一次的帮助和转发都是对他们家庭莫大的支持和鼓舞，最后希望他的父亲能够早日康复!
		    </div>
		</div>
    </div>
    <div class="row">
    	<div class="panel panel-default">
	    	<div class="panel-heading">
		        <h3 class="panel-title"><span class="glyphicon glyphicon-user"></span>杨涵</h3>
		    </div>
		    <div class="panel-body">
		       今天参加完第十届互联网大赛，大骂马化腾，爽！
		    </div>
		</div>
    </div>
  </div> 
  
  <div class = "col-md-offset-1 col-lg-offset-1 col-sm-offset-1 col-sm-3 colcol-md-3 col-lg-3">
	<div class="panel panel-default">
	    <div class="panel-heading">
	        <h3 class="panel-title"><span class="glyphicon glyphicon-user"></span>最近来访</h3>
	    </div>
	    <div class="panel-body">
	        <table class="table">
		        <tr><td>刘炳璋</td><td>曹斌</td><td>杨涵</td><td>王五</td></tr>
		        <tr><td>张三</td><td>李四</td><td>王二麻子</td></tr>
		    </table>
	    </div>
	</div>
  </div>
  
 </div> 
</div>
	
<!-- 登陆模态框（Modal） -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:350px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">登陆</h4>
            </div>
            <div class="modal-body">
            	<form class="form-horizontal" id = "loginForm" role="form" method = "post" onsubmit="return check(this)">
				  <div class="form-group">
				    <label for="firstname" class="col-sm-3 control-label">登陆名</label>
				    <div class="col-sm-9">
				      <input type="text" class="form-control" name = "username" id="name" placeholder="请输入登录名">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="lastname" class="col-sm-3 control-label">密码</label>
				    <div class="col-sm-9">
				      <input type="text" class="form-control" name = "userpassword" id="password" placeholder="请输入密码">
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-6">
				      <div class="checkbox">
				        <label>
				          <input type="checkbox">请记住我
				        </label>
				      </div>
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="col-sm-offset-1 col-sm-10">
				      <button type="submit" class="btn btn-default btn-block" onclick="login()">登录</button>
				    </div>
				  </div>
				</form>
            </div>
            
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 注册模态框（Modal） -->
<div class="modal fade" id="registModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:350px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">注册</h4>
            </div>
            <div class="modal-body">
            	<form class="form-horizontal" role="form" id = "registForm" method = "post" onsubmit="return check(this);">
				  <div class="form-group">
				    <label for="firstname" class="col-sm-3 control-label">登陆名</label>
				    <div class="col-sm-9">
				      <input type="text" class="form-control" name = "username" id="r_name" placeholder="请输入登录名">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="lastname" class="col-sm-3 control-label">密码</label>
				    <div class="col-sm-9">
				      <input type="text" class="form-control" name = "userpassword" id="r_password" placeholder="请输入密码">
				    </div>
				  </div>
				  <div class="form-group">
				    <div class="col-sm-offset-1 col-sm-10">
				      <input type="submit" class="btn btn-default btn-block" onclick="regist()" value = "注册"/>
				    </div>
				  </div>
				</form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<script type="text/javascript">

$(document).ready(function(){
	//更新登陆状态
	var user = $.cookie('user');
	if(user != null){
		$("#loginBtn").remove();
		$("#registBtn").remove();
		$("#personalBtn").html(user);
	}
	else{
		$("#exitBtn").hide();
	}
//更新新鲜事
	$.get("getnewthings", function(result){
	    alert(result.data);
	  });
		
	});
	
	function check(form) {
	    if(form.name.value=='') {
	    	$("#name").attr('placeholder','登录名不能为空！');
	        form.name.focus();
	        return false;
	     }
	     if(form.password.value==''){
	    	$("#password").attr('placeholder','密码不能为空！');
	        form.password.focus();
	        return false;
	     }
	      return true;
	}
	
	function login() {
		var str_data = "username="+$("#name").val()+"&userpassword="+$("#password").val();
		//post请求
		$.post("login",$("#loginForm").serialize(), function(data){
			if(data.status == 200){
				//alert("登陆成功");
			}
		});
    }
	
	function regist() {
		var str_data = "username="+$("#r_name").val()+"&userpassword="+$("#r_password").val();
		
		//post请求
		$.post("regist",$("#registForm").serialize(), function(data){
			if(data.status == 200){
				alert("注册成功");
			}
			else{
				alert("注册失败");
			}
		});
	}
	
	function exit(){
		$.cookie('user', '', { expires: -1 });
		location.reload();
	}
	
</script>
</body>
</html>