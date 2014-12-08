package kr.or.jaspersoft.android.talkplaza.common.widget;

import kr.or.jaspersoft.android.talkplaza.common.util.LogUtil;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class NodeTreeView extends SurfaceView implements Callback {
	
	Context mContext;
	SurfaceHolder mHolder;
	Process mProcess;
	boolean mForcedStop = false;

	/**
	 * <pre>
	 * =================================================================
	 * 생성자
	 * =================================================================
	 * </pre>
	 */
	public NodeTreeView(Context context, AttributeSet attrs) {
		super(context, attrs);
		SurfaceHolder holder = getHolder();
		holder.addCallback(this);
		
		mHolder = holder;
		mContext = context;
		mProcess = new Process();
	}

	/**
	 * <pre>
	 * =================================================================
	 * SurfaceView 생성 시점에서 호출
	 * =================================================================
	 * </pre>
	 */
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		mProcess.start();
	}

	/**
	 * <pre>
	 * =================================================================
	 * SurfaceView 크기 변화 시점에서 호출
	 * =================================================================
	 * </pre>
	 */
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		
	}

	/**
	 * <pre>
	 * =================================================================
	 * SurfaceView 종료 시점에서 호출
	 * =================================================================
	 * </pre>
	 */
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean done = true;
		try {
			while (done) {
				mForcedStop = true;
				done = false;
				mProcess.join();
			}
		} catch (Exception e) {
			// 오류 무시
		}
	}
	
	public void setRenderStop(boolean stop) {
		mForcedStop = stop;
	}
	
	/**
	 * <pre>
	 * =================================================================
	 * 처리 로직
	 * =================================================================
	 * </pre>
	 */
	class Process extends Thread {
		
		Paint circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		
		public Process() {
			circlePaint.setColor(Color.YELLOW);
		}
		
		@Override
		public void run() {
			Canvas canvas = null;
			while (!mForcedStop) {
				canvas = mHolder.lockCanvas();// canvas 잠그고 버퍼 할당
				try {
					synchronized (mHolder) {// 동기화 유지하고 하위로 그리는 작업 수행
						canvas.drawCircle(100f, 200f, 45f, circlePaint);
						LogUtil.log("render");
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					mHolder.unlockCanvasAndPost(canvas);// canvas 내용을 view에 전송
				}
			}
		}
	}
}
