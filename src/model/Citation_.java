package model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-02-26T22:46:21.011-0600")
@StaticMetamodel(Citation.class)
public class Citation_ {
	public static volatile SingularAttribute<Citation, Integer> citeId;
	public static volatile SingularAttribute<Citation, Integer> srcId;
	public static volatile SingularAttribute<Citation, LocalDate> dateFound;
	public static volatile SingularAttribute<Citation, String> refBody;
	public static volatile SingularAttribute<Citation, String> locDetail;
	public static volatile SingularAttribute<Citation, Source> source;
}
