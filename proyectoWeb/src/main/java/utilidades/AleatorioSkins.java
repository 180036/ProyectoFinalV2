package utilidades;

import java.util.List;
import java.util.Random;

import com.app.web.entidad.Skin;

/**
 * Esta clase recupera una Skin Caliddad Aleatoria, segun los datos aleatorios recuperaremos una skin de una calidad.
 * 
 * @author: Oskar Stankevicius
 * @version: 1.0.6v
 */
public abstract class AleatorioSkins {
	static Random random = new Random();
<<<<<<< HEAD
	public static Skin skinAleatoria(List<Skin> lista, int rol) {
=======
	
	/**
     * Genera una calidad aleatoria recuperando los datos aleatorios anteriores.
     * Basada en una lista de skins.
     *
     * @param lista La lista de skins disponibles.
     * @return La skin generada aleatoriamente.
     */
    public static Skin skinAleatoria(List<Skin> lista) {
>>>>>>> branch 'master' of git@github.com:180036/ProyectoFinalV2.git

<<<<<<< HEAD
		Skin skinDevolver = new Skin();
		Skin skinPC = new Skin();
		Skin skinR = new Skin();
		Skin skinM= new Skin();
		Skin skinL= new Skin();
		Skin skinA= new Skin();
		
		// int random = (int)(Math.random()*100) + 1;
=======
        Skin skinDevolver = new Skin();
        Skin skinPC = new Skin();
        Skin skinR = new Skin();
        Skin skinM = new Skin();
        Skin skinL = new Skin();
        Skin skinA = new Skin();
        Skin skinER = new Skin();
>>>>>>> branch 'master' of git@github.com:180036/ProyectoFinalV2.git

<<<<<<< HEAD
		for (Skin s : lista) {
=======
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
                skinA = s;
            if (s.getCs().getId() == 7)
                skinER = s;
        }
>>>>>>> branch 'master' of git@github.com:180036/ProyectoFinalV2.git

<<<<<<< HEAD
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
=======
        if (randomPC())
            skinDevolver = skinPC;
        if (randomR())
            skinDevolver = skinR;
        if (randomM())
            skinDevolver = skinM;
        if (randomL())
            skinDevolver = skinL;
        if (randomA())
            skinDevolver = skinA;
        if (randomER())
            skinDevolver = skinER;
>>>>>>> branch 'master' of git@github.com:180036/ProyectoFinalV2.git

<<<<<<< HEAD
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
=======
        return skinDevolver;
    }

    /**
     * Genera un valor aleatorio y comprueba si cumple la condición para la skin "PC (Poco-Común)".
     *
     * @return true si cumple la condición, false de lo contrario.
     */
    private static boolean randomPC() {
        return new Random().nextBoolean(); // 50% 1/2
    }

    /**
     * Genera un número aleatorio y comprueba si cumple la condición para la skin "R (Rara)".
     *
     * @return true si cumple la condición, false de lo contrario.
     */
    private static boolean randomR() {
        random = new Random();
>>>>>>> branch 'master' of git@github.com:180036/ProyectoFinalV2.git
        int randomNumber = random.nextInt(5);
        int randomNumber2 = random.nextInt(5);
        return randomNumber == randomNumber2; // 20% 1/5
    }

    /**
     * Genera un número aleatorio y comprueba si cumple la condición para la skin "M (Mitica)".
     *
     * @return true si cumple la condición, false de lo contrario.
     */
    private static boolean randomM() {
        random = new Random();
        int randomNumber = random.nextInt(20);
        int randomNumber2 = random.nextInt(20);
        return randomNumber == randomNumber2; // 5% 1/20
    }

    /**
     * Genera un número aleatorio y comprueba si cumple la condición para la skin "L(Legendario)".
     *
     * @return true si cumple la condición, false de lo contrario.
     */
    private static boolean randomL() {
        random = new Random();
        int randomNumber = random.nextInt(50);
        int randomNumber2 = random.nextInt(50);
        return randomNumber == randomNumber2; // 2% 1/50
    }

    /**
     * Genera un número aleatorio y comprueba si cumple la condición para la skin "A (Ancestral)".
     *
     * @return true si cumple la condición, false de lo contrario.
     */
    private static boolean randomA() {
        random = new Random();
        int randomNumber = random.nextInt(100);
        int randomNumber2 = random.nextInt(100);
<<<<<<< HEAD
		return randomNumber == randomNumber2;  //1% 1/100
		
	}
=======
        return randomNumber == randomNumber2; // 1% 1/100
    }

    /**
     * Genera un número aleatorio y comprueba si cumple la condición para la skin "ER(Extremadamente raro)".
     *
     * @return true si cumple la condición, false de lo contrario.
     */
    private static boolean randomER() {
        random = new Random();
        int randomNumber = random.nextInt(500);
        int randomNumber2 = random.nextInt(500);
        return randomNumber == randomNumber2; // 0.5% 1/500
    }
>>>>>>> branch 'master' of git@github.com:180036/ProyectoFinalV2.git
}
