/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.housekeeper.data;

import lombok.Data;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;

import java.io.Serializable;

/*
 * on start, read the retry queue and put the messages back to main queue (save offset)
 * */
@Data
public class HousekeeperTask implements Serializable {

    private final TenantId tenantId;
    private final EntityId entityId;
    private final HousekeeperTaskType taskType;

    // maybe we should not delete relations asynchronously
//    public static HousekeeperTask deleteRelations(TenantId tenantId, EntityId entityId) {
//        return new HousekeeperTask(tenantId, entityId, HousekeeperTaskType.DELETE_RELATIONS);
//    }

    public static HousekeeperTask deleteAttributes(TenantId tenantId, EntityId entityId) {
        return new HousekeeperTask(tenantId, entityId, HousekeeperTaskType.DELETE_ATTRIBUTES);
    }

    public static HousekeeperTask deleteTelemetry(TenantId tenantId, EntityId entityId) {
        return new HousekeeperTask(tenantId, entityId, HousekeeperTaskType.DELETE_TELEMETRY);
    }

    public static HousekeeperTask deleteEvents(TenantId tenantId, EntityId entityId) {
        return new HousekeeperTask(tenantId, entityId, HousekeeperTaskType.DELETE_EVENTS);
    }

    public static HousekeeperTask unassignAlarms(TenantId tenantId, UserId userId) {
        return new HousekeeperTask(tenantId, userId, HousekeeperTaskType.UNASSIGN_ALARMS);
    }

    public static HousekeeperTask deleteEntityAlarms(TenantId tenantId, EntityId entityId) {
        return new HousekeeperTask(tenantId, entityId, HousekeeperTaskType.DELETE_ENTITY_ALARMS);
    }

}
