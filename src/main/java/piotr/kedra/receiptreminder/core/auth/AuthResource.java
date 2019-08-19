package piotr.kedra.receiptreminder.core.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;

@RestController
@RequestMapping("auth")
public class AuthResource {

    @Autowired
    TokenService tokenService;

    @Autowired
    UserService userService;

    @GetMapping(value = "login")
    public ResponseEntity login(@QueryParam("email") String email, @QueryParam("password") String password){

        if(email == null || password == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(email);
        }

        if(userService.authenticate(email, password)){
            String token = tokenService.generateToken();
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Wrong credentials");

    }
}
