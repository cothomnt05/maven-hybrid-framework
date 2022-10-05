package com.nopcommerce.data;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class UserDataMapper {
	public static UserDataMapper getUserData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/src/test/resources/UserData.json"), UserDataMapper.class);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static class Login {
		@JsonProperty("username")
		String username;

		@JsonProperty("password")
		String password;
	}

	@JsonProperty("login")
	private Login login;

	public String getUsernameLogin() {
		return login.username;
	}

	public String getPasswordLogin() {
		return login.password;
	}

	public static class Subject {
		@JsonProperty("name")
		String name;

		@JsonProperty("point")
		float point;

		public String getName() {
			return name;
		}

		public float getPoint() {
			return point;
		}
	}

	@JsonProperty("subjects")
	private List<Subject> subjects;

	public List<Subject> getSubjects() {
		return subjects;
	}

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("email")
	private String email;

	@JsonProperty("password")
	private String password;

	@JsonProperty("date")
	private String date;

	@JsonProperty("month")
	private String month;

	@JsonProperty("year")
	private String year;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getDate() {
		return date;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}
}
