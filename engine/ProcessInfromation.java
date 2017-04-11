package engine;

public class ProcessInfromation {
	public int groupnum;// 段数
	public int vesselsnum1;// 一段压力容器数
	public int vesselsnum2;// 二段压力容器数
	public int nmyjs1;// 一段压力容器内膜元件数
	public int nmyjs2;// 二段压力容器内膜元件数
	public double P12;// 段间增压
	public String motype;// SS为膜元件类型
	public double outvel;// 系统产水量Qp
	public double systemHSL;// 系统回收率Y

	public ProcessInfromation(int group_num, int ylrq1, int nmyjs1, int ylrq2, int nmyjs2, double P1_2, String mo_type,
			double out_vel, double systemHSL) {
		this.groupnum = group_num;
		this.vesselsnum1 = ylrq1;
		this.nmyjs1 = nmyjs1;
		this.vesselsnum2 = ylrq2;
		this.nmyjs2 = nmyjs2;
		this.P12 = P1_2;
		this.motype = mo_type;
		this.outvel = out_vel;
		this.systemHSL = systemHSL;
	}

	public int getGroup_num() {
		return groupnum;
	}

	public void setGroup_num(int group_num) {
		this.groupnum = group_num;
	}

	public int getYlrq1() {
		return vesselsnum1;
	}

	public void setYlrq1(int ylrq1) {
		this.vesselsnum1 = ylrq1;
	}

	public int getYlrq2() {
		return vesselsnum2;
	}

	public void setYlrq2(int ylrq2) {
		this.vesselsnum2 = ylrq2;
	}

	public int getNmyjs1() {
		return nmyjs1;
	}

	public void setNmyjs1(int nmyjs1) {
		this.nmyjs1 = nmyjs1;
	}

	public int getNmyjs2() {
		return nmyjs2;
	}

	public void setNmyjs2(int nmyjs2) {
		this.nmyjs2 = nmyjs2;
	}

	public double getP1_2() {
		return P12;
	}

	public void setP1_2(double p1_2) {
		P12 = p1_2;
	}

	public String getMo_type() {
		return motype;
	}

	public void setMo_type(String mo_type) {
		this.motype = mo_type;
	}

	public double getOut_vel() {
		return outvel;
	}

	public void setOut_vel(double out_vel) {
		this.outvel = out_vel;
	}

	public double getSystemHSL() {
		return systemHSL;
	}

	public void setSystemHSL(double systemHSL) {
		this.systemHSL = systemHSL;
	}

	public int n(int x) {
		int n = 0;
		if (x == 1) {
			n = nmyjs1;
		} else if (x == 2) {
			n = nmyjs1 + nmyjs2;
		}
		return n;
	}

	public int N(int x) {
		int N = 0;
		if (x == 1) {
			N = vesselsnum1 * nmyjs1;
		} else if (x == 2) {
			N = vesselsnum1 * nmyjs1 + vesselsnum2 * nmyjs2;
		}
		return N;
	}

	public int monum(int x) {
		int monum = 0;
		if (x == 1) {
			monum = nmyjs1;
		} else if (x == 2) {
			monum = nmyjs2;
		}
		return monum;
	}

	// 系统压力降
	public double oPfc(int x) {
		double OPfc = 0;
		if (x == 1) {
			double tem1 = Calculate.nszl_ratio(motype) * nmyjs1 * Math.pow(145.038, -1);
			OPfc = tem1 * Math.pow(4.403 * outvel * (2 - systemHSL) / (2 * systemHSL), 1.7);// 系统压力降
		} else if (x == 2) {
			double tem2 = (outvel * 4.403) * Math.pow(2 * systemHSL * vesselsnum2, -1);
			OPfc = Math.pow(3626, -1) * Math.pow(tem2 * (Math.pow(vesselsnum1 / vesselsnum2, -1) + 1 - systemHSL), 2);// 系统压力降
		}
		return OPfc;
	}

	/*
	 * 系统进水压力Pf
	 */
	public double Pf(double T,double wryz,double intds,double M) {
		double Pf = (outvel * 4.061)
				* Math.pow(N(groupnum) * Calculate.mo_area(motype) * Calculate.ts_ratio(motype) * Calculate.TCF(T)
						* wryz, -1)
				+ oPfc(groupnum) / 2 + Calculate.paif(T, intds, M) * Calculate.w(AvgHSL(systemHSL));
		return Pf;
	}

	public double Avgpfc() {
		double avgpfc = oPfc(groupnum) / n(groupnum);
		return avgpfc;
	}

	/*
	 * 系统平均回收率
	 */
	public double AvgHSL(double Y) {
		double y = 1 - Math.pow((1 - Y), (double) 1 / n(groupnum));// y为平均回收率
		return y;
	}
}
