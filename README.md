<!---
 Licensed to the Apache Software Foundation (ASF) under one or more
 contributor license agreements.  See the NOTICE file distributed with
 this work for additional information regarding copyright ownership.
 The ASF licenses this file to You under the Apache License, Version 2.0
 (the "License"); you may not use this file except in compliance with
 the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
-->

Hexindai Maven Plugin
======

A Maven plugin. **Work in progress**

Will add many features. Just wait. Thank you.

How to use?
---------------
1. Add this plugin to you pom.xml
```xml
<build>
        <plugins>
            <plugin>
                <groupId>com.github.hexindai.maven.plugins</groupId>
                <artifactId>hexindai-maven-plugin</artifactId>
                <version>0.0.1</version>
                <configuration>
                    <properties>
                        <property>
                            <name>tableNamePrefix</name>
                            <value>New_V_FundIO_</value>
                        </property>
                        <property>
                            <name>shardingCount</name>
                            <value>512</value>
                        </property>
                        <property>
                            <name>seed</name>
                            <value>12341234</value>
                        </property>
                        <property>
                            <name>numOfNodesPerTable</name>
                            <value>5</value>
                        </property>
                    </properties>
                </configuration>
            </plugin>
        </plugins>
    </build>
```
2. Run this plugin

```shell script
./mvnw com.github.hexindai.maven.plugins:hexindai-maven-plugin:0.0.1-SNAPSHOT:newvfundio -Duserid=148407
```

This command is too long. Like short? Add the following to your `~/.m2/settings.xml` file.

```xml
 <pluginGroups>
+    <pluginGroup>com.github.hexindai.maven.plugins</pluginGroup>
 </pluginGroups>
```

3. Enjoy

```shell script
./mvnw hexindai:newvfundio -Duserid=148407
```
