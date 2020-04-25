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
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.Properties;

/**
 * Goal which generates newvfundio tablename with user id.
 */
@Mojo( name = "newvfundio" )
public class NewVFundIoMojo extends AbstractMojo
{
    @Parameter( property = "userid", required = true )
    private String userId;

    @Parameter
    private Properties properties;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException
    {
        final ConfigurableSharding sharding = new GeneralSharding();

        if ( properties == null )
        {
            properties = new Properties()
            {{
                setProperty( "tableNamePrefix", "New_V_FundIO_" );
                setProperty( "shardingCount", "512" );
                setProperty( "seed", "1234ABCD" );
                setProperty( "numOfNodesPerTable", "10" );
            }};
        }

        sharding.setProperties( properties );
        final String tableName = sharding.getShardingTableName( userId );
        getLog().info( String.format( "Sharding Table Name: <<<%s>>>", tableName ) );
    }
}
