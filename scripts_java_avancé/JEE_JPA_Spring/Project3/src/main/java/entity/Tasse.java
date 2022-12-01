package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Tasse")
public class Tasse {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="status")
	private boolean status;
	@Column(name="anse")
	private boolean anse;
	@Column(name="gravure")
	private String gravure;
	@Column(name="motif")
	private String motif;
	
	public Tasse() {
	}
	
	public Tasse(boolean status, boolean anse, String gravure, String motif) {
		this.status = status;
		this.anse = anse;
		this.gravure = gravure;
		this.motif = motif;
	}


	@Override
	public String toString() {
		return "Tasse [id=" + id + ", status=" + status + ", anse=" + anse + ", gravure=" + gravure + ", motif=" + motif
				+ "]";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isAnse() {
		return anse;
	}
	public void setAnse(boolean anse) {
		this.anse = anse;
	}
	public String getGravure() {
		return gravure;
	}
	public void setGravure(String gravure) {
		this.gravure = gravure;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	
	
}
