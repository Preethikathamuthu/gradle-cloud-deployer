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
package de.qaware.cloud.deployer.plugin.task;

import de.qaware.cloud.deployer.commons.Deployer;
import de.qaware.cloud.deployer.commons.error.EnvironmentConfigException;
import de.qaware.cloud.deployer.commons.error.ResourceConfigException;
import de.qaware.cloud.deployer.commons.error.ResourceException;
import de.qaware.cloud.deployer.plugin.environment.Environment;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.util.List;

/**
 * Represents a task which deploys one specified environment.
 */
public class DeployTask extends BaseSingleEnvironmentTask {

    /**
     * Creates a new deploy task object.
     *
     * @throws EnvironmentConfigException If an error during config creation occurs.
     */
    public DeployTask() throws EnvironmentConfigException {
        super();
    }

    /**
     * Deploys the environment with the specified id.
     *
     * @throws ResourceException       If a error during resource interaction with the backend occurs.
     * @throws ResourceConfigException If a error during config creation/parsing occurs.
     */
    @TaskAction
    public void deploy() throws ResourceException, ResourceConfigException {

        // Retrieve necessary data
        Environment environment = getEnvironment();
        Deployer deployer = environment.getDeployer();
        List<File> files = environment.getFiles();

        // Deploy resources
        deployer.deploy(files);
    }
}
