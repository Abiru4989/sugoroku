package sugoroku;

public class EventCell extends Cell {
	int flg = rand.nextInt(100);
	public EventCell() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public boolean doEvent(Coma[] coma,int i) {
		if(flg <= 49) {
			coma[i].addMony(300);
		}else if(flg <= 74) {
			coma[i].addMony(500);
		}else if(flg <= 89) {
			coma[i].addMony(1000);
		}else if(flg <= 94) {
			coma[i].addMony(2000);
		}else if(flg <= 99) {
			coma[i].addMony(3000);
		}
		return true;
	}

	@Override
	public String getCaption() {
		if(flg <= 49) {
			return "お金を拾った！";
		}else if(flg <= 74) {
			return "お金を拾った！!";
		}else if(flg <= 89) {
			return "お金を拾った！!!";
		}else if(flg <= 94) {
			return "財布を拾った！";
		}else if(flg <= 99) {
			return "財布を拾った！";
		}else {
			return "";
		}
	}

	@Override
	public String getMark() {
		// TODO 自動生成されたメソッド・スタブ
		return "!";
	}

}
