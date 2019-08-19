package piotr.kedra.receiptreminder.core.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Random;

@Component
public class TokenService {

    private String secret;
    private Algorithm algorithm;

    public TokenService(){
        secret = generateRandomSecret();
        System.out.println(secret);
        algorithm = Algorithm.HMAC256(secret);
    }


    private String generateRandomSecret(){
        byte[] array = new byte[15]; // length is bounded by 7
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }

    public String generateToken() throws JWTCreationException {
        return JWT.create()
                .withIssuer("auth0")
                .sign(algorithm);
    }

    public void verifyToken(String token) throws JWTVerificationException {
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build();
        verifier.verify(token);
        System.out.println("OK");
    }

}