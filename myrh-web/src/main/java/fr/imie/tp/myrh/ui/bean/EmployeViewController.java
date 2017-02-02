package fr.imie.tp.myrh.ui.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import fr.imie.tp.myrh.dao.ifc.IEmployeDAO;
import fr.imie.tp.myrh.dao.impl.EmployeDAOimpl;
import fr.imie.tp.myrh.dao.model.Employe;

@ManagedBean(name="employeViewController")
public class EmployeViewController implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private List<Employe> employeItems;
	
	
	private final IEmployeDAO _employeDaoService = new EmployeDAOimpl();

	
	@PostConstruct
    public void init() {
		employeItems = (List<Employe>) _employeDaoService.getAllEmploye();
    }
	
	public List<Employe> getEmployeItems() {
		return employeItems;
	}

	public void setEmployeItems(List<Employe> employeItems) {
		this.employeItems = employeItems;
	}
	
}