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
package de.qaware.cloud.deployer.kubernetes.config.cloud;

public class CloudConfig {

    private final String baseUrl;
    private final String username;
    private final String password;
    private final String updateStrategy;
    private final SSLConfig sslConfig;

    public CloudConfig(String baseUrl, String username, String password, String updateStrategy, SSLConfig sslConfig) {
        this.baseUrl = baseUrl;
        this.username = username;
        this.password = password;
        this.updateStrategy = updateStrategy;
        this.sslConfig = sslConfig;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public SSLConfig getSslConfig() {
        return sslConfig;
    }

    public String getUpdateStrategy() {
        return updateStrategy;
    }
}
