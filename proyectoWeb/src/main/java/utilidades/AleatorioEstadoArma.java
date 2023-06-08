package utilidades;

import java.util.List;
import java.util.Random;

import com.app.web.entidad.EstadoArma;
import com.app.web.entidad.Skin;

public abstract class AleatorioEstadoArma {
	static Random random = new Random();
	public static EstadoArma estadoArmaAleatorio() {

		EstadoArma ea = new EstadoArma("BATTLE-SCARRED"); //46%
		
		EstadoArma ea2 = new EstadoArma("WELL-WORN");
		EstadoArma ea3 = new EstadoArma("FIELD-TESTED");
		EstadoArma ea4 = new EstadoArma("MINIMAL WEAR");
		EstadoArma ea5 = new EstadoArma("FACTORY NEW");
		
		if(randomFieldTested())
			ea = ea3;
		if(randomWellWorn())
			ea = ea2;
		if(randomMinimalWear())
			ea = ea4;
		if(randomFactoryNew())
			ea = ea5;

		return ea;
	}
	private static boolean randomFieldTested() {
		random = new Random();
        int randomNumber = random.nextInt(3);
        int randomNumber2 = random.nextInt(3);
		return randomNumber == randomNumber2; //33% 1/3
		
	}
	private static boolean randomWellWorn() {
		random = new Random();
        int randomNumber = random.nextInt(14);
        int randomNumber2 = random.nextInt(14);
		return randomNumber == randomNumber2; //7% 1/14
		
	}
	private static boolean randomMinimalWear() {
		random = new Random();
        int randomNumber = random.nextInt(14);
        int randomNumber2 = random.nextInt(14);
		return randomNumber == randomNumber2; //7% 1/14
		
	}
	private static boolean randomFactoryNew() {
		random = new Random();
        int randomNumber = random.nextInt(14);
        int randomNumber2 = random.nextInt(14);
		return randomNumber == randomNumber2; //7% 1/14
		
	}

}
