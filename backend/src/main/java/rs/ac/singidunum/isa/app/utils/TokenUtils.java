package rs.ac.singidunum.isa.app.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenUtils {
	
	private String secret = "123456";
	
	private Claims getClaims(String token) {
		Claims claims = null;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
		}	
		return claims;
	}
	
	private boolean isExpired(String token) {
		try {
			return getClaims(token).getExpiration().before(new Date(System.currentTimeMillis()));
		} catch (Exception e) {
		}
		return true;
	}
	
	public String getUsername(String token) {
		String username = null;
		
		try {
			return getClaims(token).getSubject();
		} catch (Exception e) {
		}
		return username;
	}
	
	public boolean validateToken(String token, UserDetails userDetails) {
		String username = getUsername(token);
		return username.equals(userDetails.getUsername()) && !isExpired(token);
	}
	
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("sub", userDetails.getUsername());
		claims.put("created", new Date(System.currentTimeMillis()));
		
		return Jwts.builder().setClaims(claims).setExpiration(new Date(System.currentTimeMillis() + 7200 * 1000)).signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
}
