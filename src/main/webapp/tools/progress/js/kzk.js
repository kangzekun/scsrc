var progressTimer=null;

function scsrcprogress() {
    $('#scsrc-all-iterations').html('');
    $('#scsrc-single-iterations').html('');
    var $pb = $('#h-center-basic .progress-bar');
    $.ajax( {
        url : "/rest/spark/getIteration",
        type:'GET',
        dataType:"json",
//            data:{progressValue:$pb.attr('data-transitiongoal')},
        success : function(data) {
            $('#scsrc-all-iterations').html("40");
            $('#scsrc-single-iterations').html(data + " / 40");
            if((data* (100/40))>=100) {
                $pb.attr('data-transitiongoal',100);
                $("#h-basic-exec").removeAttr("disabled");
                window.clearInterval(progressTimer);
            }else {
                $pb.attr('data-transitiongoal',data* (100/40));
            }
            $pb.progressbar({display_text: 'center', use_percentage: false});
        }
    } );
}

function execscsrc() {
    $.ajax( {
        url : "/rest/spark/sparkShow",
        dataType:"json",
        success : function(data) {
            var dtol = data.dtol;
            var iter = data.iter;

            $('#scsrc-img').attr('src', 'imgs/classifiedImage.jpg');

            Highcharts.chart('scsrc-chart-container', {
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
}

$(document).ready(function() {
        $('select:not(.ignore)').niceSelect();
        FastClick.attach(document.body);
    $('#h-basic-exec').click(function() {
        $("#h-basic-exec").attr({"disabled":"disabled"});
        $('#h-center-basic .progress-bar').attr('data-transitiongoal', 0).progressbar({display_text: 'center'});
        progressTimer = window.setInterval(scsrcprogress,500);
        execscsrc();
    });
});