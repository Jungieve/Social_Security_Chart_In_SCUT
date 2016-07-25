var chartsOption = {
	theme1 : {
		options : [
				{	
					title: {
						text: '仪表盘样例'
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
						name : '社保指标',
						type : 'gauge',
						detail : {
							formatter : '{value}%'
						},
						data : [ {
							value : 50,
							name : '参保率'
						} ]
					} ]
				},
				{
					title : {
						text : '柱状图样例',
						subtext : ''
					},
					tooltip : {
						trigger : 'axis'
					},
					legend : {
						data : [ '险种1', '险种2' ]
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
								name : '险种1',
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
								name : '险种2',
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
						text : '社保展示',
						subtext : '',
						x : 'center'
					},
					tooltip : {
						trigger : 'item'
					},
					dataRange : {
						min : 0,
						max : 2500,
						x : 'left',
						y : 'bottom',
						text : [ '高', '低' ], // 文本，默认为数值文本
						calculable : false
					},
					toolbox : {
						show : false,
						orient : 'vertical',
						x : 'right',
						y : 'center',
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
					roamController : {
						show : true,
						x : 'right',
						mapTypeControl : {
							'china' : true
						}
					},
					series : [ {
						name : 'iphone3',
						type : 'map',
						mapType : 'china',
						roam : false,
						itemStyle : {
							normal : {
								label : {
									show : true
								}
							},
							emphasis : {
								label : {
									show : true
								}
							}
						},
						data : [ {
							name : '北京',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '天津',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '上海',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '重庆',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '河北',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '河南',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '云南',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '辽宁',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '黑龙江',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '湖南',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '安徽',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '山东',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '新疆',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '江苏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '浙江',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '江西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '湖北',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '广西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '甘肃',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '山西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '内蒙古',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '陕西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '吉林',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '福建',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '贵州',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '广东',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '青海',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '西藏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '四川',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '宁夏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '海南',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '台湾',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '香港',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '澳门',
							value : Math.round(Math.random() * 1000)
						} ]
					}, {
						name : 'iphone4',
						type : 'map',
						mapType : 'china',
						itemStyle : {
							normal : {
								label : {
									show : true
								}
							},
							emphasis : {
								label : {
									show : true
								}
							}
						},
						data : [ {
							name : '北京',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '天津',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '上海',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '重庆',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '河北',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '安徽',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '新疆',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '浙江',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '江西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '山西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '内蒙古',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '吉林',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '福建',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '广东',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '西藏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '四川',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '宁夏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '香港',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '澳门',
							value : Math.round(Math.random() * 1000)
						} ]
					}, {
						name : 'iphone5',
						type : 'map',
						mapType : 'china',
						itemStyle : {
							normal : {
								label : {
									show : true
								}
							},
							emphasis : {
								label : {
									show : true
								}
							}
						},
						data : [ {
							name : '北京',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '天津',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '上海',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '广东',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '台湾',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '香港',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '澳门',
							value : Math.round(Math.random() * 1000)
						} ]
					} ]
				},
				{
					title : {
						text : '折线图样例',
						subtext : ''
					},
					tooltip : {
						trigger : 'axis'
					},
					legend : {
						data : [ '险种1', '险种2' ]
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
						name : '险种1',
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
						text : '漏斗图样例',
						subtext : ''
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
						data : [ '险种1', '险种2', '险种3', '险种4', '险种5' ]
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
							name : '险种3'
						}, {
							value : 40,
							name : '险种4'
						}, {
							value : 20,
							name : '险种5'
						}, {
							value : 80,
							name : '险种2'
						}, {
							value : 100,
							name : '险种1'
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
							name : '险种3'
						}, {
							value : 10,
							name : '险种4'
						}, {
							value : 5,
							name : '险种5'
						}, {
							value : 50,
							name : '险种2'
						}, {
							value : 80,
							name : '险种1'
						} ]
					} ]
				} ]
	},

	theme2 : {
		options : [
				{
					title: {
						text: '仪表盘样例'
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
						name : '社保指标',
						type : 'gauge',
						detail : {
							formatter : '{value}%'
						},
						data : [ {
							value : 50,
							name : '参保率'
						} ]
					} ]
				},
				{
					title : {
						text : '柱状图样例',
						subtext : ''
					},
					tooltip : {
						trigger : 'axis'
					},
					legend : {
						data : [ '险种1', '险种2' ]
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
								name : '险种1',
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
								name : '险种2',
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
						text : '社保展示',
						subtext : '',
						x : 'center'
					},
					tooltip : {
						trigger : 'item'
					},
					dataRange : {
						min : 0,
						max : 2500,
						x : 'left',
						y : 'bottom',
						text : [ '高', '低' ], // 文本，默认为数值文本
						calculable : false
					},
					toolbox : {
						show : false,
						orient : 'vertical',
						x : 'right',
						y : 'center',
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
					roamController : {
						show : true,
						x : 'right',
						mapTypeControl : {
							'china' : true
						}
					},
					series : [ {
						name : 'iphone3',
						type : 'map',
						mapType : 'china',
						roam : false,
						itemStyle : {
							normal : {
								label : {
									show : true
								}
							},
							emphasis : {
								label : {
									show : true
								}
							}
						},
						data : [ {
							name : '北京',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '天津',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '上海',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '重庆',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '河北',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '河南',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '云南',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '辽宁',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '黑龙江',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '湖南',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '安徽',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '山东',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '新疆',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '江苏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '浙江',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '江西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '湖北',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '广西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '甘肃',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '山西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '内蒙古',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '陕西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '吉林',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '福建',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '贵州',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '广东',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '青海',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '西藏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '四川',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '宁夏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '海南',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '台湾',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '香港',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '澳门',
							value : Math.round(Math.random() * 1000)
						} ]
					}, {
						name : 'iphone4',
						type : 'map',
						mapType : 'china',
						itemStyle : {
							normal : {
								label : {
									show : true
								}
							},
							emphasis : {
								label : {
									show : true
								}
							}
						},
						data : [ {
							name : '北京',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '天津',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '上海',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '重庆',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '河北',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '安徽',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '新疆',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '浙江',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '江西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '山西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '内蒙古',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '吉林',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '福建',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '广东',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '西藏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '四川',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '宁夏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '香港',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '澳门',
							value : Math.round(Math.random() * 1000)
						} ]
					}, {
						name : 'iphone5',
						type : 'map',
						mapType : 'china',
						itemStyle : {
							normal : {
								label : {
									show : true
								}
							},
							emphasis : {
								label : {
									show : true
								}
							}
						},
						data : [ {
							name : '北京',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '天津',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '上海',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '广东',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '台湾',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '香港',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '澳门',
							value : Math.round(Math.random() * 1000)
						} ]
					} ]
				},
				{
					title : {
						text : '折线图样例',
						subtext : ''
					},
					tooltip : {
						trigger : 'axis'
					},
					legend : {
						data : [ '险种1', '险种2' ]
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
						name : '险种1',
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
						text : '漏斗图样例',
						subtext : ''
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
						data : [ '险种1', '险种2', '险种3', '险种4', '险种5' ]
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
							name : '险种3'
						}, {
							value : 40,
							name : '险种4'
						}, {
							value : 20,
							name : '险种5'
						}, {
							value : 80,
							name : '险种2'
						}, {
							value : 100,
							name : '险种1'
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
							name : '险种3'
						}, {
							value : 10,
							name : '险种4'
						}, {
							value : 5,
							name : '险种5'
						}, {
							value : 50,
							name : '险种2'
						}, {
							value : 80,
							name : '险种1'
						} ]
					} ]
				} ]
	},

	theme3 : {
		options : [
				{
					title: {
						text: '仪表盘样例'
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
						name : '社保指标',
						type : 'gauge',
						detail : {
							formatter : '{value}%'
						},
						data : [ {
							value : 50,
							name : '参保率'
						} ]
					} ]
				},
				{
					title : {
						text : '柱状图样例',
						subtext : ''
					},
					tooltip : {
						trigger : 'axis'
					},
					legend : {
						data : [ '险种1', '险种2' ]
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
								name : '险种1',
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
								name : '险种2',
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
						text : '社保展示',
						subtext : '',
						x : 'center'
					},
					tooltip : {
						trigger : 'item'
					},
					dataRange : {
						min : 0,
						max : 2500,
						x : 'left',
						y : 'bottom',
						text : [ '高', '低' ], // 文本，默认为数值文本
						calculable : false
					},
					toolbox : {
						show : false,
						orient : 'vertical',
						x : 'right',
						y : 'center',
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
					roamController : {
						show : true,
						x : 'right',
						mapTypeControl : {
							'china' : true
						}
					},
					series : [ {
						name : 'iphone3',
						type : 'map',
						mapType : 'china',
						roam : false,
						itemStyle : {
							normal : {
								label : {
									show : true
								}
							},
							emphasis : {
								label : {
									show : true
								}
							}
						},
						data : [ {
							name : '北京',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '天津',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '上海',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '重庆',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '河北',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '河南',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '云南',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '辽宁',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '黑龙江',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '湖南',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '安徽',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '山东',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '新疆',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '江苏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '浙江',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '江西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '湖北',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '广西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '甘肃',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '山西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '内蒙古',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '陕西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '吉林',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '福建',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '贵州',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '广东',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '青海',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '西藏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '四川',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '宁夏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '海南',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '台湾',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '香港',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '澳门',
							value : Math.round(Math.random() * 1000)
						} ]
					}, {
						name : 'iphone4',
						type : 'map',
						mapType : 'china',
						itemStyle : {
							normal : {
								label : {
									show : true
								}
							},
							emphasis : {
								label : {
									show : true
								}
							}
						},
						data : [ {
							name : '北京',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '天津',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '上海',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '重庆',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '河北',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '安徽',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '新疆',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '浙江',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '江西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '山西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '内蒙古',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '吉林',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '福建',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '广东',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '西藏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '四川',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '宁夏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '香港',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '澳门',
							value : Math.round(Math.random() * 1000)
						} ]
					}, {
						name : 'iphone5',
						type : 'map',
						mapType : 'china',
						itemStyle : {
							normal : {
								label : {
									show : true
								}
							},
							emphasis : {
								label : {
									show : true
								}
							}
						},
						data : [ {
							name : '北京',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '天津',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '上海',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '广东',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '台湾',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '香港',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '澳门',
							value : Math.round(Math.random() * 1000)
						} ]
					} ]
				},
				{
					title : {
						text : '折线图样例',
						subtext : ''
					},
					tooltip : {
						trigger : 'axis'
					},
					legend : {
						data : [ '险种1', '险种2' ]
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
						name : '险种1',
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
						text : '漏斗图样例',
						subtext : ''
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
						data : [ '险种1', '险种2', '险种3', '险种4', '险种5' ]
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
							name : '险种3'
						}, {
							value : 40,
							name : '险种4'
						}, {
							value : 20,
							name : '险种5'
						}, {
							value : 80,
							name : '险种2'
						}, {
							value : 100,
							name : '险种1'
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
							name : '险种3'
						}, {
							value : 10,
							name : '险种4'
						}, {
							value : 5,
							name : '险种5'
						}, {
							value : 50,
							name : '险种2'
						}, {
							value : 80,
							name : '险种1'
						} ]
					} ]
				} ]
	},

	theme4 : {
		options : [
				{
					title: {
						text: '仪表盘样例'
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
						name : '社保指标',
						type : 'gauge',
						detail : {
							formatter : '{value}%'
						},
						data : [ {
							value : 50,
							name : '参保率'
						} ]
					} ]
				},
				{
					title : {
						text : '柱状图样例',
						subtext : ''
					},
					tooltip : {
						trigger : 'axis'
					},
					legend : {
						data : [ '险种1', '险种2' ]
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
								name : '险种1',
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
								name : '险种2',
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
						text : '社保展示',
						subtext : '',
						x : 'center'
					},
					tooltip : {
						trigger : 'item'
					},
					dataRange : {
						min : 0,
						max : 2500,
						x : 'left',
						y : 'bottom',
						text : [ '高', '低' ], // 文本，默认为数值文本
						calculable : false
					},
					toolbox : {
						show : false,
						orient : 'vertical',
						x : 'right',
						y : 'center',
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
					roamController : {
						show : true,
						x : 'right',
						mapTypeControl : {
							'china' : true
						}
					},
					series : [ {
						name : 'iphone3',
						type : 'map',
						mapType : 'china',
						roam : false,
						itemStyle : {
							normal : {
								label : {
									show : true
								}
							},
							emphasis : {
								label : {
									show : true
								}
							}
						},
						data : [ {
							name : '北京',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '天津',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '上海',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '重庆',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '河北',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '河南',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '云南',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '辽宁',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '黑龙江',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '湖南',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '安徽',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '山东',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '新疆',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '江苏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '浙江',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '江西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '湖北',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '广西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '甘肃',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '山西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '内蒙古',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '陕西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '吉林',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '福建',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '贵州',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '广东',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '青海',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '西藏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '四川',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '宁夏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '海南',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '台湾',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '香港',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '澳门',
							value : Math.round(Math.random() * 1000)
						} ]
					}, {
						name : 'iphone4',
						type : 'map',
						mapType : 'china',
						itemStyle : {
							normal : {
								label : {
									show : true
								}
							},
							emphasis : {
								label : {
									show : true
								}
							}
						},
						data : [ {
							name : '北京',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '天津',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '上海',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '重庆',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '河北',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '安徽',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '新疆',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '浙江',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '江西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '山西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '内蒙古',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '吉林',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '福建',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '广东',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '西藏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '四川',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '宁夏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '香港',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '澳门',
							value : Math.round(Math.random() * 1000)
						} ]
					}, {
						name : 'iphone5',
						type : 'map',
						mapType : 'china',
						itemStyle : {
							normal : {
								label : {
									show : true
								}
							},
							emphasis : {
								label : {
									show : true
								}
							}
						},
						data : [ {
							name : '北京',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '天津',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '上海',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '广东',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '台湾',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '香港',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '澳门',
							value : Math.round(Math.random() * 1000)
						} ]
					} ]
				},
				{
					title : {
						text : '折线图样例',
						subtext : ''
					},
					tooltip : {
						trigger : 'axis'
					},
					legend : {
						data : [ '险种1', '险种2' ]
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
						name : '险种1',
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
						text : '漏斗图样例',
						subtext : ''
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
						data : [ '险种1', '险种2', '险种3', '险种4', '险种5' ]
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
							name : '险种3'
						}, {
							value : 40,
							name : '险种4'
						}, {
							value : 20,
							name : '险种5'
						}, {
							value : 80,
							name : '险种2'
						}, {
							value : 100,
							name : '险种1'
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
							name : '险种3'
						}, {
							value : 10,
							name : '险种4'
						}, {
							value : 5,
							name : '险种5'
						}, {
							value : 50,
							name : '险种2'
						}, {
							value : 80,
							name : '险种1'
						} ]
					} ]
				} ]
	},

	theme5 : {
		options : [
				{
					title: {
						text: '仪表盘样例'
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
						name : '社保指标',
						type : 'gauge',
						detail : {
							formatter : '{value}%'
						},
						data : [ {
							value : 50,
							name : '参保率'
						} ]
					} ]
				},
				{
					title : {
						text : '柱状图样例',
						subtext : ''
					},
					tooltip : {
						trigger : 'axis'
					},
					legend : {
						data : [ '险种1', '险种2' ]
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
								name : '险种1',
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
								name : '险种2',
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
						text : '社保展示样例',
						subtext : '',
						x : 'center'
					},
					tooltip : {
						trigger : 'item'
					},
					dataRange : {
						min : 0,
						max : 2500,
						x : 'left',
						y : 'bottom',
						text : [ '高', '低' ], // 文本，默认为数值文本
						calculable : false
					},
					toolbox : {
						show : false,
						orient : 'vertical',
						x : 'right',
						y : 'center',
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
					roamController : {
						show : true,
						x : 'right',
						mapTypeControl : {
							'china' : true
						}
					},
					series : [ {
						name : 'iphone3',
						type : 'map',
						mapType : 'china',
						roam : false,
						itemStyle : {
							normal : {
								label : {
									show : true
								}
							},
							emphasis : {
								label : {
									show : true
								}
							}
						},
						data : [ {
							name : '北京',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '天津',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '上海',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '重庆',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '河北',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '河南',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '云南',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '辽宁',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '黑龙江',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '湖南',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '安徽',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '山东',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '新疆',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '江苏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '浙江',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '江西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '湖北',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '广西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '甘肃',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '山西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '内蒙古',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '陕西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '吉林',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '福建',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '贵州',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '广东',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '青海',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '西藏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '四川',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '宁夏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '海南',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '台湾',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '香港',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '澳门',
							value : Math.round(Math.random() * 1000)
						} ]
					}, {
						name : 'iphone4',
						type : 'map',
						mapType : 'china',
						itemStyle : {
							normal : {
								label : {
									show : true
								}
							},
							emphasis : {
								label : {
									show : true
								}
							}
						},
						data : [ {
							name : '北京',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '天津',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '上海',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '重庆',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '河北',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '安徽',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '新疆',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '浙江',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '江西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '山西',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '内蒙古',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '吉林',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '福建',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '广东',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '西藏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '四川',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '宁夏',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '香港',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '澳门',
							value : Math.round(Math.random() * 1000)
						} ]
					}, {
						name : 'iphone5',
						type : 'map',
						mapType : 'china',
						itemStyle : {
							normal : {
								label : {
									show : true
								}
							},
							emphasis : {
								label : {
									show : true
								}
							}
						},
						data : [ {
							name : '北京',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '天津',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '上海',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '广东',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '台湾',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '香港',
							value : Math.round(Math.random() * 1000)
						}, {
							name : '澳门',
							value : Math.round(Math.random() * 1000)
						} ]
					} ]
				},
				{
					title : {
						text : '折线图样例',
						subtext : ''
					},
					tooltip : {
						trigger : 'axis'
					},
					legend : {
						data : [ '险种1', '险种2' ]
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
						name : '险种1',
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
						text : '漏斗图样例',
						subtext : ''
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
						data : [ '险种1', '险种2', '险种3', '险种4', '险种5' ]
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
							name : '险种3'
						}, {
							value : 40,
							name : '险种4'
						}, {
							value : 20,
							name : '险种5'
						}, {
							value : 80,
							name : '险种2'
						}, {
							value : 100,
							name : '险种1'
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
							name : '险种3'
						}, {
							value : 10,
							name : '险种4'
						}, {
							value : 5,
							name : '险种5'
						}, {
							value : 50,
							name : '险种2'
						}, {
							value : 80,
							name : '险种1'
						} ]
					} ]
				} ]
	},

	theme6 : {
		options : [ {
			title : {
				text : '模拟字符云'
			},
			tooltip : {
				show : true
			},
			series : [ {
				name : 'Google Trends',
				type : 'wordCloud',
				size : [ '80%', '80%' ],
				textRotation : [ 0, 45, 90, -45 ],
				textPadding : 0,
				autoSize : {
					enable : true,
					minSize : 14
				},
				data : [ {
					name : "Sam S Club",
					value : 10000,
					itemStyle : {
						normal : {
							color : 'black'
						}
					}
				}, {
					name : "Macys",
					value : 6181
				}, {
					name : "Amy Schumer",
					value : 4386
				}, {
					name : "Jurassic World",
					value : 4055
				}, {
					name : "Charter Communications",
					value : 2467
				}, {
					name : "Chick Fil A",
					value : 2244
				}, {
					name : "Planet Fitness",
					value : 1898
				}, {
					name : "Pitch Perfect",
					value : 1484
				}, {
					name : "Express",
					value : 1112
				}, {
					name : "Home",
					value : 965
				}, {
					name : "Johnny Depp",
					value : 847
				}, {
					name : "Lena Dunham",
					value : 582
				}, {
					name : "Lewis Hamilton",
					value : 555
				}, {
					name : "KXAN",
					value : 550
				}, {
					name : "Mary Ellen Mark",
					value : 462
				} ]
			} ]
		},
		
		{
		    title : {
		        text: '韦恩图样例'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{b}: {c}"
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : false,
		    series : [
		        {
		            name:'韦恩图',
		            type:'venn',
		            itemStyle: {
		                normal: {
		                    label: {
		                        show: true,
		                        textStyle: {
		                            fontFamily: 'Arial, Verdana, sans-serif',
		                            fontSize: 16,
		                            fontStyle: 'italic',
		                            fontWeight: 'bolder'
		                        }
		                    },
		                    labelLine: {
		                        show: false,
		                        length: 10,
		                        lineStyle: {
		                            // color: 各异,
		                            width: 1,
		                            type: 'solid'
		                        }
		                    }
		                },
		                emphasis: {
		                    color: '#cc99cc',
		                    borderWidth: 3,
		                    borderColor: '#996699'
		                }
		            },
		            data:[
		                {value:100, name:'险种1'},
		                {value:50, name:'险种2'},
		                {value:20, name:'公共'}
		            ]
		        }
		    ]
		}, 
		{
		    title : {
		        text: '雷达图样例'
		    },
		    tooltip : {
		        trigger: 'axis'
		    },
		    toolbox: {
		        show : false,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    polar : [
		       {
		           indicator : [
		               { text: '险种1', max: 6000},
		               { text: '险种2', max: 16000},
		               { text: '险种3', max: 30000},
		               { text: '险种4', max: 38000},
		               { text: '险种5', max: 52000}
		            ]
		        }
		    ],
		    calculable : true,
		    series : [
		        {
		            name: '预算 vs 开销（Budget vs spending）',
		            type: 'radar',
		            data : [
		                {
		                    value : [4300, 10000, 28000, 35000, 50000, 19000],
		                    name : '预算分配（Allocated Budget）'
		                },
		                 {
		                    value : [5000, 14000, 28000, 31000, 42000, 21000],
		                    name : '实际开销（Actual Spending）'
		                }
		            ]
		        }
		    ]
		}, 
		{
			color : [ 'rgba(255, 69, 0, 0.5)',
					'rgba(255, 150, 0, 0.5)', 'rgba(255, 200, 0, 0.5)',
					'rgba(155, 200, 50, 0.5)',
					'rgba(55, 200, 100, 0.5)' ],
			title : {
				text : '漏斗图样例',
				subtext : ''
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
				data : [ '险种1', '险种2', '险种3', '险种4', '险种5' ]
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
					name : '险种3'
				}, {
					value : 40,
					name : '险种4'
				}, {
					value : 20,
					name : '险种5'
				}, {
					value : 80,
					name : '险种2'
				}, {
					value : 100,
					name : '险种1'
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
					name : '险种3'
				}, {
					value : 10,
					name : '险种4'
				}, {
					value : 5,
					name : '险种5'
				}, {
					value : 50,
					name : '险种2'
				}, {
					value : 80,
					name : '险种1'
				} ]
			} ]
		}, 
		{
		    title : {
		        text: '饼图样例',
		        x:'left'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    toolbox: {
		        show : false,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            magicType : {
		                show: true, 
		                type: ['pie', 'funnel'],
		                option: {
		                    funnel: {
		                        x: '25%',
		                        width: '50%',
		                        funnelAlign: 'left',
		                        max: 1548
		                    }
		                }
		            },
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    series : [
		        {
		            name:'社保',
		            type:'pie',
		            radius : '55%',
		            center: ['50%', '60%'],
		            data:[
		                {value:335, name:'险种1'},
		                {value:310, name:'险种2'},
		                {value:234, name:'险种3'},
		                {value:135, name:'险种4'},
		                {value:1548, name:'险种5'}
		            ]
		        }
		    ]
		}]
	}
};
