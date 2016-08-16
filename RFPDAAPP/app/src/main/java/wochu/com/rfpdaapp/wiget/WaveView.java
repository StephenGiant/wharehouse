package wochu.com.rfpdaapp.wiget;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * 水波纹控件
 * 1. ��ε�֪�û�������ĸ�Ԫ�� 2. ���ȡ�ñ����Ԫ�ص���Ϣ 3. ���ͨ��layout�����ػ����ˮ���� 4. ����ӳ�up�¼��ķַ�
 * 
 */
public class WaveView extends LinearLayout {
	private View mTargetTouchView;
	private Paint mHalfTransPaint;
	private Paint mTransPaint;
	private float[] mDownPositon;// ��ָ��������꣬Ҳ����Բ�������ĵ�
	private float rawRadius;// ԭʼ��Բ���뾶
	private float drawedRadius;// �����������Ƶ�Բ���뾶
	private float drawingRadiusDegrees = 10;//��������Բ����ʱ�򣬰뾶�ĵ����ٷֱ�
	private static final long INVALID_DURATION = 30;
	private static postUpEventDelayed delayedRunnable;
	public void init() {
		setOrientation(VERTICAL);
		mHalfTransPaint = new Paint();
		mHalfTransPaint.setColor(Color.parseColor("#55ffffff"));
		mHalfTransPaint.setAntiAlias(true);
		mTransPaint = new Paint();
		mTransPaint.setColor(Color.parseColor("#00ffffff"));
		mTransPaint.setAntiAlias(true);
		mDownPositon = new float[2];
		delayedRunnable = new postUpEventDelayed();
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		if (ev.getAction() == MotionEvent.ACTION_DOWN) {
			mTargetTouchView = null;
			drawedRadius = 0;
			float x = ev.getRawX();
			float y = ev.getRawY();
			mTargetTouchView = findTargetView(x, y, this);
			if(mTargetTouchView!=null){
				Button msg = (Button) mTargetTouchView;
				RectF targetTouchRectF = getViewRectF(mTargetTouchView);
				mDownPositon = getCircleCenterPostion(x, y);
				// ��Ҫ���Ƶ�Բ�������ĵ�
				float circleCenterX = mDownPositon[0];
				float circleCenterY = mDownPositon[1];
				/**
				 * Բ���İ뾶�� Բ�������ĵ�Բ�ĵ�Ȼ�ǵ�����Ǹ��㣬���ǰ뾶�Ǳ仯��
				 * Բ�Ŀ�������mTargetTouchView������������λ֮�ڣ�����Ҫ��Բ�����Ƹ�������mTargetTouchView
				 * ��radius��ȡֵΪԲ�ĵĺ����굽mTargetTouchView���ĸ���ľ����е����ֵ
				 */
				float left = circleCenterX - targetTouchRectF.left;
				float right = targetTouchRectF.right - circleCenterX;
				float top = circleCenterY - targetTouchRectF.top;
				float bottom = targetTouchRectF.bottom - circleCenterY;
				// ���������ֵ��Ϊ�뾶
				rawRadius = Math.max(bottom, Math.max(Math.max(left, right), top));
				postInvalidateDelayed(INVALID_DURATION);
			}
		}else if (ev.getAction() == MotionEvent.ACTION_UP) {
			// ��Ҫ�ò��ƻ�����Ϻ���ִ����up��ִ�еķ���
//			if(drawedRadius==0){
//				return false;
//			}
//			long totalTime = (long) (INVALID_DURATION * (drawingRadiusDegrees+5));
//			// �벨�ƽ�����ʱ��
//			long time = (long) (totalTime - drawedRadius*totalTime / rawRadius);
			delayedRunnable.event = ev;
			return true;
		}
		return super.dispatchTouchEvent(ev);
	}

	class postUpEventDelayed implements Runnable{
		private MotionEvent event;
		@Override
		public void run() {
			if(mTargetTouchView!=null && mTargetTouchView.isClickable()
					&& event!=null){
				mTargetTouchView.dispatchTouchEvent(event);
			}
		}
	}
	
	@Override
	protected void dispatchDraw(Canvas canvas) {
		super.dispatchDraw(canvas);
		/**
		 * ��������Ԫ�غ�ʼ���Ʋ���
		 */
		if (mTargetTouchView != null) {
			RectF clipRectF = clipRectF(mTargetTouchView);
			canvas.save();
			// Ϊ�˲��û��Ƶ�Բ��������Ҫ���Ƶķ�Χ
			canvas.clipRect(clipRectF);
			if(drawedRadius < rawRadius){
				drawedRadius += rawRadius / drawingRadiusDegrees;
				canvas.drawCircle(mDownPositon[0], mDownPositon[1], drawedRadius, mHalfTransPaint);
				postInvalidateDelayed(INVALID_DURATION);
			}else{
				canvas.drawCircle(mDownPositon[0], mDownPositon[1], rawRadius, mTransPaint);
				post(delayedRunnable);
			}
			canvas.restore();
		}
	}
	
	/**
	 * ��ȡԲ������������
	 */
	public float[] getCircleCenterPostion(float x,float y){
		int[] location = new int[2];
		float[] mDownPositon = new float[2];
		getLocationOnScreen(location );
		mDownPositon[0] = x;
		mDownPositon[1] = y -location[1];
		return mDownPositon;
	}
 
	/**
	 * ��ȡҪ���е�����
	 * @param mTargetTouchView
	 * @return
	 */
	public RectF clipRectF(View mTargetTouchView){
		RectF clipRectF = getViewRectF(mTargetTouchView);
		int[] location = new int[2];
		getLocationOnScreen(location);
		clipRectF.top -= location[1];
		clipRectF.bottom -=  location[1];
		return clipRectF;
	}
	
	/**
	 * Ѱ��Ŀ��view
	 * 
	 * @param x
	 * @param y
	 * @param anchorView
	 *            ���ĸ�view��ʼ����Ѱ��
	 * @return
	 */
	public View findTargetView(float x, float y, View anchorView) {
		ArrayList<View> touchablesView = anchorView.getTouchables();
		View targetView = null;
		for (View child : touchablesView) {
			RectF rectF = getViewRectF(child);
			if (rectF.contains(x, y) && child.isClickable()) {
				// ��˵���������view�ҵ���
				targetView = child;
				break;
			}
		}
		return targetView;
	}

	public RectF getViewRectF(View view) {
		int[] location = new int[2];
		view.getLocationOnScreen(location);
		int childLeft = location[0];
		int childTop = location[1];
		int childRight = childLeft + view.getMeasuredWidth();
		int childBottom = childTop + view.getMeasuredHeight();
		return new RectF(childLeft, childTop, childRight, childBottom);
	}

	public WaveView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public WaveView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public WaveView(Context context) {
		this(context, null, 0);
	}

}
