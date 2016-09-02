/*
 * Copyright 2016 QAware GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.qaware.cloud.deployer.kubernetes.update;

import de.qaware.cloud.deployer.commons.error.ResourceException;
import de.qaware.cloud.deployer.commons.resource.Resource;
import de.qaware.cloud.deployer.kubernetes.resource.base.KubernetesResource;
import de.qaware.cloud.deployer.kubernetes.resource.namespace.NamespaceResource;
import de.qaware.cloud.deployer.kubernetes.resource.namespace.NamespaceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SoftUpdateStrategy implements UpdateStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(SoftUpdateStrategy.class);

    private static void deployResources(List<KubernetesResource> resources) throws ResourceException {
        LOGGER.info("Deploying resources...");

        for (Resource resource : resources) {
            if (resource.exists()) {
                resource.delete();
                resource.create();
                LOGGER.info("- " + resource + " (updated)");
            } else {
                resource.create();
                LOGGER.info("- " + resource + " (created)");
            }
        }

        LOGGER.info("Finished deploying resources...");
    }

    @Override
    public void deploy(NamespaceResource namespaceResource, List<KubernetesResource> resources) throws ResourceException {

        // 1. Create the namespace if it doesn't exist
        NamespaceUtil.safeCreateNamespace(namespaceResource);

        // 2. Update existing resources (delete and create again) and create new ones
        deployResources(resources);
    }
}
