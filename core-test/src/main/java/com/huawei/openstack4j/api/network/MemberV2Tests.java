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
package com.huawei.openstack4j.api.network;
import org.testng.annotations.Test;

import com.huawei.openstack4j.api.AbstractTest;
import com.huawei.openstack4j.api.Builders;
import com.huawei.openstack4j.model.common.ActionResponse;
import com.huawei.openstack4j.model.network.ext.MemberV2;
import com.huawei.openstack4j.model.network.ext.MemberV2Update;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

/**
 *
 * @author ashleykasim
 *
 */
@Test(suiteName="Network/memberV2", enabled = true)
public class MemberV2Tests extends AbstractTest {
    private static final String MEMBERSV2_JSON = "/network/membersv2.json";
    private static final String MEMBERV2_JSON = "/network/memberv2.json";
    private static final String MEMBERV2_UPDATE_JSON = "/network/memberv2_update.json";

    public void testListMembersV2() throws IOException {
        respondWith(MEMBERSV2_JSON);
        List<? extends MemberV2> list = osv3().networking().lbaasV2().lbPool().listMembers("4c0a0a5f-cf8f-44b7-b912-957daa8ce5e5");
        assertEquals(list.size(), 2);
        assertEquals("9a7aff27-fd41-4ec1-ba4c-3eb92c629313", list.get(0).getId());
    }

    public void testListMembersV2Filter() throws IOException {
        respondWith(MEMBERSV2_JSON);
        Map<String, String> map = new HashMap<>();
        map.put("weight", "1");
        List<? extends MemberV2> list = osv3().networking().lbaasV2().lbPool().listMembers("4c0a0a5f-cf8f-44b7-b912-957daa8ce5e5", map);
        assertEquals(list.size(), 2);
    }

    public void testGetMemberV2() throws IOException {
        respondWith(MEMBERV2_JSON);
        String id = "9a7aff27-fd41-4ec1-ba4c-3eb92c629313";
        MemberV2 hm = osv3().networking().lbaasV2().lbPool().getMember("4c0a0a5f-cf8f-44b7-b912-957daa8ce5e5", id);
        assertNotNull(hm);
        assertEquals(hm.getId(), id);
    }

    public void testCreateMemberV2() throws IOException {
        respondWith(MEMBERV2_JSON);
        String address = "******";
        Integer port = 80;
        Integer weight = 1;
        MemberV2 create = Builders.memberV2()
                .adminStateUp(true)
                .address(address)
                .protocolPort(port)
                .weight(weight)
                .build();
        MemberV2 result = osv3().networking().lbaasV2().lbPool().createMember("4c0a0a5f-cf8f-44b7-b912-957daa8ce5e5", create);
        assertEquals(result.getProtocolPort(), port);
        assertEquals(result.getWeight(), weight);
        assertTrue(result.isAdminStateUp());
    }

    public void testUpdateMemberV2() throws IOException {
        respondWith(MEMBERV2_UPDATE_JSON);
        Integer weight = 2;
        String id = "9a7aff27-fd41-4ec1-ba4c-3eb92c629313";
        MemberV2Update update = Builders.memberV2Update()
                .weight(weight)
                .adminStateUp(false)
                .build();
        MemberV2 result = osv3().networking().lbaasV2().lbPool().updateMember("4c0a0a5f-cf8f-44b7-b912-957daa8ce5e5", id, update);
        assertEquals(result.getWeight(), weight);
        assertFalse(result.isAdminStateUp());
    }

    public void testDeleteMemberV2() {
        respondWith(204);
        ActionResponse result = osv3().networking().lbaasV2().lbPool().deleteMember("4c0a0a5f-cf8f-44b7-b912-957daa8ce5e5", "9a7aff27-fd41-4ec1-ba4c-3eb92c629313");
        assertTrue(result.isSuccess());
    }

    @Override
    protected Service service() {
        return Service.NETWORK;
    }
}