/*******************************************************************************
 * 	Copyright 2016 ContainX and OpenStack4j                                          
 * 	                                                                                 
 * 	Licensed under the Apache License, Version 2.0 (the "License"); you may not      
 * 	use this file except in compliance with the License. You may obtain a copy of    
 * 	the License at                                                                   
 * 	                                                                                 
 * 	    http://www.apache.org/licenses/LICENSE-2.0                                   
 * 	                                                                                 
 * 	Unless required by applicable law or agreed to in writing, software              
 * 	distributed under the License is distributed on an "AS IS" BASIS, WITHOUT        
 * 	WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the         
 * 	License for the specific language governing permissions and limitations under    
 * 	the License.                                                                     
 *******************************************************************************/
package com.huawei.openstack4j.openstack.compute.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huawei.openstack4j.model.ModelEntity;

/**
 * A wrapper model class to return the console output from a server
 * 
 * @author Jeremy Unruh
 *
 */
public class ConsoleOutput implements ModelEntity {

	private static final long serialVersionUID = 1L;

	@JsonProperty
	private String output;
	
	/**
	 * @return the console output from a VM/Server or null
	 */
	public String getOutput() {
		return output;
	}
	
}
