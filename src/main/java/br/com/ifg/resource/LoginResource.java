package br.com.ifg.resource;

import br.com.ifg.model.dto.LoginDTO;
import br.com.ifg.model.dto.LoginResponseDTO;
import br.com.ifg.model.dto.TitleAPI;
import br.com.ifg.service.LoginService;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/login")
public class LoginResource {

    @Inject
    LoginService loginService;

    @PermitAll
    @POST
    public LoginResponseDTO login(LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }
}
