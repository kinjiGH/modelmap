package modelmap.events;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Shell;

public class FileExitItemListener implements SelectionListener{

	private Shell shell = null;
	
	public FileExitItemListener(Shell shell)
	{
		this.shell = shell;
	}
	
	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		shell.setVisible(false);
	}

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		shell.setVisible(false);
		
	}

}
