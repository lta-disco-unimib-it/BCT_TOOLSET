package it.unimib.disco.lta.eclipse.anomalyGraph.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class AnomalyGraphElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private AnomalyGraphElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Graph_79 = getElementType("it.unimib.disco.lta.eclipse.anomalyGraph.diagram.Graph_79"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType BctIOModelViolation_1001 = getElementType("it.unimib.disco.lta.eclipse.anomalyGraph.diagram.BctIOModelViolation_1001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType BctFSAModelViolation_1002 = getElementType("it.unimib.disco.lta.eclipse.anomalyGraph.diagram.BctFSAModelViolation_1002"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType Relationship_3001 = getElementType("it.unimib.disco.lta.eclipse.anomalyGraph.diagram.Relationship_3001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return it.unimib.disco.lta.eclipse.anomalyGraph.diagram.part.AnomalyGraphDiagramEditorPlugin
						.getInstance().getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap();

			elements
					.put(
							Graph_79,
							it.unimib.disco.lta.eclipse.anomalyGraph.AnomalyGraphPackage.eINSTANCE
									.getGraph());

			elements
					.put(
							BctIOModelViolation_1001,
							it.unimib.disco.lta.eclipse.anomalyGraph.AnomalyGraphPackage.eINSTANCE
									.getBctIOModelViolation());

			elements
					.put(
							BctFSAModelViolation_1002,
							it.unimib.disco.lta.eclipse.anomalyGraph.AnomalyGraphPackage.eINSTANCE
									.getBctFSAModelViolation());

			elements
					.put(
							Relationship_3001,
							it.unimib.disco.lta.eclipse.anomalyGraph.AnomalyGraphPackage.eINSTANCE
									.getRelationship());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(Graph_79);
			KNOWN_ELEMENT_TYPES.add(BctIOModelViolation_1001);
			KNOWN_ELEMENT_TYPES.add(BctFSAModelViolation_1002);
			KNOWN_ELEMENT_TYPES.add(Relationship_3001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

}
