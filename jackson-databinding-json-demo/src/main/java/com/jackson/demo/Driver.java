package com.jackson.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {

			ObjectMapper mapper = new ObjectMapper();

			Student student = mapper.readValue(new File("data/sample-lite.json"), Student.class);

			System.out.println(student.getFirstName());
			System.out.println(student.getLastName());
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
