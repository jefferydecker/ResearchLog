package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="citation")
public class Citation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="refid")
	private int refId;
	@Column(name="srcid")
	private int srcId;
	@Column(name="datefound")
	private int dateFound;
	@Column(name="refbody")
	private int refBody;
	@Column(name="locdetail")
	private int locDetail;
	
	public Citation() {
		super();
	}

	public Citation(int refId, int srcId, int dateFound, int refBody, int locDetail) {
		super();
		this.refId = refId;
		this.srcId = srcId;
		this.dateFound = dateFound;
		this.refBody = refBody;
		this.locDetail = locDetail;
	}

	public int getDateFound() {
		return dateFound;
	}

	public void setDateFound(int dateFound) {
		this.dateFound = dateFound;
	}

	public int getRefBody() {
		return refBody;
	}

	public void setRefBody(int refBody) {
		this.refBody = refBody;
	}

	public int getLocDetail() {
		return locDetail;
	}

	public void setLocDetail(int locDetail) {
		this.locDetail = locDetail;
	}

	public int getRefId() {
		return refId;
	}

	public int getSrcId() {
		return srcId;
	}
	
	
	
	
}
