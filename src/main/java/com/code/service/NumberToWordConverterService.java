package com.code.service;

import com.code.exception.MaxLimitExceededException;

public interface NumberToWordConverterService {

	public String convert(int number) throws MaxLimitExceededException;
}
