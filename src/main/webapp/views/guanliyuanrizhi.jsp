<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员日志</title>
    <script type="text/javascript"src="<%=basePath%>lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jedate.js"></script>
    <link href="<%=basePath%>css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>css/H-ui.admin.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>css/paihangbang.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>css/jedate.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>lib/Hui-iconfont/1.0.1/iconfont.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>css/style.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">
	var basePath='<%=basePath%>';
</script>
<script type="text/javascript" src="<%=basePath%>js/guanliyuanrizhi.js"></script>
<body>
	<nav class="breadcrumb">
    	<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 管理员日志 <a class="btn btn-success radius r mr-20" style="line-height: 1.6em; margin-top: 3px" href="javascript:location.replace(location.href);" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a></nav>
        <div class="pd-20">
        <div class="text-c">
            <div class="textbox">
                <ul>
                    <li>
                        <label>账号 </label><input type="text" value="" id="login_accounts" name="login_accounts" />
                    </li>
                     <li>
                    	<label>操作开始时间</label>
                        <input class="datainp" id="signinDateBegin" name="signinDateBegin" type="text" placeholder="请选择"/>
                    </li>
                    <li>
                    	<label>操作结束时间</label>
                        <input class="datainp" id="signinDateEnd" name="signinDateEnd" type="text" placeholder="请选择"/>
                    </li>
                	<li>
                        <button type="button" class="btn btn-success radius" id="Button1" onclick="query('select')"><i class="Hui-iconfont">&#xe665;</i> 查询</button>
                    </li>
                </ul>
            </div>
        </div>
        <div class="claer"></div>
        <div class="cl pd-5 bg-1 bk-gray mt-20">
            <span class="count"></span>
        </div>
        <div class="mt-20">
            <div>
                <table class="table table-border table-bordered table-bg table-hover ">
                    <thead>
                        <tr class="text-c">
                            <th>管理员帐号</th>
                            <th>管理员姓名</th>
                            <th>操作时间</th>
                            <th>操作模块</th>
                           <!--  <th>操作电脑IP</th> -->
                            <th>操作功能</th>
                        </tr>
                    </thead>
                    <tbody id="tbody">
                    </tbody>
                </table>
            </div>
            <div class="clear con-top"></div>
            <div id="DataTables_Table_0_info" class="dataTables_info" role="status" aria-live="polite">显示 <span id="pageTail">1</span>页，共 <span id="pageCount">1</span>页</div>
            <div id="DataTables_Table_0_paginate" class="dataTables_paginate paging_simple_numbers">
                <a id="DataTables_Table_0_previous" class="paginate_button previous disabled" aria-controls="DataTables_Table_0" data-dt-idx="0" tabindex="0" onclick="query('previous')">上一页</a>
                <span>
                    <a class="paginate_button current bgcurg" id="currentPage">1</a>
                </span>
                <input type="hidden" name="rows" id="pageSize" value=10>
                <a id="DataTables_Table_0_next" class="paginate_button next disabled" aria-controls="DataTables_Table_0" data-dt-idx="2" tabindex="0" onclick="query('next')">下一页</a>
            </div>
        </div>
        </div>
<script type="text/javascript">
    jeDate({
		dateCell:"#signinDateBegin",
		format:"YYYY-MM-DD",
		isinitVal:false,
		isTime:true, //isClear:false,
		minDate:"2014-09-19 00:00",
		okfun:function(val){alert(val)}
	});
    jeDate({
		dateCell:"#signinDateEnd",
		format:"YYYY-MM-DD",
		isinitVal:false,
		isTime:true, //isClear:false,
		minDate:"2014-09-19 00:00",
		okfun:function(val){alert(val)}
	});
</script>
</body>
</html>
