package model;

import java.io.Serializable;

public interface PersistentEntity<I extends Serializable> extends Serializable {
	public I getId();
	
}
