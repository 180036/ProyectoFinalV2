package utilidades;

import java.util.List;
import java.util.Random;

import com.app.web.entidad.Skin;

public abstract class AleatorioSkins {
	static Random random = new Random();
	public static Skin skinAleatoria(List<Skin> lista) {

		Skin skinDevolver = new Skin();
		Skin skinPC = new Skin();
		Skin skinR = new Skin();
		Skin skinM= new Skin();
		Skin skinL= new Skin();
		Skin skinA= new Skin();
		Skin skinER= new Skin();
		
		// int random = (int)(Math.random()*100) + 1;

		// Poner pocha a devolver
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
			if (s.getCs().getId() == 7)
				skinER= s;

		}
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
		if(randomER())
			skinDevolver = skinER;

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
	private static boolean randomER() {
		random = new Random();
        int randomNumber = random.nextInt(500);
        int randomNumber2 = random.nextInt(500);
		return randomNumber == randomNumber2;  //0.5% 1/500
		
	}
}
