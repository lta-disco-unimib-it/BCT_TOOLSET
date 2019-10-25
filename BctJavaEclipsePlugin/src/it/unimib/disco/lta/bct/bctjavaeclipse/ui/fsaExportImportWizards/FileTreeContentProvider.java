package it.unimib.disco.lta.bct.bctjavaeclipse.ui.fsaExportImportWizards;

import java.io.File;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * this class is the content provider of TreeView
 * 
 *@author Terragni Valerio
 */


public class FileTreeContentProvider implements ITreeContentProvider {

	public Object[] getChildren(Object arg0) {   
		return ((File) arg0).listFiles(); // children is the list of files
	}

	public Object getParent(Object arg0) {
		return ((File) arg0).getParentFile();
	}

	public boolean hasChildren(Object arg0) {
		Object[] obj = getChildren(arg0);
		return obj == null ? false : obj.length > 0;
	}

	public Object[] getElements(Object arg0) { 

		// elements of treeview is the list file of the workspace path
		return ((File) arg0).listFiles();



	}

	public void dispose() {
	}

	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
	}
}