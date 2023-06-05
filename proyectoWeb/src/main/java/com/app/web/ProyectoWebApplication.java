package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.web.entidad.Arma;
import com.app.web.entidad.Caja;
import com.app.web.entidad.CalidadSkin;
import com.app.web.entidad.EstadoArma;
import com.app.web.entidad.ModeloArma;
import com.app.web.entidad.ObjetoSkinArma;
import com.app.web.entidad.Skin;
import com.app.web.entidad.Usuario;
import com.app.web.repositorios.ArmaRepositorio;
import com.app.web.repositorios.CajaRepositorio;
import com.app.web.repositorios.CalidadskinRepositorio;
import com.app.web.repositorios.EstadoarmaRepositorio;
import com.app.web.repositorios.ModeloarmaRepositorio;
import com.app.web.repositorios.ObjetoskinarmaRepositorio;
import com.app.web.repositorios.SkinRepositorio;
import com.app.web.repositorios.UsuarioRepositorio;

@SpringBootApplication()
public class ProyectoWebApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ProyectoWebApplication.class, args);
	}

	
	@Autowired(required=true)
	private UsuarioRepositorio repo;
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
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		inicial(); //Datos iniciales que existiran previamente en la BD
	}
	
	private void inicial() {
		//Usuarios
		Usuario usuario1= new Usuario("Angarona", "1234", "angarona2001@gmail.com", "imagen.jpg");
		repo.save(usuario1);
		Usuario usuario2= new Usuario("AlejandroDPZ", "8869", "alejandroxd@omegalul.com", "");
		repo.save(usuario2);
		
		//ModeloArmas
		ModeloArma ma = new ModeloArma("Pistolas");
		repoM.save(ma);
		ModeloArma ma1 = new ModeloArma("Armas Pesadas");
		repoM.save(ma1);
		ModeloArma ma2 = new ModeloArma("Subfusiles SMG");
		repoM.save(ma2);
		ModeloArma ma3 = new ModeloArma("Fusiles");
		repoM.save(ma3);
		ModeloArma ma4 = new ModeloArma("Equipo");
		repoM.save(ma4);
		ModeloArma ma5 = new ModeloArma("Granadas");
		repoM.save(ma5);

		//Arma con su ma
		Arma arma1 = new Arma("AWP", ma3);
		repoA.save(arma1);
		
		//Calidad de las skins
		CalidadSkin cs = new CalidadSkin("Comun");
		CalidadSkin cs2 = new CalidadSkin("Poco comun");
		CalidadSkin cs3 = new CalidadSkin("Raro");
		CalidadSkin cs4 = new CalidadSkin("Mitico");
		CalidadSkin cs5 = new CalidadSkin("Legendario");
		CalidadSkin cs6 = new CalidadSkin("Ancestral");
		CalidadSkin cs7 = new CalidadSkin("Extraordinariamente raro");
		repoC.save(cs);
		repoC.save(cs2);
		repoC.save(cs3);
		repoC.save(cs4);
		repoC.save(cs5);
		repoC.save(cs6);
		repoC.save(cs7);
		
		//Skin con su cs
		Skin skin1 = new Skin("DragonLore", arma1, cs6);
		Skin skin2 = new Skin("DragonLore", arma1, cs6);
		Skin skin3 = new Skin("DragonLore", arma1, cs6);
		Skin skin4 = new Skin("DragonLore", arma1, cs6);
		Skin skin5 = new Skin("DragonLore", arma1, cs6);
		Skin skin6 = new Skin("DragonLore", arma1, cs6);
		Skin skin7 = new Skin("DragonLore", arma1, cs6);
		Skin skin8 = new Skin("DragonLore", arma1, cs6);
		Skin skin9 = new Skin("DragonLore", arma1, cs6);
		Skin skin10 = new Skin("DragonLore", arma1, cs6);

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
		
		Caja caja1 = new Caja("a",2000,skin1,skin2,skin3,skin4,skin5,skin6,skin7,skin8,skin9,skin10);
		repoCa.save(caja1);
		
		//Estado Armas
		EstadoArma ea = new EstadoArma("Recien Fabricado");
		repoE.save(ea);
		EstadoArma ea2 = new EstadoArma("Casi Nuevo");
		repoE.save(ea2);
		EstadoArma ea3 = new EstadoArma("Algo desgastado");
		repoE.save(ea3);
		EstadoArma ea4 = new EstadoArma("Bastante desgastado");
		repoE.save(ea4);
		EstadoArma ea5 = new EstadoArma("Deplorable");
		repoE.save(ea5);
		
		//Relacion mucho a muchos, potente
		ObjetoSkinArma osa1 = new ObjetoSkinArma("Mi armita reshulona", 10000, skin1, usuario2, ea);
		repoO.save(osa1);
		
		
	}

}

