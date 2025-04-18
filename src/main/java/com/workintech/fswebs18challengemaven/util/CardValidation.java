package com.workintech.fswebs18challengemaven.util;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Type;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

public class CardValidation {

    public static void validate(Card card) {
        if (card == null) {
            throw new CardException("Card payload is null", HttpStatus.BAD_REQUEST);
        }
        boolean hasValue = card.getValue() != null;
        boolean hasType = card.getType() != null;

        if (hasValue && hasType) {
            throw new CardException("Card cannot have both type and value", HttpStatus.BAD_REQUEST);
        }
        if (!hasValue && !hasType) {
            throw new CardException("Card must have either type or value", HttpStatus.BAD_REQUEST);
        }
        if (card.getType() == Type.JOKER) {
            if (card.getValue() != null || card.getColor() != null) {
                throw new CardException("JOKER must not have value or color", HttpStatus.BAD_REQUEST);
            }
        }
    }
}
