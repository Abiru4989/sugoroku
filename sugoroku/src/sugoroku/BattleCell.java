package sugoroku;

import java.util.Scanner;

public class BattleCell extends Cell {
	private Scanner input = new Scanner(System.in);
	private int bet;
	private int[] battle = new int[10];
	
	public BattleCell() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public boolean doEvent(Coma[] coma,int i) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println(coma[i].getName() + "さんがバトルマスにとまりました");
		System.out.println("掛け金を入力してくだし");
		bet = input.nextInt();
		System.out.println("掛け金を徴収します");
		for (int j = 0; j < coma.length; j++) {
			coma[j].dddMony(bet);
			battle[j] = rand.nextInt(50);
		}
		int max = battle[0];
		int win = 0;
		for (int j = 0; j < coma.length; j++) {
			System.out.println(coma[j] + "さんは" + battle[j] + "の数値");
		}
		for (int j = 0; j < battle.length; j++) {
			if(max < battle[j]) {
				max = battle[j];
				win = j;
			}
		}
		System.out.println("勝者は" + battle[win] + "の数値を出した" + coma[win] + "さんです");
		System.out.println("賞金は" + bet*coma.length + "円です！");
		coma[win].addMony(bet*coma.length);
		return true;
	}

	@Override
	public String getCaption() {
		// TODO 自動生成されたメソッド・スタブ
		return "バトルマスだっぇぇぇ";
	}

	@Override
	public String getMark() {
		// TODO 自動生成されたメソッド・スタブ
		return "V";
	}

}
