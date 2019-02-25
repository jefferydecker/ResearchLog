package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-02-24T19:48:49.961-0600")
@StaticMetamodel(Source.class)
public class Source_ {
	public static volatile SingularAttribute<Source, Integer> srcId;
	public static volatile SingularAttribute<Source, String> srcTitle;
	public static volatile SingularAttribute<Source, String> srcAuthor;
	public static volatile SingularAttribute<Source, String> srcPublication;
	public static volatile SingularAttribute<Source, String> srcLocation;
	public static volatile ListAttribute<Source, Citation> citationList;
}
