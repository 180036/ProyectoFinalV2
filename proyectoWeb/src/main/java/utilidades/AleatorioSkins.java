package utilidades;

import java.util.List;
import java.util.Random;

import com.app.web.entidad.Skin;

public abstract class AleatorioSkins {
	static Random random = new Random();
	public static Skin skinAleatoria(List<Skin> lista, int rol) {

		Skin skinDevolver = new Skin();
		Skin skinPC = new Skin();
		Skin skinR = new Skin();
		Skin skinM= new Skin();
		Skin skinL= new Skin();
		Skin skinA= new Skin();
		
		// int random = (int)(Math.random()*100) + 1;

		for (Skin s : lista) {

			if (s.getCs().getId() == 1) // A devolver siempre una comun
				skinDevolver = s;
			if (s.getCs().getId() == 2)
				skinPC = s;
			if (s.getCs().getId() == 3)
				skinR = s;
			if (s.getCs().getId() == 4)
				skinM = s;
			if (s.getCs().getId() == 5)
				skinL = s;
			if (s.getCs().getId() == 6)
				skinA= s;

		}
		
	
		
		if(rol == 0) {
			if(randomPC())
				skinDevolver = skinPC;
			if(randomR())
				skinDevolver = skinR;
			if(randomM())
				skinDevolver = skinM;
			if(randomL())
				skinDevolver = skinL;
			if(randomA())
				skinDevolver = skinA;
			
		} else if(rol == 1) {
			skinDevolver = skinR; //Minimo le devuelve una rara
			if(randomM())
				skinDevolver = skinM;
			if(randomL())
				skinDevolver = skinL;
			if(randomA())
				skinDevolver = skinA;
		} else if(rol == 2) { //Al ser admin devuelve la mejor
			return skinA;
		}
		
		return skinDevolver;
	}
	private static boolean randomPC() {
		return new Random().nextBoolean(); //50% 1/2
		
	}
	private static boolean randomR() {
		random = new Random();
        int randomNumber = random.nextInt(5);
        int randomNumber2 = random.nextInt(5);
		return randomNumber == randomNumber2; //20% 1/5
		
	}
	private static boolean randomM() {
		random = new Random();
        int randomNumber = random.nextInt(20);
        int randomNumber2 = random.nextInt(20);
		return randomNumber == randomNumber2; //5% 1/20
		
	}
	private static boolean randomL() {
		random = new Random();
        int randomNumber = random.nextInt(50);
        int randomNumber2 = random.nextInt(50);
		return randomNumber == randomNumber2; //2% 1/50
		
	}
	private static boolean randomA() {
		random = new Random();
        int randomNumber = random.nextInt(100);
        int randomNumber2 = random.nextInt(100);
		return randomNumber == randomNumber2;  //1% 1/100
		
	}
}
