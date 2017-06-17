package modelmap.events;

import org.eclipse.swt.events.DragDetectEvent;
import org.eclipse.swt.events.DragDetectListener;

public class CanvasDragDetectListener implements DragDetectListener{

	@Override
	public void dragDetected(DragDetectEvent dragEvObject) {
		
		System.out.println("X="+dragEvObject.x+" and Y="+dragEvObject.y);
	}

}

