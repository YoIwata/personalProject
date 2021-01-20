package com.example.personalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.personalProject.dao.FormDao;
import com.example.personalProject.domain.Form;

@RestController
public class FormController {

	// https://dev.classmethod.jp/articles/use_spring-boot-dao/

	@Autowired
	private FormDao formDao;

	@RequestMapping(value = "/index", method=RequestMethod.GET)
	public List<Form> doGet() {
		List<Form> list = formDao.getFormList();

		return list;
	}

	public void doPost(Form form) {
		formDao.insertForm(form);

	}

	public void doPut(Form form) {
		formDao.updateForm(form);

	}

	public void doDelete(Integer id) {
		formDao.deleteForm(id);

	}
}
