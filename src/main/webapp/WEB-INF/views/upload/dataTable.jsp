<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Tell the browser to be responsive to screen width -->
    <%--<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">--%>
    <!-- DataTables -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/plugins/datatables/dataTables.bootstrap.css">
    <!-- DataTables -->
    <script src="${pageContext.request.contextPath}/admin/plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/admin/plugins/datatables/dataTables.bootstrap.min.js"></script>
</head>
<!-- Main content -->
<body>
<section class="content">
    <div class="row">
        <div class="col-xs-12">

            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">已上传文件列表</h3>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <table id="scsrc-datatable" class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th>文件名</th>
                            <th>文件类型</th>
                            <th>文件大小</th>
                            <th>上传时间</th>
                            <th>备注</th>
                        </tr>
                        </thead>
                        <tbody>
                    <tr>
                        <td>train</td>
                        <td>text/plain</td>
                        <td>35KB</td>
                        <td>2016.03.11</td>
                        <td>训练集</td>
                    </tr>
                    </tbody>
                    </table>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->
</section>
<!-- /.content -->

<%--<!-- jQuery 2.2.3 -->--%>
<%--<script src="admin/plugins/jQuery/jquery-2.2.3.min.js"></script>--%>
<%--<!-- Bootstrap 3.3.6 -->--%>
<%--<script src="admin/bootstrap/js/bootstrap.min.js"></script>--%>


<%--<!-- SlimScroll -->--%>
<%--<script src="admin/plugins/slimScroll/jquery.slimscroll.min.js"></script>--%>
<%--<!-- FastClick -->--%>
<%--<script src="admin/plugins/fastclick/fastclick.js"></script>--%>
<%--<!-- AdminLTE App -->--%>
<%--<script src="admin/dist/js/app.min.js"></script>--%>
<%--<!-- AdminLTE for demo purposes -->--%>
<%--<script src="admin/dist/js/demo.js"></script>--%>
<%--<!-- page script -->--%>
<script>
    $(function () {
        $("#scsrc-datatable").DataTable();
//        $('#scsrc-datatable').DataTable({
//            "paging": true,
//            "lengthChange": false,
//            "searching": false,
//            "ordering": true,
//            "info": true,
//            "autoWidth": false
//        });
    });
</script>
</body>
</html>