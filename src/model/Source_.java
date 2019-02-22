package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-02-21T20:46:45.297-0600")
@StaticMetamodel(Source.class)
public class Source_ {
	public static volatile SingularAttribute<Source, String> srcLocation;
	public static volatile SingularAttribute<Source, String> srcPublication;
	public static volatile SingularAttribute<Source, Integer> srcAuthor;
	public static volatile SingularAttribute<Source, String> srcTitle;
	public static volatile SingularAttribute<Source, Integer> srcId;
	public static volatile ListAttribute<Source, Citation> citationList;
}
