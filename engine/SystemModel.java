package engine;
import java.util.ArrayList;

public class SystemModel extends GroupModel {
	public SystemModel(int mo_num, String mo_type, double Pf, double In_Vel, double In_TDS, double Paif,
			double Avgpfc, double Y, double AvgY) {
		super(mo_num, mo_type, Pf, In_Vel, In_TDS, Paif, Avgpfc, Y, AvgY);
	}
	GroupModel gp,gp1;
	static java.text.DecimalFormat df = new java.text.DecimalFormat("0.000");
	
	public ArrayList<Double> SystemCalc(int m,int monum1,String motype1,double avg,double sys,double avghsl) {
		ArrayList<Double> num1 = new ArrayList<Double>();
		ArrayList<Double> num2= new ArrayList<Double>();
		gp = new GroupModel(monum, motype, Pf, InVel, InTDS, Paif, Avgpfc, Y, AvgY);
		num1 = gp.GroupCount();
		if(m==2){
			InVel= num1.get(10 * (PP.monum(m- 1) - 1) + 3) * (PP.vesselsnum1) / (PP.vesselsnum2);
			InTDS= num1.get(10 * (PP.monum(m- 1) - 1) + 5);
			Pf = num1.get(10 * (PP.monum(m- 1) - 1) + 7)
					- num1.get(10 * (PP.monum(m- 1) - 1) + 1) - 0.0372 + PP.P12;
			Paif= Calculate.paif(water.T, water.inTDS, M) * num1.get(10 * (PP.monum(m- 1) - 1) + 5)
					/ num1.get(8);
			gp1 = new GroupModel(monum1,motype1,Pf,InVel, InTDS, Paif, avg,sys,avghsl);
			num2=gp1.GroupCount();
			num1.addAll(num2);
		}
		return num1;
	}

	public ArrayList<Double> SystemPara(ArrayList<Double> DATA,int m) {
		ArrayList<Double> data3 = new ArrayList<Double>();
		ArrayList<Double> data4 = new ArrayList<Double>();
		double Qps1 = 0;
		double YY1 = 0;
		double cp1 = 0, rs1 = 0, fp1 = 0;
		double mm1 = 0;
		double Qps2 = 0;
		double cp2 = 0;
		double Qps3 = 0;
		double cp3 = 0;
		double QP1 = 0, QC1, CP1, FP1, QP2, QC2, CP2, FP2;
		double QPS, Y, CP, Rs, Fp, Qc;
		if (m== 1) {
			for (int i = 1; i <= PP.monum(1); i++) {
				Qps1 = Qps1 + DATA.get(10 * (i - 1));
				cp1 = cp1 +PP.vesselsnum1*(DATA.get(10 * (i - 1)) * DATA.get(10 * (i - 1) + 4)) / PP.outvel;
				mm1 = mm1 + PP.vesselsnum1*(DATA.get(10 * (i - 1)) * DATA.get(10 * (i - 1) + 4)) * (PP.systemHSL* PP.vesselsnum1)
						/ (PP.outvel* DATA.get(8));
			}
			YY1 = (Qps1 * PP.systemHSL * PP.vesselsnum1) / PP.outvel;
			rs1 = 1 - mm1;
			fp1 = PP.outvel * 1000 / (PP.N(1) * Calculate.mo_area(PP.motype));
			data4.add(PP.vesselsnum1 *Qps1);
			data4.add(YY1);
			data4.add(cp1);
			data4.add(rs1);
			data4.add(fp1);
			data4.add(PP.vesselsnum1 *DATA.get(10 * (PP.monum(1) - 1) + 3));
		}
		if (m== 2) {
			for (int i = 1; i <= PP.monum(1); i++) {
				Qps2 = Qps2 + DATA.get(10 * (i - 1));
				cp2 = cp2 + (DATA.get(10 * (i - 1)) * DATA.get(10 * (i - 1) + 4));
			}
			// 第一段
			QP1 = PP.vesselsnum1 * Qps2;
			QC1 = PP.vesselsnum1 * (DATA.get(10 * (PP.monum(1) - 1) + 3));
			CP1 = cp2 / Qps2;
			FP1 = Qps2 * 1000 / (PP.nmyjs1 * Calculate.mo_area(PP.motype));
			data3.add(QP1);
			data3.add(QC1);
			data3.add(CP1);
			data3.add(FP1);
			// 第二段
			for (int j = 1; j <= PP.monum(PP.groupnum); j++) {
				Qps3 = Qps3 + DATA.get(10 * (PP.nmyjs1 + j - 1));
				cp3 = cp3 + (DATA.get(10 * (PP.nmyjs1 + j - 1)) * DATA.get(10 * (PP.nmyjs1 + j - 1) + 4));
			}
			QP2 = PP.vesselsnum2 * Qps3;
			QC2 = PP.vesselsnum2 * DATA.get(10 * (PP.nmyjs1 + PP.monum(PP.groupnum) - 1) + 3);
			CP2 = cp3 / Qps3;
			FP2 = Qps3 * 1000 / (PP.nmyjs2 * Calculate.mo_area(PP.motype));
			QPS = QP1 + QP2;
			Y = QPS / (PP.vesselsnum1 * (DATA.get(0) + DATA.get(3)));
			CP = (cp2 * PP.vesselsnum1 + PP.vesselsnum2 * cp3) / PP.outvel;
			Rs = 1 - CP / DATA.get(8);
			Fp = QPS * 1000 / (PP.N(PP.groupnum) * Calculate.mo_area(PP.motype));
			Qc = QC1 + QC2;
			data3.add(QP2);
			data3.add(QC2);
			data3.add(CP2);
			data3.add(FP2);
			data4.add(QPS);
			data4.add(Y);
			data4.add(CP);
			data4.add(Rs);
			data4.add(Fp);
			data4.add(Qc);
		}
		data4.addAll(data3);
		return data4;
	}
	
}
