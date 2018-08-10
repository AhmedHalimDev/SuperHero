package com.superhero.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception for violating the constraints.
 * <p/>
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 08.08.2018
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Some constraints are violated ...")
public class ConstraintsViolationException extends Exception {

	static final long serialVersionUID = -3387516993224229948L;

	public ConstraintsViolationException(String message) {
		super(message);
	}

}
