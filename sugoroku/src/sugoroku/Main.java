package sugoroku;

import java.util.Random;
import java.util.Scanner;

/**
 * すごろくchallenge
 * @author 3d159
 *
 */

public class Main {
	//すごろくインスタンスで使用する乱数発生装置
	private Random rand = new Random();
	
	private Scanner input = new Scanner(System.in);
	
	int turn;
	
	/**
	 * すごろくのマスめ配列
	 */
	private Cell[] path;
	/**
	 * プレイヤーのコマ
	 */
	private Coma[] players;
	
	private boolean start = false;
	private boolean goal = false;
	
	/**
	 * すごろくのメインプログラム
	 * @param args  起動時引数
	 */
	
	
	public static void main(String[] args) {

		//ダイスがある
		//マス目がある
		//ふりだし。あがり。その他のいろいろなマスがある
		//プレイヤーが存在する
		//どの位置にいるかを記録しておく必要がある
		//お金の概念がある
		//アイテムの概念がある
		
		
		//どんなマスが存在しているのか、画面に出たほうがいい
		//競争するならそれぞれのプレイヤーの位置がどこかわかる
		
		
//		Main m = new Main();
//		m.run();
		new Main().run();
		
	}
	/**
	 * すごろくプログラムの動作
	 */
	private void run() {

		initGame();
		
		//ターンを繰り返し
		do {
			showPath();
				for (int i = 0; i < players.length; i++) {	
						//プレイヤーがダイスを振る
					if(players[i].getType() == 0) {
						System.out.println("ダイスを振る（エンターキー押下）");
						input.nextLine();   //入力待ち（データは読み取らない）
					}
					int proceed = rand.nextInt(4) + 1;  // 1～４のどれか適当に
					System.out.println( proceed + "だよ");
					//コマを出目文進める
					players[i].proceed(proceed);
					//どんなマスに来たのか情報を出す
					
					int pos = players[i].getPosition();
					if( pos < path.length) {
						Cell now = path[pos];
						System.out.println(now.getCaption());
						now.doEvent(players,i);
						players[i].showProfiel();
					}
					//もしゴールだったらゲーム終了
					start = path.length -1 <= players[i].getPosition();
					if (start) {
						if(path.length -1 == players[i].getPosition()) {
							goal = true;
							break;
						}else {
							players[i].back((players[i].getPosition() % (path.length - 1)) * 2);
							Cell now = path[players[i].getPosition()];
							System.out.println(path[players[i].getPosition()].getCaption());
							now.doEvent(players,i);
							players[i].showProfiel();
						}
						//System.out.println("ゴールだよ");
						//break;
					}
				}
			turn += 1;
		} while (!goal);

		exitGame();
	}
	/**
	 * 現状のすごろく状態を表示する
	 */
	private void showPath() {
		// マス目番号を表示
		System.out.print("  ");
		for (int i = 0; i < path.length; i++) {
			if( i < 10 ) {
				System.out.print( " ");
			}
			System.out.print( i + "  ");
		}
		System.out.println(); //改行
		System.out.print("   ");
		for (int i = 0; i < path.length; i++) {
			System.out.print( path[i].getMark() + "   ");
		}
		System.out.println();
		
		//プレイヤー位置を表示
		for (int i = 0; i < players.length; i++) {
			showComaPos(i);
		}


	}
	private void showComaPos(int pid ) {
		Coma coma = players[pid];
		System.out.print( pid + ":" );
		for (int i = 0; i < path.length; i++) {
			if( i != coma.getPosition() ) {
				System.out.print( "    " );
			}else {
				System.out.print(" *     ");
			}
		}
		System.out.println();// 改行
	}
	
	private void exitGame() {
		// TODO ゲームが終わった時の処理
		System.out.println("クリアまで" + turn + "ターンかかったよ");
		for (int i = 0; i < players.length; i++) {
			players[i].showProfiel();
		}
	}
	/**
	 * ゲームを始めるための下準備
	 */
	private void initGame() {
		// TODO マスを準備
		path = new Cell[] {
				 new StartCell(),
				 new BattleCell(),				 
				 new NormalCell(),
				 new EventCell(),
				 new EventCell(),
				 new NormalCell(),
				 new EventCell(),
				 new EventCell(),
				 new NormalCell(),
				 new EventCell(),
				 new EventCell(),
				 new EventCell(),
				 new BattleCell(),
				 new NormalCell(),
				 new EventCell(),
				 new EventCell(),
				 new EventCell(),
				 new EventCell(),
				 new NormalCell(),
				 new EventCell(),
				 new EventCell(),
				 new EventCell(),
				 new NormalCell(),
				 new GoalCell()
		};
//		for (int i = 1; i < path.length -1; i++) {
//			//とりあえず通常マスで埋める
//			path[i] = new NormalCell();
//		}
//		path[path.length -1] = new GoalCell();
		// TODO プレイヤー準備
		players = new Coma[] {
				new Coma("player",0),	
				new Coma("cpu",1)
		};
		
		
	}

}
