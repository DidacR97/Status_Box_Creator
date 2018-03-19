package model;

public class Container {

	public static String header ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
			"<svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http:"
			+ "//www.w3.org/1999/xlink\" xmlns:ev=\"http://www.w3.org/2001/"
			+ "xml-events\" baseProfile=\"full\" width=\"100%\" height=\"100%\" viewBox=\"0 0 1920 1080\">";
	public static String footer ="\t\t</g>\r\n\t</g>\r\n</svg>";
	
	public static String status = "estados";
	
	public static String firstTransform = "<g id=\"" + status + "\" transform=\"matrix(0.76 0 0 0.76 550 150)\">";
	
	public static String secondTransform = "<g id=\"semaforos\" transform=\"matrix(1 0 0 1 1355 890)\">";
	
	private static int TAB = 1;
	
	
	public static String svgCreator(int status, int ellipses) {
		String svg = "";
		svg += header+spacer(firstTransform)+spacer(secondTransform);
		svg+=spacer("<rect id=\"rect_arg\" fill=\"#9A9A9A\" "
				+ "fill-opacity=\"\" x=\"0\" y=\"0\" width=\"415\" "
				+ "height=\"308\" rx=\"6\" ry=\"6\" display=\"\"/>")+System.lineSeparator();
		svg+=footer;
		return svg;
	}
	
	private static String spacer(String text) {
		return System.lineSeparator()+tabber(text);
	}
	
	private static String tabber(String text) {
		String toReturn = "";
		for (int i = 0; i < TAB; i++) {
			toReturn += "\t";	
		}
		TAB++;
		return toReturn+text;
	}
}

