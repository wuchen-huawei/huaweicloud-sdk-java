 /*******************************************************************************
 * 	Copyright 2018 Huawei Technologies Co.,Ltd.                                         
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
package com.huawei.openstack4j.openstack.map.reduce.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huawei.openstack4j.model.ModelEntity;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MapReduceClusterCreateResult implements ModelEntity {

	private static final long serialVersionUID = -4868885128978653274L;

	@JsonProperty("cluster_id")
	String clusterId;

	@JsonProperty("msg")
	String msg;

	@JsonProperty("result")
	Boolean result;

}
