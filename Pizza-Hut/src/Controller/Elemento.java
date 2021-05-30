package Controller;

public class Elemento {
//x,y,eidth,height
// valor = pizza, buton
	// pintar() : stroke
	// encima, hover, enArea

	// boolean encima () : return true or false --> condicion mX> x .... true si no
	// false
	int x;
	int y;
	int width;
	int height;
	int valor;

	public class Rects {
		int posX;
		int posY;
		protected int width;
		protected int height;

		public Rects(int _posX, int _posY, int _width, int _height) {
			this.posX = _posX;
			this.posY = _posY;
			this.width = _width;
			this.height = _height;

		}

		public boolean hasBeenClick(int _posX, int _posY) {
			boolean isInXrange = _posX > (posX - width / 2) && _posX < (posX + width / 2);
			boolean isInYrange = _posY > (posY - height / 2) && _posY < (posY + height / 2);
			return isInXrange && isInYrange;
		}
	}
}
