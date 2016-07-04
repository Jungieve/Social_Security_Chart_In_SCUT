/**
 * Created by Allen on 2016/4/26.
 */
$(function () {
    $('#container').highcharts({
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
            name: 'year',
            data: [2831,
                3797,
                3163,
                4136,
                3164,
                2908
            ]
        }, {
            name: '男',
            data: [1557,2043,1622,2158,1590,1391]

        }, {
            name: '女',
            data: [1274,1754,1541,1978,1574,1517]

        },]
    });
});
