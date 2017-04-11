package console;
import java.util.ArrayList;
import engine.Calculate;
import engine.ProcessInfromation;
import engine.SystemModel;
import engine.Water;
public class Output {
	static Water water = new Water(2000.0, 25, 0.85, 7.6);
	static ProcessInfromation PP = new ProcessInfromation(2, 2, 3, 1, 3, 0, "BW_8040", 7.5, 0.6);
	static SystemModel systemmodel;
	static double M = 58.44;// 氯化钠的摩尔质量
	static String tipstring = null;
	static java.text.DecimalFormat df;
	static int groupnum;
	static OutputTips outputtip = new OutputTips();
	public void output(String Str) {
		systemmodel = new SystemModel(PP.monum(1), PP.motype, PP.Pf(water.T, water.wryz, water.inTDS, M),
				PP.outvel / (PP.systemHSL * PP.vesselsnum1), water.inTDS, Calculate.paif(water.T, water.inTDS, M),
				PP.Avgpfc(), PP.systemHSL, PP.AvgHSL(PP.systemHSL));
		groupnum=PP.groupnum;
		ArrayList<Double> DATA = new ArrayList<Double>();
		df = new java.text.DecimalFormat("0.000");
		String[] initoutput = { "water", "process", "result", "exit", "quit" };
		String[] waterparameter = { "TDS", "temperature", "pollutionfactor", "pH" };
		String[] processparameter = { "groupnum", "vesselsnum1", "monum1", "vesselsnum2", "monum2", "BoostedPressure", "motype",
				"outvel", "systemrecover" };
		String[] systemparameter = { "systemresult", "detailresult", "warning" };
		String[] operate= { "show", "set", "exit", "quit", "help" };
		String instr = null;
		String inittipstring = null;
		int strlength = 0;
		ArrayList<String> string = new ArrayList<String>();
		string = Calculate.SpiltString(Str);
		String[] inputStr = new String[string.size()];
		string.toArray(inputStr);
		ArrayList<String> inString = new ArrayList<String>();
		DATA = systemmodel.SystemCalc(groupnum,PP.monum(PP.groupnum),PP.motype,PP.Avgpfc(),PP.systemHSL, PP.AvgHSL(PP.systemHSL));
		if (inputStr.length > 0) {
			inittipstring = tipstring;
			inString = Calculate.CheckMatch(initoutput, inputStr[0]);
			if (inittipstring != null && !inittipstring.equals("")) {
				tipstring = inittipstring;
			} else {
				tipstring = "";
			}
			if (inString.size() == 1) {
				inputStr[0] = inString.get(0);
				instr = inputStr[0];
				if (inputStr.length == 1) {
					tipstring = inputStr[0];
				}else{
					string.remove(0);
					string.toArray(inputStr);
					strlength=inputStr.length-1;
				}
			}else if (inString.size() > 1) {
				instr = tipstring;
				for (int m = 0; m < inString.size(); m++) {
					System.out.println(inString.get(m));
				}
			} else if (inString.size() == 0) {
				instr = tipstring;
				strlength=inputStr.length;
			}
			if (Calculate.CheckMatch(operate, inputStr[0]).size() == 1) {
				inputStr[0] = Calculate.CheckMatch(operate, inputStr[0]).get(0);
				switch (inputStr[0]) {
				case "show":
					if (instr.equals("water")) {
						if (strlength == 2) {
							if (Calculate.CheckMatch(waterparameter, inputStr[1]).size() == 1) {
								inputStr[1] = Calculate.CheckMatch(waterparameter, inputStr[1]).get(0);
								switch (inputStr[1]) {
								case "TDS":
									System.out.println("进水浓度：" + water.inTDS);
									break;
								case "temperature":
									System.out.println("温度：" + water.T);
									break;
								case "pollutionfactor":
									System.out.println("污染因子：" + water.wryz);
									break;
								case "pH":
									System.out.println("pH：" + water.pH);
									break;
								}
							} else if (Calculate.CheckMatch(waterparameter, inputStr[1]).size() > 1) {
								DuplicateDetection(waterparameter, inputStr[0], inputStr[1],instr);
							} else if (Calculate.CheckMatch(waterparameter, inputStr[1]).size() == 0) {
								outputtip.str2(waterparameter, tipstring, instr,operate);
							}
						} else if (strlength == 1) {
							System.out.printf("进水浓度：%-10s温度：%-10s\n", water.inTDS, water.T);
							System.out.printf("污染因子：%-10spH：%-10s",water.wryz, water.pH);
						} else if(strlength>2){
							outputtip.str2(waterparameter, tipstring, instr,operate);
						}
					} else if (instr.equals("process")) {
						if (strlength == 2) {
							if (Calculate.CheckMatch(processparameter, inputStr[1]).size() == 1) {
								inputStr[1] = Calculate.CheckMatch(processparameter, inputStr[1]).get(0);
								switch (inputStr[1]) {
								case "groupnum":
									System.out.println("段数：" + PP.groupnum);
									break;
								case "vesselsnum1":
									System.out.println("一段压力容器数：" + PP.vesselsnum1);
									break;
								case "monum1":
									System.out.println("一段压力容器内膜元件数：" + PP.nmyjs1);
									break;
								case "vesselsnum2":
									System.out.println("二段压力容器数：" + PP.vesselsnum2);
									break;
								case "monum2":
									System.out.println("二段压力容器内膜元件数：" + PP.nmyjs2);
									break;
								case "BoostedPressure":
									System.out.println("段间增压：" + PP.P12);
									break;
								case "motype":
									System.out.println("膜元件类型：" + PP.motype);
									break;
								case "outvel":
									System.out.println("系统产水量：" + PP.outvel);
									break;
								case "systemrecover":
									System.out.println("系统回收率：" + PP.systemHSL);
									break;
								}
							} else if (Calculate.CheckMatch(processparameter, inputStr[1]).size() > 1) {
								DuplicateDetection(processparameter, inputStr[0], inputStr[1],instr);
							} else if (Calculate.CheckMatch(processparameter, inputStr[1]).size() == 0) {
								outputtip.str22(processparameter, PP.groupnum, tipstring, instr,operate);
							}
						} else if (strlength == 1) {
							if (PP.groupnum == 1) {
								System.out.printf("系统段数：%-23s一段压力容器数：%-10s\n", PP.groupnum, PP.vesselsnum1);
								System.out.printf("一段压力容器内膜元件数：%-10s膜元件类型：%-10s\n", PP.nmyjs1, PP.motype);
								System.out.printf("系统回收率：%-21s系统产水量：%-10s\n", PP.systemHSL, PP.outvel);
							} else if(PP.groupnum ==2){
								System.out.printf("系统段数：%-23s一段压力容器数：%-10s\n", PP.groupnum, PP.vesselsnum1);
								System.out.printf("一段压力容器内膜元件数：%-10s二段压力容器数：%-10s\n", PP.nmyjs1, PP.vesselsnum2);
								System.out.printf("二段压力容器内膜元件数：%-10s段间增压：%-10s\n", PP.nmyjs2, PP.P12);
								System.out.printf("膜元件类型：%-21s系统产水量：%-10s\n", PP.motype, PP.outvel);
								System.out.printf("系统回收率：%-21s", PP.systemHSL);
							}
						} else if(strlength>2){
							outputtip.str22(processparameter, PP.groupnum, tipstring, instr,operate);
						}
					} else if (instr.equals("result")) {
						if (strlength == 2) {
							if (Calculate.CheckMatch(systemparameter, inputStr[1]).size() == 1) {
								inputStr[1] = Calculate.CheckMatch(systemparameter, inputStr[1]).get(0);
								switch (inputStr[1]) {
								case "systemresult":
									System.out.println("系统计算结果：");
									systemresult(DATA);
									break;
								case "detailresult":
									System.out.println("段内膜元件参数细节：");
									detailresult(DATA);
									break;
								case "warning":
									System.out.println("系统预警：");
									warning(DATA);
									break;
								}
							} else if (Calculate.CheckMatch(systemparameter, inputStr[1]).size() > 1) {
								DuplicateDetection(systemparameter, inputStr[0], inputStr[1],instr);
							} else if (Calculate.CheckMatch(systemparameter, inputStr[1]).size() == 0) {
								outputtip.res(systemparameter, tipstring, instr,operate);
							}
						} else if (strlength == 1) {
							System.out.println("系统计算结果：");
							systemresult(DATA);
							System.out.println("\n段内膜元件参数细节：");
							detailresult(DATA);
							System.out.println("\n系统预警：");
							warning(DATA);
						} else if(strlength>2){
							outputtip.res(systemparameter, tipstring, instr,operate);
						}
					}
					break;
				case "set":
					if (instr.equals("water")) {
						if (strlength > 1) {
							if (Calculate.CheckMatch(waterparameter, inputStr[1]).size() == 1) {
								inputStr[1] = Calculate.CheckMatch(waterparameter, inputStr[1]).get(0);
								if (strlength > 2) {
									switch (inputStr[1]) {
									case "TDS":
										if (isNumber(inputStr[2])) {
											water.setIn_TDS(Double.parseDouble(inputStr[2]));
											if (water.inTDS > 0) {
												System.out.println("进水浓度：" + water.inTDS);
											} else {
												System.out.println("请输入大于0的进水浓度值！");
											}
										} else {
											System.out.println("输入数据类型不对！");
										}
										break;
									case "temperature":
										if (isNumber(inputStr[2])) {
											water.setT(Double.parseDouble(inputStr[2]));
											if (water.T < 100 && water.T > 0) {
												System.out.println("温度：" + water.T);
											} else {
												System.out.println("请输入1~99之间的温度值！");
											}
										} else {
											System.out.println("输入数据类型不对！");
										}
										break;
									case "pollutionfactor":
										if (isNumber(inputStr[2])) {
											water.setWryz((Double.parseDouble(inputStr[2])));
											if (water.wryz > 0) {
												System.out.println("污染因子：" + water.wryz);
											} else {
												System.out.println("请输入大于0的污染因子值！");
											}
										} else {
											System.out.println("输入数据类型不对！");
										}
										break;
									case "pH":
										if (isNumber(inputStr[2])) {
											water.setpH((Double.parseDouble(inputStr[2])));
											if (water.pH <= 14 && water.pH >= 0) {
												System.out.println("pH：" + water.pH);
											} else {
												System.out.println("请输入0~14之间的pH值！");
											}
										} else {
											System.out.println("输入数据类型不对！");
										}
										break;
									}
								} else {
									outputtip.str2Set(waterparameter, tipstring, instr,operate,inputStr,strlength);
								}
							} else if (Calculate.CheckMatch(waterparameter, inputStr[1]).size() > 1) {
								DuplicateDetection(waterparameter, inputStr[0], inputStr[1],instr);
							} else if (Calculate.CheckMatch(waterparameter, inputStr[1]).size() == 0) {
								System.out.println("下列指令有效：");
								outputtip.str2Set(waterparameter, tipstring, instr,operate,inputStr,strlength);
							}
						} else {
							outputtip.str2Set(waterparameter, tipstring, instr,operate,inputStr,strlength);
						}
					} else if (instr.equals("process")) {
						if (strlength > 1) {
							if (Calculate.CheckMatch(processparameter, inputStr[1]).size() == 1) {
								inputStr[1] = Calculate.CheckMatch(processparameter, inputStr[1]).get(0);
								if (strlength > 2) {
									switch (inputStr[1]) {
									case "groupnum":
										if (isNumber(inputStr[2])) {
											try {
												PP.setGroup_num(Integer.valueOf(inputStr[2]).intValue());
												if (PP.groupnum == 1 || PP.groupnum == 2) {
													System.out.println("段数：" + PP.groupnum);
												} else {
													System.out.println("请输入的段数值为1或2！");
												}
											} catch (Exception e) {
												System.out.println("请输入整数型段数值！");
											}
										} else {
											System.out.println("输入数据类型不对！");
										}
										break;
									case "vesselsnum1":
										if (isNumber(inputStr[2])) {
											try {
												PP.setYlrq1(Integer.valueOf(inputStr[2]).intValue());
												if (PP.vesselsnum1 > 0) {
													System.out.println("一段压力容器数：" + PP.vesselsnum1);
												} else {
													System.out.println("请输入大于0的压力容器数！");
												}
											} catch (Exception e) {
												System.out.println("请输入整数型压力容器数值！");
											}
										} else {
											System.out.println("输入数据类型不对！");
										}
										break;
									case "monum1":
										if (isNumber(inputStr[2])) {
											try {
												PP.setNmyjs1(Integer.valueOf(inputStr[2]).intValue());
												if (PP.nmyjs1 > 0) {
													System.out.println("一段压力容器内膜元件数：" + PP.nmyjs1);
												} else {
													System.out.println("请输入大于0的内膜元件数！");
												}
											} catch (Exception e) {
												System.out.println("请输入整数型内膜元件数值！");
											}
										} else {
											System.out.println("输入数据类型不对！");
										}
										break;
									case "vesselsnum2":
										if (isNumber(inputStr[2])) {
											try {
												PP.setYlrq2(Integer.valueOf(inputStr[2]).intValue());
												if (PP.vesselsnum2 > 0) {
													System.out.println("二段压力容器数：" + PP.vesselsnum2);
												} else {
													System.out.println("请输入大于0的压力容器数！");
												}
											} catch (Exception e) {
												System.out.println("请输入整数型压力容器数值！");
											}
										} else {
											System.out.println("输入数据类型不对！");
										}
										break;
									case "monum2":
										if (isNumber(inputStr[2])) {
											try {
												PP.setNmyjs2(Integer.valueOf(inputStr[2]).intValue());
												if (PP.nmyjs2 > 0) {
													System.out.println("二段压力容器内膜元件数：" + PP.nmyjs2);
												} else {
													System.out.println("请输入大于0的内膜元件数！");
												}	
											} catch (Exception e) {
												System.out.println("请输入整数型内膜元件数值！");
											}
											
										} else {
											System.out.println("输入数据类型不对！");
										}
										break;
									case "BoostedPressure":
										if (isNumber(inputStr[2])) {
											PP.setP1_2(Double.parseDouble(inputStr[2]));
											if (PP.P12 >= 0) {
												System.out.println("段间增压：" + PP.P12);
											} else {
												System.out.println("请输入大于等于0的段间增压！");
											}
										} else {
											System.out.println("输入数据类型不对！");
										}
										break;
									case "motype":
										PP.setMo_type(inputStr[2]);
										if ((PP.motype.equals("BW_8040")) || (PP.motype.equals("SW_8040"))
												|| (PP.motype.equals("ULP_8040"))) {
											System.out.println("膜元件类型：" + PP.motype);
										} else {
											System.out.println("请输入BW_8040、SW_8040、ULP_8040中一个为膜类型！");
										}
										break;
									case "outvel":
										if (isNumber(inputStr[2])) {
											PP.setOut_vel(Double.parseDouble(inputStr[2]));
											if (PP.outvel > 0) {
												System.out.println("系统产水量：" + PP.outvel);
											} else {
												System.out.println("请输入大于0的系统产水量！");
											}
										} else {
											System.out.println("输入数据类型不对！");
										}
										break;
									case "systemrecover":
										if (isNumber(inputStr[2])) {
											PP.setSystemHSL(Double.parseDouble(inputStr[2]));
											if (PP.systemHSL < 1 && PP.systemHSL > 0) {
												System.out.println("系统回收率：" + PP.systemHSL);
											} else {
												System.out.println("请输入0~1且不等于0或1的系统回收率！");
											}
										} else {
											System.out.println("输入数据类型不对！");
										}
										break;
									}
								} else {
									outputtip.str22Set(processparameter, PP.groupnum, tipstring, instr,operate,inputStr,strlength);
								}
							} else if (Calculate.CheckMatch(processparameter, inputStr[1]).size() > 1) {
								DuplicateDetection(processparameter, inputStr[0], inputStr[1],instr);
							} else if (Calculate.CheckMatch(processparameter, inputStr[1]).size() == 0) {
								System.out.println("下列指令有效：");
								outputtip.str22Set(processparameter, PP.groupnum, tipstring, instr,operate,inputStr,strlength);
							}
						} else {
							outputtip.str22Set(processparameter, PP.groupnum, tipstring, instr,operate,inputStr,strlength);
						}
					} else if (instr.equals("result")) {
						System.out.println("下列指令有效：");
						outputtip.result(tipstring, instr,operate);
					}
					break;
				case "exit":
					System.exit(0);
					break;
				case "quit":
					System.exit(0);
					break;
				case "help":
					if (instr.equals("water") || instr.equals("process")) {
						outputtip.operate(operate, tipstring, instr);
					} else if (instr.equals("result")) {
						outputtip.result(tipstring, instr,operate);
					} else if (inputStr[0].equals("help")) {
						outputtip.tempinit(initoutput);
					}
				}
			} else if (Calculate.CheckMatch(operate, inputStr[0]).size() > 1) {
				DuplicateDetection(operate,"",inputStr[0],instr);
			} else if (Calculate.CheckMatch(operate, inputStr[0]).size() == 0) {
				if (!inputStr[0].contains("water") && !inputStr[0].contains("process")
						&& !inputStr[0].contains("result")) {
					System.out.println("下列指令有效：");
					if (instr.equals("water") || instr.equals("process")) {
						outputtip.operate(operate, tipstring, instr);
					} else if (instr.equals("result")) {
						outputtip.result(tipstring, instr,operate);
					} else {
						outputtip.tempinit(initoutput);
					}
				}
			}
		} else {
			if (tipstring != null && !tipstring.equals("")) {
			} else {
				tipstring = "";
			}
		}
		System.out.print("\n" + tipstring + "> ");
	}
	public  boolean isNumber(String str) {
		String reg = "^[-+]?[0-9]+(.[0-9]+)?$";
		return str.matches(reg);
	}

