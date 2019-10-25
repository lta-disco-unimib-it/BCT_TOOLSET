package it.unimib.disco.lta.bct.bctjavaeclipse.ui.fsaExportImportWizards;


import java.io.File;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
/**
 * this class is the content provider of import checkboxTreeView
 * 
 *@author Terragni Valerio
 */


public class FileTreeSystemContentProvider implements ITreeContentProvider {
	public Object[] getChildren(Object arg0) {
		return ((File) arg0).listFiles();
	}

	public Object getParent(Object arg0) {
		return ((File) arg0).getParentFile();
	}

	public boolean hasChildren(Object arg0) {
		Object[] obj = getChildren(arg0);
		return obj == null ? false : obj.length > 0;
	}

	public Object[] getElements(Object arg0) {
		return File.listRoots(); // the root is the system drive



	}

	public void dispose() {
	}

	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
	}
}
