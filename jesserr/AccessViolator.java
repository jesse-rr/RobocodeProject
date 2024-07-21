package jesserr;

import robocode.*;
import java.awt.Color;

public class AccessViolator extends AdvancedRobot {// tem q set AdvancedRobot

	 public void run() {
		setAllColors(Color.DARK_GRAY);
		turnRadarLeft(Double.POSITIVE_INFINITY);

		while(true) {
		
		}
	}

	 public void onScannedRobot(ScannedRobotEvent e) {
		
		double frente = e.getBearingRadians() + getHeadingRadians(); // achar qual direcao o tank vai virrar com enem. frente + minha frente;
		double gunAng; // angulo da arma, definir dps
		
		setTurnRadarLeftRadians(getRadarTurnRemainingRadians());
		gunAng = robocode.util.Utils.normalRelativeAngle(frente - getGunHeadingRadians()); // definir angulo da arma (variavel)
		        setAhead((e.getDistance() - 120)); // para aproximar inimigo -> movimento em repetiçao, mas n pode colocar no while loop, ent bota aqui msm
		
		// pegar distancia inimiga, pra variar força de tiro
		if (e.getDistance() > 130) { 
		
			setTurnGunRightRadians(gunAng); // setar o ang da arma, tem q ser dps do primeiro
			setTurnRightRadians(robocode.util.Utils.normalRelativeAngle(frente - getHeadingRadians()));
			
			fire(2); // fire mais fraco pq mais distancia = mais facil de desviar
		}
		else { 
			
			setTurnGunRightRadians(gunAng); 
			setTurnRight(90 - e.getBearing());
			
			fire(3); // fire mais forte pq menos distancia = mais dificil de desviar
		}
	}
	
	public void onHitByBullet(HitByBulletEvent e) {

		// nao precisa, "acho"
	}
	
	public void onHitWall(HitWallEvent e) {

		// nao precisa, "acho"
	}	
	
	public void onWin(WinEvent e){
		
		// hump
		for(int i=0; i<10; i++){
			ahead(10);
			back(10);
		}
	}
}
