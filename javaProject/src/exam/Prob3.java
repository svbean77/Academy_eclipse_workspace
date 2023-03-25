package exam;

class Prob3 {
	public static void main(String args[]) {
		PhoneCharge skt = new PhoneCharge("김현우", 100, 50, 1);
		PhoneCharge ktf = new PhoneCharge("신희만", 200, 100, 2);
		PhoneCharge lgt = new PhoneCharge("조유성", 150, 500, 10);
		skt.printCharge();
		ktf.printCharge();
		lgt.printCharge();
	}
}

class PhoneCharge {
	// 구현하시오.
	private String user;
	private int call;
	private int sms;
	private int data;
	private int total;

	public PhoneCharge(String user, int call, int sms, int data) {
		this.user = user;
		this.call = call;
		this.sms = sms;
		this.data = data;
	}

	public int calcCharte() {
		int callFee;
		int smsFee;
		int dataFee;

		if (call >= 200) {
			callFee = 20 * call;
		} else {
			callFee = 10 * call;
		}

		if (sms >= 300) {
			smsFee = 80 * sms;
		} else {
			smsFee = 20 * sms;
		}

		if (data >= 7) {
			dataFee = 2000 * data;
		} else {
			dataFee = 1000 * data;
		}

		return callFee + smsFee + dataFee;
	}

	public void printCharge() {
		this.total = calcCharte();
		System.out.println(user + " 사용자는 이번달에 사용하신 전화요금이 " + total + " 원입니다.");
	}
}
