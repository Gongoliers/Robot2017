package org.usfirst.frc5112.Robot2017V3;

import org.opencv.core.Range;

import com.kylecorry.frc.vision.TargetSpecs;

public class BoilerRetroSpecs implements TargetSpecs{

	@Override
	public Range getHue() {
		return new Range(75, 125);
	}

	@Override
	public Range getSaturation() {
		return new Range(175, 255);
	}

	@Override
	public Range getValue() {
		return new Range(65, 255);
	}

	@Override
	public double getWidth() {
		return inchestToMeters(15);
	}

	@Override
	public double getHeight() {
		return inchestToMeters(10);
	}

	private double inchestToMeters(double inches) {
		return inches * 0.0254;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinPixelArea() {
		// TODO Auto-generated method stub
		return 0;
	}

}
