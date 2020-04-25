package com.github.hexindai.maven.plugins;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import com.github.hexindai.s3harding.core.ConfigurableSharding;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeneralShardingTest
{

    @Test
    void getShardingTableName()
    {
        ConfigurableSharding sharding = new GeneralSharding();
        sharding.setProperties(new Properties()
        {{
            setProperty( "tableNamePrefix", "New_V_FundIO_" );
            setProperty( "shardingCount", "512" );
            setProperty( "seed", "1234ABCD" );
            setProperty( "numOfNodesPerTable", "10" );
        }});

        String name = sharding.getShardingTableName( "148407" );
        assertEquals( "New_V_FundIO_449", name );

        String name1 = sharding.getShardingTableName( "20" );
        assertEquals( "New_V_FundIO_G_1", name1 );
    }
}