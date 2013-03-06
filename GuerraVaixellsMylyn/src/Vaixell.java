
public class Vaixell {
	int x,y;
	int mida;
	Orientacio orient;
	
	public Vaixell(int mida, Orientacio or){
		this.mida=mida;
		orient=or;
	}
	
	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}
	
	public int getMida(){
		return mida;
	}
	
	public Orientacio getOrientacio(){
		return orient;
	}

}
