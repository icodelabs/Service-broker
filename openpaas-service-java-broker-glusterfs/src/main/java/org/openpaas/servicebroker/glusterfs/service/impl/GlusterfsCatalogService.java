package org.openpaas.servicebroker.glusterfs.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.openpaas.servicebroker.model.Catalog;
import org.openpaas.servicebroker.model.ServiceDefinition;
import org.openpaas.servicebroker.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * An implementation of the CatalogService that gets the catalog injected (ie configure 
 * in spring config)
 * 
 * @author sgreenberg@gopivotal.com
 *
 */
@Service
public class GlusterfsCatalogService implements CatalogService {

	private Catalog catalog;
	private Map<String,ServiceDefinition> serviceDefs = new HashMap<String,ServiceDefinition>();
	
	@Autowired
	public GlusterfsCatalogService(Catalog catalog) {
		this.catalog = catalog;
		initializeMap();
	}
	
	private void initializeMap() {
		for (ServiceDefinition def: catalog.getServiceDefinitions()) {
			serviceDefs.put(def.getId(), def);
		}
	}
	
	@Override
	public Catalog getCatalog() {
		return catalog;
	}

	@Override
	public ServiceDefinition getServiceDefinition(String serviceId) {
		System.out.println("getServiceDefinition serviceId = " + serviceId);
		return serviceDefs.get(serviceId);
	}

}
