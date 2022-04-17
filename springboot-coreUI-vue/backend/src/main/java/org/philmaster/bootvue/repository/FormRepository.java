/*
 * Created on 2020-08-09 ( Time 23:38:02 )
 * Generated by Telosys Tools Generator ( version 3.1.2 )
 */

package org.philmaster.bootvue.repository;

import java.util.List;

import org.philmaster.bootvue.model.Form;
import org.philmaster.bootvue.model.FormType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Spring JPA Repository for Form
 * 
 * @author Telosys Tools Generator
 *
 */
@RepositoryRestResource
public interface FormRepository extends JpaRepository<Form, Short> {

	public List<Form> findByFormType(@Param("formtype") FormType formtype);

}