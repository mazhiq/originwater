package engine;
public class Water {
	public double inTDS;
	public double T;
	public double wryz;
	public double pH;

	public Water(double in_TDS, double T, double wryz, double pH) {
		this.inTDS = in_TDS;
		this.T= T;
		this.wryz = wryz;
		this.pH = pH;
	}

	public double getIn_TDS() {
		return inTDS;
	}

	public void setIn_TDS(double in_TDS) {
		this.inTDS = in_TDS;
	}

	public double getT() {
		return T;
	}

	public void setT(double t) {
		T = t;
	}

	public double getWryz() {
		return wryz;
	}

	public void setWryz(double wryz) {
		this.wryz = wryz;
	}

	public double getpH() {
		return pH;
	}

	public void setpH(double pH) {
		this.pH = pH;
	}
}
