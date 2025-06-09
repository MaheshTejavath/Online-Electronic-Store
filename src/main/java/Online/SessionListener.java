package Online;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener,HttpSessionAttributeListener
{
	@Override
	public void sessionCreated(HttpSessionEvent hse)
	{
		System.out.println("Session Created");
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent hse)
	{
		System.out.println("Session Destroyed");
	}
	@Override
	public void attributeAdded(HttpSessionBindingEvent hae)
	{
		System.out.println("Attribute added to the session");
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent hae)
	{
		System.out.println("attribute removed from session");
	}
}
