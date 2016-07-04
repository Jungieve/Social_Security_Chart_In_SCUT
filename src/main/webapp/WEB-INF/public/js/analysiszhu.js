/**
 * Created by Allen on 2016/4/26.
 */
$(function () {
    $('#container1').highcharts({
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
});				