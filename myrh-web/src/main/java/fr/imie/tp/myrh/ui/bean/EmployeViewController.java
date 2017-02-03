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
	private EmployeBean employeForm;
	
	private List<Employe> employeItems;
	
	private final IEmployeDAO employeDaoService = new EmployeDAOimpl();

	
	@PostConstruct
    public void init() {
		employeItems = (List<Employe>) employeDaoService.getAllEmploye();
    }
	
	public void addEmploye() {
		System.out.println("Utilisateur "+ employeForm.getNom() +" "+ employeForm.getPrenom());
		employeDaoService.addEmploye(
			employeForm.getNom(), 
				employeForm.getPrenom(), 
			//employeBean.getDepartement(), 
			null,
			employeForm.getNum_secu(), 
			employeForm.getSalaire(), 
			employeForm.getDateEmbauche(), 
			employeForm.getDateFinEmbauche()
		);
	}
	
	public List<Employe> getEmployeItems() {
		return employeItems;
	}

	public void setEmployeItems(List<Employe> employeItems) {
		this.employeItems = employeItems;
	}

	/**
	 * @return the employeForm
	 */
	public EmployeBean getEmployeForm() {
		return employeForm;
	}

	/**
	 * @param employeForm the employeForm to set
	 */
	public void setEmployeForm(EmployeBean employeForm) {
		this.employeForm = employeForm;
	}

	
	
}