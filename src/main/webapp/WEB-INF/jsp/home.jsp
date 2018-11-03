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
    
    <link href="css/fileinput.css" media="all" rel="stylesheet" type="text/css"/>
	<link href="css/fileinput.min.css" media="all" rel="stylesheet" type="text/css"/>
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" media="all" rel="stylesheet" type="text/css"/>
	<link href="themes/explorer-fa/theme.css" media="all" rel="stylesheet" type="text/css"/>

	<script src="js/plugins/sortable.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/fileinput.js"></script>
	<script type="text/javascript" src="js/locales/zh.js"></script>
	<script src="themes/explorer-fa/theme.js" type="text/javascript"></script>
	<script src="themes/fa/theme.js" type="text/javascript"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
	
	<title>Calm-Social</title>
	
	<style type="text/css">
		.modal-dialog {  
	   		margin: 200px auto;  
		}  
		.img{
			width: auto;
			height: auto;
			max-width: 100%;
			max-height: 100%;	
		}
		
	</style>
	
</head>

<body background="images/home_bg.jpg" style="background-repeat:no-repeat; background-size:cover;">

<div class="container">
 <div class="row"> 
  <nav class="navbar navbar-default" style = "background-color:#CDBA96;border:0px;" > 
   <div class="container-fluid"> 
    <!-- Brand and toggle get grouped for better mobile display --> 
    <div class="navbar-header"> 
     <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button> 
     <a class="navbar-brand" href="#">Calm-Social</a> 
    </div> 
    <!-- Collect the nav links, forms, and other content for toggling --> 
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"> 
     <ul class="nav navbar-nav" id = "navbar_id"> 
      <form class="navbar-form navbar-left"> 
       <div class="form-group"> 
        <input type="text" class="form-control" placeholder="Search" /> 
       </div> 
       <button type="submit" class="btn btn-default">搜索</button> 
      </form> 
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
 
  <div class="col-sm-2 col-md-2 col-lg-2 hidden-xs" style = "text-align:center;"> 
   <div class="row">
   <ul class="list-group">
	  <li class="list-group-item"><a href="#"><span class="glyphicon glyphicon-user"></span>个人中心</a> </li>
	  <li class="list-group-item"><a href="#"><span class="glyphicon glyphicon-eye-open"></span>设置头像</a> </li>
	  <li class="list-group-item"><a href="#"><span class="glyphicon glyphicon-film"></span>我的相册</a></li>
	  <li class="list-group-item"><a href="#" data-toggle="modal" data-target="#addFriendsModal"><span class="glyphicon glyphicon-user"></span>搜寻好友</a></li>
	  <li class="list-group-item"><a href="javascript:showFriendRequest()"><span class="glyphicon glyphicon-film"></span>好友请求</a></li>
	</ul> 
   </div> 
  </div> 
  
  <div class="col-sm-offset-1 col-md-offset-1 col-lg-offset-1 col-xs-12 col-md-5 col-lg-5 col-sm-5" id = "newthings_show">
    <div class="hidden-sm hidden-md hidden-lg hidden-print">
	  <a href="#">个人中心&nbsp;</a>
	  <a href="#">相册&nbsp;</a>
	  <a href="#" data-toggle="modal" data-target="#addFriendsModal">搜寻好友&nbsp;</a>
	  <a href="javascript:showFriendRequest()">好友请求&nbsp;</a>
	  <a href="#">最近访客</a>
	  <hr/>
	</div>
    <div class="row">
    	<div class = "col-lg-9 col-sm-9 col-md-9 col-xs-8">
		    <form role="form">
			  <div class="form-group">
			    <textarea class="form-control" rows="2" placeholder = "说些什么吧" id = "report_content"></textarea>
			    <a style = "margin-left:5px;" href="#" data-toggle="modal" data-target="#newthingsPictureModal"><span class="glyphicon glyphicon-picture"></span></a>
			  </div>
			</form>
			<div class="form-group">
		    </div> 
		</div>
		<div class = "col-xs-2 col-lg-2 col-sm-2 col-md-2 col-xs-2">
			<button class="btn btn-default btn-lg" onclick = "report()">发表</button> 
		</div>
</div>
    
  </div> 
   
  <div id = "body_r" class = "col-md-offset-1 col-lg-offset-1 col-sm-offset-1 col-sm-3 colcol-md-3 col-lg-3 hidden-xs">
	
  </div>
  
 </div> 
</div>

