package com.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.app.web.entidad.Arma;
import com.app.web.entidad.Caja;
import com.app.web.entidad.CalidadSkin;
import com.app.web.entidad.EstadoArma;
import com.app.web.entidad.ModeloArma;
import com.app.web.entidad.ObjetoSkinArma;
import com.app.web.entidad.Skin;
import com.app.web.repositorios.ArmaRepositorio;
import com.app.web.repositorios.AuthorityRepositorio;
import com.app.web.repositorios.CajaRepositorio;
import com.app.web.repositorios.CalidadskinRepositorio;
import com.app.web.repositorios.EstadoarmaRepositorio;
import com.app.web.repositorios.ModeloarmaRepositorio;
import com.app.web.repositorios.ObjetoskinarmaRepositorio;
import com.app.web.repositorios.SkinRepositorio;
import com.app.web.repositorios.UserRepository;
import com.app.web.usuarioregistro.Authority;
import com.app.web.usuarioregistro.AuthorityName;
import com.app.web.usuarioregistro.User;

@SpringBootApplication()
public class ProyectoWebApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoWebApplication.class, args);
	}
	@Autowired(required=true)
	private SkinRepositorio repoS;
	@Autowired(required=true)
	private ArmaRepositorio repoA;
	@Autowired(required=true)
	private ObjetoskinarmaRepositorio repoO;
	@Autowired(required=true)
	private ModeloarmaRepositorio repoM;
	@Autowired(required=true)
	private EstadoarmaRepositorio repoE;
	@Autowired(required=true)
	private CalidadskinRepositorio repoC;
	@Autowired(required=true)
	private CajaRepositorio repoCa;
	
	@Autowired(required=true)
	private UserRepository userRepo;
	@Autowired(required=true)
	private AuthorityRepositorio authRepo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		inicial(); //Datos iniciales que existiran previamente en la BD
	}
	
	private void inicial() {

			this.authRepo.saveAll(List.of(
					new Authority(AuthorityName.ADMIN),
					new Authority(AuthorityName.CREATOR),
					new Authority(AuthorityName.USER)
					));
		

			User prueba = new User("alejandro", new BCryptPasswordEncoder().encode("123"), List.of(this.authRepo.findByName(AuthorityName.ADMIN).get()),"a@email.com","imagen.jpg");
			this.userRepo.saveAll(List.of(
					prueba,
					new User("oskaras", new BCryptPasswordEncoder().encode("123"), List.of(this.authRepo.findByName(AuthorityName.CREATOR).get()),"a2@email.com","imagen.jpg"),
					new User("pepe", new BCryptPasswordEncoder().encode("69"), List.of(this.authRepo.findByName(AuthorityName.USER).get()),"a3@email.com","imagen.jpg")
					));
		
		//Usuarios
		/*Usuario usuario1= new Usuario("Angarona", "1234", "angarona2001@gmail.com", "imagen.jpg");
		repo.save(usuario1);
		Usuario usuario2= new Usuario("AlejandroDPZ", "8869", "alejandroxd@omegalul.com", "");
		repo.save(usuario2);*/
		
		//ModeloArmas
		ModeloArma ma = new ModeloArma("Pistolas");
		ModeloArma ma1 = new ModeloArma("Armas Pesadas");
		ModeloArma ma2 = new ModeloArma("Subfusiles SMG");
		ModeloArma ma3 = new ModeloArma("Fusiles");
		repoM.save(ma);
		repoM.save(ma1);
		repoM.save(ma2);
		repoM.save(ma3);

		//Arma con su modelo (ma | 1,2,3,4,5)
			//Pistolas 10 ma1
			Arma arma1 = new Arma("Glock-18", ma);
			Arma arma2 = new Arma("USP-S", ma);
			Arma arma3 = new Arma("P2000", ma);
			Arma arma4 = new Arma("Dual Berettas", ma);
			Arma arma5 = new Arma("P250", ma);
			Arma arma6 = new Arma("Tec-9", ma);
			Arma arma7 = new Arma("Five-SeveN", ma);
			Arma arma8 = new Arma("CZ75-Auto", ma);
			Arma arma9 = new Arma("Desert Eagle", ma);
			Arma arma10 = new Arma("R8 Revolver", ma);
			//Armas Pesadas 6 ma2
			Arma arma11 = new Arma("M249", ma1);
			Arma arma12 = new Arma("Negev", ma1);
			Arma arma13 = new Arma("Nova", ma1);
			Arma arma14 = new Arma("XM1014", ma1);
			Arma arma15 = new Arma("Sawed-Off", ma1);
			Arma arma16 = new Arma("MAG-7", ma1);
			//Subfusiles 6 ma3
			Arma arma17 = new Arma("MAC-10", ma2);
			Arma arma18 = new Arma("MP9",ma2 );
			Arma arma19 = new Arma("MP7", ma2);
			Arma arma20 = new Arma("UMP-45", ma2);
			Arma arma21 = new Arma("P90", ma2);
			Arma arma22 = new Arma("PP-Bizon", ma2);
			//Rifles de asalto 11
			Arma arma23 = new Arma("AK-47", ma3);
			Arma arma24 = new Arma("M4A4", ma3);
			Arma arma25 = new Arma("M4A1-S", ma3);
			Arma arma26 = new Arma("AUG", ma3);
			Arma arma27 = new Arma("SG 553", ma3);
			Arma arma28 = new Arma("FAMAS", ma3);
			Arma arma29 = new Arma("Galil AR", ma3);
			Arma arma30 = new Arma("AWP", ma3);
			Arma arma31 = new Arma("SSG 08", ma3);
			Arma arma32 = new Arma("G3SG1", ma3);
			Arma arma33 = new Arma("SCAR-20", ma3);
			//InsertarArmas
			repoA.save(arma1);
			repoA.save(arma2);
			repoA.save(arma3);
			repoA.save(arma4);
			repoA.save(arma5);
			repoA.save(arma6);
			repoA.save(arma7);
			repoA.save(arma8);
			repoA.save(arma9);
			repoA.save(arma10);
			repoA.save(arma11);
			repoA.save(arma12);
			repoA.save(arma13);
			repoA.save(arma14);
			repoA.save(arma15);
			repoA.save(arma16);
			repoA.save(arma17);
			repoA.save(arma18);
			repoA.save(arma19);
			repoA.save(arma20);
			repoA.save(arma21);
			repoA.save(arma22);
			repoA.save(arma23);
			repoA.save(arma24);
			repoA.save(arma25);
			repoA.save(arma26);
			repoA.save(arma27);
			repoA.save(arma28);
			repoA.save(arma29);
			repoA.save(arma30);
			repoA.save(arma31);
			repoA.save(arma32);
			repoA.save(arma33);
			
		//Calidad de las skins
		CalidadSkin cs = new CalidadSkin("Comun");
		CalidadSkin cs2 = new CalidadSkin("Poco comun");
		CalidadSkin cs3 = new CalidadSkin("Raro");
		CalidadSkin cs4 = new CalidadSkin("Mitico");
		CalidadSkin cs5 = new CalidadSkin("Legendario");
		CalidadSkin cs6 = new CalidadSkin("Ancestral");
		CalidadSkin cs7 = new CalidadSkin("Extremadamente raro");
		repoC.save(cs);
		repoC.save(cs2);
		repoC.save(cs3);
		repoC.save(cs4);
		repoC.save(cs5);
		repoC.save(cs6);
		repoC.save(cs7);
		
		//Skin con su cs
		Skin skin1 = new Skin("DragonLore", arma30, cs5, 1750);
		Skin skin2 = new Skin("Neo Nair", arma1, cs5, 400);
		Skin skin3 = new Skin("DragonLore", arma1, cs3, 2000);
		Skin skin4 = new Skin("DragonLore", arma1, cs4, 2000);
		Skin skin5 = new Skin("DragonLore", arma1, cs5, 2000);
		Skin skin6 = new Skin("DragonLore", arma1, cs6, 2000);
		Skin skin7 = new Skin("DragonLore", arma1, cs2,2000);
		Skin skin8 = new Skin("DragonLore", arma1, cs2, 2000);
		Skin skin9 = new Skin("DragonLore", arma1, cs7, 2000);
		Skin skin10 = new Skin("DragonLore", arma1, cs2, 3000);
		repoS.save(skin1);
		repoS.save(skin2);
		repoS.save(skin3);
		repoS.save(skin4);
		repoS.save(skin5);
		repoS.save(skin6);
		repoS.save(skin7);
		repoS.save(skin8);
		repoS.save(skin9);
		repoS.save(skin10);
		
		//Insertar skins en una caja
		Caja caja1 = new Caja("a",2000,skin1,skin2,skin3,skin4,skin5,skin6,skin7,skin8,skin9,skin10);
		repoCa.save(caja1);
		
		//Estado Armas
		EstadoArma ea = new EstadoArma("BATTLE-SCARRED");
		EstadoArma ea2 = new EstadoArma("WELL-WORN");
		EstadoArma ea3 = new EstadoArma("FIELD-TESTED");
		EstadoArma ea4 = new EstadoArma("MINIMAL WEAR");
		EstadoArma ea5 = new EstadoArma("FACTORY NEW");
		repoE.save(ea);
		repoE.save(ea2);
		repoE.save(ea3);		
		repoE.save(ea4);		
		repoE.save(ea5);
		
		//Relacion mucho a muchos, potente
		ObjetoSkinArma osa1 = new ObjetoSkinArma("Mi armita reshulona", 10000, skin1, prueba, ea);
		repoO.save(osa1);
		
		
	}

}

