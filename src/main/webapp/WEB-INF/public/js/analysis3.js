/**
 * Created by clin on 16/4/26.
 */
/**
 * Created by clin on 16/4/26.
 */


$(function () {
    $(".icn_add_user").find("a").on("click",js_method);
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
                text: '2010—2015年度医疗保险参保人数',
                x: -20 //center
            },

            xAxis: {
                categories: ['2010', '2011', '2012', '2013', '2014', '2015']
            },
            yAxis: {
                title: {
                    text: '人数'
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
                name: '人数',
                data: [10, 274, 603, 781, 964,1412]
            },{
                name: '人数/男',
                data: [9, 169, 430, 574, 657,967]
            },{
                name: '人数/女',
                data: [1, 105, 173, 207, 307,445]}
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
            text: '2010—2015年度医疗保险参保人数'
        },

        xAxis: {
            categories: ['2010', '2011', '2012', '2013', '2014', '2015']
        },
        yAxis: {
            min: 0,
            title: {
                text: '人数 '
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
            name: '人数/男',
            data: [9, 169, 430, 574, 657,967]
        },{
            name: '人数/女',
            data: [1, 105, 173, 207, 307,445]}
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
                text: '男女人数占比'
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
                    ['男',  69.4],
                    ['女',  30.6],

                ]
            }]
        });
    });
    }
});
