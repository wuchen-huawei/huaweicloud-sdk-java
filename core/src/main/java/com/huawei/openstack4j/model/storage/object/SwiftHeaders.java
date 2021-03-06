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
package com.huawei.openstack4j.model.storage.object;

/**
 * Common Object Storage (Swift) headers
 * 
 * @author Jeremy Unruh
 */
public final class SwiftHeaders {

    // Account Headers
    public static final String ACCOUNT_METADATA_PREFIX = "X-Account-Meta-";
    public static final String ACCOUNT_REMOVE_METADATA_PREFIX = "X-Remove-Account-Meta-";
    public static final String ACCOUNT_TEMPORARY_URL_KEY = ACCOUNT_METADATA_PREFIX + "Temp-Url-Key";
    public static final String ACCOUNT_BYTES_USED = "X-Account-Bytes-Used";
    public static final String ACCOUNT_CONTAINER_COUNT = "X-Account-Container-Count";
    public static final String ACCOUNT_OBJECT_COUNT = "X-Account-Object-Count";

    // Container Headers
    public static final String CONTAINER_METADATA_PREFIX = "X-Container-Meta-";
    public static final String CONTAINER_REMOVE_METADATA_PREFIX = "X-Remove-Container-Meta-";
    
    // Object Headers
    public static final String OBJECT_METADATA_PREFIX = "X-Object-Meta-";

    // Versioning
    public static final String VERSIONS_LOCATION = "X-Versions-Location";
    
    // ACL's (not all implementations support this)
    public static final String CONTAINER_READ = "X-Container-Read";
    public static final String CONTAINER_WRITE = "X-Container-Write";
    public static final String CONTAINER_ACL_ANYBODY_READ = ".r:*,.rlistings";
    
    
    // Generic
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String ETAG = "ETag";
    public static final String X_COPY_FROM = "X-Copy-From";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String LAST_MODIFIED = "Last-Modified";

    private SwiftHeaders() {
    }
}
