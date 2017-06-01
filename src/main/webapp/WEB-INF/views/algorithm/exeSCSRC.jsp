<%--
  Created by IntelliJ IDEA.
  User: kangk_000
  Date: 3/21/2017
  Time: 12:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link rel="stylesheet" type="text/css" href="tools/progress/css/normalize.css"/>
<link rel="stylesheet" type="text/css" href="tools/progress/css/default.css">
<link rel="stylesheet" type="text/css" href="tools/progress/css/minddust.min.css">
<link rel="stylesheet" type="text/css" href="tools/progress/css/bootstrap-progressbar-3.2.0.min.css">
<link rel="stylesheet" type="text/css" href="tools/highcharts/css/highcharts.css">
<link rel="stylesheet" type="text/css" href="tools/select/css/normalize.css"/>
<link rel="stylesheet" type="text/css" href="tools/select/css/pintsize.min.css">
<link rel="stylesheet" type="text/css" href="tools/select/css/nice-select.css">
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
            <h1>
            海量高光谱图像分类云系统
            <small>算法执行模块</small>
            <small>分类结果显示模块</small>
        </h1>
    <%--<h1>--%>
    <%--Dashboard--%>
    <%--<small>Control panel</small>--%>
    <%--</h1>--%>
    </section>
    <!-- Main content -->
    <div class="htmleaf-container">
        <div class="container">
            <div id="content">
                <div class="tab-content">
                    <div class="tab-pane fade in active" id="h-center-basic">
                        <%--<select class="small">--%>
                            <%--<option data-display="Select">Nothing</option>--%>
                            <%--<option value="1">Some option</option>--%>
                            <%--<option value="2">Another option</option>--%>
                            <%--<option value="3" disabled>A disabled option</option>--%>
                            <%--<option value="4">Potato</option>--%>
                        <%--</select>--%>

                            <br>

                            <div class="progress progress-striped active">
                                <div class="progress-bar progress-bar-success" role="progressbar"></div>
                            </div>
                            <select class="small">
                                <option data-display="选择算法"/>
                                <option value="1">SCSRC</option>
                                <option value="2" disabled>PPI</option>
                                <option value="3" disabled>SPARKPI</option>
                            </select>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <button type="button" class="btn btn-primary" id="h-basic-exec">执行</button>
                            <br>

                            <p>总迭代任务数: <span class="label label-info" id="scsrc-all-iterations"></span></p>

                            <p>当前进行任务: <span class="label label-success" id="scsrc-single-iterations"></span></p>
                    </div>
                </div>
                <!-- Line CHART -->
                <div class="box box-danger">
                    <div class="box-header with-border">
                        <h3 class="box-title">Classified Image</h3>

                        <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                    class="fa fa-minus"></i>
                            </button>
                            <%--<button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>--%>
                        </div>
                    </div>
                    <div class="box-body">
                        <img id="scsrc-img" class="img-responsive center-block" style="margin: 0 auto">
                        <canvas id="areaChart" style="min-width: 0px; height: 0px; margin: 0 auto"></canvas>
                    </div>
                </div>
                <!-- /.box-body -->
            </div>
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">SCSRC Chart</h3>

                    <div class="box-tools pull-right">
                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                class="fa fa-minus"></i>
                        </button>
                        <%--<button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>--%>
                    </div>
                </div>
                <div class="box-body">
                    <div class="chart" id="scsrc-chart-container">
                        <canvas id="lineChart" style="min-width: 0px; height: 0px; margin: 0 auto"></canvas>
                    </div>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
            <%--<div id="scsrc-chart-container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>--%>
        </div>
    </div>
</div>
<!-- /.content -->
</div>

<script type="text/javascript" src="http://cdn.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="tools/progress/js/common.min.js"></script>
<script type="text/javascript" src="tools/progress/js/bootstrap-progressbar.js"></script>
<script type="text/javascript" src="admin/plugins/chartjs/Chart.min.js"></script>
<script type="text/javascript" src="tools/progress/js/minddust.min.js"></script>
<script type="text/javascript" src="tools/highcharts/highcharts.js"></script>
<script type="text/javascript" src="tools/highcharts/exporting.js"></script>
<script type="text/javascript" src="tools/progress/js/kzk.js"></script>
<script type="text/javascript" src="tools/select/js/jquery.nice-select.min.js"></script>
<script type="text/javascript" src="tools/select/js/fastclick.js"></script>
