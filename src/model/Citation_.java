package model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-02-28T22:57:40.773-0600")
@StaticMetamodel(Citation.class)
public class Citation_ {
	public static volatile SingularAttribute<Citation, Integer> refId;
	public static volatile SingularAttribute<Citation, Integer> srcId;
	public static volatile SingularAttribute<Citation, LocalDate> dateFound;
	public static volatile SingularAttribute<Citation, String> refBody;
	public static volatile SingularAttribute<Citation, String> locDetail;
}
