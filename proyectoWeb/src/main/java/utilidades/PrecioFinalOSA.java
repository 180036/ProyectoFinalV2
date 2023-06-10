package utilidades;

import java.util.Random;

import com.app.web.entidad.EstadoArma;
import com.app.web.entidad.Skin;
/**
 * Esta clase referencia al Precio de la skin, segun los datos de la skin, se calcula su precio.
 * 
 * @author: Oskar Stankevicius
 * @version: 1.0.6v
 */
public abstract class PrecioFinalOSA {
	static Random random = new Random();

	 /**
     * Calcula el precio final de una skin de arma basado en su estado, precio base.
     *
     * @param ea         El estado del arma.
     * @param precioSkin El precio base de la skin.
     * @param stattrak   Indica si la skin tiene la opción StatTrak activada.
     * @return El precio final aproximado de la skin.
     */
    public static int precioFinal(EstadoArma ea, int precioSkin, boolean stattrak) {
        int precioAproximado = precioSkin;

        if (ea.getId() == 1)
            precioAproximado *= 1.1;
        if (ea.getId() == 2)
            precioAproximado *= 1.2;
        if (ea.getId() == 3)
            precioAproximado *= 1.4;
        if (ea.getId() == 4)
            precioAproximado *= 1.8;
        if (ea.getId() == 5)
            precioAproximado *= 2.5;

        if (stattrak)
            precioAproximado *= 1.1;

        return precioAproximado;
    }
}
