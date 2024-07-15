package kr.kyung.spring.config;

import java.util.Optional;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditorAwareImpl implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		String userId = "";
		
		if(authentication != null) {
			userId = authentication.getName();
		}
		return Optional.of(userId);
	}
	

}
