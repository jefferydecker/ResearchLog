package model;


import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private Date dateFound;
	@Column(name="refbody")
	private String refBody;
	@Column(name="locdetail")
<<<<<<< HEAD
	private int locDetail;
	
//	@ManyToOne
//			//	@JoinColumns({
//			//			@JoinColumn(name = "SRCID", referencedColumnName = "SRCID") })
//	@JoinColumn(name = "SRCID")
//	private Source source;
=======

	private String locDetail;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "SRCID", referencedColumnName = "SRCID") })
	private Source source;
>>>>>>> e41456e03a0914011f7b7351e6182289ac479c29

	public Citation() {
		super();
	}

	public Citation(int refId, int srcId, Date dateFound, String refBody, String locDetail) {
		super();
		this.refId = refId;
		this.srcId = srcId;
		this.dateFound = dateFound;
		this.refBody = refBody;
		this.locDetail = locDetail;
	}

	public Date getDateFound() {
		return dateFound;
	}

	public void setDateFound(Date dateFound) {
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
