/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.infra.datasource.pool.metadata.type.druid;

import org.apache.shardingsphere.infra.datasource.pool.metadata.DataSourcePoolFieldMetaData;
import org.apache.shardingsphere.infra.datasource.pool.metadata.DataSourcePoolMetaData;
import org.apache.shardingsphere.infra.datasource.pool.metadata.DataSourcePoolPropertiesValidator;
import org.apache.shardingsphere.infra.datasource.pool.metadata.DefaultDataSourcePoolPropertiesValidator;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;

/**
 * Druid data source pool meta data.
 */
public final class DruidDataSourcePoolMetaData implements DataSourcePoolMetaData {
    private final Collection<String> transientFieldNames = new LinkedList<>();

    public DruidDataSourcePoolMetaData() {
        this.buildTransientFieldNames();
    }

    private void buildTransientFieldNames() {
        this.transientFieldNames.add("closed");
    }

    public Map<String, Object> getDefaultProperties() {
        return Collections.emptyMap();
    }

    public Map<String, Object> getInvalidProperties() {
        return Collections.emptyMap();
    }

    public Map<String, String> getPropertySynonyms() {
        return Collections.emptyMap();
    }

    public String getType() {
        return "com.alibaba.druid.pool.DruidDataSource";
    }

    public Collection<String> getTransientFieldNames() {
        return this.transientFieldNames;
    }

    @Override
    public DataSourcePoolFieldMetaData getFieldMetaData() {
        return new DruidDataSourcePoolFieldMetaData();
    }

    @Override
    public DataSourcePoolPropertiesValidator getDataSourcePoolPropertiesValidator() {
        return new DefaultDataSourcePoolPropertiesValidator();
    }
}
