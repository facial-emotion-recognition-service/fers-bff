package esense.bff.faces.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import esense.bff.faces.Rectangle;
import esense.bff.faces.Rectangle2Points;

public class CoordinatesSubMapper {

	public void validateInput(String input) {
		if (input == null || input.length() < 3) {
			throw new RuntimeException("Invalid coordinates text input: " + input);
		}
		if (input == null || input.length() < 3) {
			throw new RuntimeException();
		}
	}

	public String modifyInputText(String input) {
		String input2 = input.strip();
		String input3 = input2.substring(1, input2.length() - 1);
		String input4 = input3.replace('[', 'S').replace(']', 'E');
		String input5 = input4 + ", ";
		return input5;
	}

	public List<String> splitIntoListEachRectangleIsString(String input5) {
		List<String> coordinatesAsText1 = Arrays.asList(input5.split("S"));

		List<String> coordinatesAsText2 = coordinatesAsText1.stream().filter(a->!a.isEmpty()).toList();

		List<String> coordinatesAsText3 = coordinatesAsText2.stream().map(s->s.substring(0, s.length()-3)).toList();
		return coordinatesAsText3;
	}

	public List<List<String>> splitIntoListOfListCoordinatesAsStrings(List<String> lstRectangleAsString) {
		List<List<String>> coordinatesAsStrings = new ArrayList<>();
		for (String text : lstRectangleAsString) {
			List<String> a =Arrays.asList(text.split(", "));
			coordinatesAsStrings.add(a);
		}
		return coordinatesAsStrings;
	}

	public List<List<Integer>> parseCoordinatesIntoIntegers(List<List<String>> coordinatesAsStrings) {
		List<List<Integer>> coordinatesAsIntegers = new ArrayList<>();
		for (List<String> a : coordinatesAsStrings) {
			List<Integer> b = a.stream().map(s->Integer.parseInt(s)).toList();
			coordinatesAsIntegers.add(b);
		}
		return coordinatesAsIntegers;
	}


	public List<Rectangle2Points> parseIntegerCoordinatesIntoRectangle2Points(List<List<Integer>> coordinatesAsIntegers) {
		return coordinatesAsIntegers.stream().map(a -> toRectangle2Points(a)).toList();
	}

	private Rectangle2Points toRectangle2Points(List<Integer> a) {
		//top, right, bottom, left
		return new Rectangle2Points(a.get(0), a.get(1), a.get(2), a.get(3));
	}

	public List<Rectangle> mapRectangle2PointsIntoRectangle(List<Rectangle2Points> points) {
		return points.stream().map(a -> toRectangle(a)).toList();
	}

	private Rectangle toRectangle(Rectangle2Points a) {
		int x = a.getLeft(); 
		int y = a.getTop(); 
		int w = a.getRight() - a.getLeft(); 
		int h = a.getBottom() - a.getTop();
		return new Rectangle(x, y, w, h);
	}

}
