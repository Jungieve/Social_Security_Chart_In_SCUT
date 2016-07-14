var echart, myChart, charts = { length: 5 };
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
		$('.right-content .single').hide();
		$('.right-content .multi').show();
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
		console.log($(this).parent().parent().siblings(".active").length);
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
	
	myChart = echart.init(document.getElementById('chartMain'));
	
	if(!data.type) {
		myChart.setOption(data);
	}else {
		switch(data.type) {
			case 'gauge': 
				setGaugeOption(data.data);
				break;
			default:
		}
	}
}

//设置仪表盘option
function setGaugeOption(data) {
	var option = {
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
			name : '失业保险覆盖率',
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
		value : data[0].total,
		name : data[0].year + "覆盖率"
	};
	
	myChart.setOption(option);
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