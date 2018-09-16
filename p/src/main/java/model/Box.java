package model;

import enums.TypeOfBox;

public class Box {
	private TypeOfBox typeOfBox;
	private IObjectGraphic objectGraphic;
	
	public Box (TypeOfBox typeOfBox, IObjectGraphic objectGraphic) {
		this.typeOfBox = typeOfBox;
		this.objectGraphic = objectGraphic;
	}

	public TypeOfBox getTypeOfBox() {
		return typeOfBox;
	}

	public void setTypeOfBox(TypeOfBox typeOfBox) {
		this.typeOfBox = typeOfBox;
	}
	
	public IObjectGraphic getObjectGraphic() {
		return objectGraphic;
	}

	public void setObjectGraphic(IObjectGraphic objectGraphic) {
		this.objectGraphic = objectGraphic;
	}	
}
