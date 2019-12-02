/**
 * 
 */
package sugoroku;

import java.util.Random;

/**
 * すごろくに使用される 升目を表現する 基底クラス
 * @author 3d159
 *
 */
public abstract class Cell {
	/**
	 * マス目の確立に使用する乱数
	 */
	protected Random rand = new Random();
	
	/**
	 *コンストラクタ(new できないので protectedにしておく) 
	 */
	protected Cell() {

	}
	/**
	 * なにかしらのイベントを実行できる予定
	 */
	public abstract boolean doEvent(Coma[] coma,int i);
	/**
	 *このマス目の表示名 
	 */
	public abstract String getCaption();
	public abstract String getMark();

}
