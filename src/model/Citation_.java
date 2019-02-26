package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-02-26T01:01:45.076-0600")
@StaticMetamodel(Citation.class)
public class Citation_ {
	public static volatile SingularAttribute<Citation, Integer> citeId;
	public static volatile SingularAttribute<Citation, Integer> srcId;
	public static volatile SingularAttribute<Citation, Date> dateFound;
	public static volatile SingularAttribute<Citation, String> refBody;
	public static volatile SingularAttribute<Citation, String> locDetail;
	public static volatile SingularAttribute<Citation, Source> source;
}
