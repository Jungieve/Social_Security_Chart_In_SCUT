var echart, myChart, charts = { length: 6 };
var timer = null; //主要用于仪表盘等定时器的句柄，每当新的展示需要重置操作
//chart1, chart2, chart3, chart4, chart5
var mapGeoData; //用于保存地图数据
var isInit = true; //用于初始化处理单独显示的div宽高获取不到的情况


//初始化设置
$(function() {
	
	$(".tablesorter").tablesorter();

	//When page loads...
	$(".tab_content").hide(); //Hide all content
	$("ul.tabs li:first").addClass("active").show(); //Activate first tab
	$(".tab_content:first").show(); //Show first tab content

	//On Click Event
	$("ul.tabs li").click(function() {

		$("ul.tabs li").removeClass("active ");//Remove any "active" class
		$(this).addClass("active"); //Add "active" class to selected tab
		$(".tab_content").hide(); //Hide all tab content

		var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
		$(activeTab).fadeIn(); //Fade in the active ID content
		return false;
	});

	$('.column').equalHeight();

/**** 用于绑定处理点击事件 ****/
	//主题点击
	$('.item').on('click', function() {
		//清除定时器
		clearInterval(timer);
		
		$('.right-content .single').hide();
		$('.right-content .multi').show();
		$('.sub-item-wrap.active').removeClass('active');
		var self = $(this);
		if(!self.hasClass('active')) {
			$('.sub-' + $('.item.active').data('index')).slideToggle();
			$('.item.active').removeClass('active');
			self.addClass('active');
			$('.sub-' + self.data('index')).slideToggle();
		}
		
		setMultiCharts();
	});
	
	//子主题的点击
	$(document).on('click', '.sub-item-wrap .type', function() {
		//清除定时器
		clearInterval(timer);

		$('.sub-item-wrap.active').removeClass('active');
		$(this).parent().addClass('active');
		var param = {};
		param.url = $(this).data('url');
		getAjax(param);
	});
	
/****     结束配置    ****/
});

/*** 进行设置多图展示的函数 ***/
function setMultiCharts() {
	var active = $('.item.active');
	var themeId = active.data('id');
	
	var options = chartsOption[themeId].options;
	//将多余的展示div设置成不可见
	if(options.length < charts.length) {
		var diff = options.length + 1;
		for(diff; diff <= charts.length; diff++ ) {
			$('#chart' + diff).css('visibility','hidden');
		}
	}
	
	var index = 1;
	$.each(options, function(key, value) {
		$('#chart' + index).css('visibility','visible');
		//初始化用于获得设置echarts的句柄
		charts['chart'+index] = echart.init(document.getElementById('chart'+index));
		charts['chart'+index].setOption(value);
		index++;
	});
	
	if(isInit) {
		//这样写是为了能够让echarts能够得到所设置的width，而不是使用默认的width。 设置完毕后进行hide隐藏掉
		$('.right-content .single').css('visibility','visible').hide();
		isInit = false;
	}
	
	hideLoading();
	
}
/*** 结束定义 ***/

/*** 设置进行ajax访问请求 ***/
function getAjax(param) {
	showLoading();
	
//	$.ajax({
//		type: 'get',
//		url: param.url,
//		async: true,
//		dataType: 'json',
//		success: function(res) {
//			formatOptionConfig(res);
//			hideLoading();
//		},
//		error: function(err) {
//			alert("ajax请求错误： " + JSON.stringify(err));
//			hideLoading();
//		}
//	});
	
	$.get(param.url, function (res) {
        formatOptionConfig(res);
		hideLoading();
    });
}
/*** 结束设置 ***/

/*** 设置option处理函数 ***/
function formatOptionConfig(data) {
	$('.right-content .single').show();
	$('.right-content .multi').hide();
	
	//初始化用于获得设置echarts的句柄
	myChart = echart.init(document.getElementById('chartMain'));
	
	if(!data.type) {
		myChart.setOption(eval('('+ data+')'));
	}else {
		switch(data.type) {
			case 'gauge': 
				setGaugeOption(data);
				break;
			default:
		}
	}
}

