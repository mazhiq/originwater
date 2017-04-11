package engine;
import java.util.ArrayList;
public class Calculate {
	public static boolean MatchString(String str, String input) {
		if (str.length() >= input.length()) {
			String substr = str.substring(0, input.length());
			if (substr.equalsIgnoreCase(input)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	public static ArrayList<String> CheckMatch(String[] str, String input) {
		ArrayList<String> STR = new ArrayList<String>();
		for (int m = 0; m < str.length; m++) {
			if (str[m].length() >= input.length()) {
				String substr = str[m].substring(0, input.length());
				if (substr.equalsIgnoreCase(input)) {
					STR.add(str[m]);
				}
			}
		}
		return STR;
	}

	public static ArrayList<String> SpiltString(String str) {
		ArrayList<String> temp = new ArrayList<>();
		String[] tempstr = str.split("[ \t]");
		for (int t = 0; t < tempstr.length; t++) {
			if (!tempstr[t].isEmpty()) {
				temp.add(tempstr[t]);
			}
		}
		return temp;
	}

	/*
	 * 系统平均回收率相关
	 */
	public static  double w(double y) {
		double b = (1 + Math.pow((1 - y), -1)) / 2;
		double β = Math.exp(0.7 * y);
		double w = b * β;
		return w;
	}

	/*
	 * 求温度系数TCF方法
	 */
	public static double TCF(double T1) {
		double TCF = 0;
		double a = 2640 * (1.0 / 298 - (double) 1 / (273 + T1));
		double b = 3020 * (1.0 / 298 - (double) 1 / (273 + T1));
		if (T1 > 25) {
			TCF = Math.exp(a);
		} else {
			TCF = Math.exp(b);
		}
		return TCF;
	}

	/*
	 * 进水渗透压πf
	 */
	public static double paif(double T2, double cf, double m) {
		double paif = 8.31 * Math.pow(10, -6) * (273 + T2) * (cf / m + cf / m);
		return paif;
	}

	/*
	 * 单支膜压力降
	 */
	public static double Pfc(double k, double Qf, double Qc) {
		double a = (Qf + Qc) * 4.403 / 2;
		double Pfc = (k / 145.038) * Math.pow(a, 1.7);
		return Pfc;
	}

	/*
	 * 透水系数A与透盐系数B的计算
	 */
	public static double A(String s, double x1, double x2, double x3, double x4) {
		double a0 = 0, a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 = 0, a6 = 0, a7 = 0, a8 = 0, a9 = 0, a10 = 0, a11 = 0,
				a12 = 0, a13 = 0;
		if (s.equals("BW_8040")) {
			a0 = 7.016 * Math.pow(10, -2);
			a1 = 1.850 * Math.pow(10, -3);
			a2 = 3.188 * Math.pow(10, -6);
			a3 = 4.812 * Math.pow(10, -4);
			a4 = -4.398 * Math.pow(10, -2);
			a5 = -2.575 * Math.pow(10, -9);
			a6 = 4.668 * Math.pow(10, -5);
			a7 = -3.874 * Math.pow(10, -5);
			a8 = -3.282 * Math.pow(10, -6);
			a9 = -3.750 * Math.pow(10, -3);
			a10 = 6.780 * Math.pow(10, -5);
			a11 = -4.114 * Math.pow(10, -12);
			a12 = 1.282 * Math.pow(10, -4);
			a13 = 3.600 * Math.pow(10, -2);

		} else if (s.equals("ULP_8040")) {
			a0 = 1.144 * Math.pow(10, -1);
			a1 = 4.480 * Math.pow(10, -3);
			a2 = 7.346 * Math.pow(10, -6);
			a3 = -9.245 * Math.pow(10, -5);
			a4 = -6.363 * Math.pow(10, -2);
			a5 = -1.705 * Math.pow(10, -7);
			a6 = 5.958 * Math.pow(10, -5);
			a7 = -5.743 * Math.pow(10, -4);
			a8 = -6.242 * Math.pow(10, -6);
			a9 = -3.860 * Math.pow(10, -3);
			a10 = 9.771 * Math.pow(10, -5);
			a11 = 6.744 * Math.pow(10, -11);
			a12 = 1.431 * Math.pow(10, -4);
			a13 = 4.683 * Math.pow(10, -2);

		} else if (s.equals("SW_8040")) {
			a0 = 5.307 * Math.pow(10, -2);
			a1 = 1.520 * Math.pow(10, -3);
			a2 = 2.599 * Math.pow(10, -7);
			a3 = 3.199 * Math.pow(10, -4);
			a4 = -9.960 * Math.pow(10, -3);
			a5 = -1.124 * Math.pow(10, -8);
			a6 = 1.086 * Math.pow(10, -5);
			a7 = -7.040 * Math.pow(10, -5);
			a8 = -6.090 * Math.pow(10, -8);
			a9 = 3.041 * Math.pow(10, -5);
			a10 = 1.395 * Math.pow(10, -5);
			a11 = 1.602 * Math.pow(10, -12);
			a12 = -2.526 * Math.pow(10, -5);
			a13 = 8.628 * Math.pow(10, -4);

		}
		double A = a0 + a1 * x1 + a2 * x2 + a3 * x3 + a4 * x4 + a5 * x1 * x2 + a6 * x1 * x3 + a7 * x1 * x4
				+ a8 * x2 * x4 + a9 * x3 * x4 + a10 * x1 * x1 + a11 * x2 * x2 + a12 * x3 * x3 + a13 * x4 * x4;
		return A;
	}

	public static double B(String s, double x1, double x2, double x3, double x4) {
		double b0 = 0, b1 = 0, b2 = 0, b3 = 0, b4 = 0, b5 = 0, b6 = 0, b7 = 0, b8 = 0, b9 = 0, b10 = 0, b11 = 0,
				b12 = 0, b13 = 0;
		if (s.equals("BW_8040")) {
			b0 = 7.176 * Math.pow(10, -2);
			b1 = -2.920 * Math.pow(10, -3);
			b2 = 1.862 * Math.pow(10, -6);
			b3 = 3.890 * Math.pow(10, -3);
			b4 = -8.096 * Math.pow(10, -2);
			b5 = -1.655 * Math.pow(10, -7);
			b6 = -2.073 * Math.pow(10, -4);
			b7 = 4.340 * Math.pow(10, -3);
			b8 = -3.746 * Math.pow(10, -6);
			b9 = -1.844 * Math.pow(10, -2);
			b10 = 3.200 * Math.pow(10, -4);
			b11 = 2.537 * Math.pow(10, -10);
			b12 = 8.878 * Math.pow(10, -4);
			b13 = 1.043 * Math.pow(10, -1);

		} else if (s.equals("ULP_8040")) {
			b0 = 1.769 * Math.pow(10, -1);
			b1 = -1.047 * Math.pow(10, -2);
			b2 = 7.361 * Math.pow(10, -6);
			b3 = 1.453 * Math.pow(10, -2);
			b4 = -2.798 * Math.pow(10, -1);
			b5 = -8.449 * Math.pow(10, -7);
			b6 = -8.260 * Math.pow(10, -4);
			b7 = 1.531 * Math.pow(10, -2);
			b8 = -1.596 * Math.pow(10, -5);
			b9 = -6.571 * Math.pow(10, -2);
			b10 = 8.367 * Math.pow(10, -4);
			b11 = 1.529 * Math.pow(10, -9);
			b12 = 3.190 * Math.pow(10, -3);
			b13 = 3.716 * Math.pow(10, -1);
		} else if (s.equals("SW_8040")) {
			b0 = 3.755 * Math.pow(10, -2);
			b1 = -9.262 * Math.pow(10, -4);
			b2 = 1.683 * Math.pow(10, -7);
			b3 = 8.081 * Math.pow(10, -4);
			b4 = -6.770 * Math.pow(10, -3);
			b5 = -2.559 * Math.pow(10, -8);
			b6 = -7.182 * Math.pow(10, -5);
			b7 = 4.449 * Math.pow(10, -4);
			b8 = -8.373 * Math.pow(10, -8);
			b9 = -2.248 * Math.pow(10, -4);
			b10 = 9.939 * Math.pow(10, -5);
			b11 = 5.506 * Math.pow(10, -12);
			b12 = 4.760 * Math.pow(10, -5);
			b13 = 7.754 * Math.pow(10, -4);
		}
		double B = b0 + b1 * x1 + b2 * x2 + b3 * x3 + b4 * x4 + b5 * x1 * x2 + b6 * x1 * x3 + b7 * x1 * x4
				+ b8 * x2 * x4 + b9 * x3 * x4 + b10 * x1 * x1 + b11 * x2 * x2 + b12 * x3 * x3 + b13 * x4 * x4;
		return B;
	}

	public static double nszl_ratio(String ss) {
		double nszl_ratio = 0;// nszl_ratio为浓水流通阻力系数
		if (ss.equals("BW_8040")) {
			nszl_ratio = 0.01;
		} else if (ss.equals("ULP_8040")) {
			nszl_ratio = 0.0079;
		} else if (ss.equals("SW_8040")) {
			nszl_ratio = 0.0075;
		}
		return nszl_ratio;
	}

	public static double mo_area(String ss) {
		double mo_area = 0;// 膜元件的面积
		if (ss.equals("BW_8040")) {
			mo_area = 37;
		} else if (ss.equals("ULP_8040")) {
			mo_area = 37;
		} else if (ss.equals("SW_8040")) {
			mo_area = 37;
		}
		return mo_area;
	}

	public static double ts_ratio(String ss) {
		double ts_ratio = 0;// ts_ratio为透水系数初算值
		if (ss.equals("BW_8040")) {
			ts_ratio = 0.125;
		} else if (ss.equals("ULP_8040")) {
			ts_ratio = 0.235;
		} else if (ss.equals("SW_8040")) {
			ts_ratio = 0.055;
		}
		return ts_ratio;
	}

	/*
	 * 判断
	 */
	public static boolean Compare(double datapfc, double opfc2, double dataY, double y2) {
		double m = datapfc / opfc2;
		double n = dataY / y2;
		if ((m > 0.995 && m < 1.005) && (n > 0.995 && n < 1.005)) {
			return true;
		} else {
			return false;
		}
	}
}
