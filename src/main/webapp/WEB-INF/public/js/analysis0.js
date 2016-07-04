/**
 * Created by clin on 16/4/26.
 */

function js_method0(){
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
            text: '2005—2010年度养老保险参保人数',
            x: -20 //center
        },

        xAxis: {
            categories: ['2005', '2006', '2007', '2008', '2009', '2010']
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
            name: '总人数',
            data: [2831,
                3797,
                3163,
                4136,
                3164,
                2908
            ]
        }, {
            name: '男',
            data: [1557, 2043, 1622, 2158, 1590, 1391]

        }, {
            name: '女',
            data: [1274, 1754, 1541, 1978, 1574, 1517]

        },]
    });
}
function js2(){$('#container1').highcharts({   //柱状图
    credits:{
        enabled:false // 禁用版权信息
    },
    chart: {
        type: 'column'
    },
    title: {
        text: '2005—2010年度养老保险参保人数'
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
        name: '男',
        data: [1557,2043,1622,2158,1590,2908]

    }, {
        name: '女',
        data: [1274,1754,1541,1978,1574,1517]

    },]
});
}
function js3(){$(function () {    //饼状图
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
                ['男',  51.8],
                ['女',  48.2],

            ]
        }]
    });
});
}

$(function () {  //  折线图

    $(".icn_new_article").find("a").on("click",js_method0);
   
});
