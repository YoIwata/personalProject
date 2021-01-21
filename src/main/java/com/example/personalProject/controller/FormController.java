package com.example.personalProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value = "/result", method=RequestMethod.POST)
	public Form doPost(@RequestBody Form form) {
		formDao.insertForm(form);

		return form;
	}

	@RequestMapping(value = "/index/{id}", method=RequestMethod.PUT)
	public void doPut(@PathVariable("id") Integer id, @RequestBody Form form) {
		formDao.updateForm(form);

	}

	@RequestMapping(value = "/index/{id}", method=RequestMethod.DELETE)
	public void doDelete(@PathVariable("id") Integer id) {
		formDao.deleteForm(id);

	}
}
