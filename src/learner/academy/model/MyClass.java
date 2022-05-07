package learner.academy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class MyClass implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    
	private String name;
	
	@OneToMany(mappedBy="Myclass")
	private List<Student> studList = new ArrayList<>();
	@JoinTable(name="class_subject_teacher")
	@ManyToMany
	
	private List<Subject> subjects = new ArrayList<>();
	@ManyToMany(mappedBy="clist")
	private List<Teacher> teachers = new ArrayList<>();

	public MyClass(String name)
	{
		this.name= name;
	}
	
	public MyClass()
	{ super();
		
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + "]";
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

	public List<Student> getStudList() {
		return studList;
	}

	public void setStudList(List<Student> studList) {
		this.studList = studList;
	}
	
	
}
