/**
 * 
 */
package sugoroku;

/**
 * すごろくのプレイヤーと位置を表すコマクラス
 * @author 3d159
 *
 */
public class Coma {
	/**
	 * プレイヤーの名前
	 */
	private String name;
	/**
	 * プレイヤーの位置
	 */
	private int position;
	/**
	 * 持ち金
	 */
	private int mony = 1000;
	
	private int type;

	
	/**
	 * コンストラクタ
	 */
	public Coma( String name,int type) {
		this.name = name;
		this.type = type;
	}
	
	/**
	 * このコマの現在位置を返す
	 * @return
	 */
	public int getPosition(){
		return this.position;
	}
	public int getType() {
		return this.type;
	}
	/**
	 * この4コマが 指定された分量 進みます
	 * @param amount 進む量
	 */
	public void proceed( int amount ) {
		this.position += amount;
		
	}
	//マス戻る
	public void back (int amount) {
		this.position -= amount;
	}
	// 金が増える
	public void addMony( int amount) {
		System.out.println(name + "は" + amount + "円手に入れた");
		this.mony += amount;
	}
	//金が減る
	public void dddMony( int amount) {
		System.out.println(name + "は" + amount + "円失った");
		this.mony -= amount;
	}	//金が減る
	public void dddhalfMony() {
		int amount = this.mony/2;
		System.out.println(name + "は" + amount + "円失った");
		this.mony -= amount;
	}	//金が減る
	public void dddfullMony() {
		int amount = this.mony;
		System.out.println(name + "は" + amount + "円失った");
		this.mony -= amount;
	}
	
	public void showProfiel() {
		System.out.println(name + "は" + this.mony + "円持っている" + this.position + "コマにいる");
	}
	public String getName() {
		return this.name;
	}
}
