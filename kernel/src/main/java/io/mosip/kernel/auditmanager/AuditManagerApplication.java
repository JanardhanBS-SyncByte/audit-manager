package io.mosip.kernel.auditmanager;

import io.mosip.kernel.auditmanager.impl.AuditHandlerImpl;

public class AuditManagerApplication {	
	public static void main(String[] args) {
		AuditHandlerImpl obj = new AuditHandlerImpl();
        obj.hashCode();
        System.out.println("AuditManagerApplication Test completed.");
    }
}