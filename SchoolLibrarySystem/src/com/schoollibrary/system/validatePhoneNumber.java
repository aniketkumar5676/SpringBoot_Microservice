package com.schoollibrary.system;

import java.util.regex.Pattern;

class validatePhoneNumber{
	
public validatePhoneNumber(String phone) {
    final String regexStr = "^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$";
    if (!Pattern.matches(regexStr, phone)) {
        throw new PhoneNotValidException(phone);
    }
}
}