package org.juliansimpson;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.Task;

public class HostName extends Task {
	String hostName;

	String property = "hostname";

	public void execute() {
				
		hostName=getHostName();		
		Project project = getProject();
		if (project == null) {throw new BuildException("project is null"); }
		project.setProperty(property, hostName);
				
			
		}
	public String getProperty() {
		return property;
	}
	
	public void setProperty(String property) {
		this.property = property;
	}
	public String getHostName()  {
		
	      InetAddress addr = null;
		try {
			addr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			throw new BuildException("can't resolve the hostname");
			
		}
		return addr.getHostName();
	}
}