	public void DuplicateDetection(String[] str,String input0,String input1,String in){
		for (int m = 0; m < Calculate.CheckMatch(str, input1).size(); m++) {
			if (tipstring != null && !tipstring.equals("")) {
				if (!tipstring.equals(in)) {
					System.out.println(in + " " + input0 + " "+ Calculate.CheckMatch(str,input1).get(m));
				} else {
					System.out.println(input0 + " "+Calculate.CheckMatch(str,input1).get(m));
				}
			} else {
				System.out.println(in + " " + input0 + " "+ Calculate.CheckMatch(str,input1).get(m));
			}
		}
	}
	public void systemresult(ArrayList<Double> DATA) {
		ArrayList<Double> bb = new ArrayList<>();
		bb = systemmodel.SystemPara(DATA, PP.groupnum);
			System.out.printf("%s%-12s%s%-12s%s%-8s\n", "系统进水量：", df.format(PP.outvel / PP.systemHSL), "系统产水量：",
					df.format(bb.get(0)), "进水TDS：", df.format(DATA.get(8)));
			System.out.printf("%s%-14s%s%-16s%s%-8s\n", "进水压力：", df.format(DATA.get(7)), "回收率：",
					df.format(bb.get(1)), "产水TDS：", df.format(bb.get(2)));
			System.out.printf("%s%-14s%s%-14s%s%-10s\n", "段间增压：", df.format(PP.P12), "平均通量：",
					df.format(bb.get(4)), "脱盐率：", df.format(bb.get(3)));
			System.out.printf("%s%-16s%s%-14s\n", "总面积：", PP.N(PP.groupnum) * Calculate.mo_area(PP.motype), "给水温度：",
					water.T);
			System.out.printf("%-6s%-12s%-5s%-14s\n", "膜元件数量：", PP.N(PP.groupnum), "污染因子：", df.format(water.wryz));
			System.out.printf("%-4s%-5s%-8s%-6s%-6s%-6s%-6s%-6s%-6s%-6s%-6s%-6s%-6s%-6s\n", "\n段", "膜元件", "容器数量",
					"元件数量", "给水流量", "浓水流量", "产水流量", "进水压力", "浓水压力", "产水压力", "升压压力", "平均通量", "进水TDS", "产水TDS");
			if (PP.groupnum == 1) {
			System.out.printf("%-2s%-10s%-10s%-7s%-9s%-8s%-9s%-9s%-9s%-9s%-8s%-7s%-9s%-6s\n", "1", PP.motype, PP.vesselsnum1,
					PP.nmyjs1, df.format(PP.outvel / PP.systemHSL),
					df.format(PP.vesselsnum1 * DATA.get(10 * (PP.nmyjs1 - 1) + 3)), df.format(bb.get(0)),
					df.format(DATA.get(7)),
					df.format((DATA.get(10 * (PP.nmyjs1 - 1) + 7) - DATA.get(10 * (PP.nmyjs1 - 1) + 1))), df.format(0),
					df.format(PP.P12), df.format(bb.get(4)), df.format(DATA.get(8)), df.format(bb.get(2)));
		    }else if (PP.groupnum == 2) {
			System.out.printf("%-2s%-10s%-10s%-7s%-9s%-8s%-9s%-9s%-9s%-9s%-8s%-7s%-9s%-6s\n", "1", PP.motype, PP.vesselsnum1,
					PP.nmyjs1, df.format(PP.outvel / PP.systemHSL),
					df.format(PP.vesselsnum1 * DATA.get(10 * (PP.nmyjs1 - 1) + 3)), df.format(bb.get(6)),
					df.format(DATA.get(7)),
					df.format((DATA.get(10 * (PP.nmyjs1 - 1) + 7) - DATA.get(10 * (PP.nmyjs1 - 1) + 1))), df.format(0),
					df.format(PP.P12), df.format(bb.get(9)), df.format(DATA.get(8)), df.format(bb.get(8)));
			System.out.printf("%-2s%-10s%-10s%-7s%-9s%-8s%-9s%-9s%-9s%-9s%-8s%-7s%-9s%-6s\n", PP.groupnum, PP.motype,
					PP.vesselsnum2, PP.nmyjs2, df.format(DATA.get(10 * (PP.nmyjs1)) + DATA.get(10 * (PP.nmyjs1) + 3)),
					df.format(DATA.get(10 * (PP.nmyjs1 + 2) + 3)), df.format(bb.get(10)),
					df.format(DATA.get(10 * PP.nmyjs1 + 7)),
					df.format((DATA.get(10 * (PP.nmyjs1 + 2) + 7) - DATA.get(10 * (PP.nmyjs1 + 2) + 1))), df.format(0),
					df.format(0), df.format(bb.get(13)), df.format(DATA.get(10 * (PP.nmyjs1) + 8)),
					df.format(bb.get(12)));
		}
	}
	public void detailresult(ArrayList<Double> DATA) {
		System.out.printf("%-6s%-7s%-7s%-6s%-7s%-7s%-6s%-6s\n","第一段", "进水流量", "产水流量", "回收率", "进水TDS", "产水TDS", "脱盐率",
				"进水压力");
		System.out.printf("%-8s%-9s%-9s%-7s%-9s%-9s%-8s%-6s\n", "  1", df.format(PP.outvel / (PP.systemHSL * PP.vesselsnum1)),
				df.format(DATA.get(0)), df.format(DATA.get(2)), df.format(DATA.get(8)), df.format(DATA.get(4)),
				df.format(DATA.get(6)), df.format(DATA.get(7)));
		for (int i = 2; i <= PP.monum(1); i++) {
			System.out.printf("%-8s%-9s%-9s%-7s%-9s%-9s%-8s%-6s\n", "  " + i,
					df.format(DATA.get(10 * (i - 1)) + DATA.get(10 * (i - 1) + 3)),
					df.format(DATA.get(10 * (i - 1) + 0)), df.format(DATA.get(10 * (i - 1) + 2)),
					df.format(DATA.get(10 * (i - 1) + 8)), df.format(DATA.get(10 * (i - 1) + 4)),
					df.format(DATA.get(10 * (i - 1) + 6)), df.format(DATA.get(10 * (i - 1) + 7)));
		}
		if (PP.groupnum == 2) {
			System.out.printf("%-6s%-7s%-7s%-6s%-7s%-7s%-6s%-6s\n", "第二段", "进水流量", "产水流量", "回收率", "进水TDS", "产水TDS",
					"脱盐率", "进水压力");
			System.out.printf("%-8s%-9s%-9s%-7s%-9s%-9s%-8s%-6s\n", "  1",
							df.format(
									DATA.get(10 * (PP.monum(groupnum - 1) - 1) + 3) * (PP.vesselsnum1) / (PP.vesselsnum2)),
							df.format(
									DATA.get(10 * (PP.monum(groupnum)))),
							df.format(
									DATA.get(10 * (PP.monum(groupnum)) + 2)),
							df.format(
									DATA.get(
											10 * (PP.monum(groupnum - 1) - 1) + 5)),
							df.format(DATA.get(10 * (PP.monum(groupnum)) + 4)),
							df.format(DATA.get(10 * (PP.monum(groupnum)) + 6)),
							df.format(DATA.get(10 * (PP.monum(groupnum - 1) - 1) + 7)
									- DATA.get(10 * (PP.monum(groupnum - 1) - 1) + 1) - 0.0372 + PP.P12));
			for (int i = 2; i <= PP.monum(PP.groupnum); i++) {
				System.out.printf("%-8s%-9s%-9s%-7s%-9s%-9s%-8s%-6s\n", "  " + i,
						df.format(DATA.get(10 * (PP.monum(groupnum - 1) + i - 1) + 3)
								+ DATA.get(10 * (PP.monum(groupnum - 1) + i - 1))),
						df.format(DATA.get(10 * ((PP.monum(groupnum - 1) + i - 1)))),
						df.format(DATA.get(10 * (PP.monum(groupnum - 1) + i - 1) + 2)),
						df.format(DATA.get(10 * (PP.monum(groupnum - 1) + i - 1) + 8)),
						df.format(DATA.get(10 * (PP.monum(groupnum - 1) + i - 1) + 4)),
						df.format(DATA.get(10 * (PP.monum(groupnum - 1) + i - 1) + 6)),
						df.format(DATA.get(10 * (PP.monum(groupnum - 1) + i - 1) + 7)));
			}
		}
	}

