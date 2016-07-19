var chartsOption = {
	theme1 : {
		options : [
				{
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
						name : '业务指标',
						type : 'gauge',
						detail : {
							formatter : '{value}%'
						},
						data : [ {
							value : 50,
							name : '完成率'
						} ]
					} ]
				},
				{
					title : {
						text : '蒸发量和降水量',
						subtext : '纯属虚构'
					},
					tooltip : {
						trigger : 'axis'
					},
					legend : {
						data : [ '蒸发量', '降水量' ]
					},
					toolbox : {
						show : false,
						feature : {
							mark : {
								show : true
							},
							dataView : {
								show : true,
								readOnly : false
							},
							magicType : {
								show : true,
								type : [ 'line', 'bar' ]
							},
							restore : {
								show : true
							},
							saveAsImage : {
								show : true
							}
						}
					},
					calculable : true,
					xAxis : [ {
						type : 'category',
						data : [ '1月', '2月', '3月', '4月', '5月', '6月', '7月',
								'8月', '9月', '10月', '11月', '12月' ]
					} ],
					yAxis : [ {
						type : 'value'
					} ],
					series : [
							{
								name : '蒸发量',
								type : 'bar',
								data : [ 2.0, 4.9, 7.0, 23.2, 25.6, 76.7,
										135.6, 162.2, 32.6, 20.0, 6.4, 3.3 ],
								markPoint : {
									data : [ {
										type : 'max',
										name : '最大值'
									}, {
										type : 'min',
										name : '最小值'
									} ]
								},
								markLine : {
									data : [ {
										type : 'average',
										name : '平均值'
									} ]
								}
							},
							{
								name : '降水量',
								type : 'bar',
								data : [ 2.6, 5.9, 9.0, 26.4, 28.7, 70.7,
										175.6, 182.2, 48.7, 18.8, 6.0, 2.3 ],
								markPoint : {
									data : [ {
										name : '年最高',
										value : 182.2,
										xAxis : 7,
										yAxis : 183,
										symbolSize : 18
									}, {
										name : '年最低',
										value : 2.3,
										xAxis : 11,
										yAxis : 3
									} ]
								},
								markLine : {
									data : [ {
										type : 'average',
										name : '平均值'
									} ]
								}
							} ]
				},

				{
					title : {
						text : '某站点用户访问来源',
						subtext : '纯属虚构',
						x : 'center'
					},
					tooltip : {
						trigger : 'item',
						formatter : "{a} <br/>{b} : {c} ({d}%)"
					},
					legend : {
						orient : 'vertical',
						x : 'left',
						data : [ '直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎' ]
					},
					toolbox : {
						show : false,
						feature : {
							mark : {
								show : true
							},
							dataView : {
								show : true,
								readOnly : false
							},
							magicType : {
								show : true,
								type : [ 'pie', 'funnel' ],
								option : {
									funnel : {
										x : '25%',
										width : '50%',
										funnelAlign : 'left',
										max : 1548
									}
								}
							},
							restore : {
								show : true
							},
							saveAsImage : {
								show : true
							}
						}
					},
					calculable : true,
					series : [ {
						name : '访问来源',
						type : 'pie',
						radius : '55%',
						center : [ '50%', '60%' ],
						data : [ {
							value : 335,
							name : '直接访问'
						}, {
							value : 310,
							name : '邮件营销'
						}, {
							value : 234,
							name : '联盟广告'
						}, {
							value : 135,
							name : '视频广告'
						}, {
							value : 1548,
							name : '搜索引擎'
						} ]
					} ]
				},
				{
					title : {
						text : '未来一周气温变化',
						subtext : '纯属虚构'
					},
					tooltip : {
						trigger : 'axis'
					},
					legend : {
						data : [ '最高气温', '最低气温' ]
					},
					toolbox : {
						show : false,
						feature : {
							mark : {
								show : true
							},
							dataView : {
								show : true,
								readOnly : false
							},
							magicType : {
								show : true,
								type : [ 'line', 'bar' ]
							},
							restore : {
								show : true
							},
							saveAsImage : {
								show : true
							}
						}
					},
					calculable : true,
					xAxis : [ {
						type : 'category',
						boundaryGap : false,
						data : [ '周一', '周二', '周三', '周四', '周五', '周六', '周日' ]
					} ],
					yAxis : [ {
						type : 'value',
						axisLabel : {
							formatter : '{value} °C'
						}
					} ],
					series : [ {
						name : '最高气温',
						type : 'line',
						data : [ 11, 11, 15, 13, 12, 13, 10 ],
						markPoint : {
							data : [ {
								type : 'max',
								name : '最大值'
							}, {
								type : 'min',
								name : '最小值'
							} ]
						},
						markLine : {
							data : [ {
								type : 'average',
								name : '平均值'
							} ]
						}
					} ]
				},

				{
					color : [ 'rgba(255, 69, 0, 0.5)',
							'rgba(255, 150, 0, 0.5)', 'rgba(255, 200, 0, 0.5)',
							'rgba(155, 200, 50, 0.5)',
							'rgba(55, 200, 100, 0.5)' ],
					title : {
						text : '漏斗图',
						subtext : '纯属虚构'
					},
					tooltip : {
						trigger : 'item',
						formatter : "{a} <br/>{b} : {c}%"
					},
					toolbox : {
						show : false,
						feature : {
							mark : {
								show : true
							},
							dataView : {
								show : true,
								readOnly : false
							},
							restore : {
								show : true
							},
							saveAsImage : {
								show : true
							}
						}
					},
					legend : {
						data : [ '展现', '点击', '访问', '咨询', '订单' ]
					},
					calculable : true,
					series : [ {
						name : '预期',
						type : 'funnel',
						x : '10%',
						width : '80%',
						itemStyle : {
							normal : {
								label : {
									formatter : '{b}预期'
								},
								labelLine : {
									show : false
								}
							},
							emphasis : {
								label : {
									position : 'inside',
									formatter : '{b}预期 : {c}%'
								}
							}
						},
						data : [ {
							value : 60,
							name : '访问'
						}, {
							value : 40,
							name : '咨询'
						}, {
							value : 20,
							name : '订单'
						}, {
							value : 80,
							name : '点击'
						}, {
							value : 100,
							name : '展现'
						} ]
					}, {
						name : '实际',
						type : 'funnel',
						x : '10%',
						width : '80%',
						maxSize : '80%',
						itemStyle : {
							normal : {
								borderColor : '#fff',
								borderWidth : 2,
								label : {
									position : 'inside',
									formatter : '{c}%',
									textStyle : {
										color : '#fff'
									}
								}
							},
							emphasis : {
								label : {
									position : 'inside',
									formatter : '{b}实际 : {c}%'
								}
							}
						},
						data : [ {
							value : 30,
							name : '访问'
						}, {
							value : 10,
							name : '咨询'
						}, {
							value : 5,
							name : '订单'
						}, {
							value : 50,
							name : '点击'
						}, {
							value : 80,
							name : '展现'
						} ]
					} ]
				} ]
	}
};
