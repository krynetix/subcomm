package com.roylaurie.subcomm.client.message;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.roylaurie.subcomm.client.SubcommMessage;

public final class SubcommLoginOkMessage extends SubcommMessage {
	private static final String NETCHAT_PREFIX = "LOGINOK";
    private static final Pattern NETCHAT_PATTERN = Pattern.compile(
        "^" + NETCHAT_PREFIX + ":$"
    );
    
   /**
    * Creates a message object from a single raw netchat message.
    * @param String netchatMessage
    * @return SubcommLoginOkMessage NULL if the expected pattern doesn't match.
    * @throws IllegalArgumentException If the parameter values are unsupported
    */
    public static SubcommLoginOkMessage parseNetchatMessage(String netchatMessage) {
        Matcher matcher = NETCHAT_PATTERN.matcher(netchatMessage);
        if (!matcher.find())
            return null;
        return new SubcommLoginOkMessage();
    }  	
	
    public SubcommLoginOkMessage() {
        super(NETCHAT_PREFIX);
    }

    @Override
    public String getNetchatMessage() {
       return createNetchatMessage();
    }
}
