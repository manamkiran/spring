package com.jackson.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DriverFull {

	public static void main(String[] args) {

		try {

			ObjectMapper mapper = new ObjectMapper();

			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);

			System.out.println(student.getFirstName());
			System.out.println(student.getLastName());
			System.out.println(student.getAddress());

			for (String language : student.getLanguages()) {
				System.out.println(language);
			}

			Student student2 = mapper.readValue(new File("data/sample-full_additionalProp.json"), Student.class);

			System.out.println(student2.getFirstName());
			System.out.println(student2.getLastName());
			System.out.println(student2.getAddress());

			for (String language : student2.getLanguages()) {
				System.out.println(language);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
