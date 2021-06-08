package bean;

public class Pay {
	/**購入履歴*/
	private BuyHistory buyHistory;
	/**合計金額*/
	private String pay;

	public BuyHistory getBuyHistory() {
		return buyHistory;
	}

	public void setBuyHistory(BuyHistory buyHistory) {
		this.buyHistory = buyHistory;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}
}
