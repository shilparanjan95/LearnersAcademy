package learner.academy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table

public class Subject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6843402284884080410L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@ManyToMany(mappedBy = "subjects")
	private List<MyClass> clist = new ArrayList<>();

	public Subject(String sub) {
		this.name = sub;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MyClass> getClist() {
		return clist;
	}

	public void setClist(List<MyClass> clist) {
		this.clist = clist;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", clist=" + clist + "]";
	}
     public Subject()
     {
    	 super();
     }
}
