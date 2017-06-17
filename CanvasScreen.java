package modelmap.screens;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;

import modelmap.events.CanvasDragDetectListener;
import modelmap.events.CanvasMouseListerner;
import modelmap.events.FileExitItemListener;

public class CanvasScreen {

	private Display display = null;

	public CanvasScreen(Display display) {
		this.display = display;
	}

	public void createCanvasScreen() {
		// display = new Display();
		Shell shell = new Shell(this.display);
		shell.setText("Model Map");
		shell.setMinimumSize(1000, 800);
		shell.setLocation(0, 0);

		Label label = new Label(shell, SWT.CENTER);
		label.setBounds(shell.getClientArea());

		Menu menuBar = new Menu(shell, SWT.BAR);
		MenuItem fileMenuHeader = new MenuItem(menuBar, SWT.CASCADE);
		fileMenuHeader.setText("&File");

		Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
		fileMenuHeader.setMenu(fileMenu);

		// MenuItem fileSaveItem = new MenuItem(fileMenu, SWT.PUSH);
		// fileSaveItem.setText("&Save");

		MenuItem fileExitItem = new MenuItem(fileMenu, SWT.PUSH);
		fileExitItem.setText("E&xit");

		Image image = new Image(display, "C:\\Kinjal\\ModelMap\\images\\modelmapicon.png");

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		shell.setLayout(gridLayout);

		// Image alignment
		Label imageLabel = new Label(shell, SWT.NULL);
		imageLabel.setImage(image);

		GridData imageGridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		imageGridData.horizontalSpan = 2;
		imageLabel.setLayoutData(imageGridData);
		
		ToolBar toolBar = new ToolBar(shell, SWT.FLAT | SWT.WRAP | SWT.RIGHT);
	    
	    ToolItem itemPush = new ToolItem(toolBar, SWT.PUSH);
	    itemPush.setText("And Item");
	    Image image1 = new Image(display, "C:\\Kinjal\\ModelMap\\images\\and.jpg");
	    //Image icon = new Image(shell.getDisplay(), image1);
	    itemPush.setImage(image1);
	    
//	    ToolItem itemSeparator = new ToolItem(toolBar, SWT.SEPARATOR);
//	    Text text = new Text(toolBar, SWT.BORDER | SWT.SINGLE);
//	    text.pack();
//	    itemSeparator.setWidth(text.getBounds().width);
//	    itemSeparator.setControl(text);
	    
//	    final ToolItem itemDropDown = new ToolItem(toolBar, SWT.DROP_DOWN);
//	    itemDropDown.setText("DROP_DOWN item");
//	    itemDropDown.setToolTipText("Click here to see a drop down menu ...");
	    
//		GridData image1GridData = new GridData(GridData.FILL, GridData.CENTER, true, false);
//		image1GridData.horizontalSpan = 1;
//		itemPush.setL
	    
	    // Create a canvas
	    Canvas canvas = new Canvas(shell, SWT.NO_BACKGROUND | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
	    
	    //Scroll bars
//	    final ScrollBar hBar = canvas.getHorizontalBar();
//        Rectangle size = canvas.getBounds();
//        hBar.setMaximum(size.width);
//        hBar.setMinimum(0);
//
//        final ScrollBar vBar = canvas.getVerticalBar();
//        vBar.setMaximum(size.height);
//        vBar.setMinimum(0);
	    
	    GridData canvasGridData = new GridData(GridData.FILL, GridData.FILL, true, true);
	    canvasGridData.horizontalSpan = 4;
	    //canvasGridData.verticalSpan = 160;
	    canvas.setLayoutData(canvasGridData);
	    
	    CanvasDragDetectListener canvasDragEventList = new CanvasDragDetectListener();
	    canvas.addDragDetectListener(canvasDragEventList);
	    
	    CanvasMouseListerner canvasMouseListerner = new CanvasMouseListerner(); 
	    canvas.addMouseListener(canvasMouseListerner);
	    canvas.addPaintListener(canvasMouseListerner);
	   
		fileExitItem.addSelectionListener(new FileExitItemListener(shell));
		// fileSaveItem.addSelectionListener(new FileSaveItemListener(shell));

		shell.setMenuBar(menuBar);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
