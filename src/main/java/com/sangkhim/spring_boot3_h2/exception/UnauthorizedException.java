package com.sangkhim.spring_boot3_h2.exception;

import com.sangkhim.spring_boot3_h2.exception.base.ServiceException;

/** trigger for unauthorized exception */
public class UnauthorizedException extends ServiceException {

  public UnauthorizedException() {
    super();
  }

  public UnauthorizedException(String message) {
    super(message);
  }

  public UnauthorizedException(String message, Throwable throwable) {
    super(message, throwable);
  }
}