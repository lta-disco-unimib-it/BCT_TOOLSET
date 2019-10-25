package org.eclipse.core.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import javax.management.RuntimeErrorException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import console.WorkspaceUtil;

public class Workspace implements IWorkspace {

	private WorkspaceRoot root;

	public Workspace(File workspace) {
		this.root = new WorkspaceRoot( workspace );
	}

	@Override
	public IWorkspaceRoot getRoot() {
		return root;
	}
	
	@Override
	public IProjectDescription newProjectDescription(String project) {
		return new ProjectDescription( project, this );
	}
	
	public String toString(){
		return root.getFile().getAbsolutePath();
	}

	@Override
	public IStatus copy(IResource src[], IPath dest, boolean force, IProgressMonitor monitor) {
		
		if ( src.length == 0 ){
			return new Status(0, "", "");
		}
		
		String destFullPath = createFullPath(dest);
		
		
		File destFile = new File ( destFullPath );
		
		if ( src.length == 1 ){
			File sourceFile = src[0].getRawLocation().toFile();
			try {
				copyFile( sourceFile, destFile);
				return new Status(0, "", "");
			} catch (IOException e) {
				throw new RuntimeException("Copy does not work.",e);
			}
		}
		
		String resourcesTxt = "";
		for ( IResource resource : src ){
			resourcesTxt += resource.getRawLocation().toString()+" ";
		}
		throw new RuntimeException("Copy of multiple files not implemented: "+resourcesTxt);
	}

	public String createFullPath(IPath dest) {
		return root.getFile().getAbsolutePath()+dest;
	}
	
	public static void copyFile(File sourceFile, File destFile) throws IOException {
		if( destFile.exists() && destFile.isDirectory() ) {
			destFile = new File( destFile, sourceFile.getName() );
		}
		
		if(!destFile.exists()) {
	        destFile.createNewFile();
	    }

	    FileChannel source = null;
	    FileChannel destination = null;

	    try {
	        source = new FileInputStream(sourceFile).getChannel();
	        destination = new FileOutputStream(destFile).getChannel();
	        destination.transferFrom(source, 0, source.size());
	    }
	    finally {
	        if(source != null) {
	            source.close();
	        }
	        if(destination != null) {
	            destination.close();
	        }
	    }
	}

}
