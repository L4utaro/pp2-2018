package model;

import enums.TypeOfBox;

public class Box {
	private TypeOfBox typeOfBox;
	private ObjectGraphic objectGraphic;
	
	public Box (TypeOfBox typeOfBox, ObjectGraphic objectGraphic) {
		this.typeOfBox = typeOfBox;
		this.objectGraphic = objectGraphic;
	}

	public TypeOfBox getTypeOfBox() {
		return typeOfBox;
	}

	public void setTypeOfBox(TypeOfBox typeOfBox) {
		this.typeOfBox = typeOfBox;
	}

	public ObjectGraphic getObjectGraphic() {
		return objectGraphic;
	}

	public void setObjectGraphic(ObjectGraphic objectGraphic) {
		this.objectGraphic = objectGraphic;
	}	
}
