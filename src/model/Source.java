package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sources")
public class Source {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="srcid")
	private int srcId;
	@Column(name="title")
	private String srcTitle;
	@Column(name="author")
	private String srcAuthor;
	@Column(name="publication")
	private String srcPublication;
	@Column(name="srcloc")
	private String srcLocation;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="SRCID")			// Why don't we need this? Is it because
										// we it knows the key of SOURCE and CITATION
										// has a field with the same name?

	private List<Citation> citationList;
	
	
	public Source() {
		super();
	}
	
	public Source(String srcTitle, String srcAuthor, String srcPublication, String srcLocation) {
		super();
		this.srcTitle = srcTitle;
		this.srcAuthor = srcAuthor;
		this.srcPublication = srcPublication;
		this.srcLocation = srcLocation;
	}
	
	
	public String getSrcTitle() {
		return srcTitle;
	}
	public void setSrcTitle(String srcTitle) {
		this.srcTitle = srcTitle;
	}
	public String getSrcAuthor() {
		return srcAuthor;
	}
	public void setSrcAuthor(String srcAuthor) {
		this.srcAuthor = srcAuthor;
	}
	public String getSrcPublication() {
		return srcPublication;
	}
	public void setSrcPublication(String srcPublication) {
		this.srcPublication = srcPublication;
	}
	public String getSrcLocation() {
		return srcLocation;
	}
	public void setSrcLocation(String srcLocation) {
		this.srcLocation = srcLocation;
	}
	public List<Citation> getCitationList() {
		return citationList;
	}
	public void setCitationList(List<Citation> citationList) {
		this.citationList = citationList;
	}
	public int getSrcId() {
		return srcId;
	}

	
	
	
}
