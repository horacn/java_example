package com.hz.example.logic;

/**
 * 某地有两个奇怪的村庄，张庄的人在星期一、三、五说谎，李村的人在星期二、四、六说谎。
 * 在其他日子他们说实话,一天,外地的王从明来到这里,见到两个人,分别向他们提出关于日期的题,两个人都说”前天是我说谎的日子”
 * 如果被问的两个人分别来自张庄和李村,那么这一天是星期几？
 * 
 * @author Zhao.He
 */
public class TestVillageLie {
	public static void main(String[] args) {
		boolean isLay = true;
		for(int beYes = 1;beYes <= 7;beYes++){
			int today = (beYes+2)%7;
			String zhangCun = "zhang";
			String liCun =  "li";
			if(isRight(zhangCun,beYes,isLay) && isRight(liCun,beYes,isLay)){
				System.out.println("这一天是星期"+today);
			}
		}
	}
	/**
	 * 逻辑是否正确，正确就返回true
	 * @param user
	 * @param beYes
	 * @param isLay
	 * @return
	 */
	public static boolean isRight(String user,int beYes,boolean isLay){
		int today = (beYes+2)%7;
		boolean belay = isLying(user,beYes);
		boolean lay = isLying(user,today);
		if(lay && !belay == isLay){
			return true;
		}else if(!lay && belay == isLay){
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 是否说谎
	 * @param user
	 * @param day
	 * @return
	 */
	private static boolean isLying(String user,int day){
		if("zhang".equals(user)){
			if(day == 1 || day == 3 || day == 5){
				return true;
			}
		}else if(user.equals("li")){
			if(day == 2 || day == 4 || day == 6){
				return true;
			}
		}
		return false;
	}
}
