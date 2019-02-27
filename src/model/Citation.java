package model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="citations")
public class Citation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="refid")
	private int refId;
	@Column(name="srcid")
	private int srcId;
	@Column(name="datefound")
	private String dateFound;		//change to LocalDate type after adding converters
	@Column(name="refbody")
	private String refBody;
	@Column(name="locdetail")
	private String locDetail;


	public Citation() {
		super();
	}

	public Citation(int refId, int srcId, String dateFound, String refBody, String locDetail) {
		super();
		this.refId = refId;
		this.srcId = srcId;
		this.dateFound = dateFound;
		this.refBody = refBody;
		this.locDetail = locDetail;
	}

	public String getDateFound() {
		return dateFound;
	}

	public void setDateFound(String dateFound) {
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

	public int getRefId() {
		return refId;
	}

	public int getSrcId() {
		return srcId;
	}
	
	
	
	
}
