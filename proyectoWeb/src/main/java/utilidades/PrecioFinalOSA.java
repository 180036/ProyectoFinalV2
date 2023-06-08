package utilidades;

import java.util.Random;

import com.app.web.entidad.EstadoArma;
import com.app.web.entidad.Skin;

public abstract class PrecioFinalOSA {
	static Random random = new Random();

	public static int precioFinal(EstadoArma ea, int precioSkin, boolean stattrak) {
		int precioAproximado = precioSkin;
		if(ea.getId()==1)
			precioAproximado *=1.1;
		if(ea.getId()==2)
			precioAproximado *=1.2;
		if(ea.getId()==3)
			precioAproximado *=1.4;
		if(ea.getId()==4)
			precioAproximado *=1.8;
		if(ea.getId()==5)
			precioAproximado *=2.5;
		
		if(stattrak)
			precioAproximado *=1.1;
		
		
		return precioAproximado;
	}
}
