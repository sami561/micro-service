package com.sami.customer.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerNotFoundeException extends RuntimeException
{
    private final String msg;
}