//设置仪表盘option
function setGaugeOption(obj) {
	var type = $('.item.active label').html().substring(0,4);
	var data = obj.data;
	var option = null;
	
	//修改仪表盘的样式
	switch(type) {
		case '养老保险':
			option = {
				title : {
			        text: type+'年份覆盖率',
			        x:'center'
			    },
			    tooltip : {
			        formatter: "{a} <br/>{b} : {c}%"
			    },
			    toolbox: {
			        show : false,
			        feature : {
			            mark : {show: true},
			            restore : {show: true},
			            saveAsImage : {show: true}
			        }
			    },
			    series : [
			        {
			            name:type+'覆盖率',
			            type:'gauge',
			            center : ['50%', '50%'],    // 默认全局居中
			            radius : [0, '75%'],
			            startAngle: 140,
			            endAngle : -140,
			            min: 0,                     // 最小值
			            max: 100,                   // 最大值
			            precision: 0,               // 小数精度，默认为0，无小数点
			            splitNumber: 10,             // 分割段数，默认为5
			            axisLine: {            // 坐标轴线
			                show: true,        // 默认显示，属性show控制显示与否
			                lineStyle: {       // 属性lineStyle控制线条样式
			                    color: [[0.2, 'lightgreen'],[0.8, 'skyblue'],[1, '#ff4500']], 
			                    width: 30
			                }
			            },
			            axisTick: {            // 坐标轴小标记
			                show: true,        // 属性show控制显示与否，默认不显示
			                splitNumber: 5,    // 每份split细分多少段
			                length :8,         // 属性length控制线长
			                lineStyle: {       // 属性lineStyle控制线条样式
			                    color: '#eee',
			                    width: 1,
			                    type: 'solid'
			                }
			            },
			            axisLabel: {           // 坐标轴文本标签，详见axis.axisLabel
			                show: true,
			                formatter: function(v){
			                    switch (v+''){
			                        case '10': return '低';
			                        case '50': return '中';
			                        case '90': return '高';
			                        default: return '';
			                    }
			                },
			                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
			                    color: '#333'
			                }
			            },
			            splitLine: {           // 分隔线
			                show: true,        // 默认显示，属性show控制显示与否
			                length :30,         // 属性length控制线长
			                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
			                    color: '#eee',
			                    width: 2,
			                    type: 'solid'
			                }
			            },
			            pointer : {
			                length : '80%',
			                width : 8,
			                color : 'auto'
			            },
			            title : {
			                show : true,
			                offsetCenter: ['-65%', -10],       // x, y，单位px
			                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
			                    color: '#333',
			                    fontSize : 15
			                }
			            },
			            detail : {
			                show : true,
			                backgroundColor: 'rgba(0,0,0,0)',
			                borderWidth: 0,
			                borderColor: '#ccc',
			                width: 100,
			                height: 40,
			                offsetCenter: ['-60%', 10],       // x, y，单位px
			                formatter:'{value}%',
			                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
			                    color: 'auto',
			                    fontSize : 30
			                }
			            },
			            data:[{value: 0, name: '覆盖率'}]
			        }
			    ]
			};
			break;
			
		case '失业保险':
			option = {
				title : {
			        text: type+'年份覆盖率',
			        x:'center'
			    },
			    tooltip : {
			        formatter: "{a} <br/>{b} : {c}%"
			    },
			    toolbox: {
			        show : false,
			        feature : {
			            mark : {show: true},
			            restore : {show: true},
			            saveAsImage : {show: true}
			        }
			    },
			    series : [
			        {
			            name:type+'覆盖率',
			            type:'gauge',
			            startAngle: 180,
			            endAngle: 0,
			            center : ['50%', '90%'],    // 默认全局居中
			            radius : 320,
			            axisLine: {            // 坐标轴线
			                lineStyle: {       // 属性lineStyle控制线条样式
			                    width: 200
			                }
			            },
			            axisTick: {            // 坐标轴小标记
			                splitNumber: 10,   // 每份split细分多少段
			                length :12,        // 属性length控制线长
			            },
			            axisLabel: {           // 坐标轴文本标签，详见axis.axisLabel
			                formatter: function(v){
			                    switch (v+''){
			                        case '10': return '低';
			                        case '50': return '中';
			                        case '90': return '高';
			                        default: return '';
			                    }
			                },
			                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
			                    color: '#fff',
			                    fontSize: 15,
			                    fontWeight: 'bolder'
			                }
			            },
			            pointer: {
			                width:50,
			                length: '90%',
			                color: 'rgba(255, 255, 255, 0.8)'
			            },
			            title : {
			                show : true,
			                offsetCenter: [0, '-60%'],       // x, y，单位px
			                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
			                    color: '#fff',
			                    fontSize: 30
			                }
			            },
			            detail : {
			                show : true,
			                backgroundColor: 'rgba(0,0,0,0)',
			                borderWidth: 0,
			                borderColor: '#ccc',
			                width: 100,
			                height: 40,
			                offsetCenter: [0, -40],       // x, y，单位px
			                formatter:'{value}%',
			                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
			                    fontSize : 50
			                }
			            },
			            data:[{value: 0, name: '覆盖率'}]
			        }
			    ]
			};
			break;
			
			default:
				option = {
					title : {
						text : type+'覆盖率',
						x : 'center'
					},
					tooltip : {
						formatter : "{a} <br/>{b} : {c}%"
					},
					toolbox : {
						show : false,
						feature : {
							mark : {
								show : true
							},
							restore : {
								show : true
							},
							saveAsImage : {
								show : true
							}
						}
					},
					series : [ {
						name : type+'覆盖率',
						type : 'gauge',
						detail : {
							formatter : '{value}%'
						},
						data : [ {
							value : 0,
							name : '覆盖率'
						} ]
					} ]
			};
	}
	
	
	option.series[0].data[0] = {
		value : (data[0].total / obj.total * 100).toFixed(2) - 0,
		name : data[0].year + '年' + type + "覆盖率"
	};
	
	myChart.setOption(option);
	
	var dataIndex = 1; //用于记录数据的展示索引
	timer = setInterval(function() {
		if(dataIndex >= data.length) {
			dataIndex = 0;
		}
		
		option.series[0].data[0] = {
			value : (data[dataIndex].total / obj.total * 100).toFixed(2) - 0,
			name : data[dataIndex].year + '年' + type + "覆盖率"
		};
		dataIndex++;
		myChart.setOption(option, true);
	}, 2000);
}
/*** 结束设置 ***/

/*** loading动画 ***/
//加载loading
function showLoading() {
	$('.spinner').show();
}
//结束loading
function hideLoading() {
	$('.spinner').hide();
}
/*** 结束设置 ***/

// 路径配置
require.config({
	paths : {
		'echarts': 'http://echarts.baidu.com/build/dist',
        'echarts-x': 'js/echarts-x-0.2.0/build/dist'
	}
});

require([ 'echarts', 'echarts/chart/gauge', 'echarts/chart/bar', 
          'echarts/chart/pie', 'echarts/chart/line', 'echarts/chart/funnel',
          'echarts/chart/wordCloud', 'echarts/chart/venn', 'echarts/chart/radar',
          
          'echarts/chart/map'   // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
          ], 
function(ec) {
	
	//将echart的实例保存起来用于下次更换图表的再次初始化
	echart = ec;
	
	//获取地图数据
	mapGeoData = require('echarts/util/mapData/params');
	mapGeoData.params.jiangmen = {
      getGeoJson: function (callback) {
          $.getJSON('jsons/jiangmen.json', function (data) {
              // 压缩后的地图数据必须使用 decode 函数转换
              callback(mapGeoData.decode(data));
          });
      }
	};
	
	setMultiCharts();
});