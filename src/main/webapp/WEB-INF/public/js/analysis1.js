/**
 * Created by clin on 16/4/26.
 */
$(function () {
    $(".icn_edit_article").find("a").on("click",js_method);
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
                text: '2005—2010年度养老保险参保总金额',
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
                name: '总金额',
                data: [2007028.45, 3263756.50, 2975047.97, 4484343.65, 4005491.00,3875394.32]
            },{
                name: '总金额/男',
                data: [1275273.7, 1957887.5, 1753995.57, 2701179.17, 2369165.52,2146081.59]
            },{
                name: '总金额/女',
                data: [731754.75, 1305869, 1221052.4, 1783164.48, 1636325.48,1729312.73]
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
            text: '2005—2010年度养老保险参保总金额'
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
            name: '总金额/男',
            data: [1275273.7, 1957887.5, 1753995.57, 2701179.17, 2369165.52,2146081.59]
        },{
            name: '总金额/女',
            data: [731754.75, 1305869, 1221052.4, 1783164.48, 1636325.48,1729312.73]
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
                    ['男',  59.3],
                    ['女',  40.7],

                ]
            }]
        });
    });
    }
});