	public void warning(ArrayList<Double> DATA) {
		double MaxInVel = 0;
		double MaxP =0;
		int maxin = 1;
		int maxp = 1;
		int count = 0;
		int gm=0;
		int temp=0;
		if(PP.groupnum==1){
			MaxInVel = DATA.get(0) + DATA.get(3);
			MaxP = DATA.get(7);
			gm=PP.nmyjs1;
			temp=0;
		}else if(PP.groupnum==2){
			MaxInVel = (DATA.get(10 * (PP.nmyjs1 - 1)) + DATA.get(10 * (PP.nmyjs1 - 1) + 3));
			MaxP = DATA.get(10 * (PP.nmyjs1) + 7);
			gm=PP.nmyjs2;
			temp=PP.nmyjs1;
		}
		for(int t=1;t<=PP.groupnum;t++){
		for (int m = 1; m <=gm; m++) {
			if ((DATA.get(10 * (temp+m- 1)) + DATA.get(10 * (temp+m-1) + 3)) > MaxInVel) {
				MaxInVel = (DATA.get(10 * (temp+m-1)) + DATA.get(10 * (temp+m-1) + 3));
				maxin = m;
			}
			if (DATA.get(10 * (temp+m- 1) + 7) > MaxP) {
				MaxP = DATA.get(10 * (temp+m - 1) + 7);
				maxp = m;
			}
			if ((DATA.get(10 * (temp+m - 1)) > 1.7)) {
				System.out.println("第"+t+"段的第" + m + "支膜设计超出限值，产水量 >1.7");
			}
			if (DATA.get(10 * (temp+m - 1) + 2) > 0.3) {
				System.out.println("第"+t+"段的第"+ m + "支膜设计超出限值，回收率>0.3");
			}
			if (DATA.get(10 * (temp+m - 1) + 3) < 3) {
				System.out.println("第"+t+"段的第" + m + "支膜设计超出限值，浓水量<3");
			}
		}
		if (MaxP > 4.1) {
			System.out.println("第"+t+"段的第"+ maxp + "支膜设计超出限值，最大压力>4.1");
		}
		if (MaxInVel> 17) {
			System.out.println("第"+t+"段的第"+ maxin + "支膜设计超出限值，最大进水量>17");
		}
		}
		for (int k = 1; k <= (gm+temp); k++) {
			if (DATA.get(10 * (k - 1)) <= 1.7 && DATA.get(10 * (k - 1) + 2) <= 0.3
					&& DATA.get(10 * (k - 1) + 3) >= 3 && DATA.get(10 * (k - 1) + 7) <= 4.1
					&& (DATA.get(10 * (k - 1)) + DATA.get(10 * (k - 1) + 3)) <= 17) {
				count++;
			}
		}
		if (count==(temp+gm)) {
			System.out.println("无");
		}
	}
}
