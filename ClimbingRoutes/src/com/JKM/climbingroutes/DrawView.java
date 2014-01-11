package com.JKM.climbingroutes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;

public class DrawView extends View{

	public DrawView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	@Override public void onDraw(Canvas canvas){
		super.onDraw(canvas);
		//for test
		Paint paint = new Paint();
		this.setAlpha(150);
		/*
		this.drawCircle(canvas, 200, 100, (float)0.5, paint);
		this.drawTriangle(canvas, 200, 300, (float)0.5, paint);
		this.drawSquare(canvas, 200, 200, (float)0.5, paint);
		*/
		
	}
	
	//draw hand and foot hold of the route
	//x,y are the center of the circle
	
	private int alpha;
	public void setAlpha(int targetAlpha){
		alpha = targetAlpha;
	}
	
	public void drawCircle(Canvas canvas, float x, float y, float scale, Paint paint){
		paint.setColor( Color.BLUE );
		paint.setStyle( Style.FILL );
		paint.setAlpha( alpha );
		canvas.drawCircle(x, y, 100*scale, paint);
	}
		
	//draw start point of the route as triangle
	//x,y are the center of the triangle
	public void drawTriangle(Canvas canvas, float x, float y, float scale, Paint paint){
		paint.setColor( Color.YELLOW );
		paint.setStyle( Style.STROKE );
		paint.setStrokeWidth(30*scale);
		paint.setAlpha( alpha );
		//p1 at top, p2 at left, p3 at right
		//p1.x=x,      p1.y=y-sqrt(3)/3*a
		//p2.x=x-a/2,  p2.y=y+sqrt(3)/6*a    a=100*scale
		//p3.x=x+a/2,  p3.y=y+sqrt(3)/6*a    sqrt(3)=1.732
		
		// y increa down
		// x increa right
	
		//p1-p2
		canvas.drawLine(x, (float)(y-1.732/3*(100*scale)), x-(100*scale)/2, (float)(y+1.732/6*(100*scale)), paint);
		//p1-p3
		canvas.drawLine(x, (float)(y-1.732/3*(100*scale)), x+(100*scale)/2, (float)(y+1.732/6*(100*scale)), paint);
		//p2-p3
		canvas.drawLine(x-(100*scale)/2, (float)(y+1.732/6*(100*scale)), x+(100*scale)/2, (float)(y+1.732/6*(100*scale)), paint);
	}
	
	
	//draw end point of the route as square
	//x,y are the center of the square
	public void drawSquare(Canvas canvas, float x, float y, float scale, Paint paint){
		paint.setColor( Color.RED );
		paint.setStyle( Style.FILL );
		paint.setAlpha( alpha );
		//p1 p2 are two point of box
		//p1 = top left, p2 = bot right		
		canvas.drawRect(x-(100*scale)/2, y+(100*scale)/2, x+(100*scale)/2, y-(100*scale)/2, paint );	
	}
}

