package com.challenge.eldorado.medical.scheduling.usecase;

import com.challenge.eldorado.medical.scheduling.exceptions.IncorrectPasswordException;
import com.challenge.eldorado.medical.scheduling.gateway.UserGateway;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserLogin {

	private static final String KEY = "s3cr3t";

	private static final String AUDIENCE = "client";

	private static final String ISSUER = "server";

	private final UserGateway gateway;

	public String login(final String email, final String password) {
		final var user = gateway.findByEmail(email);
		if (!user.compare(password)) {
			throw new IncorrectPasswordException(email);
		}
		return encode(user.getId());
	}

	private String encode(final UUID subject) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		long expMillis = nowMillis + (1000 * 60 * 30); // 30min
		Date now = new Date(nowMillis);
		Date exp = new Date(expMillis);

		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(KEY);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		return Jwts.builder()
				.setIssuedAt(now)
				.setExpiration(exp)
				.setSubject(subject.toString())
				.setIssuer(ISSUER)
				.signWith(signatureAlgorithm, signingKey)
				.compact();
	}

}
