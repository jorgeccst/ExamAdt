/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 2dam
 */

@Entity
@XmlRootElement
@Table(schema="studentdb")
public class School implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idSchool;
    @Column(name="name")
    private String name;
    @Enumerated
    private SchoolType type;
    
    @OneToMany(mappedBy="school")
    private List<Student> students;
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="schoolSubject",schema="studentdb",joinColumns=@JoinColumn(name="idSchool",referencedColumnName="idSchool"),inverseJoinColumns=@JoinColumn(name="idStudent",referencedColumnName="id"))
    private List<Subject>subjects;
    @XmlTransient
    public List<Student> getStudents() {
        return students;
    }

    @XmlTransient
    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SchoolType getType() {
        return type;
    }

    public void setType(SchoolType type) {
        this.type = type;
    }
    
    public Integer getId() {
        return idSchool;
    }

    public void setId(Integer idSchool) {
        this.idSchool = idSchool;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSchool != null ? idSchool.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof School)) {
            return false;
        }
        School other = (School) object;
        if ((this.idSchool == null && other.idSchool != null) || (this.idSchool != null && !this.idSchool.equals(other.idSchool))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.School[ id=" + idSchool + " ]";
    }
    
}
