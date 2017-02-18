package org.usfirst.frc5112.Robot2017V3;

import org.opencv.core.Range;

import com.kylecorry.frc.vision.TargetSpecs;
import com.thegongoliers.input.camera.LEDColor;

public class BoilerRetroSpecs implements TargetSpecs{

	@Override
	public Range getHue() {
		// TODO Auto-generated method stub
		return LEDColor.GreenV2.getHue();
	}

	@Override
	public Range getSaturation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Range getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return 0;
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
