package br.com.ifg.resource;

import br.com.ifg.model.dto.SearchAPI;
import br.com.ifg.model.dto.UserDTO;
import br.com.ifg.model.entity.User;
import br.com.ifg.service.UserService;
import com.google.gson.Gson;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.Map;

@Path("/user")
public class UserResource {

    @Inject
    UserService userService;

    @Operation(summary = "Método para registrar usuário")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = User.class, type = SchemaType.ARRAY)))
    @Tag(name = "save user")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(UserDTO userDTO) {
        return Response.ok(userService.create(userDTO)).build();
    }
}
