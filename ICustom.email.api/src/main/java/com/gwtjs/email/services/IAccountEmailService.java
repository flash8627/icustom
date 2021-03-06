package com.gwtjs.email.services;

import com.gwtjs.common.entity.ResultWrapper;
import com.gwtjs.email.exception.AccountEmailException;

public interface IAccountEmailService {
	
	public ResultWrapper sendMail(String to,String subject,String htmlText) throws AccountEmailException;
	
}
