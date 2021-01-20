package com.example.personalProject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.personalProject.domain.Form;

@Repository
public class FormDao {

	//https://dev.classmethod.jp/articles/use_spring-boot-dao/

	private EntityManager entityManager;

	/**
	 *
	 * @return
	 */
	public List<Form> getFormList() {
		Query query = entityManager.createQuery("FROM FORM");
		List<Form> list = query.getResultList();
		entityManager.close();
		return list;
	}

	/**
	 *
	 * @param field
	 * @return
	 */
	public List<Form> getFormByField (String field) {
		List<Form> list = entityManager.createQuery("FROM FORM WHERE FIELD = :field")
										.setParameter("field", field)
										.getResultList();

		return list;
	}

	/**
	 *
	 * @param form
	 */
	public void insertForm(Form form) {
		entityManager.createNativeQuery("INSERT INTO FORM (FIELD, QUESTION_NO, SCORE, NOTE) "
				+ "VALUES (?,?,?,?)")
	      .setParameter(1, form.getField())
	      .setParameter(2, form.getQuestionNo())
	      .setParameter(3, form.getScore())
	      .setParameter(4, form.getNote())
	      .executeUpdate();
	}

	/**
	 *
	 * @param form
	 */
	public void updateForm(Form form) {
		entityManager.createNativeQuery("UPDATE FORM SET"
				+ "FIELD = ?, QUESTION_NO = ?, SCORE = ?, NOTE = ?) ")
	      .setParameter(1, form.getField())
	      .setParameter(2, form.getQuestionNo())
	      .setParameter(3, form.getScore())
	      .setParameter(4, form.getNote())
	      .executeUpdate();
	}

	/**
	 *
	 * @param id
	 */
	public void deleteForm(Integer id) {
		entityManager.createNativeQuery("DELETE FORM WHERE ID = ?")
	      .setParameter(1, id)
	      .executeUpdate();
	}
}
