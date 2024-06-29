package com.akhm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.akhm.exception.MyCustomException;

public class DateUtils {

	private DateUtils() {

	}

	public static Date convertStringToDate(String inputDate)
			throws MyCustomException {
		// Initialize an empty Date object
		Date date = null;

		try {
			// Create a SimpleDateFormat object with the specified date format
			// ("dd/MM/yyyy")
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			// Parse the input string into a Date object
			date = sdf.parse(inputDate);
		} catch (ParseException pe) {
			// If parsing fails, throw a custom exception with details
			throw new MyCustomException(
					"Exception occurred while converting String to Date in DateUtils class. Input date: "
							+ inputDate
							+ ". Exception message: "
							+ pe.getMessage());
		}

		// Return the converted Date object or null if parsing failed (exception
		// thrown)
		return date;
	}

	public static String convertDateToString(Date date) {
		// Initialize the output date string to null
		String outPutDate = null;
		try {
			// Create a SimpleDateFormat instance with the desired date format
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			// Format the given date into the specified format and assign it to
			// outPutDate
			outPutDate = sdf.format(date);
		} catch (Exception e) {
			// If any exception occurs during date formatting, it will be caught
			// here
			// The catch block is empty, so the exception is ignored
		}

		// Return the formatted date string, or null if an exception occurred
		return outPutDate;
	}

}
