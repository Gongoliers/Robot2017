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
		return inchesToMeters(15);
	}

	@Override
	public double getHeight() {
		return inchesToMeters(10);
	}

	private double inchesToMeters(double inches) {
		return inches * 0.0254;
	}

	@Override
	public double getArea() {
		return 0;
	}

	@Override
	public int getMinPixelArea() {
		// TODO Auto-generated method stub
		return 0;
	}

}
