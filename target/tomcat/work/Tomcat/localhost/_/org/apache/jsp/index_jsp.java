/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
<<<<<<< HEAD
 * Generated at: 2018-10-26 13:52:57 UTC
=======
<<<<<<< HEAD
 * Generated at: 2018-10-26 05:15:46 UTC
=======
 * Generated at: 2018-10-26 12:07:56 UTC
>>>>>>> edf6e99bca741bfbcec3000911d110e4f3d54c81
>>>>>>> d928dd0118bee9cc12347723a6803626902d7899
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write(" <!-- Required meta tags -->\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap -->\r\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery.cookie.js\"></script>\r\n");
      out.write("    \r\n");
      out.write("    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<title>Calm-Social</title>\r\n");
      out.write("\t\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t\t.modal-dialog {  \r\n");
      out.write("\t   \t\tmargin: 200px auto;  \r\n");
      out.write("\t\t}  \r\n");
      out.write("\t</style>\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\"> \r\n");
      out.write(" <div class=\"row\"> \r\n");
      out.write("  <nav class=\"navbar navbar-default\" style=\"background-color: #e3f2fd;\"> \r\n");
      out.write("   <div class=\"container-fluid\"> \r\n");
      out.write("    <!-- Brand and toggle get grouped for better mobile display --> \r\n");
      out.write("    <div class=\"navbar-header\"> \r\n");
      out.write("     <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\" aria-expanded=\"false\"> <span class=\"sr-only\">Toggle navigation</span> <span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span> </button> \r\n");
      out.write("     <a class=\"navbar-brand\" href=\"#\">Calm-Social</a> \r\n");
      out.write("    </div> \r\n");
      out.write("    <!-- Collect the nav links, forms, and other content for toggling --> \r\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"\"> \r\n");
      out.write("     <ul class=\"nav navbar-nav\"> \r\n");
      out.write("      <form class=\"navbar-form navbar-left\"> \r\n");
      out.write("       <div class=\"form-group\"> \r\n");
      out.write("        <input type=\"text\" class=\"form-control\" placeholder=\"Search\" /> \r\n");
      out.write("       </div> \r\n");
      out.write("       <button type=\"submit\" class=\"btn btn-default\">搜索</button> \r\n");
      out.write("      </form> \r\n");
      out.write("      <li id = \"loginBtn\"><a href=\"#\" data-toggle=\"modal\" data-target=\"#loginModal\">登陆</a></li> \r\n");
      out.write("      <li id = \"registBtn\"><a href=\"#\" data-toggle=\"modal\" data-target=\"#registModal\">注册</a></li> \r\n");
      out.write("      <li><a id = \"personalBtn\" href=\"#\" ></a></li>\r\n");
      out.write("      <li id = \"exitBtn\"><a href=\"javascript:exit();\">退出</a></li>\r\n");
      out.write("     </ul> \r\n");
      out.write("     <ul class=\"nav navbar-nav navbar-right\"> \r\n");
      out.write("      <li><a href=\"#\">关于Calm-Social</a></li> \r\n");
      out.write("     </ul> \r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- /.navbar-collapse --> \r\n");
      out.write("   </div>\r\n");
      out.write("   <!-- /.container-fluid --> \r\n");
      out.write("  </nav> \r\n");
      out.write(" </div> \r\n");
      out.write(" \r\n");
      out.write(" <div class=\"row\"> \r\n");
      out.write(" \r\n");
      out.write("  <div class=\"col-sm-2 col-md-2 col-lg-2\" style = \"text-align:center;\"> \r\n");
      out.write("   <div class=\"row\">\r\n");
      out.write("   <ul class=\"list-group\">\r\n");
      out.write("\t  <li class=\"list-group-item\"><a href=\"#\"><span class=\"glyphicon glyphicon-user\"></span>个人中心</a> </li>\r\n");
      out.write("\t  <li class=\"list-group-item\"><a href=\"#\"><span class=\"glyphicon glyphicon-eye-open\"></span>新鲜事儿</a> </li>\r\n");
      out.write("\t  <li class=\"list-group-item\"><a href=\"#\"><span class=\"glyphicon glyphicon-film\"></span>我的相册</a></li>\r\n");
      out.write("\t  <li class=\"list-group-item\"><a href=\"#\" data-toggle=\"modal\" data-target=\"#addFriendsModal\"><span class=\"glyphicon glyphicon-user\"></span>搜寻好友</a></li>\r\n");
      out.write("\t  <li class=\"list-group-item\"><a href=\"#\"><span class=\"glyphicon glyphicon-film\"></span>那年今日</a></li>\r\n");
      out.write("\t</ul> \r\n");
      out.write("   </div> \r\n");
      out.write("  </div> \r\n");
      out.write("  \r\n");
      out.write("  <div class=\"col-sm-offset-1 col-md-offset-1 col-lg-offset-1 col-md-5 col-lg-5 col-sm-5\" id = \"newthings_show\">\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("    \t<div class = \"col-lg-10 col-sm-10 col-md-10\">\r\n");
      out.write("\t\t    <form role=\"form\">\r\n");
      out.write("\t\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t\t    <textarea class=\"form-control\" rows=\"2\" placeholder = \"说些什么吧\" id = \"report_content\"></textarea>\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class = \"col-lg-2 col-sm-2 col-md-2\">\r\n");
      out.write("\t\t\t<button class=\"btn btn-default btn-lg\" onclick = \"report()\">发表</button> \r\n");
      out.write("\t\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("    \r\n");
      out.write("  </div> \r\n");
      out.write("  \r\n");
      out.write("  <div class = \"col-md-offset-1 col-lg-offset-1 col-sm-offset-1 col-sm-3 colcol-md-3 col-lg-3\">\r\n");
      out.write("\t<div class=\"panel panel-default\">\r\n");
      out.write("\t    <div class=\"panel-heading\">\r\n");
      out.write("\t        <h3 class=\"panel-title\"><span class=\"glyphicon glyphicon-user\"></span>最近来访</h3>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t    <div class=\"panel-body\">\r\n");
      out.write("\t        <table class=\"table\">\r\n");
      out.write("\t\t        <tr><td>刘炳璋</td><td>曹斌</td><td>杨涵</td><td>王五</td></tr>\r\n");
      out.write("\t\t        <tr><td>张三</td><td>李四</td><td>王二麻子</td></tr>\r\n");
      out.write("\t\t    </table>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write(" </div> \r\n");
      out.write("</div>\r\n");
      out.write("\t\r\n");
      out.write("<!-- 登陆模态框（Modal） -->\r\n");
      out.write("<div class=\"modal fade\" id=\"loginModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("    <div class=\"modal-dialog\" style=\"width:350px;\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\r\n");
      out.write("                <h4 class=\"modal-title\" id=\"myModalLabel\">登陆</h4>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("            \t<form class=\"form-horizontal\" id = \"loginForm\" role=\"form\" method = \"post\" onsubmit=\"return check(this)\">\r\n");
      out.write("\t\t\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t    <label for=\"firstname\" class=\"col-sm-3 control-label\">登陆名</label>\r\n");
      out.write("\t\t\t\t    <div class=\"col-sm-9\">\r\n");
      out.write("\t\t\t\t      <input type=\"text\" class=\"form-control\" name = \"username\" id=\"name\" placeholder=\"请输入登录名\">\r\n");
      out.write("\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t    <label for=\"lastname\" class=\"col-sm-3 control-label\">密码</label>\r\n");
      out.write("\t\t\t\t    <div class=\"col-sm-9\">\r\n");
      out.write("\t\t\t\t      <input  class=\"form-control\" type=\"password\" name = \"userpassword\" id=\"password\" placeholder=\"请输入密码\">\r\n");
      out.write("\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t    <div class=\"col-sm-offset-2 col-sm-6\">\r\n");
      out.write("\t\t\t\t      <div class=\"checkbox\">\r\n");
      out.write("\t\t\t\t        <label>\r\n");
      out.write("\t\t\t\t          <input type=\"checkbox\">请记住我\r\n");
      out.write("\t\t\t\t        </label>\r\n");
      out.write("\t\t\t\t      </div>\r\n");
      out.write("\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t    <div class=\"col-sm-offset-1 col-sm-10\">\r\n");
      out.write("\t\t\t\t      <button type=\"submit\" class=\"btn btn-default btn-block\" onclick=\"login()\">登录</button>\r\n");
      out.write("\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("        </div><!-- /.modal-content -->\r\n");
      out.write("    </div><!-- /.modal -->\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- 注册模态框（Modal） -->\r\n");
      out.write("<div class=\"modal fade\" id=\"registModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("    <div class=\"modal-dialog\" style=\"width:350px;\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\r\n");
      out.write("                <h4 class=\"modal-title\" id=\"myModalLabel\">注册</h4>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\">\r\n");
      out.write("            \t<form class=\"form-horizontal\" role=\"form\" id = \"registForm\" method = \"post\" onsubmit=\"return check(this);\">\r\n");
      out.write("\t\t\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t    <label for=\"firstname\" class=\"col-sm-3 control-label\">登陆名</label>\r\n");
      out.write("\t\t\t\t    <div class=\"col-sm-9\">\r\n");
      out.write("\t\t\t\t      <input type=\"text\" class=\"form-control\" name = \"username\" id=\"r_name\" placeholder=\"请输入登录名\">\r\n");
      out.write("\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t    <label for=\"lastname\" class=\"col-sm-3 control-label\">密码</label>\r\n");
      out.write("\t\t\t\t    <div class=\"col-sm-9\">\r\n");
      out.write("\t\t\t\t      <input class=\"form-control\" type=\"password\" name = \"userpassword\" id=\"r_password\" placeholder=\"请输入密码\">\r\n");
      out.write("\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t    <div class=\"col-sm-offset-1 col-sm-10\">\r\n");
      out.write("\t\t\t\t      <input type=\"submit\" class=\"btn btn-default btn-block\" onclick=\"regist()\" value = \"注册\"/>\r\n");
      out.write("\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div><!-- /.modal-content -->\r\n");
      out.write("    </div><!-- /.modal -->\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- 添加好友模态框（Modal） -->\r\n");
      out.write("<div class=\"modal fade\" id=\"addFriendsModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n");
      out.write("    <div class=\"modal-dialog\" style=\"width:350px;\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <div class=\"modal-header\">\r\n");
      out.write("                <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>\r\n");
      out.write("                <h4 class=\"modal-title\" id=\"myModalLabel\">搜寻好友</h4>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"modal-body\" id = \"addFriendBody\">\r\n");
      out.write("            \t<form class=\"form-horizontal\" role=\"form\" id = \"addFriendsForm\" onsubmit=\"return check(this);\">\r\n");
      out.write("\t\t\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t\t\t    <label for=\"firstname\" class=\"col-sm-3 control-label\">用户名</label>\r\n");
      out.write("\t\t\t\t    <div class=\"col-sm-6\">\r\n");
      out.write("\t\t\t\t      <input type=\"text\" class=\"form-control\" name = \"username\" id=\"friend_name\" placeholder=\"请输入用户名\">\r\n");
      out.write("\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t    <div class=\"col-sm-2\">\r\n");
      out.write("\t\t\t\t      <button class=\"btn btn-default\" onclick=\"searchFriends()\">搜索</button>\r\n");
      out.write("\t\t\t\t    </div>\r\n");
      out.write("\t\t\t\t  </div>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div><!-- /.modal-content -->\r\n");
      out.write("    </div><!-- /.modal -->\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
<<<<<<< HEAD
=======
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\t//更新登陆状态\r\n");
      out.write("\t\tvar user = $.cookie('user');\r\n");
      out.write("\t\tif (user != null) {\r\n");
      out.write("\t\t\t$(\"#loginBtn\").remove();\r\n");
      out.write("\t\t\t$(\"#registBtn\").remove();\r\n");
      out.write("\t\t\t$(\"#personalBtn\").html(user);\r\n");
      out.write("\t\t\t//更新新鲜事\r\n");
      out.write("\t\t\t$.get(\"getnewthings\", function(result) {\r\n");
      out.write("\t\t\t\t//展示新鲜事\r\n");
      out.write("\t\t\t\tfor(var i = 0; i < result.data.length; i++){\r\n");
      out.write("\t\t\t\t\tvar eachThing = result.data[i].split(\"+\");\r\n");
      out.write("\t\t\t\t\tvar footer = \"\";\r\n");
      out.write("\t\t\t\t\tif(eachThing[0] == user){  //如果为当前用户新鲜事则增加删除功能\r\n");
      out.write("\t\t\t\t\t\tfooter = '<div class=\"panel-footer\"><a href=\"#\" class = \"col-lg-offset-8\"><span class=\"glyphicon glyphicon-edit\"></span>评论</a><a href=\"#\" class=\"col-lg-offset-1\"><span class=\"glyphicon glyphicon-trash\"></span>删除</a></div>';\r\n");
      out.write("\t\t\t\t\t}else{  //否则不允许删除\r\n");
      out.write("\t\t\t\t\t\tfooter = '<div class=\"panel-footer\"><a href=\"#\" class = \"col-lg-offset-9\"><span class=\"glyphicon glyphicon-edit\"></span>评论</a></div>';\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t$(\"#newthings_show\").append(\r\n");
      out.write("\t\t\t\t\t'<div class=\"row\"><div class=\"panel panel-default\"><div class=\"panel-heading\"><h3 class=\"panel-title\"><span class=\"glyphicon glyphicon-user\"></span>'+eachThing[0]+'</h3></div>'\r\n");
      out.write("\t\t\t\t    \t+'<div class=\"panel-body\">'+eachThing[1]+'</div>'+footer+'</div></div>');\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\t$(\"#exitBtn\").hide();\r\n");
      out.write("\t\t}\r\n");
>>>>>>> edf6e99bca741bfbcec3000911d110e4f3d54c81
      out.write("\r\n");
      out.write("\r\n");
<<<<<<< HEAD
      out.write("\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\t//更新登陆状态\r\n");
      out.write("\tvar user = $.cookie('user');\r\n");
      out.write("\tif(user != null){\r\n");
      out.write("\t\t$(\"#loginBtn\").remove();\r\n");
      out.write("\t\t$(\"#registBtn\").remove();\r\n");
      out.write("\t\t$(\"#personalBtn\").html(user);\r\n");
      out.write("\t\t//更新个人新鲜事\r\n");
      out.write("\t\t$.get(\"getnewthings\", function(result){\r\n");
      out.write("\t\t    alert(result.data);\r\n");
      out.write("\t\t  });\r\n");
      out.write("\t}\r\n");
      out.write("\telse{\r\n");
      out.write("\t\t$(\"#exitBtn\").hide();\r\n");
      out.write("\t}\t\r\n");
      out.write("});\r\n");
      out.write("\t\r\n");
=======
>>>>>>> edf6e99bca741bfbcec3000911d110e4f3d54c81
      out.write("\tfunction check(form) {\r\n");
      out.write("\t\tif (form.name.value == '') {\r\n");
      out.write("\t\t\t$(\"#name\").attr('placeholder', '登录名不能为空！');\r\n");
      out.write("\t\t\tform.name.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (form.password.value == '') {\r\n");
      out.write("\t\t\t$(\"#password\").attr('placeholder', '密码不能为空！');\r\n");
      out.write("\t\t\tform.password.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction login() {\r\n");
      out.write("\t\tvar str_data = \"username=\" + $(\"#name\").val() + \"&userpassword=\"\r\n");
      out.write("\t\t\t\t+ $(\"#password\").val();\r\n");
      out.write("\t\t//post请求\r\n");
      out.write("\t\t$.post(\"login\", $(\"#loginForm\").serialize(), function(data) {\r\n");
      out.write("\t\t\tif (data.status == 200) {\r\n");
      out.write("\t\t\t\t//alert(\"登陆成功\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction regist() {\r\n");
      out.write("\t\tvar str_data = \"username=\" + $(\"#r_name\").val() + \"&userpassword=\"\r\n");
      out.write("\t\t\t\t+ $(\"#r_password\").val();\r\n");
      out.write("\r\n");
      out.write("\t\t//post请求\r\n");
      out.write("\t\t$.post(\"regist\", $(\"#registForm\").serialize(), function(data) {\r\n");
      out.write("\t\t\tif (data.status == 200) {\r\n");
      out.write("\t\t\t\talert(\"注册成功\");\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\talert(\"注册失败\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction exit() {\r\n");
      out.write("\t\t$.cookie('user', '', {\r\n");
      out.write("\t\t\texpires : -1\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tlocation.reload();\r\n");
      out.write("\t}\r\n");
<<<<<<< HEAD
      out.write("\r\n");
=======
>>>>>>> edf6e99bca741bfbcec3000911d110e4f3d54c81
      out.write("\t\r\n");
      out.write("\tfunction report(){\r\n");
      out.write("\t\t$.post(\"report\",{content : $(\"#report_content\").val()}, function(data){\r\n");
      out.write("\t\t\tif(data.status == 200){\r\n");
<<<<<<< HEAD
      out.write("\t\t\t\talert(\"发表成功\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
=======
      out.write("\t\t\t\tlocation.reload();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
<<<<<<< HEAD
      out.write("\t\r\n");
      out.write("\tfunction searchFriends(){\r\n");
      out.write("\t\t$.get(\"search_friend?username=\"+$(\"#friend_name\").val(), function(data){\r\n");
      out.write("\t\t\tif(data.status == 200){\r\n");
      out.write("\t\t\t\t$(\"#addFriendBody\").append(\r\n");
      out.write("\t\t\t\t  '<div class = \"col-sm-offset-2\">'+data.data+ '<button class = \"btn btn-default col-sm-offset-1\" onclick = \"addFriend('+data.data+')\">添加</button></div>'\r\n");
      out.write("\t\t\t\t)\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse{\r\n");
      out.write("\t\t\t\t$(\"#friend_name\").attr('placeholder', '查无此好友！');\r\n");
      out.write("\t\t\t\t$(\"#friend_name\").focus();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction addFriend(friendname){\r\n");
      out.write("\t\t$.post(\"addFriend\",{username : freindname}, function(data){\r\n");
      out.write("\t\t\tif(data.status == 200){\r\n");
      out.write("\t\t\t\talert(\"添加成功\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
=======
>>>>>>> edf6e99bca741bfbcec3000911d110e4f3d54c81
>>>>>>> d928dd0118bee9cc12347723a6803626902d7899
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
