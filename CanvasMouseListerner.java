package modelmap.events;


import java.util.HashMap;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Canvas;

import modelmap.utilities.RectangleObject;

public class CanvasMouseListerner implements MouseListener, PaintListener {

	private int x = 0;
	private int y = 0;
	private boolean isMousePressed = false;
	HashMap<Integer, RectangleObject> hashmapY = null;
	

	@Override
	public void mouseDoubleClick(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDown(MouseEvent mE) {
		System.out.println("in Mouse Down Event X=" + mE.x + " and Y=" + mE.y);

		this.x = mE.x;
		this.y = mE.y;

		Canvas canvas = (Canvas) mE.getSource();
		canvas.redraw();

		isMousePressed = true;

	}

	@Override
	public void mouseUp(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void paintControl(PaintEvent pE) {

		System.out.println("In Paint Control");
		
		GC gc = pE.gc;
		gc.setBackground(pE.display.getSystemColor(SWT.COLOR_RED));

		int keyToBeRemoved = 0;
		HashMap<Integer, RectangleObject> itemsToBeAdded = new HashMap<Integer, RectangleObject>();
		
		
		if (isMousePressed && hashmapY == null) {
			
			hashmapY = new HashMap<Integer, RectangleObject> ();
			
			
			gc.fillRectangle(x - 20, y - 20, 200, 60);
							
			gc.fillRectangle(x + 220, y + 60, 200, 60);
			RectangleObject rootRect = new RectangleObject("2",x + 220, y + 60);
			itemsToBeAdded.put(y + 60, rootRect);
						
			gc.fillRectangle(x + 220, y - 100, 200, 60);
			rootRect = new RectangleObject("3",x + 220, y - 100);
			itemsToBeAdded.put(y - 100, rootRect);

			gc.drawLine(x + 220 + 100, y + 60, x - 20 + 200, y - 20 + 30);
			gc.drawLine(x + 220 + 100, y - 100 + 60, x - 20 + 200, y - 20 + 30);

			isMousePressed = false;
		}else if (isMousePressed)
		{
			Set<Integer> keySet = hashmapY.keySet();
			
			for(Integer key : keySet)
			{
				System.out.println("Y Range from="+key+" to "+key+60);
				System.out.println("Y Range from="+((RectangleObject)(hashmapY.get(key))).x+" to "+(((RectangleObject)(hashmapY.get(key))).x + 200));
				
				
				if(this.y > key && this.y < key+60 
						&& this.x > ((RectangleObject)(hashmapY.get(key))).x 
						&& this.x < (((RectangleObject)(hashmapY.get(key))).x + 200) ){
					System.out.println("Clicked inside");
					
					int rootX = ((RectangleObject)(hashmapY.get(key))).x;
					int rootY = key;
					
					//Mark the root to be removed
					keyToBeRemoved = key;
					
					//Build the roots
					gc.fillRectangle(rootX + 220, rootY + 60, 200, 60);
					RectangleObject rootRect = new RectangleObject("2",rootX + 220, rootY + 60);
					itemsToBeAdded.put(rootY + 60, rootRect);
								
					gc.fillRectangle(rootX + 220, rootY - 100, 200, 60);
					rootRect = new RectangleObject("3",rootX + 220, rootY - 100);
					itemsToBeAdded.put(rootY - 100, rootRect);

					gc.drawLine(rootX + 220 + 100, rootY + 60, rootX + 200, rootY + 30);
					gc.drawLine(rootX + 220 + 100, rootY - 100 + 60, rootX + 200, rootY + 30);
					
				}else{
					System.out.println("Clicked Outside do nothing");
				}
			}
			isMousePressed = false;
		}
		//Add and remove to hashMap
		if(hashmapY != null){
			hashmapY.remove(keyToBeRemoved);
			hashmapY.putAll(itemsToBeAdded);
			itemsToBeAdded.clear();
		}
		
		
	}

}
