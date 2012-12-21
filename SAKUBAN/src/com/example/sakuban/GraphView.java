package com.example.sakuban;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class GraphView extends View{

	private int width=320;
	private static int height=480;
	private int topMargin = 10;
	private int lineHeight = 10;
	private int days = 30;
	private int sp = 2;
	private int ep = 98;
	private int mm = 2;
	private int sm = 1;

	Paint p = new Paint();

	public GraphView(Context context) {
		super(context);
		p.setColor(Color.rgb(255, 255, 255));
		setCanvasSize(context);
	}

	public GraphView(Context context, AttributeSet attrs ) {
		super(context,attrs);
		p.setColor(Color.rgb(255, 255, 255));
		setCanvasSize(context);
	}


	public void onDraw(Canvas c){
		super.onDraw(c);
		setCanvasSize(this.getContext());
		height = days*lineHeight + topMargin;
		c.drawColor(Color.BLACK);

		for(int day=0; day<days; day++){
			baseOfday(c,day*lineHeight + topMargin,day+1);
			Log.d("GraphView", ""+day+" days");
		}
	}

	private void setCanvasSize(Context context){
		WindowManager wm = (WindowManager)context.getSystemService(context.WINDOW_SERVICE);
		Display disp = wm.getDefaultDisplay();
		width = disp.getWidth();
		height = disp.getHeight();
		Log.d("GraphView",""+width);
		Log.d("GraphView",""+height);
	}

	private void baseOfday(Canvas c,int y, int day){

		c.drawText(day+"��", 0,Y(y-mm),  p);
		c.drawLine(X(sp), Y(y), X(ep), Y(y), p);
		//���C���ڐ���@�U���Ԃ���
		for(int i=0;i<5;i++){
			c.drawLine(timeX(6*i), Y(y-mm), timeX(6*i), Y(y+mm), p);
		}
		//�T�u�ڐ��� �P���Ԃ���
		for(int i=0;i<25;i++){
			c.drawLine(timeX(i), Y(y-sm), timeX(i), Y(y+sm), p);
		}


	}

	private void jisseki(){

	}
	private int timeX(float t){
		return (int)(X(sp) + (X(ep)-X(sp))*(t/24));
	}
	private int X(float x){
		return (int)Math.round((width*x)/100);
	}

	private int Y(float y){
		return (int)Math.round((height*y)/100);
	}

	public static int getGraphHeight(){
		return height;
	}
}