package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-02-24T16:11:45.570-0600")
@StaticMetamodel(Citation.class)
public class Citation_ {
	public static volatile SingularAttribute<Citation, Integer> refId;
	public static volatile SingularAttribute<Citation, Integer> srcId;
	public static volatile SingularAttribute<Citation, Integer> dateFound;
	public static volatile SingularAttribute<Citation, Integer> refBody;
	public static volatile SingularAttribute<Citation, Integer> locDetail;
	public static volatile SingularAttribute<Citation, Source> source;
}
