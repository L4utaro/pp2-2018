package model;

import org.eclipse.jdt.annotation.Nullable;

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
	
	@Nullable
	public IObjectGraphic getObjectGraphic() {
		return objectGraphic;
	}

	public void setObjectGraphic(IObjectGraphic objectGraphic) {
		this.objectGraphic = objectGraphic;
	}	
}
