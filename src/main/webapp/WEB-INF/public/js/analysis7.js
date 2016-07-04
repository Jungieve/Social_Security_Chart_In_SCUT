/**
 * Created by clin on 16/4/26.
 */
/**
 * Created by clin on 16/4/26.
 */
$(function () {
    $(".icn_photo").find("a").on("click",js_method);
    function js_method(){
        js1();
        js2();
        js3();
    }
    function js1() {
        $('#container').highcharts({
            credits:{
                enabled:false // 禁用版权信息
            },
            title: {
                text: '2013—2015年度失业保险参保总金额',
                x: -20 //center
            },

            xAxis: {
                categories: ['2013', '2014', '2015']
            },
            yAxis: {
                title: {
                    text: '金额(元)'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            tooltip: {
                valueSuffix: ''
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle',
                borderWidth: 0
            },
            series: [{
                name: '总金额',
                data: [1260, 22764, 19992]
            },{
                name: '总金额/男',
                data: [1260, 7770, 0]
            },{
                name: '总金额/女',
                data: [0, 14994, 19992]}
            ]
        });
    }
    function js2(){$('#container1').highcharts({
        credits:{
            enabled:false // 禁用版权信息
        },
        chart: {
            type: 'column'
        },
        title: {
            text: '2013—2015年度失业保险参保总金额'
        },

        xAxis: {
            categories: ['2013', '2014', '2015']
        },
        yAxis: {
            min: 0,
            title: {
                text: '金额(元) '
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
            '<td style="padding:0"><b>{point.y:.1f}</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: '总金额/男',
            data: [1260, 7770, 0]
        },{
            name: '总金额/女',
            data: [0, 14994, 19992]}
        ]
    });
    }
    function js3(){$(function () {
        $('#container2').highcharts({
            credits:{
                enabled:false // 禁用版权信息
            },
            chart: {
                plotBackgroundColor: null,
                plotBorderWidth: null,
                plotShadow: false
            },
            title: {
                text: '男女金额占比'
            },
            tooltip: {
                pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
            },
            plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: true,
                        color: '#000000',
                        connectorColor: '#000000',
                        format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                    }
                }
            },
            series: [{
                type: 'pie',
                name: '性别',
                data: [
                    ['男',  50.5],
                    ['女',  79.5],

                ]
            }]
        });
    });
    }
});
