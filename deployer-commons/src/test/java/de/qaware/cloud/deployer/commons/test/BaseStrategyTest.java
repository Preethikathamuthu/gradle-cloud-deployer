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
package de.qaware.cloud.deployer.commons.test;

import de.qaware.cloud.deployer.commons.resource.Resource;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

/**
 * @author sjahreis
 */
public abstract class BaseStrategyTest {

    protected List<Resource> resources;
    protected Resource resource1;
    protected Resource resource2;

    @Before
    public void setup() {
        resource1 = mock(Resource.class);
        resource2 = mock(Resource.class);

        resources = new ArrayList<>();
        resources.add(resource1);
        resources.add(resource2);
    }
}
