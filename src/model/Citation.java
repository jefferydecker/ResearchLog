package model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "citation")
public class Citation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "citeid")
	private int citeId;
	@Column(name = "srcid")
	private int srcId;
	@Column(name = "datefound")
	private LocalDate dateFound;
	@Column(name = "refbody")
	private String refBody;
	@Column(name = "locdetail")

	private String locDetail;

	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "SRCID", referencedColumnName = "SRCID") })
	private Source source;

	public Citation() {
		super();
		
	}
	
	
	public Citation(String srcId, LocalDate dateFound, String body, Source source) {
		super();
	}

	public Citation(int citeId, int srcId, LocalDate dateFound, String refBody, String locDetail) {
		super();
		this.citeId = citeId;
		this.srcId = srcId;
		this.dateFound = dateFound;
		this.refBody = refBody;
		this.locDetail = locDetail;
	}

	public Citation(String srcId, LocalDate dateFound, String body, Source source) {
		// TODO Auto-generated constructor stub
	}


	public LocalDate getDateFound() {
		return dateFound;
	}

	public void setDateFound(LocalDate dateFound) {
		this.dateFound = dateFound;
	}

	public String getRefBody() {
		return refBody;
	}

	public void setRefBody(String refBody) {
		this.refBody = refBody;
	}

	public String getLocDetail() {
		return locDetail;
	}

	public void setLocDetail(String locDetail) {
		this.locDetail = locDetail;
	}

	public int getCiteID() {
		return citeId;
	}

	public int getSrcId() {
		return srcId;
	}

}
