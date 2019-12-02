/**
 * 
 */
package sugoroku;

/**
 * 普通のマスの実装クラス
 * @author 3d159
 *
 */
public class NormalCell extends Cell {
	int flg = rand.nextInt(50);
	/**
	 * コンストラクタ
	 */
	public NormalCell() {
	}

	/* (非 Javadoc)
	 * @see sugoroku.Cell#doEvent()
	 */
	@Override
	public boolean doEvent( Coma[] coma,int i) {
		// TODO 自動生成されたメソッド・スタブ
		
		if(flg == 0) {
			coma[i].dddfullMony();
			return false;
		}else if(flg == 1 | flg == 2) {
			coma[i].dddhalfMony();
			return false;
		}
		coma[i].addMony(500);
		return true;
	}

	/* (非 Javadoc)
	 * @see sugoroku.Cell#getCaption()
	 */
	@Override
	public String getCaption() {
		// TODO 自動生成されたメソッド・スタブ
		if(flg == 0) {
			System.out.println("所持金の全額をすられた");
		}else if(flg == 1 | flg == 2) {
			System.out.println("所持金の半分をすられた");
		}
		return "風が吹いている....";
	}

	@Override
	public String getMark() {
		// TODO 自動生成されたメソッド・スタブ
		return "#";
	}

}
