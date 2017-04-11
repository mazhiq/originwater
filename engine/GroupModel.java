package engine;
import java.util.ArrayList;

public class GroupModel extends BranchModel {
	public GroupModel(int mo_num, String mo_type, double Pf, double In_Vel, double In_TDS, double Paif,
			double Avgpfc, double Y, double AvgY) {
		super(mo_num, mo_type, Pf, In_Vel, In_TDS, Paif, Avgpfc, Y, AvgY);
	}
	public ArrayList<Double> GroupCount() {
		ArrayList<Double> num = new ArrayList<Double>();
		ArrayList<Double> num1 = new ArrayList<Double>();
		BranchModel mo = new BranchModel(monum, motype, Pf, InVel, InTDS, Paif, Avgpfc, Y, AvgY);
		num = mo.MoCalculate();
		for (int i = 2; i <= monum; i++) {
			InTDS = num.get(10 * (i - 2) + 5);
			InVel = num.get(10 * (i - 2) + 3);
			Pf = num.get(10 * (i - 2) + 7) - num.get(10 * (i - 2) + 1);
			Paif = num.get(9) * num.get(10 * (i - 2) + 5) / num.get(8);
			BranchModel mo1 = new BranchModel(i, motype, Pf, InVel, InTDS, Paif, Avgpfc, Y, AvgY);
			num1 = mo1.MoCalculate();
			num.addAll(num1);
		}
		return num;
	}
}
