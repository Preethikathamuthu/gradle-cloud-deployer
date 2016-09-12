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
import junit.framework.TestCase;

import static de.qaware.cloud.deployer.kubernetes.logging.KubernetesMessageBundle.KUBERNETES_MESSAGE_BUNDLE;

public class KubernetesUpdateStrategyFactoryTest extends TestCase {

    public void testCreateWithHardUpdateStrategy() throws ResourceException {
        KubernetesUpdateStrategy hard = KubernetesUpdateStrategyFactory.create("HARD");
        assertTrue(hard instanceof KubernetesHardUpdateStrategy);
    }

    public void testCreateWithSoftUpdateStrategy() throws ResourceException {
        KubernetesUpdateStrategy soft = KubernetesUpdateStrategyFactory.create("SOFT");
        assertTrue(soft instanceof KubernetesSoftUpdateStrategy);
    }

    public void testCreateWithUnknownStrategy() {
        boolean exceptionThrown = false;
        try {
            KubernetesUpdateStrategyFactory.create("BLA");
        } catch (ResourceException e) {
            exceptionThrown = true;
            assertEquals(KUBERNETES_MESSAGE_BUNDLE.getMessage("DEPLOYER_KUBERNETES_ERROR_UNKNOWN_UPDATE_STRATEGY", "BLA"), e.getMessage());
        }
        assertTrue(exceptionThrown);
    }
}