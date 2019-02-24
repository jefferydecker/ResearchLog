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
	private int srcAuthor;
	@Column(name="publication")
	private String srcPublication;
	@Column(name="srcloc")
	private String srcLocation;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="SRCID")			// Why don't we need this? Is it because
										// we it knows the key of SOURCE and CITATION
										// has a field with the same name?

	private List<Citation> citationList;

}
