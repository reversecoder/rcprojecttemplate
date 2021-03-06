package com.reversecoder.library.customview.ScrollInsideScroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class CustomScrollableListView extends ListView {
	private float lastMotionY;

	public CustomScrollableListView(Context context) {
		super(context);
	}

	public CustomScrollableListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int mode = MeasureSpec.getMode(widthMeasureSpec);
		if (mode == MeasureSpec.UNSPECIFIED) {
			int height = getLayoutParams().height;
			if (height > 0)
				setMeasuredDimension(getMeasuredWidth(), height);
		}
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent event) {
		int action = event.getAction();
		float x = event.getX();
		float y = event.getY();
		float dy = y - lastMotionY;
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			lastMotionY = y;
			break;
		case MotionEvent.ACTION_MOVE:
			if (ScrollViewUtil.canScroll(this, false, (int) dy, (int) x, (int) y)) {
				lastMotionY = y;
				return false;
			}
			break;
		}
		return super.onInterceptTouchEvent(event);
	}

}
