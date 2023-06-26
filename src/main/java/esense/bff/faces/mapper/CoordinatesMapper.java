package esense.bff.faces.mapper;

import java.util.List;

import esense.bff.faces.Rectangle;
import esense.bff.faces.Rectangle2Points;

public class CoordinatesMapper {

	private final CoordinatesSubMapper sub = new CoordinatesSubMapper();

	public List<Rectangle> toCoordinatesList(String input) {
		sub.validateInput(input);
		String input5 = sub.modifyInputText(input);
		List<String> lstRectangleAsString = sub.splitIntoListEachRectangleIsString(input5);
		List<List<String>> coordinatesAsStrings = sub.splitIntoListOfListCoordinatesAsStrings(lstRectangleAsString);
		List<List<Integer>> coordinatesAsIntegers = sub.parseCoordinatesIntoIntegers(coordinatesAsStrings);
		List<Rectangle2Points> points = sub.parseIntegerCoordinatesIntoRectangle2Points(coordinatesAsIntegers);
		List<Rectangle> results = sub.mapRectangle2PointsIntoRectangle(points);
		return results;
	}

}
