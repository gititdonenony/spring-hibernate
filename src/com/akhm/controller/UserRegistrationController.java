package com.akhm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.akhm.controller.command.AddUserCommand;
import com.akhm.service.UserService;
import com.akhm.utils.DateUtils;
import com.akhm.service.dto.UserDTO;

public class UserRegistrationController extends SimpleFormController {
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {

		return super.formBackingObject(request);
	}

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		AddUserCommand addUserCommand = (AddUserCommand) command;
		UserDTO userDTO = new UserDTO();
		userDTO.setFirstName(addUserCommand.getFirstName());
		userDTO.setLastName(addUserCommand.getLastName());
		userDTO.setEmailId(addUserCommand.getEmailId());
		userDTO.setMobileNumber(addUserCommand.getMobileNumber());
		userDTO.setPassWord(addUserCommand.getPassWord());
		if (addUserCommand.getDob() != null) {
			userDTO.setDob(DateUtils.convertStringToDate(addUserCommand
					.getDob()));
		}
		Integer userId = userService.saveUser(userDTO);
		String target = "adduser.jsp";
		if (userId != null && userId > 0) {
			target = "redirect:users.htm";
		}
		return new ModelAndView(target);
	}

}
