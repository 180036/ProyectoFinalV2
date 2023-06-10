package utilidades;

import java.util.List;
import java.util.Random;

import com.app.web.entidad.EstadoArma;
import com.app.web.entidad.Skin;

/**
 * Esta clase referencia al Estado Arma, se usa para saber que estado tendra el arma de da la caja que abramos.
 * 
 * @author: Oskar Stankevicius
 * @version: 1.0.6v
 */
public abstract class AleatorioEstadoArma {
	static Random random = new Random();
	
	/**
     * Genera un estado de arma aleatorio (Battle-Scarred, Well-Worn, Field-Tested, Minimal Wear, Facotory New)
     *
     * @return El estado de arma generado aleatoriamente.
     */
    public static EstadoArma estadoArmaAleatorio() {
        EstadoArma ea = new EstadoArma("BATTLE-SCARRED"); // 46%

        EstadoArma ea2 = new EstadoArma("WELL-WORN");
        EstadoArma ea3 = new EstadoArma("FIELD-TESTED");
        EstadoArma ea4 = new EstadoArma("MINIMAL WEAR");
        EstadoArma ea5 = new EstadoArma("FACTORY NEW");

        if (randomFieldTested())
            ea = ea3;
        if (randomWellWorn())
            ea = ea2;
        if (randomMinimalWear())
            ea = ea4;
        if (randomFactoryNew())
            ea = ea5;

        return ea;
    }

    /**
     * Genera un número aleatorio y comprueba si cumple la condición para el estado "FIELD-TESTED".
     *
     * @return true si cumple la condición, false de lo contrario.
     */
    private static boolean randomFieldTested() {
        random = new Random();
        int randomNumber = random.nextInt(3);
        int randomNumber2 = random.nextInt(3);
        return randomNumber == randomNumber2; // 33% 1/3
    }

    /**
     * Genera un número aleatorio y comprueba si cumple la condición para el estado "WELL-WORN".
     *
     * @return true si cumple la condición, false de lo contrario.
     */
    private static boolean randomWellWorn() {
        random = new Random();
        int randomNumber = random.nextInt(14);
        int randomNumber2 = random.nextInt(14);
        return randomNumber == randomNumber2; // 7% 1/14
    }

    /**
     * Genera un número aleatorio y comprueba si cumple la condición para el estado "MINIMAL WEAR".
     *
     * @return true si cumple la condición, false de lo contrario.
     */
    private static boolean randomMinimalWear() {
        random = new Random();
        int randomNumber = random.nextInt(14);
        int randomNumber2 = random.nextInt(14);
        return randomNumber == randomNumber2; // 7% 1/14
    }

    /**
     * Genera un número aleatorio y comprueba si cumple la condición para el estado "FACTORY NEW".
     *
     * @return true si cumple la condición, false de lo contrario.
     */
    private static boolean randomFactoryNew() {
        random = new Random();
        int randomNumber = random.nextInt(14);
        int randomNumber2 = random.nextInt(14);
        return randomNumber == randomNumber2; // 7% 1/14
    }

}
