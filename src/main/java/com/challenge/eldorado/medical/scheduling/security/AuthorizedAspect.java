package com.challenge.eldorado.medical.scheduling.security;

import static java.util.Optional.ofNullable;
import static org.h2.util.StringUtils.isNullOrEmpty;

import com.challenge.eldorado.medical.scheduling.exceptions.TokenNotFoundException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Profile("prod")
@Aspect
@Component
@RequiredArgsConstructor
public class AuthorizedAspect {

	private static final String KEY = "Authorization";

	private static final String SECRET = "s3cr3t";

	private final HttpServletRequest request;

	@Around("@annotation(com.challenge.eldorado.medical.scheduling.security.Authorized)")
	public Object validate(ProceedingJoinPoint joinPoint) throws Throwable {
		final String token = getTokenFromHeader();

		System.out.println(token);

		Claims claims = Jwts.parser()
				.setSigningKey(SECRET)
				.parseClaimsJws(token)
				.getBody();

		System.out.println("Logged user: " + claims.getSubject());

		return joinPoint.proceed();
	}

	private String getTokenFromHeader() {
		String key = request.getHeader(KEY);
		if (isNullOrEmpty(key)) {
			key = request.getHeader(KEY.toLowerCase());
		}
		return ofNullable(key)
				.map(k -> k.substring(7))
				.orElseThrow(TokenNotFoundException::new);
	}
}
