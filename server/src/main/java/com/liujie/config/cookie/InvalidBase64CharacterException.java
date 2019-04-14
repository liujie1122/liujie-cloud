package com.liujie.config.cookie;

 /**
 * Thrown to indicate a bad input character in the Base64 stream.
 *
 * @author Luke Taylor
 * @since 1.2.2
 */
public class InvalidBase64CharacterException extends IllegalArgumentException {

    InvalidBase64CharacterException(String message) {
        super(message);
    }

}