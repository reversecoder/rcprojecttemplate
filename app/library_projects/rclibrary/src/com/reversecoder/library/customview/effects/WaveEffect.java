package com.reversecoder.library.customview.effects;

import android.view.View;

import com.reversecoder.library.customview.utils.CustomEffect;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

public class WaveEffect implements CustomEffect {

	@Override
	public void initView(View item, int position, int scrollDirection) {
		ViewHelper.setTranslationX(item, -item.getWidth());
	}

	@Override
	public void setupAnimation(View item, int position, int scrollDirection,
			ViewPropertyAnimator animator) {
		animator.translationX(0);
	}

}
