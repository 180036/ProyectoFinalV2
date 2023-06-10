package utilidades;

import java.util.Random;

public final class StatTrak {
	/**
     * Calcula si tendra startrack la skin.
     *
     * @return true si la skin tiene la opción StatTrak, false de lo contrario.
     */
    public static boolean tieneStatTrak() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        int randomNumber2 = random.nextInt(10);
        return randomNumber == randomNumber2; // 10% 1/10
    }

}
