import processing.core.PApplet;
import processing.core.PImage;

public class Principal extends PApplet {

	PImage img;

	public static void main(String[] args) {
		PApplet.main("Principal");
	}

	@Override
	public void settings() // void Awake
	{
		size(1440, 1024);
		img = loadImage("Pantalla Inicio.png");
	}

	@Override
	public void setup() // void Start
	{

	}

	@Override
	public void draw() // void Update
	{
		image(img, 0, 0);
	}

}
