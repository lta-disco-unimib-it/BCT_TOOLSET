package it.unimib.disco.lta.bct.bctjavaeclipse.ui.preferences;

import it.unimib.disco.lta.bct.bctjavaeclipse.core.bctIntegrationLayer.BctDefaultOptions;
import it.unimib.disco.lta.bct.bctjavaeclipse.core.bctIntegrationLayer.DefaultOptionsManager;
import it.unimib.disco.lta.bct.bctjavaeclipse.core.bctIntegrationLayer.DefaultOptionsManagerException;
import it.unimib.disco.lta.bct.bctjavaeclipse.core.utils.WorkspaceOptionsManager;
import it.unimib.disco.lta.bct.bctjavaeclipse.ui.BctJavaEclipsePlugin;
import it.unimib.disco.lta.bct.bctjavaeclipse.ui.configuration.inferencesEngines.FsaEngineOptionsComposite;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;


/**
 * This class represents a preference page that
 * is contributed to the Preferences dialog. By 
 * subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows
 * us to create a page that is small and knows how to 
 * save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They
 * are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can
 * be accessed directly via the preference store.
 */

public class ReissPreferencePage
extends PreferencePage
implements IWorkbenchPreferencePage {

	private FsaEngineOptionsComposite ReissComp;
	public ReissPreferencePage() {

		setPreferenceStore(BctJavaEclipsePlugin.getDefault().getPreferenceStore());
		setDescription("Reiss page");
	}



	public void init(IWorkbench workbench) {
	}

	@Override
	protected Control createContents(Composite parent) {
		ReissComp = new FsaEngineOptionsComposite(parent,SWT.None);





		BctDefaultOptions workspaceOptions;



		try {
			workspaceOptions = WorkspaceOptionsManager.getWorkspaceOptions();
			if (workspaceOptions.getReissEnigineOptions().containsValue("")){ //if ReissOptions are empty load default options


				BctDefaultOptions defaultOptions = DefaultOptionsManager.getDefaultOptions();
				ReissComp.load(defaultOptions.getReissEnigineOptions());

			}else{


				ReissComp.load(workspaceOptions.getReissEnigineOptions());



			}


		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DefaultOptionsManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return parent; 

	}
	protected void performDefaults() {  //when restore default button select


		try {
			BctDefaultOptions defaultOptions = DefaultOptionsManager.getDefaultOptions();
			ReissComp.load(defaultOptions.getReissEnigineOptions());

		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DefaultOptionsManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

	public boolean performOk() {

		WorkspaceOptionsManager.setReissInferenceEngineOptions(ReissComp.getUserDefinedOptions());

		return true;

	}

}