<!-- 添加好友模态框（Modal） -->
<div class="modal fade" id="addFriendsModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:350px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">搜寻好友</h4>
            </div>
            <div class="modal-body" id = "addFriendBody">
            	<form class="form-horizontal" role="form" id = "addFriendsForm" onsubmit="return check(this);">
				  <div class="form-group">
				    <label for="firstname" class="col-sm-3 col-md-3 col-lg-3 col-xs-3 control-label">用户名</label>
				    <div class="col-sm-6 col-md-6 col-lg-6 col-xs-6">
				      <input type="text" class="form-control" name = "username" id="friend_name" placeholder="请输入用户名">
				    </div>
				    <div class="col-sm-2 col-md-2 col-lg-2 col-xs-2">
				      <button class="btn btn-default" type="button" onclick="searchFriends()">搜索</button>
				    </div>
				  </div>
				</form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 删除动态确定模态框（Modal） -->
<div class="modal fade" id="deleteSureModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:350px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">删除确认</h4>
            </div>
            <div class="modal-body" id = "addFriendBody">
            	<p>此操作不可恢复，确定删除该条动态吗？</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-danger" id = "deleteSure" onclick="sureToDelete()">删除</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 好友请求模态框（Modal） -->
<div class="modal fade" id="friendRequestModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width:350px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">好友请求</h4>
            </div>
            <div class="modal-body" id = "friendRequestBody" style = "margin-left:60px;">
            	
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-warning" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 发表动态图片添加（Modal） -->
<div class="modal fade" id="newthingsPictureModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加图片</h4>
            </div>
            <div class="modal-body" id = "newthingsPictureBody">
            	<div class="form-group">
		            <div class="file-loading">
		                <label>Preview File Icon</label>
		                <input id="file-3" type="file" multiple>
		            </div>
		        </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-warning" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<script type="text/javascript">

	$(document).ready(function() {
		//更新登陆状态
		var user = $.cookie('user');
		//alert(user);
		if (user != null && user !='') {
			$("#navbar_id").append('<li><a id = "personalBtn" href="#" ></a></li><li id = "exitBtn"><a href="javascript:exit();">退出</a></li>');
			$("#personalBtn").html(user);
			//更新新鲜事
			$.get("getnewthings", function(result) {
				var json = eval('(' + result.data + ')');
				//展示新鲜事
				for(var i = 0; i < json.length; i++){
					var eachThing = new Array();
					eachThing[0] = json[i]["curUsername"];
					eachThing[1] = json[i]["content"];
					eachThing[2] = json[i]["postTime"];
					eachThing[3] = json[i]["thingId"];
					var comment_body = "";
					for(var j = 0; j < json[i]["commentList"].length; j++){
						var cmtName = json[i]["commentList"][j].cmtname; //展开评论
						var cmtId = json[i]["commentList"][j].cmtId;
						var content = json[i]["commentList"][j].content;
						var cmttedname = json[i]["commentList"][j].cmttedname;
						var postTime = json[i]["commentList"][j].postTime;
						if(cmttedname != null)
							comment_body += '<div style="margin-top:7px">' +"&nbsp;&nbsp;<a href = '#'><b>"+cmtName+"</b></a>&nbsp;"+'回复&nbsp;<a href = "#">'+cmttedname+"</a>:&nbsp;"+content+"</div>" + "<div>&nbsp;&nbsp;&nbsp;&nbsp;<font size='0.3' color='#666666'>"+postTime+'&nbsp;&nbsp;&nbsp;&nbsp;<a href= "javascript:commentComment(\''+eachThing[3]+'\',\''+cmtName+'\',\''+cmtId+'\')">回复</a>'+'</font></div>';
						else
							comment_body += "<div style='margin-top:7px'>"+"&nbsp;&nbsp;<a href = '#'><b>"+cmtName+"</b></a>:&nbsp;"+content+"</div>"+ "<div>&nbsp;&nbsp;&nbsp;&nbsp;<font size='0.3' color='#666666'>"+postTime+'&nbsp;&nbsp;&nbsp;&nbsp;<a href= "javascript:commentComment(\''+eachThing[3]+'\',\''+cmtName+'\',\''+cmtId+'\')">回复</a>'+'</font></div>';;	
					}	
					var footer = "";
					var collapse_input = '<form role="form" id = \''+eachThing[3] +'comment'+'\' class = "panel-collapse collapse"><div class="form-group"><textarea class="form-control" rows="2" id = \''+eachThing[3] +'comment_content'+'\' placeholder="请输入评论"></textarea><a href="javascript:collapseCommentInput(\''+eachThing[3] +'comment'+'\',\''+eachThing[3] +'comment_btn'+'\');" class="col-lg-offset-11 col-md-offset-11 col-sm-offset-11 col-xs-offset-10"><small>收起</small></a></div></form>';
					var hide_input = '<input type="hidden" id=\''+eachThing[3] +'hide_input'+'\' value="-1">';
					if(eachThing[0] == user){  //如果为当前用户新鲜事则增加删除功能
						footer = '<div class="panel-footer">'+comment_body+hide_input+collapse_input+'<a id = \''+eachThing[3] +'comment_btn'+'\' href= "javascript:commentThing(\''+eachThing[3]+'\')" class = "col-lg-offset-8 col-md-offset-9 col-sm-offset-8 col-xs-offset-9"><span class="glyphicon glyphicon-edit"></span>评论</a><a href="javascript:deleteThing(\''+eachThing[3]+'\')" class="col-lg-offset-1"><span class="glyphicon glyphicon-trash"></span>删除</a></div>';
					}else{  //否则不允许删除
						footer = '<div class="panel-footer">'+comment_body+hide_input+collapse_input+'<a id = \''+eachThing[3] +'comment_btn'+'\' href="javascript:commentThing(\''+eachThing[3]+'\')" class = "col-lg-offset-10 col-md-offset-10 col-sm-offset-10 col-xs-offset-10"><span class="glyphicon glyphicon-edit"></span>评论</a></div>';
					}
					$("#newthings_show").append(
					'<div class="row"><div class="panel panel-default"><div class="panel-heading"><h3 class="panel-title"><span class="glyphicon glyphicon-user"></span>'+eachThing[0]+'</h3>&nbsp;'+eachThing[2]+'</div>'
				    	+'<div class="panel-body">'+eachThing[1]+'</div>'+footer+'</div></div>');
				}
			});
			$("#body_r").append('<div id = "asker" class="panel panel-default"><div class="panel-heading"><h3 class="panel-title"><span class="glyphicon glyphicon-user"></span>最近来访</h3></div><div class="panel-body"><table class="table" style = "border:0px"><tr><td>刘炳璋</td><td>曹斌</td><td>杨涵</td><td>王五</td></tr><tr><td>张三</td><td>李四</td><td>王二麻子</td></tr></table></div></div>');
		} else {
			
		}

	});

	function check(form) {
		if (form.name.value == '') {
			$("#name").attr('placeholder', '登录名不能为空！');
			form.name.focus();
			return false;
		}
		if (form.password.value == '') {
			$("#password").attr('placeholder', '密码不能为空！');
			form.password.focus();
			return false;
		}
		return true;
	}

	function login() {
			$.ajax({
				type : "POST",  //提交方式
				url : "login",//路径
				data : $("#loginForm").serialize(),//数据，这里使用的是Json格式进行传输
				async: false,
				success : function(result) {//返回数据根据结果进行相应的处理
					//成功了
				},
			 	error:function(e){  
				 	alert("出错");
    			}  
		    });
	}

	function regist() {
		$.ajax({
			type : "POST",  //提交方式
			url : "regist",//路径
			data : $("#registForm").serialize(),//数据，这里使用的是Json格式进行传输
			async: false,
			success : function(result) {//返回数据根据结果进行相应的处理
				if(result.status == 411){
					alert("用户名重复");
				}
			},
		 	error:function(e){  
			 	alert("出错");
			}  
	    });
	}

	function exit() {
		$.cookie('user','',{
		    expires:-1,  
		    path:'/',
		    domain:document.domain,
		});
		//进入首页
		location.href = "${pageContext.request.contextPath}/MyLogin";
	}
	
	function report(){
		$.post("report",{content : $("#report_content").val()}, function(data){
			if(data.status == 200){
				location.reload();
			}
		});
	}
	
	function searchFriends(){
		$.post("search_friend",{username: $("#friend_name").val()}, function(data){
			if(data.status == 200){
				var str = '<div class = "col-sm-offset-2">'+data.data+ '<button class = "btn btn-default col-sm-offset-1" onclick = "addFriend(\''+data.data+'\')">添加</button></div>';
				$("#addFriendBody").append(str);
			}
			else{
				$("#friend_name").attr('placeholder', '查无此好友！');
				$("#friend_name").focus();
			}
		});
	}
	
	function addFriend(friend_name){
		$.post("addFriend",{friendname : friend_name}, function(data){
			if(data.status == 200){
				alert("请求已发送");
				location.reload();
			}
			else if(data.status == 444){
				alert("不允许重复添加好友");
				location.reload();
			}
			else if(data.status == 445){
				alert("不可添加自己为好友");
				location.reload();
			}
		});
	}
	
	//同意添加好友
	function agreeAddFriend(friend_name){
		$.post("agreeAddFriend",{friendname : friend_name}, function(data){
			if(data.status == 200){
				//更新friendlist
				var success = false;
				$('#friendRequestList tr').each(function(i){                   // 遍历 tr
					var count = 0;
				      $(this).children('td').each(function(j){  // 遍历 tr 的各个 td
				         if(count == 1){
				        	 $(this).html("<button class = 'btn btn-default col-md-offset-8' disabled='disabled')>已同意</button></td>");
				        	 success = true;
				        	 return false;
				         }
				         if($(this).text() == data.data){
				        	 count++;
				         }
				      });
					if(success)
						return false;
				   });
			}
		});
	}
	
	//删除id为id的新鲜事
	var thing_id = -1;
	function deleteThing(id){
		$('#deleteSureModal').modal('show');
		thing_id = id;
	}
	
	function sureToDelete(){
		if(thing_id != -1){
			$.post("deleteThing",{thingId : thing_id}, function(data){
				if(data.status == 200){
					location.reload();
				}
			});
		}
		thing_id = -1;
	};
	
	function showFriendRequest(){
		$("#friendRequestBody").val("");
		//获取好友请求
		$.get("getFriendsRequest", function(result) {
			if(result.data != null){  //如果好友请求不是空
				var str = "<table border='0' id = 'friendRequestList' style='border-collapse:separate;border-spacing:0px 5px;'>";
				for(var i = 0; i < result.data.length; ++i){
					str += '<tr><td>'+result.data[i]+ '</td><td><button class = "btn btn-default col-md-offset-8" onclick = "agreeAddFriend(\''+result.data[i]+'\')">同意添加</button></td></tr>';
				}
				str += "</table>";
				$("#friendRequestBody").append(str);
				$("#friendRequestModal").modal("show");
			}
		});
	}
	
	function commentThing(id){
		if($("#"+ id + "comment_btn").text() == "评论"){
			$("#"+ id + "comment").collapse('show');
			$("#"+ id + "comment_btn").html('<span class="glyphicon glyphicon-send"></span>发表');
		}
		else if($("#"+ id + "comment_btn").text() == "发表"){
			var content = $("#"+ id + "comment_content").val();
			var _becommentedId = $("#"+ id + "hide_input").val();
			$.ajax({
				type : "POST",  //提交方式
				url : "saveComment",//路径
				data : {thingId:id, comment:content, becommentedId:_becommentedId},//数据，这里使用的是Json格式进行传输
				success : function(result) {//返回数据根据结果进行相应的处理
					if(result.status == 200){
						$("#"+ id + "comment").collapse('hide');
						parent.location.reload();
						$("#"+ id + "hide_input").val("-1");
					}
				},
			 	error:function(e){  
				 	alert("出错");
				}  
		    });
		}
	}
	
	function commentComment(thingId, cmtName, cmtId){
		$("#"+ thingId + "comment").collapse('show');
		$("#"+ thingId + "comment_btn").html('<span class="glyphicon glyphicon-send"></span>发表');
		$("#"+ thingId + "comment_content").attr('placeholder', '回复'+cmtName+':');
		$("#"+ thingId + "hide_input").val(cmtId);
	}
	
	function collapseCommentInput(commentInputId, btnId){
		$("#"+ btnId).html('<span class="glyphicon glyphicon-edit"></span>评论');
		$("#"+commentInputId).collapse('hide');
	}
	
    $("#file-3").fileinput({
    	theme: 'fa',
        language : 'zh',
        uploadUrl : "/image/save-test",
        showUpload: true, //是否显示上传按钮
        showRemove : true, //显示移除按钮
        showPreview : true, //是否显示预览
        showCaption: false,//是否显示标题
        autoReplace : true,
        minFileCount: 0,
        uploadAsync: true,
        maxFileCount: 10,//最大上传数量
        browseOnZoneClick: true,
        msgFilesTooMany: "选择上传的文件数量 超过允许的最大数值！",
        enctype: 'multipart/form-data',
        // overwriteInitial: false,//不覆盖已上传的图片
        allowedFileExtensions : [ "jpg", "png", "gif" ],
        browseClass : "btn btn-primary", //按钮样式
        previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
       	previewSettings: {
               image: {width: "100px", height: "100px"},
        }
    }).on("fileuploaded", function(e, data) {//文件上传成功的回调函数，还有其他的一些回调函数，比如上传之前...
        var res = data.response;
        console.log(res)
        imageData.push({
            "path": res.data.path,
            "date":res.data.date
        });
        console.log(imageData);
    });
</script>
</body>
</html>