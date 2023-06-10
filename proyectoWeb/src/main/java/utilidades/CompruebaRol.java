package utilidades;

import java.util.List;

import com.app.web.usuarioregistro.Authority;
import com.app.web.usuarioregistro.AuthorityName;

public abstract class  CompruebaRol {

	public static int compruebaRol(List<Authority> lista) {
		
		for(Authority a: lista) {
			if(a.getName().equals(AuthorityName.ADMIN)) {
				return 2;
			}
			if(a.getName().equals(AuthorityName.UPGRADE)) {
				return 1;
			}
			
				
		}
		return 0;
	}
}
