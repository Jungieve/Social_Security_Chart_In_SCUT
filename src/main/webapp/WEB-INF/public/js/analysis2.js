/**
 * Created by clin on 16/4/26.
 */
/**
 * Created by clin on 16/4/26.
 */
$(function () {
    $(".icn_categories").find("a").on("click",js_method);
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
                text: '2005—2010年度养老保险参保平均金额',
                x: -20 //center
            },

            xAxis: {
                categories: ['2005', '2006', '2007', '2008', '2009', '2010']
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
                name: '平均金额',
                data: [
                    708.94, 859.56, 940.87, 1084.22, 1265.95,1332.66]
            },{
                name: '平均金额/男',
                data: [819.05, 958.33, 1082.04, 1251.7, 1490.04,1542.83]
            },{
                name: '平均金额/女',
                data: [574.37, 744.5, 792.37, 901.49, 1039.59,1139.95]
            }
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
            text: '2005—2010年度养老保险参保平均金额'
        },

        xAxis: {
            categories: [
                '2005',
                '2006',
                '2007',
                '2008',
                '2009',
                '2010',

            ]
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
            name: '平均金额/男',
            data: [819.05, 958.33, 1082.04, 1251.7, 1490.04,1542.83]
        },{
            name: '平均金额/女',
            data: [574.37, 744.5, 792.37, 901.49, 1039.59,1139.95]
        }
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
                text: '男女平均金额占比'
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
                    ['男',  58.0],
                    ['女',  42.0],

                ]
            }]
        });
    });
    }
});
