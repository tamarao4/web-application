package rs.ac.singidunum.isa.app.controller;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rs.ac.singidunum.isa.app.dto.KorisnikDTO;
import rs.ac.singidunum.isa.app.dto.TokenDTO;
import rs.ac.singidunum.isa.app.model.Korisnik;
import rs.ac.singidunum.isa.app.model.KorisnikPravoPristupa;
import rs.ac.singidunum.isa.app.service.KorisnikService;
import rs.ac.singidunum.isa.app.service.PravoPristupaService;
import rs.ac.singidunum.isa.app.utils.TokenUtils;

@Controller
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenUtils tokenUtils;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private KorisnikService korisnikService;
	
	@Autowired
	private PravoPristupaService pravoPristupaService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ResponseEntity<TokenDTO> login(@RequestBody KorisnikDTO korisnik) {
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(korisnik.getKorisnickoIme(), korisnik.getLozinka());
			Authentication authentication = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			UserDetails userDetails = userDetailsService.loadUserByUsername(korisnik.getKorisnickoIme());
			String jwt = tokenUtils.generateToken(userDetails);
			
			TokenDTO jwtDTO = new TokenDTO(jwt);
			
			return new ResponseEntity<TokenDTO>(jwtDTO, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<TokenDTO>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ResponseEntity<KorisnikDTO> register(@RequestBody KorisnikDTO korisnik) {
		Korisnik noviKorisnik = new Korisnik(null, korisnik.getKorisnickoIme(), passwordEncoder.encode(korisnik.getLozinka()), korisnik.getIme(), korisnik.getPrezime());
		noviKorisnik = korisnikService.save(noviKorisnik);
		
		noviKorisnik.setKorisnikPravoPristupa(new HashSet<KorisnikPravoPristupa>());
		noviKorisnik.getKorisnikPravoPristupa().add(new KorisnikPravoPristupa(null, noviKorisnik, pravoPristupaService.findOne(1l).get()));
		korisnikService.save(noviKorisnik);
		
		return new ResponseEntity<KorisnikDTO>(new KorisnikDTO(noviKorisnik.getId(), noviKorisnik.getKorisnickoIme(), null, noviKorisnik.getIme(), noviKorisnik.getPrezime()), HttpStatus.OK);
	}
	
}
