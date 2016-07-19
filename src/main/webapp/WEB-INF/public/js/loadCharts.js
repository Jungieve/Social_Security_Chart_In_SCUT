var echart, myChart, charts = { length: 5 };
var timer = null; //主要用于仪表盘等定时器的句柄，每当新的展示需要重置操作
//chart1, chart2, chart3, chart4, chart5


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
		//初始化用于获得设置echarts的句柄
		charts['chart'+index] = echart.init(document.getElementById('chart'+index));
		charts['chart'+index].setOption(value);
		index++;
	});
	
	//这样写是为了能够让echarts能够得到所设置的width，而不是使用默认的width。 设置完毕后进行hide隐藏掉
	$('.right-content .single').css('visibility','visible').hide();
	
	hideLoading();
	
}
/*** 结束定义 ***/

/*** 设置进行ajax访问请求 ***/
function getAjax(param) {
	showLoading();
	
	$.ajax({
		type: 'get',
		url: param.url,
		async: true,
		dataType: 'json',
		success: function(res) {
			formatOptionConfig(res);
			hideLoading();
		},
		error: function(err) {
			alert("ajax请求错误： " + err);
			hideLoading();
		}
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
		myChart.setOption(data);
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
	var option = {
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
		echarts : 'http://echarts.baidu.com/build/dist',
	}
});

require([ 'echarts', 'echarts/chart/gauge', 'echarts/chart/bar', 'echarts/chart/pie', 'echarts/chart/line', 'echarts/chart/funnel' ], function(ec) {
	//初始化用于获得设置echarts的句柄
//	myChart = ec.init(document.getElementById('chartMain'));
//	charts.chart1  = ec.init(document.getElementById('chart1'));
//	charts.chart2  = ec.init(document.getElementById('chart2'));
//	charts.chart3  = ec.init(document.getElementById('chart3'));
//	charts.chart4  = ec.init(document.getElementById('chart4'));
//	charts.chart5  = ec.init(document.getElementById('chart5'));
	
	//将echart的实例保存起来用于下次更换图表的再次初始化
	echart = ec;
	
	setMultiCharts();
});