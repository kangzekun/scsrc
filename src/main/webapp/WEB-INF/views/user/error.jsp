<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Highcharts Example</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/highcharts/css/highcharts.css">

    <script type="text/javascript" src="http://cdn.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax( {
                url : "/rest/spark/sparkShow",
                dataType:"json",
                success : function(data) {
                    var dtol = data.dtol;
                    var iter = data.iter;
                    Highcharts.chart('container', {
                        chart: {
                            zoomType: 'xy'
                        },
                        title: {
                            text: 'SCSRC算法迭代时间和损值函数的值'
                        },
                        subtitle: {
                            text: '数据来自于Spark云计算平台'
                        },
                        xAxis: [{
                            type:'linear',
                            title: {
                                text:'迭 代 次 数'
                            },
                            crosshair: true
                        }],
                        yAxis: [{ // Primary yAxis
                            labels: {
                                format: '{value}',
                                style: {
                                    color: Highcharts.getOptions().colors[1]
                                }
                            },
                            title: {
                                text: '迭代时间',
                                style: {
                                    color: Highcharts.getOptions().colors[1]
                                }
                            }
                        }, { // Secondary yAxis
                            title: {
                                text: '损失函数值',
                                style: {
                                    color: Highcharts.getOptions().colors[0]
                                }
                            },
                            labels: {
                                format: '{value} ',
                                style: {
                                    color: Highcharts.getOptions().colors[0]
                                }
                            },
                            opposite: true
                        }],
                        tooltip: {
                            shared: true
                        },
                        legend: {
                            layout: 'vertical',
                            align: 'left',
                            x: 120,
                            verticalAlign: 'top',
                            y: 100,
                            floating: true,
                            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
                        },
                        series: [{
                            name: '迭代时间',
                            type: 'column',
                            yAxis: 1,
                            data: iter,
                            tooltip: {
                                valueSuffix: ''
                            }

                        }, {
                            name: '损失函数值',
                            type: 'spline',
                            data: dtol,
                            tooltip: {
                                valueSuffix: ''
                            }
                        }]
                    });
                }
        });
        });
    </script>
</head>
<body>
<%--<script src="highcharts/highcharts.src.js" type="text/javascript"></script>--%>
<%--<script src="highcharts/exporting.src.js"  type="text/javascript"></script>--%>
<%--<script src="highcharts/data.src.js" type="text/javascript"></script>--%>

<script src="${pageContext.request.contextPath}/highcharts/highcharts.js"></script>
<script src="${pageContext.request.contextPath}/highcharts/exporting.js"></script>

<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>

</body>
</html>
