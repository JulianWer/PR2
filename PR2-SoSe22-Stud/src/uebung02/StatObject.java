package uebung02;

public class StatObject {
	private int swpcnt =0;
	private int cnt = 0;
	private int compcnt = 0;
	
	public void setSwpcnt() {
		this.swpcnt++;
	}
	public void setCnt() {
		this.cnt++;
	}
	public void setCompcnt() {
		this.compcnt++;
	}
	public int getcomparisonCounter() {return compcnt;}
	public int getswapCounter() {
		return swpcnt;
	}
	public int getrunCounter() {
		return cnt;
	}

}
