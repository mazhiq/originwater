package engine;
import console.*;
public class Branch {
	String motype;// 膜元件类型
	int monum;
	double Pf;// 膜进水压力
	double InTDS;// 膜进水浓度/TDS Cf
	double InVel;// 进水量 Qf
	double Paif;
	double Avgpfc;
	double Y;// 回收率 Y
	double AvgY;
	static double M = 58.44;// 氯化钠的摩尔质量
	static Water water = new Water(2000.0, 25, 0.85, 7.6);
	static ProcessInfromation PP= new ProcessInfromation(2, 2, 3, 1, 3, 0, "BW_8040", 7.5, 0.6);
	public Branch(int mo_num, String mo_type, double Pf, double In_Vel, double In_TDS, double Paif,
			double Avgpfc, double Y, double AvgY) {
		this.monum = mo_num;
		this.motype = mo_type;
		this.Pf = Pf;
		this.InVel = In_Vel;
		this.InTDS = In_TDS;
		this.Paif = Paif;
		this.Avgpfc = Avgpfc;
		this.Y = Y;
		this.AvgY = AvgY;
	}

	public int getMo_num() {
		return monum;
	}

	public void setMo_num(int mo_num) {
		this.monum = mo_num;
	}

	public double getIn_Vel() {
		return InVel;
	}

	public void setIn_Vel(double in_Vel) {
		InVel = in_Vel;
	}

	public double getPf() {
		return Pf;
	}

	public void setPf(double pf) {
		Pf = pf;
	}

	public double getIn_TDS() {
		return InTDS;
	}

	public void setIn_TDS(double in_TDS) {
		InTDS = in_TDS;
	}

	public String getMo_type() {
		return motype;
	}

	public void setMo_type(String mo_type) {
		this.motype = mo_type;
	}
	
}
