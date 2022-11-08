package Model;

public class TruModel {
	private static double log2_10 = 3.321928095;

	private int w;
	private int p;
	private int t;
	private int z;
	private int[] a;
	private int[] b;
	private int[] result;

	public TruModel() {

	}

	public TruModel(int w, int p, int[] a, int[] b) {
		this.w = w;
		this.p = p;
		this.a = a;
		this.b = b;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getT() {
		return t;
	}

	public void setT(int t) {
		this.t = t;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public int[] getA() {
		return a;
	}

	public void setA(int[] a) {
		this.a = a;
	}

	public int[] getB() {
		return b;
	}

	public void setB(int[] b) {
		this.b = b;
	}

	public int soDu(int a) {
		int z = (int) Math.pow(2, w);
		if (a < 0) {
			a = z + a;
		}
		int k = (int) a / z;
		return a - k * z;
	}

	public int[] getResulthaveP() {
		int m = (int) (Math.log10(p) * log2_10);
		int t = (int) Math.ceil(((float) m) / ((float) w));
		int[] c = new int[t];
		int z = 0;
		c[t - 1] = a[t - 1] - b[t - 1];
		long limit = (long) Math.pow(2, w);
		if (c[t - 1] >= 0 && c[t - 1] < limit) {
			z = 0;
		} else {
			z = 1;
			c[t - 1] = soDu(c[t - 1]);
		}
		for (int i = t - 2; i >= 0; i--) {
			c[i] = a[i] - b[i] - z;
			if (c[i] >= 0 && c[i] < limit) {
				z = 0;
			} else {
				z = 1;
				c[i] = soDu(c[i]);
			}
		}
		setZ(z);
		this.result = c;
		return result;
	}

	public int[] getResultdonthaveP() {
		int[] c = new int[t];
		int z = 0;
		c[t - 1] = a[t - 1] - b[t - 1];
		long limit = (long) Math.pow(2, w);
		if (c[t - 1] >= 0 && c[t - 1] < limit) {
			z = 0;
		} else {
			z = 1;
			c[t - 1] = soDu(c[t - 1]);
		}
		for (int i = t - 2; i >= 0; i--) {
			c[i] = a[i] - b[i] - z;
			if (c[i] >= 0 && c[i] < limit) {
				z = 0;
			} else {
				z = 1;
				c[i] = soDu(c[i]);
			}
		}
		setZ(z);
		this.result = c;
		return result;
	}

}
