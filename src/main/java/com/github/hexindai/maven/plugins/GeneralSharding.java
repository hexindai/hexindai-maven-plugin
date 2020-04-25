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

import com.github.hexindai.s3harding.core.MurmurHashSharding;

import java.util.HashMap;
import java.util.Map;

/**
 * GeneralSharding which adds some special cases for handling
 */
public class GeneralSharding extends MurmurHashSharding
{

    @Override
    public String getShardingTableName( String shardKey )
    {
        final String tableName = getTableName( shardKey );
        if ( tableName != null )
        {
            return getProperty( "tableNamePrefix" ) + tableName;
        }
        return super.getShardingTableName( shardKey );
    }

    private String getTableName( String shardKey )
    {
        Map<String, String> map = new HashMap<String, String>()
        {{
            put( "0", "0" );
            put( "20", "G_1" );
            put( "30", "Sys" );
            put( "40", "Repurchase" );
            put( "50", "Advance" );
            put( "60", "Balance" );
            put( "70", "Payment" );
            put( "80", "Reserve" );
            put( "90", "Reward" );
        }};
        return map.get( shardKey );
    }
}
