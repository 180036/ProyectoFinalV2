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
import com.app.web.entidad.Pregunta;
import com.app.web.entidad.Skin;
import com.app.web.repositorios.ArmaRepositorio;
import com.app.web.repositorios.AuthorityRepositorio;
import com.app.web.repositorios.CajaRepositorio;
import com.app.web.repositorios.CalidadskinRepositorio;
import com.app.web.repositorios.EstadoarmaRepositorio;
import com.app.web.repositorios.ModeloarmaRepositorio;
import com.app.web.repositorios.ObjetoskinarmaRepositorio;
import com.app.web.repositorios.PreguntaRepositorio;
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
	@Autowired(required=true)
	private PreguntaRepositorio preguntaRepo;

	
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
		//Guardar modeloArmas
		repoM.save(ma);
		repoM.save(ma1);
		repoM.save(ma2);
		repoM.save(ma3);

		//Arma con su modelo (ma | 1,2,3,4,5)
			//Pistolas 10 ma1
			Arma glock18 = new Arma("Glock-18", ma);
			Arma uspS = new Arma("USP-S", ma);
			Arma p2000 = new Arma("P2000", ma);
			Arma dualBerrettas = new Arma("Dual Berettas", ma);
			Arma p250 = new Arma("P250", ma);
			Arma tec9 = new Arma("Tec-9", ma);
			Arma fiveSeveN = new Arma("Five-SeveN", ma);
			Arma cz75Auto = new Arma("CZ75-Auto", ma);
			Arma desertEagle = new Arma("Desert Eagle", ma);
			Arma r8Revolver = new Arma("R8 Revolver", ma);
			//Armas Pesadas 6 ma2
			Arma m249 = new Arma("M249", ma1);
			Arma negev = new Arma("Negev", ma1);
			Arma nova = new Arma("Nova", ma1);
			Arma xm1014 = new Arma("XM1014", ma1);
			Arma sawedOff = new Arma("Sawed-Off", ma1);
			Arma mag7 = new Arma("MAG-7", ma1);
			//Subfusiles 6 ma3
			Arma mac10 = new Arma("MAC-10", ma2);
			Arma mp9 = new Arma("MP9",ma2 );
			Arma mp7 = new Arma("MP7", ma2);
			Arma ump45 = new Arma("UMP-45", ma2);
			Arma p90 = new Arma("P90", ma2);
			Arma ppBizon = new Arma("PP-Bizon", ma2);
			//Rifles de asalto 11
			Arma ak47 = new Arma("AK-47", ma3);
			Arma m4a4 = new Arma("M4A4", ma3);
			Arma m4a1S = new Arma("M4A1-S", ma3);
			Arma aug = new Arma("AUG", ma3);
			Arma sg553 = new Arma("SG 553", ma3);
			Arma famas = new Arma("FAMAS", ma3);
			Arma galilAr = new Arma("Galil AR", ma3);
			Arma awp = new Arma("AWP", ma3);
			Arma ssg08 = new Arma("SSG 08", ma3);
			Arma g3sg1 = new Arma("G3SG1", ma3);
			Arma scar20 = new Arma("SCAR-20", ma3);
			//InsertarArmas
			repoA.save(glock18);
			repoA.save(uspS);
			repoA.save(p2000);
			repoA.save(dualBerrettas);
			repoA.save(p250);
			repoA.save(tec9);
			repoA.save(fiveSeveN);
			repoA.save(cz75Auto);
			repoA.save(desertEagle);
			repoA.save(r8Revolver);
			repoA.save(m249);
			repoA.save(negev);
			repoA.save(nova);
			repoA.save(xm1014);
			repoA.save(sawedOff);
			repoA.save(mag7);
			repoA.save(mac10);
			repoA.save(mp9);
			repoA.save(mp7);
			repoA.save(ump45);
			repoA.save(p90);
			repoA.save(ppBizon);
			repoA.save(ak47);
			repoA.save(m4a4);
			repoA.save(m4a1S);
			repoA.save(aug);
			repoA.save(sg553);
			repoA.save(famas);
			repoA.save(galilAr);
			repoA.save(awp);
			repoA.save(ssg08);
			repoA.save(g3sg1);
			repoA.save(scar20);
			
		//Calidad de las skins
		CalidadSkin csC = new CalidadSkin("Comun");
		CalidadSkin csPC = new CalidadSkin("Poco comun");
		CalidadSkin csR = new CalidadSkin("Raro");
		CalidadSkin csM = new CalidadSkin("Mitico");
		CalidadSkin csL = new CalidadSkin("Legendario");
		CalidadSkin csA = new CalidadSkin("Ancestral");
		repoC.save(csC);
		repoC.save(csPC);
		repoC.save(csR);
		repoC.save(csM);
		repoC.save(csL);
		repoC.save(csA);
		
		Skin comun1 = new Skin("Prey", mp7, csC, 15);
        Skin comun2 = new Skin("Storm", aug, csC, 20);
        Skin comun3 = new Skin("Desert_Brush", r8Revolver, csC, 22);
        Skin comun4 = new Skin("Rust_Coat", mag7, csC, 25);
        Skin comun5 = new Skin("Desert_DDPAT", p90, csC, 20);
        //Poco Comun -> Siempre 1 en una caja
        Skin pocoComun1 = new Skin("Withered_Vine", fiveSeveN, csPC, 70);
        Skin pocoComun2 = new Skin("Midnight_Palm", negev, csPC,76);
        Skin pocoComun3 = new Skin("The_Bronze", desertEagle, csPC, 74);
        Skin pocoComun4 = new Skin("Carbon_Fiber", mag7, csPC, 76);
        //Raro -> Siempre 1 en una caja
        Skin raro1 = new Skin("Global_Offensive", m4a4, csR, 140);
        Skin raro2 = new Skin("Dispatch", p2000, csR,150);
        Skin raro3 = new Skin("Orange-Filigree", ssg08, csR, 145);
        Skin raro4 = new Skin("Emerald", dualBerrettas, csR, 160);
        //Mitico -> Siempre 1 en una caja
        Skin mitico1 = new Skin("Stained_Glass", mp9, csM, 400);
        Skin mitico2 = new Skin("Astral_Jormungandr", p90, csM,390);
        Skin mitico3 = new Skin("Sea_Calico", ssg08, csM, 400);
        Skin mitico4 = new Skin("Synth_Leaf", glock18, csM, 395);
        //Legendario -> Siempre 1 en una caja
        Skin legendario1 = new Skin("Wild_Lily", mp9, csL, 800);
        Skin legendario2 = new Skin("Mjolnir", negev, csL,800);
        Skin legendario3 = new Skin("Knight", m4a1S, csL, 800);
        Skin legendario4 = new Skin("Poseidon", m4a4, csL, 800);
        //Ancestral -> Siempre 1 en una caja
        Skin ancestral1 = new Skin("Medusa", awp, csA, 2000);
        Skin ancestral2 = new Skin("Dragon_Lore", awp, csA,2000);
        Skin ancestral3 = new Skin("Gugnir", awp, csA, 2000);
        Skin ancestral4 = new Skin("Wild_Lotus", ak47, csA, 2000);//
			//Guardar skins
			repoS.save(comun1);
			repoS.save(comun2);
			repoS.save(comun3);
			repoS.save(comun4);
			repoS.save(comun5);
			repoS.save(pocoComun1);
			repoS.save(pocoComun2);
			repoS.save(pocoComun3);
			repoS.save(pocoComun4);
			repoS.save(raro1);
			repoS.save(raro2);
			repoS.save(raro3);
			repoS.save(raro4);
			repoS.save(mitico1);
			repoS.save(mitico2);
			repoS.save(mitico3);
			repoS.save(mitico4);
			repoS.save(legendario1);
			repoS.save(legendario2);
			repoS.save(legendario3);
			repoS.save(legendario4);
			repoS.save(ancestral1);
			repoS.save(ancestral2);
			repoS.save(ancestral3);
			repoS.save(ancestral4);
		
			Caja caja1Evento1 = new Caja("Purple One's",50,comun1,comun2,comun3,comun4,comun5,pocoComun1,raro1,mitico1,legendario1,ancestral1);
			Caja caja2Evento1 = new Caja("Lost Love",50,comun1,comun2,comun3,comun4,comun5,pocoComun2,raro2,mitico2,legendario2,ancestral2);
			Caja caja3Evento1 = new Caja("3 meters form skye",50,comun1,comun2,comun3,comun4,comun5,pocoComun3,raro3,mitico3,legendario3,ancestral3);
			Caja caja4Evento1 = new Caja("Lost on You",50,comun1,comun2,comun3,comun4,comun5,pocoComun4,raro4,mitico4,legendario4,ancestral4);
			//Evento 2:			
			Caja caja1Evento2 = new Caja("Bomb House",50,comun1,comun2,comun3,comun4,comun5,pocoComun1,raro2,mitico3,legendario4,ancestral3);
			Caja caja2Evento2 = new Caja("Explode level",50,comun1,comun2,comun3,comun4,comun5,pocoComun2,raro3,mitico4,legendario1,ancestral4);
			Caja caja3Evento2 = new Caja("Kamikaze flying",50,comun1,comun2,comun3,comun4,comun5,pocoComun3,raro4,mitico1,legendario2,ancestral2);
			Caja caja4Evento2 = new Caja("Lost on smoke",50,comun1,comun2,comun3,comun4,comun5,pocoComun4,raro1,mitico2,legendario3,ancestral1);
			//Evento 3:
			Caja caja1Evento3 = new Caja("Izy Defuse",50,comun1,comun2,comun3,comun4,comun5,pocoComun1,raro3,mitico4,legendario2,ancestral2);
			Caja caja2Evento3 = new Caja("Super anti-T",50,comun1,comun2,comun3,comun4,comun5,pocoComun2,raro1,mitico3,legendario4,ancestral3);
			Caja caja3Evento3 = new Caja("Super armor",50,comun1,comun2,comun3,comun4,comun5,pocoComun3,raro2,mitico2,legendario3,ancestral1);
			Caja caja4Evento3 = new Caja("Lost with bombs",50,comun1,comun2,comun3,comun4,comun5,pocoComun4,raro3,mitico1,legendario1,ancestral2);
			//Colaborador 1:
			Caja caja1Colaborador1 = new Caja("Como pciker",50,comun1,comun2,comun3,comun4,comun5,pocoComun1,raro4,mitico2,legendario3,ancestral4);
			Caja caja2Colaborador1 = new Caja("Heretic is lost",50,comun1,comun2,comun3,comun4,comun5,pocoComun2,raro4,mitico1,legendario3,ancestral1);
			//Colaborador 2:
			Caja caja1Colaborador2 = new Caja("Clean Game",50,comun1,comun2,comun3,comun4,comun5,pocoComun3,raro1,mitico4,legendario1,ancestral1);
			Caja caja2Colaborador2 = new Caja("Flowing over them",50,comun1,comun2,comun3,comun4,comun5,pocoComun4,raro2,mitico3,legendario4,ancestral3);
			//Guardar cajas
			repoCa.save(caja1Evento1);
			repoCa.save(caja2Evento1);
			repoCa.save(caja3Evento1);
			repoCa.save(caja4Evento1);
			repoCa.save(caja1Evento2);
			repoCa.save(caja2Evento2);
			repoCa.save(caja3Evento2);
			repoCa.save(caja4Evento2);
			repoCa.save(caja1Evento3);
			repoCa.save(caja2Evento3);
			repoCa.save(caja3Evento3);
			repoCa.save(caja4Evento3);
			repoCa.save(caja1Colaborador1);
			repoCa.save(caja2Colaborador1);
			repoCa.save(caja1Colaborador2);
			repoCa.save(caja2Colaborador2);
		
		//Estado Armas
		EstadoArma eaBS = new EstadoArma("BATTLE-SCARRED");
		EstadoArma eWW = new EstadoArma("WELL-WORN");
		EstadoArma eaFT = new EstadoArma("FIELD-TESTED");
		EstadoArma eaMW = new EstadoArma("MINIMAL WEAR");
		EstadoArma eaFN = new EstadoArma("FACTORY NEW");
		//Guardar estados armas
		repoE.save(eaBS);
		repoE.save(eWW);
		repoE.save(eaFT);		
		repoE.save(eaMW);		
		repoE.save(eaFN);
		
		//Relacion mucho a muchos, potente
		ObjetoSkinArma osa1 = new ObjetoSkinArma(ancestral2.getNombre(), 10000, ancestral2, prueba, eaBS);
		ObjetoSkinArma osa2 = new ObjetoSkinArma(ancestral3.getNombre(), 10000, ancestral3, prueba, eaBS);
		repoO.save(osa1);
		repoO.save(osa2);

		
		Pregunta p1= new Pregunta("Una preguntilla profezo");
		preguntaRepo.save(p1);
		
		
	}

}