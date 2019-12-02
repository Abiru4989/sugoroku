package sugoroku;

/*
 * ゴールのセルクラス
 */
public class GoalCell extends Cell {

	public GoalCell() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public boolean doEvent(Coma[] coma,int i) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public String getCaption() {
		return "ゴールだよ";
	}

	@Override
	public String getMark() {
		// TODO 自動生成されたメソッド・スタブ
		return "G";
	}

}
