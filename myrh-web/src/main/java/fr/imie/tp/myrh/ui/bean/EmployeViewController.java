package fr.imie.tp.myrh.ui.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.imie.tp.myrh.dao.ifc.IEmployeDAO;
import fr.imie.tp.myrh.dao.impl.EmployeDAOimpl;
import fr.imie.tp.myrh.dao.model.Employe;

@ManagedBean(name="employeViewController")
public class EmployeViewController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{employeBean}")
	private EmployeBean employeBean;
	
	private List<Employe> employeItems;
	
	private final IEmployeDAO employeDaoService = new EmployeDAOimpl();

	
	@PostConstruct
    public void init() {
		employeItems = (List<Employe>) employeDaoService.getAllEmploye();
    }
	
	public void addEmploye() {
		System.out.println("Utilisateur "+ employeBean.getNom() +" "+ employeBean.getPrenom());
		employeDaoService.addEmploye(
			employeBean.getNom(), 
			employeBean.getPrenom(), 
			employeBean.getDepartement(), 
			employeBean.getNum_secu(), 
			employeBean.getSalaire(), 
			employeBean.getDateEmbauche(), 
			employeBean.getDateFinEmbauche()
		);
	}
	
	public List<Employe> getEmployeItems() {
		return employeItems;
	}

	public void setEmployeItems(List<Employe> employeItems) {
		this.employeItems = employeItems;
	}

	public EmployeBean getEmployeBean() {
		return employeBean;
	}

	public void setEmployeBean(EmployeBean employeBean) {
		this.employeBean = employeBean;
	}
	
}