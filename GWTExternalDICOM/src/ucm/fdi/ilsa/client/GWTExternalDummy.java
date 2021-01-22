package ucm.fdi.ilsa.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTExternalDummy implements EntryPoint {
	
	private static CompositeDocumentEditionDummy Actual;


	static {
        export();
    }
	
	public GWTExternalDummy() {
		
	}
	
	
	/**
     * Makes our setData method accessible from plain JS
     */
    private static native void export() /*-{
    	
    	$wnd.DICOMSetContext = @ucm.fdi.ilsa.client.GWTExternalDummy::setContext(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZ)
    	$wnd.DICOMGetIcon = @ucm.fdi.ilsa.client.GWTExternalDummy::getIcon()
    	$wnd.DICOMPersist = @ucm.fdi.ilsa.client.GWTExternalDummy::getPersist()
    	$wnd.DICOMisWaitingUpdate = @ucm.fdi.ilsa.client.GWTExternalDummy::isWaitingUpdate()
    	$wnd.DICOMupdateContext = @ucm.fdi.ilsa.client.GWTExternalDummy::updateContext()
    	$wnd.DICOMsetWaitingUpdate =  @ucm.fdi.ilsa.client.GWTExternalDummy::setWaitingUpdate(Z)
    	
    }-*/;

    public static void setContext(String IdVentana,String contextId,String Height,boolean isgrammar,boolean edit,boolean views,boolean CompleteView) {
//		try {
			Long contLong=Long.parseLong(contextId);
			Integer heiInteger=Integer.parseInt(Height);
			if (edit)
				Actual=new CompositeDocumentEditionDummy(IdVentana, contLong, heiInteger, isgrammar);
			else
				Actual=new CompositeDocumentDescriptionDummy(IdVentana, contLong, heiInteger, CompleteView, isgrammar, views);
//		} catch (Exception e) {
//			Window.alert(e.getMessage());
//			Window.
//			e.printStackTrace();
//		}
		
		
	}
    
    public static String getIcon() {
    	return CompositeDocumentDescriptionDummy.getIcon();
		
		
	}
    
    public static void getPersist() {
    	if (Actual!=null)
    		Actual.persistJS();
		
		
	}
    
    public static boolean isWaitingUpdate() {
    	return false;
		
		
	}
    
    public static boolean updateContext() {
    	return true;
		
		
	}
    
    public static void setWaitingUpdate(boolean update) {
    	//NOTHIG TO DO
    }


	@Override
	public void onModuleLoad() {
		GWT.log("Dummy Load");
		
	}
}
