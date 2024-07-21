package jesserr;

import robocode.*;
import java.awt.Color;

public class AccessViolator extends AdvancedRobot {

	 public void run() {
		setAllColors(Color.DARK_GRAY);
		turnRadarLeft(Double.POSITIVE_INFINITY);

		while(true) {
		
		}
	}

	 public void onScannedRobot(ScannedRobotEvent e) {
		
		double frente = e.getBearingRadians() + getHeadingRadians();
		double gunAng;
		
		setTurnRadarLeftRadians(getRadarTurnRemainingRadians());
		gunAng = robocode.util.Utils.normalRelativeAngle(frente - getGunHeadingRadians());
		setAhead((e.getDistance() - 120)); 
		

		if (e.getDistance() > 130) { 
		
			setTurnGunRightRadians(gunAng);
			setTurnRightRadians(robocode.util.Utils.normalRelativeAngle(frente - getHeadingRadians()));
			
			fire(2);
		}
		else { 
			
			setTurnGunRightRadians(gunAng); 
			setTurnRight(90 - e.getBearing());
			
			fire(3);
		}
	}
	
	public void onHitByBullet(HitByBulletEvent e) {

	}
	
	public void onHitWall(HitWallEvent e) {

	}	
	
	public void onWin(WinEvent e){
		
		for(int i=0; i<10; i++){
			ahead(10);
			back(10);
		}
	}
}
