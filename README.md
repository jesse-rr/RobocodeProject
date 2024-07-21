# Added Read me for comprehension;


turnRadarLeft(Double.POSITIVE_INFINITY); -> Double.POSITIVE_INFINITY indica que vai aumentar os angulos infinitamente de forma positiva (+)(direita), virando o Radar a todo momento pra esquerda. 
OBS: talvez "turnRadarRight" seja melhor? ou seja 50/50%? ja que arena quadrada/retangular;

onHitByBullet	\
onHitWall     	 |-> n precisa de codigo nesses parametros, pq o radar rodando + tracking faz o robo sair das paredes sozinho [onHitWall]; n precisa de movimento automatico [while(true)], 
while(true)	/    o radar rodando e o unico comando necessario; onHitByBullet = retirado pq tinha problemas onde o robo parava quando era atingido por bala;

fire(1) X -> Gasta muita energia, testes com muitos robos (batalhas) causavam overload do robo; 
fire(2,3) -> Menos energia = melhor;

import java.awt.Color; -> importa cores; Tem que colocar o: setAllColors(Color.DARK_GRAY); acima do turnRadarLeft(Double.POSITIVE_INFINITY); se nao o programa nao adiciona a cor ao robo; 
OBS: "N sei pq" 

O resto basease em logica basica:

"double gunAng;" -> angulo da arma <=> vai ser definido apos achar robo enemigo com "setTurnGunRightRadians(gunAng);"

"double frente = e.getBearingRadians() + getHeadingRadians();" -> variavel que pega a frente do robo enemigo + robo nosso (PI); ex: 90 - 0 = 90 (localizacao do enemigo); 
OBS: Veja mapa abaixo
https://www.google.com/url?sa=i&url=http%3A%2F%2Fmark.random-article.com%2Fweber%2Fjava%2Frobocode%2Flesson4.html&psig=AOvVaw1ClZ-ukIDj-8RixAyuSRmN&ust=1721687123720000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCPDDm72WuYcDFQAAAAAdAAAAABAE

"gunAng = robocode.util.Utils.normalRelativeAngle(frente - getGunHeadingRadians());" -> exatamente a mesma coisa do que o acima, mas pra arma;

"setAhead((e.getDistance() - 120));" -> anda pra frente <=> pega distancia do enemigo = "e.getDistance()" e chega mais perto em ate -120 <graus> 

"if (e.getDistance() > 130)" -> se distancia do enemigo for maior que 130 fire(2) = bala mais rapida pq -> mais distancia
"else" -> se distancia do enemigo for menor que 130 fire(3) = bala mais devagar pq -> menos distancia

"setTurnRightRadians(robocode.util.Utils.normalRelativeAngle(frente - getHeadingRadians()));" \	Ambos sao pra virar pra ficar sempre a direita do enemigo ex: 90 - 0 = +90 (direita considerando
"setTurnRight(90 - e.getBearing());"							      /	que o robo enemigo esteva virado pra 0 graus) = Desviar

