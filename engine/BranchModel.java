package engine;
import java.util.ArrayList;

public class BranchModel extends Branch {
	public BranchModel(int mo_num, String mo_type, double Pf, double In_Vel, double In_TDS, double Paif,
			double Avgpfc, double Y, double AvgY) {
		super(mo_num, mo_type, Pf, In_Vel, In_TDS, Paif, Avgpfc, Y, AvgY);
	}

	public ArrayList<Double> MoCalculate() {
		double temp0 = 0, temp1 = Avgpfc, temp2 = Y, temp3 = 0;
		double temp00 = 0, temp11 = 0, temp22 = 0, temp33 = 0;

		ArrayList<Double> data = new ArrayList<Double>();
		double pai_1 = Paif * Calculate.w(AvgY);
		double A = Calculate.A(motype, water.T, InTDS, InVel, Pf);
		double Qp_1 = (1.0 / 4.061) * Calculate.mo_area(motype) * A * Calculate.TCF(water.T) * water.wryz
				* (Pf - Avgpfc / 2 - pai_1);
		double Qc_1 = InVel - Qp_1;
		double pfc_1 = Calculate.Pfc(Calculate.nszl_ratio(motype), InVel, Qc_1);
		double Y_1 = Qp_1 / InVel;
		temp00 = Qp_1;
		temp11 = pfc_1;
		temp22 = Y_1;
		temp33 = Qc_1;

		if ((pfc_1 != Avgpfc) && (Y_1 != Y)) {
			while (!Calculate.Compare(temp11, temp1, temp22, temp2)) {
				double pai_1i = Paif * Calculate.w(temp22);
				double Qp_1i = (1.0 / 4.061) * Calculate.mo_area(motype) * A * Calculate.TCF(water.T) * water.wryz
						* (Pf - temp11 / 2 - pai_1i);
				double Qc_1i = InVel - Qp_1i;
				double pfc_1i = Calculate.Pfc(Calculate.nszl_ratio(motype), InVel, Qc_1i);
				double Y_1i = Qp_1i / InVel;
				temp0 = temp00;
				temp1 = temp11;
				temp2 = temp22;
				temp3 = temp33;
				temp00 = Qp_1i;
				temp11 = pfc_1i;
				temp22 = Y_1i;
				temp33 = Qc_1i;
				break;
			}
		}
		double B = Calculate.B(motype, water.T, InTDS, InVel, Pf);
		double Cp_1 = InTDS / (1 + 1000 * temp00 / (B * Calculate.mo_area(motype) * Calculate.TCF(water.T)));
		double Cc_1 = (InVel * InTDS - temp00 * Cp_1) / temp33;
		double R = 1 - (Cp_1 / InTDS);
		data.add(temp00);
		data.add(temp11);
		data.add(temp22);
		data.add(temp33);
		data.add(Cp_1);
		data.add(Cc_1);
		data.add(R);
		data.add(Pf);
		data.add(InTDS);
		data.add(Paif);
		return data;
	}
}
