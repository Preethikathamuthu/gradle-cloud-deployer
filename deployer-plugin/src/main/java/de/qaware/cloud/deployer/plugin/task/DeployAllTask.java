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

import de.qaware.cloud.deployer.commons.error.EnvironmentConfigException;
import de.qaware.cloud.deployer.commons.error.ResourceConfigException;
import de.qaware.cloud.deployer.commons.error.ResourceException;
import de.qaware.cloud.deployer.plugin.environment.Environment;
import org.gradle.api.tasks.TaskAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static de.qaware.cloud.deployer.plugin.logging.PluginMessageBundle.PLUGIN_MESSAGE_BUNDLE;

/**
 * Represents a task which deploys all environments.
 */
public class DeployAllTask extends BaseAllEnvironmentsTask {

    /**
     * The logger of this class.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DeployAllTask.class);

    /**
     * Deploys all environments in the configuration.
     *
     * @throws ResourceException          If an error during resource interaction with the backend occurs.
     * @throws ResourceConfigException    If an error during config creation/parsing occurs.
     * @throws EnvironmentConfigException If an error during environment parsing/creation occurs.
     */
    @TaskAction
    public void deployAll() throws ResourceException, ResourceConfigException, EnvironmentConfigException {
        // Setup environments
        setupEnvironments();

        // Retrieve necessary data
        List<Environment> environments = getEnvironments();

        // Deploy every environment
        LOGGER.info(PLUGIN_MESSAGE_BUNDLE.getMessage("DEPLOYER_PLUGIN_MESSAGES_DEPLOYING_ENVIRONMENTS_STARTED"));
        for (Environment environment : environments) {
            deploy(environment);
        }
        LOGGER.info(PLUGIN_MESSAGE_BUNDLE.getMessage("DEPLOYER_PLUGIN_MESSAGES_DEPLOYING_ENVIRONMENTS_DONE"));
    }
}
