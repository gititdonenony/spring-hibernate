package com.akhm.utils;

import com.akhm.dao.model.UserTl;
import com.akhm.service.dto.UserDTO;

public class FactoryUtils {

	private FactoryUtils() {

	}

	public static UserTl convertUserDtoToUserTl(UserDTO userDTO) {
		// Initialize an empty UserTl object
		UserTl userTl = null;

		// Check if the userDTO object is not null (avoiding
		// NullPointerException)
		if (userDTO != null) {
			// Create a new UserTl object
			userTl = new UserTl();

			// Copy properties from userDTO to userTl (assuming they have
			// matching data
			// types)
			userTl.setUserId(userDTO.getUserId());
			userTl.setFirstName(userDTO.getFirstName());
			userTl.setLastName(userDTO.getLastName());
			userTl.setEmailId(userDTO.getEmailId());
			userTl.setMobileNumber(userDTO.getMobileNumber());
			userTl.setPassWord(userDTO.getPassWord());

			// Handle the dob (date of birth) property if it's not null in
			// userDTO
			if (userDTO.getDob() != null) {
				// Convert the userDTO's dob (likely a java.util.Date) to a
				// java.sql.Date
				// suitable for databases
				java.sql.Date sqlDate = new java.sql.Date(userDTO.getDob()
						.getTime());
				userTl.setDob(sqlDate);
			}
		}

		// Return the converted UserTl object (or null if userDTO was null)
		return userTl;
	}

	public static UserDTO convertUserTlToUserDTO(UserTl userTl) {
		// Initialize an empty UserDTO object
		UserDTO userDTO = null;

		// Check if the userTl object is not null (avoiding
		// NullPointerException)
		if (userTl != null) {
			// Create a new UserDTO object
			userDTO = new UserDTO();

			// Copy properties from userTl to userDTO (assuming they have
			// matching data
			// types)
			userDTO.setUserId(userTl.getUserId());
			userDTO.setFirstName(userTl.getFirstName());
			userDTO.setLastName(userTl.getLastName());
			userDTO.setEmailId(userTl.getEmailId());
			userDTO.setMobileNumber(userTl.getMobileNumber());
			userDTO.setPassWord(userTl.getPassWord());

			// In this case, dob (date of birth) can be directly assigned
			// assuming
			// compatible types
			userDTO.setDob(userTl.getDob());
		}

		// Return the converted UserDTO object (or null if userTl was null)
		return userDTO;
	}

}
