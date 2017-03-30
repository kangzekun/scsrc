<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <link rel="stylesheet" type="text/css" href="tools/upload/css/default.css">

    <link rel="stylesheet" type="text/css" href="tools/upload/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />

    <script  type="text/javascript" src="http://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <script  type="text/javascript" src="tools/upload/js/fileinput.js"></script>
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <%--<section class="content-header">--%>
        <%--<h1>--%>
            <%--Dashboard--%>
            <%--<small>Control panel</small>--%>
        <%--</h1>--%>
        <%--<ol class="breadcrumb">--%>
            <%--<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>--%>
            <%--<li class="active">Dashboard</li>--%>
        <%--</ol>--%>
    <%--</section>--%>
    <!-- Main content -->
    <!-- 上传插件-->

    <div class="htmleaf-container">
        <div class="container kv-main">
            <div class="form-group">
                <input id="file-5" class="file" name="files" type="file" multiple="multiple" data-preview-file-type="any" data-upload-url="/rest/hdfs/upload">
            </div>
        </div>

    </div>

    <%--<jsp:include page="/WEB-INF/views/upload/dataTable.jsp" flush="true" />--%>
    <!-- /.content -->
</div>
</div>