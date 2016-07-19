package org.scut.testmybatis;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class CreateData {
	
	public String getString(String[] s) {
		int len = s.length;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < len; i++) {
			if(i < len - 1) {
				sb.append(s[i]).append(",");
			}else {
				sb.append(s[i]);
			}
		}
		
		return sb.toString();
	}
	
	public String getMonth(int month) {
		String m = "";
		if(month < 10) {
			m = "0" + month;
		}else {
			m = Integer.toString(month);
		}
		
		return m;
	}
	
    public static void main(String[] args) {
    	/**
    	 * 1、要设置index的索引
    	 * 2、根据不同人员状态进行分段创建
    	 * 3、设置人员状态
    	 * 
    	 */
    	
    	CreateData create = new CreateData();
    	
    	String[] companyID = new String[] {
    		"4209011005538", "4209011005696", "4209011005697", "4209011005698", "4209011005699", "4209011005700", "4209011005701",
    		"4209011005664", "4209011005839", "4209011005840", "4209011005841", "4209011005842", "4209011005843", "4209011005844",
    		"4209011005866", "4209011005867", "4209011005868", "4209011005869", "4209011005870", "4209011004689", "4209011004690",
    		"4209011005845", "4209011005846", "4209011005847", "4209011005848", "4209011005849", "4209011005850", "4209011005851",
    		"4209011005852", "4209011005853", "4209011005854", "4209011005855", "4209011005856", "4209011005857", "4209011005858",
    		"4209011005702", "4209011005703", "4209011005704", "4209011005705", "4209011005661", "4209011005662", "4209011005663",
    		"4209011005859", "4209011005860", "4209011005861", "4209011005862", "4209011005863", "4209011005864", "4209011005865",
    		"4209011004911"
    	};
    	
    	int[] paymentBase = new int[] {
    			2000, 3000, 4000, 5000, 6000	
    	};
    	
    	int[] oldPayment = new int[] {
    			400, 600, 800, 1000, 1200	
    	};
    	
    	int[] oldGive = new int[] {
    			1600, 2400, 3200, 4000, 4800
    	};
    	
    	int[] medicinePayment = new int[] {
    			40, 60, 80, 100, 120
    	};
    	
    	int[] medicineGive = new int[] {
    			500, 1000, 1500, 2000, 2500	
    	};
    	
    	int[] notWorkPayment = new int[] {
    			20, 30, 40, 50, 60
    	};
    	
    	int[] notWorkGive = new int[] {
    			3000, 4500, 6000, 7500, 9000
    	};
    	
    	int[] birthPayment = new int[] {
    			20, 30, 40, 50, 60
    	};
    			
    	int[] birthGive = new int[] {
    			3000, 4500, 6000, 7500, 9000	
    	};
    	
    	int[] injuryPayment = new int[] {
    			20, 30, 40, 50, 60
    	};
    	
    	int[] injuryGive = new int[] {
    			3000, 4500, 6000, 7500, 9000	
    	};
    	
    	//人员信息  1（个人编号）,2（单位编号）,4（性别）,6（出生日期）,8（人员状态）,12（个人身份  工人（92%）、教师（3%）、干部（5%））,21（地址）
    	String[] personInfo = new String[106];
    	//缴费信息 1（个人编号）,2（台帐年月）,4（险种类型企业基本养老保险（11） 失业保险（21） 大额医疗保险（32） 工伤保险（41） 生育保险（51））,
    	//8（缴费基数）,9（本期应缴  缴费基数*20%）,17（人员状态）
    	String[] paymentInfo = new String[30];
    	//医疗支出  4（个人编号）,18（基本医疗费用总额）,49（经办日期）
    	String[] medicineInfo = new String[134];
    	//养老支出 0（个人编号）,35（支付合计）,40（经办日期）
    	String[] oldInfo = new String[58];
    	//失业支出 1（个人编号）,31（失业保险待遇总额）,36（经办日期）
    	String[] workInfo = new String[42];
    	//生育支出  AAC001（个人编号）,ABC166（总金额）,AAE036（经办日期）
    	String[] birthInfo = new String[3];
    	//工伤支出  AAC001（个人编号）,ABC166（总金额）,AAE036（经办日期）
    	String[] injuryInfo = new String[3];
    	
    	for(int i = 0; i < personInfo.length; i++) {
    		if(i == 4) {
    			personInfo[i] = "男";
    			continue;
    		}
    		personInfo[i] = "";
    	}
    	
    	for(int i = 0; i < paymentInfo.length; i++) {
    		paymentInfo[i] = "";
    	}
    	
    	for(int i = 0; i < medicineInfo.length; i++) {
    		medicineInfo[i] = "";
    	}
    	
    	for(int i = 0; i < oldInfo.length; i++) {
    		oldInfo[i] = "";
    	}
    	
    	for(int i = 0; i < workInfo.length; i++) {
    		workInfo[i] = "";
    	}
    	
    	for(int i = 0; i < birthInfo.length; i++) {
    		birthInfo[i] = "";
    	}
    	
    	for(int i = 0; i < injuryInfo.length; i++) {
    		injuryInfo[i] = "";
    	}
    	
    	FileWriter peopleFileWriter = null;
        BufferedWriter writer = null;
        
        FileWriter paymentFileWriter = null;
        BufferedWriter paymentWriter = null;
        
        FileWriter oldGetFileWriter = null;
        BufferedWriter oldGetWriter = null;
        
        FileWriter notWorkFileWriter = null;
        BufferedWriter notWorkWriter = null;
        
        FileWriter medicineFileWriter = null;
        BufferedWriter medicineWriter = null;
        
        FileWriter brithFileWriter = null;
        BufferedWriter brithWriter = null;
        
        FileWriter injuryFileWriter = null;
        BufferedWriter injuryWriter = null;
        
        
		File peopleFile = new File("E:/labordata/ac01.txt");
		File paymentFile = new File("E:/labordata/ac20.txt");
		File oldGetFile = new File("E:/labordata/ic15.txt");
		File notWorkFile = new File("E:/labordata/jc14.txt");
		File medicineFile = new File("E:/labordata/kc24.txt");
		File brithFile = new File("E:/labordata/bc34.txt");
		File injuryFile = new File("E:/labordata/wc44.txt");
		
		String prex = "16";
		//XXX 索引
		int index = 57021;
		String pnum = "";
		
		Random random;
		
		//设置出生日期
		Calendar c = Calendar.getInstance(); 
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
		
		try {
			peopleFileWriter = new FileWriter(peopleFile, true);
			writer = new BufferedWriter(peopleFileWriter);
			
			paymentFileWriter = new FileWriter(paymentFile, true);
			paymentWriter = new BufferedWriter(paymentFileWriter);
			
			oldGetFileWriter = new FileWriter(oldGetFile, true);
			oldGetWriter = new BufferedWriter(oldGetFileWriter);
			
			notWorkFileWriter = new FileWriter(notWorkFile, true);
			notWorkWriter = new BufferedWriter(notWorkFileWriter);
			
			medicineFileWriter = new FileWriter(medicineFile, true);
			medicineWriter = new BufferedWriter(medicineFileWriter);
			
			brithFileWriter = new FileWriter(brithFile, true);
			brithWriter = new BufferedWriter(brithFileWriter);
			
			injuryFileWriter = new FileWriter(injuryFile, true);
			injuryWriter = new BufferedWriter(injuryFileWriter);
			
			System.out.println("--------- Start create data");
			
			//做在职的数据生成 18934+586(失业)
			//16500 = 16005(在职) + 495(失业)
			//退休：11000 8250 7980
			//XXX
			for(int i = 1; i <= 8250; i++) {
				c.setTime(new Date("2015/12/31 00:00:00"));
				pnum = prex + index;
				personInfo[1] = pnum;
				index++;
				
				random = new Random(System.currentTimeMillis());
				
				personInfo[2] = companyID[random.nextInt(50)];
				
				//XXX
				int age = random.nextInt(25) + 66;
				c.add(Calendar.YEAR, 0-age);
				personInfo[6] = sf.format(c.getTime());
				
				//XXX
				personInfo[8] = "退休";
				
				int temp = random.nextInt(100) + 1;
				if(temp <= 3) {
					personInfo[12] = "教师";
				}else if(temp >= 96) {
					personInfo[12] = "干部";
				}else {
					personInfo[12] = "工人";
				}
				
				temp = random.nextInt(100) + 1;
				if(temp <= 20) {
					personInfo[21] = "台山市";
				}else if(temp > 20 && temp <= 35) {
					personInfo[21] = "开平市";
				}else if(temp > 35 && temp <= 50) {
					personInfo[21] = "恩平市";
				}else if(temp > 50 && temp <= 70) {
					personInfo[21] = "新会区";
				}else if(temp > 70 && temp <= 78) {
					personInfo[21] = "江海区";
				}else if(temp > 78 && temp <= 90) {
					personInfo[21] = "鹤山市";
				}else {
					personInfo[21] = "蓬江区";
				}
				
				writer.write(create.getString(personInfo));
				writer.newLine();
				
				//创建缴费记录
				String month = "";
				for(int j = 2010; j <= 2015; j++) {
					//暂定退休了就什么都不用交
					if(personInfo[8].equalsIgnoreCase("退休")) {
						break;
					}
					for(int z = 1; z <= 12; z++) {
						paymentInfo[1] = personInfo[1];
						month = create.getMonth(z);
						paymentInfo[2] = j + month;
						
						paymentInfo[17] = personInfo[8];
						//添加机构编号
						paymentInfo[18] = personInfo[2];
						
						int baseTemp = random.nextInt(5);
						paymentInfo[8] = Integer.toString(paymentBase[baseTemp]);
						
						paymentInfo[4] = "养老保险";
						paymentInfo[9] = Integer.toString(oldPayment[baseTemp]);
						paymentWriter.write(create.getString(paymentInfo));
						paymentWriter.newLine();
						
						paymentInfo[4] = "失业保险";
						paymentInfo[9] = Integer.toString(notWorkPayment[baseTemp]);
						paymentWriter.write(create.getString(paymentInfo));
						paymentWriter.newLine();
						
						paymentInfo[4] = "医疗保险";
						paymentInfo[9] = Integer.toString(notWorkPayment[baseTemp]);
						paymentWriter.write(create.getString(paymentInfo));
						paymentWriter.newLine();
						
						paymentInfo[4] = "工伤保险";
						paymentInfo[9] = Integer.toString(notWorkPayment[baseTemp]);
						paymentWriter.write(create.getString(paymentInfo));
						paymentWriter.newLine();
						
						if(age <= 45) {
							paymentInfo[4] = "生育保险";
							paymentInfo[9] = Integer.toString(notWorkPayment[baseTemp]);
							paymentWriter.write(create.getString(paymentInfo));
							paymentWriter.newLine();
						}
					}
				}
				
				/**
				 * 创建支付信息
				 */
				String oldMonth = "";
				//1、创建养老支付
				if(age > 55) {
					oldInfo[0] = personInfo[1];
					int days = age - 55;
					for(int j = 2015; j >= 2010; j--) {
						if(days > 0) {
							for(int z = 1; z <= 12; z++) {
								oldMonth = create.getMonth(z);
								oldInfo[40] = j + "/" + oldMonth + "/20 00:00:00";
								oldInfo[35] = Integer.toString(oldGive[random.nextInt(5)]);
								
								oldGetWriter.write(create.getString(oldInfo));
								oldGetWriter.newLine();
							}
							
							days--;
						}
					}
				}else {
					//2、创建生育支付，当年龄大于45时没有生育支付
					if(age <= 45) {
						int birthYear = random.nextInt(6) + 2010;
						int birthMonth = random.nextInt(12) + 1;
						int birthMoney = birthGive[random.nextInt(5)];
						birthInfo[0] = personInfo[1];
						birthInfo[1] = Integer.toString(birthMoney);
						birthInfo[2] = birthYear + "/" + create.getMonth(birthMonth) + "/20 00:00:00";
						
						brithWriter.write(create.getString(birthInfo));
						brithWriter.newLine();
					}
					
					//3、创建工伤支付
					int injuryYear = random.nextInt(6) + 2010;
					int injuryMonth = random.nextInt(12) + 1;
					int innjuryMoney = injuryGive[random.nextInt(5)];
					injuryInfo[0] = personInfo[1];
					injuryInfo[1] = Integer.toString(innjuryMoney);
					injuryInfo[2] = injuryYear + "/" + create.getMonth(injuryMonth) + "/20 00:00:00";
					
					injuryWriter.write(create.getString(injuryInfo));
					injuryWriter.newLine();
					
					//4、创建失业支付   如果当前人员状态为失业则是今年失业支付，否则随机
					int outworkYear = 0, outworkMonth = random.nextInt(12) + 1, outworkMoney = notWorkGive[random.nextInt(5)];
					if(personInfo[8].equalsIgnoreCase("失业")) {
						outworkYear = 2015;
					}else {
						outworkYear = random.nextInt(5) + 2010;
					}
					
					workInfo[1] = personInfo[1];
					workInfo[31] = Integer.toString(outworkMoney);
					workInfo[36] = outworkYear + "/" + create.getMonth(outworkMonth) + "/20 00:00:00";
					
					notWorkWriter.write(create.getString(workInfo));
					notWorkWriter.newLine();
				}
				
				//5、创建医疗支付
				int medYear = 0, medMonth = 0, medMoney = 0;
				for(int g = 0; g < 2; g++) {
					medYear = random.nextInt(6) + 2010;
					medMonth = random.nextInt(12) + 1;
					medMoney = medicineGive[random.nextInt(5)];
					
					medicineInfo[4] = personInfo[1];
					medicineInfo[18] = Integer.toString(medMoney);
					medicineInfo[49] = medYear + "/" + create.getMonth(medMonth) + "/20 00:00:00";
					
					medicineWriter.write(create.getString(medicineInfo));
					medicineWriter.newLine();
				}
				
			}
			
//			String[] data = new String[] {"", "", "", "1", "aaa", "江门1"};
//			writer.write(create.getString(data));
//			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
                writer.close();
                peopleFileWriter.close();
                
                paymentWriter.close();
                paymentFileWriter.close();
    			
    			oldGetWriter.close();
    			oldGetFileWriter.close();
    			
    			notWorkWriter.close();
    			notWorkFileWriter.close();
    			
    			medicineWriter.close();
    			medicineFileWriter.close();
    			
    			brithWriter.close();
    			brithFileWriter.close();
    			
    			injuryWriter.close();
    			injuryFileWriter.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
		}
		
		System.out.println("---------- End create data");
	}
    
    public static void main1(String[] args) {
    	Random random = new Random(System.currentTimeMillis());
		System.out.println(random.nextInt(23)+18);
	}
}
